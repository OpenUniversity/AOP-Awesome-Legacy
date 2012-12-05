package awesome.platform.shadows;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.aspectj.apache.bcel.Constants;
import org.aspectj.apache.bcel.generic.Instruction;
import org.aspectj.apache.bcel.generic.InstructionHandle;
import org.aspectj.apache.bcel.generic.InstructionList;
import org.aspectj.weaver.MemberImpl;
import org.aspectj.weaver.Shadow;
import org.aspectj.weaver.Shadow.Kind;
import org.aspectj.weaver.bcel.BcelShadow;
import org.aspectj.weaver.bcel.BcelWorld;
import org.aspectj.weaver.bcel.LazyMethodGen;
import org.aspectj.weaver.bcel.Range;
import org.aspectj.weaver.bcel.ShadowRange;

import awesome.platform.MultiMechanism;

/**
 * This aspect adds to Awesome the ability to expose (reify) div-operation
 * shadows (e.g., int x = y / z). One application of such a shadow is an aspect mechanism
 * that identifies cases of division by zero.
 * @author oren
 *
 */
public aspect AddDivOperationShadow {
	/* first, we add constants and related utils to class org.aspectj.weaver.Shadow
	that declare our new shadow */
	public static final String Shadow.DIV_OPERATION = "divoperation";
	public static final Kind Shadow.DivOperation = new Kind(DIV_OPERATION, 14, true);
	// why do we get a warning 'not applied'?? anyway, tested and it works. Is this read method being used??
	Shadow.Kind around(DataInputStream is) throws IOException: 
		execution(public static Kind Shadow.read(DataInputStream)) && args(is) {
		int key = is.readByte();
		if(key == 14)
			return Shadow.DivOperation;
		else return proceed(is);
	}
	
	/* Second, we add a method to BcelShadow that makes our new shadow */
	public static BcelShadow BcelShadow.makeDivOperation(BcelWorld world, LazyMethodGen enclosingMethod, InstructionHandle divHandle,
			BcelShadow enclosingShadow) {
		final InstructionList body = enclosingMethod.getBody();
		BcelShadow s = new BcelShadow(world, DivOperation, MemberImpl.getSimpleSignature("divoperation"), enclosingMethod, enclosingShadow);
		ShadowRange r = new ShadowRange(body);
		r.associateWithShadow(s);
		r.associateWithTargets(Range.genStart(body, divHandle), Range.genEnd(body, divHandle));
		retargetAllBranches(divHandle, r.getStart());
		return s;
	}
	
	/* And finally, we adjust one of the reify methods in MultiMechanism */
	after(InstructionHandle ih, LazyMethodGen mg, BcelShadow enclosingShadow) returning(List<BcelShadow> result) :
		execution(List<BcelShadow> MultiMechanism.reify(InstructionHandle, LazyMethodGen, BcelShadow))
			&& args(ih, mg, enclosingShadow) {
		Instruction i = ih.getInstruction();
		short opcode = i.getOpcode();
		if( opcode == Constants.DDIV || opcode == Constants.FDIV || opcode == Constants.IDIV || opcode == Constants.LDIV)
		/*if (Arrays.asList(new String[]{"ddiv", "fdiv", "idiv", "ldiv"}).contains(i.getName()))*/ {
			result.add(BcelShadow.makeDivOperation(MultiMechanism.getInstance().getWorld(), mg, ih, enclosingShadow));
		}
	}
	
}
