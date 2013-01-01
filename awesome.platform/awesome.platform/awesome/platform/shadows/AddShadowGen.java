package awesome.platform.shadows;

import java.util.List;

public class AddShadowGen
{
  protected static String nl;
  public static synchronized AddShadowGen create(String lineSeparator)
  {
    nl = lineSeparator;
    AddShadowGen result = new AddShadowGen();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package awesome.platform.shadows.gen;" + NL + "" + NL + "import java.io.DataInputStream;" + NL + "import java.io.IOException;" + NL + "import java.util.List;" + NL + "" + NL + "import org.aspectj.apache.bcel.generic.Instruction;" + NL + "import org.aspectj.apache.bcel.generic.InstructionHandle;" + NL + "import org.aspectj.apache.bcel.generic.InstructionList;" + NL + "import org.aspectj.weaver.MemberImpl;" + NL + "import org.aspectj.weaver.Shadow;" + NL + "import org.aspectj.weaver.Shadow.Kind;" + NL + "import org.aspectj.weaver.bcel.BcelShadow;" + NL + "import org.aspectj.weaver.bcel.BcelWorld;" + NL + "import org.aspectj.weaver.bcel.LazyMethodGen;" + NL + "import org.aspectj.weaver.bcel.Range;" + NL + "import org.aspectj.weaver.bcel.ShadowRange;" + NL + "" + NL + "import awesome.platform.MultiMechanism;" + NL + "" + NL + "/**" + NL + "* This aspect introduces Awesome with a new shadow: ";
  protected final String TEXT_2 = " " + NL + "*/" + NL + "public aspect ";
  protected final String TEXT_3 = " {" + NL + "\t// first, constants and related utilities are added to class org.aspectj.weaver.Shadow" + NL + "\tpublic static final String Shadow._";
  protected final String TEXT_4 = " = \"";
  protected final String TEXT_5 = "\";" + NL + "\tpublic static final Kind Shadow.";
  protected final String TEXT_6 = " = new Kind(_";
  protected final String TEXT_7 = ", ";
  protected final String TEXT_8 = ", true);" + NL + "\t// Ignore the 'not applied' warning... (why do we get it?)" + NL + "\tShadow.Kind around(DataInputStream is) throws IOException: " + NL + "\t\texecution(public static Kind Shadow.read(DataInputStream)) && args(is) {" + NL + "\t\tint key = is.readByte();" + NL + "\t\tif(key == ";
  protected final String TEXT_9 = ")" + NL + "\t\t\treturn Shadow.";
  protected final String TEXT_10 = ";" + NL + "\t\telse return proceed(is);" + NL + "\t}" + NL + "\t" + NL + "\t// Second, we add a method to BcelShadow that creates our new shadow" + NL + "\tpublic static BcelShadow BcelShadow.make";
  protected final String TEXT_11 = "(BcelWorld world, LazyMethodGen enclosingMethod, InstructionHandle handle," + NL + "\t\t\tBcelShadow enclosingShadow) {" + NL + "\t\tfinal InstructionList body = enclosingMethod.getBody();" + NL + "\t\tBcelShadow s = new BcelShadow(world, ";
  protected final String TEXT_12 = ", MemberImpl.getSimpleSignature(\"";
  protected final String TEXT_13 = "\"), enclosingMethod, enclosingShadow);" + NL + "\t\tShadowRange r = new ShadowRange(body);" + NL + "\t\tr.associateWithShadow(s);" + NL + "\t\tr.associateWithTargets(Range.genStart(body, handle), Range.genEnd(body, handle));" + NL + "\t\tretargetAllBranches(handle, r.getStart());" + NL + "\t\treturn s;" + NL + "\t}" + NL + "\t" + NL + "\t// Finally, we adjust one of the reify methods in MultiMechanism" + NL + "\tafter(InstructionHandle ih, LazyMethodGen mg, BcelShadow enclosingShadow) returning(List<BcelShadow> result) :" + NL + "\t\texecution(List<BcelShadow> MultiMechanism.reify(InstructionHandle, LazyMethodGen, BcelShadow))" + NL + "\t\t\t&& args(ih, mg, enclosingShadow) {" + NL + "\t\tInstruction i = ih.getInstruction();" + NL + "\t\t";
  protected final String TEXT_14 = NL + "\t\t\tif( i.getName().equals(\"";
  protected final String TEXT_15 = "\") )" + NL + "\t\t\t\tresult.add(BcelShadow.make";
  protected final String TEXT_16 = "(MultiMechanism.getInstance().getWorld(), mg, ih, enclosingShadow));" + NL + "\t\t";
  protected final String TEXT_17 = NL + "\t\t// Alternative implementations:" + NL + "\t\t// (1) if (Arrays.asList(new String[]{\"ddiv\", \"fdiv\", \"idiv\", \"ldiv\"}).contains(i.getName()))..." + NL + "\t\t// (2) short opcode = i.getOpcode(); if( opcode == Constants.DDIV || opcode == Constants.FDIV ..." + NL + "\t}" + NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     String id = ((ShadowSpec)argument).getId(); 
     List<String> opcodes = ((ShadowSpec)argument).getOpcodes(); 
     int shadowIndex = AddShadow.getShadowIndex(); 
    stringBuffer.append(TEXT_1);
    stringBuffer.append(id);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(AddShadowWriter.getAspectName(id));
    stringBuffer.append(TEXT_3);
    stringBuffer.append(id);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(id);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(id);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(id);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(shadowIndex);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(shadowIndex);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(id);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(id);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(id);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(id);
    stringBuffer.append(TEXT_13);
     for(String opcode : opcodes ) { 
    stringBuffer.append(TEXT_14);
    stringBuffer.append(opcode);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(id);
    stringBuffer.append(TEXT_16);
    }
    stringBuffer.append(TEXT_17);
    return stringBuffer.toString();
  }
}
