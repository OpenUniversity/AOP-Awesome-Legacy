package awesome.platform.shadows.gen;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.List;

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
* This aspect introduces Awesome with a new shadow: ZaziOp 
*/
public aspect AddZaziOpShadow {
	// first, constants and related utilities are added to class org.aspectj.weaver.Shadow
	public static final String Shadow._ZaziOp = "ZaziOp";
	public static final Kind Shadow.ZaziOp = new Kind(_ZaziOp, 14, true);
	// Ignore the 'not applied' warning... (why do we get it?)
	Shadow.Kind around(DataInputStream is) throws IOException: 
		execution(public static Kind Shadow.read(DataInputStream)) && args(is) {
		int key = is.readByte();
		if(key == 14)
			return Shadow.ZaziOp;
		else return proceed(is);
	}
	
	// Second, we add a method to BcelShadow that creates our new shadow
	public static BcelShadow BcelShadow.makeZaziOp(BcelWorld world, LazyMethodGen enclosingMethod, InstructionHandle handle,
			BcelShadow enclosingShadow) {
		final InstructionList body = enclosingMethod.getBody();
		BcelShadow s = new BcelShadow(world, ZaziOp, MemberImpl.getSimpleSignature("ZaziOp"), enclosingMethod, enclosingShadow);
		ShadowRange r = new ShadowRange(body);
		r.associateWithShadow(s);
		r.associateWithTargets(Range.genStart(body, handle), Range.genEnd(body, handle));
		retargetAllBranches(handle, r.getStart());
		return s;
	}
	
	// Finally, we adjust one of the reify methods in MultiMechanism
	after(InstructionHandle ih, LazyMethodGen mg, BcelShadow enclosingShadow) returning(List<BcelShadow> result) :
		execution(List<BcelShadow> MultiMechanism.reify(InstructionHandle, LazyMethodGen, BcelShadow))
			&& args(ih, mg, enclosingShadow) {
		Instruction i = ih.getInstruction();
		
			if( i.getName().equals("ddiv") )
				result.add(BcelShadow.makeZaziOp(MultiMechanism.getInstance().getWorld(), mg, ih, enclosingShadow));
		
			if( i.getName().equals("fdiv") )
				result.add(BcelShadow.makeZaziOp(MultiMechanism.getInstance().getWorld(), mg, ih, enclosingShadow));
		
			if( i.getName().equals("idiv") )
				result.add(BcelShadow.makeZaziOp(MultiMechanism.getInstance().getWorld(), mg, ih, enclosingShadow));
		
			if( i.getName().equals("ldiv") )
				result.add(BcelShadow.makeZaziOp(MultiMechanism.getInstance().getWorld(), mg, ih, enclosingShadow));
		
		// Alternative implementations:
		// (1) if (Arrays.asList(new String[]{"ddiv", "fdiv", "idiv", "ldiv"}).contains(i.getName()))...
		// (2) short opcode = i.getOpcode(); if( opcode == Constants.DDIV || opcode == Constants.FDIV ...
	}
}