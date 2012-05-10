package awesome.ide.gen;

import awesome.ide.wizards.*;

public class AspectMechanismGen
{
  protected static String nl;
  public static synchronized AspectMechanismGen create(String lineSeparator)
  {
    nl = lineSeparator;
    AspectMechanismGen result = new AspectMechanismGen();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package ";
  protected final String TEXT_2 = ";" + NL + "" + NL + "import java.util.List;" + NL + "import java.util.ArrayList;" + NL + "import java.util.Iterator;" + NL + "import org.aspectj.weaver.bcel.BcelShadow;" + NL + "import org.aspectj.weaver.bcel.LazyClassGen;" + NL + "import org.aspectj.weaver.bcel.UnwovenClassFile;" + NL + "import org.aspectj.weaver.IClassFileProvider;" + NL + "import awesome.platform.*;" + NL + "" + NL + "public aspect ";
  protected final String TEXT_3 = " extends AbstractWeaver {" + NL + "\tprivate static final String NAME = \"";
  protected final String TEXT_4 = "\";" + NL + "\tprivate List<AspectClass> aspectClasses = new ArrayList<AspectClass>();" + NL + "\t" + NL + "\t@Override" + NL + "\tpublic List<IEffect> match(BcelShadow shadow) {" + NL + "\t\t// TODO Auto-generated method stub" + NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "\t@Override" + NL + "\tpublic List<IEffect> order(BcelShadow shadow, List<IEffect> effects) {" + NL + "\t\treturn effects;" + NL + "\t}" + NL + "\t" + NL + "\t@Override" + NL + "\tpublic String getName() {" + NL + "\t\treturn NAME;" + NL + "\t}" + NL + "\t" + NL + "\t/*" + NL + "\t * Implement these two methods for adding debug support" + NL + "\t */" + NL + "\t@Override" + NL + "\tpublic List<IEffect> getEffects(LazyClassGen aspectClazz) {" + NL + "\t\treturn new ArrayList<IEffect>();" + NL + "\t}" + NL + "\t@Override" + NL + "\tpublic boolean handledByMe(LazyClassGen aspectClazz) {" + NL + "\t\treturn false;" + NL + "\t}" + NL + "\t" + NL + "\t@Override" + NL + "\tpublic void setInputFiles(IClassFileProvider inputClasses) {" + NL + "\t\tsuper.setInputFiles(inputClasses);" + NL + "\t\t" + NL + "\t\tSystem.out.println(getName() + \".setInputFiles...\");" + NL + "\t\tfor (Iterator i = inputClasses.getClassFileIterator(); i.hasNext();) {" + NL + "\t\t\tUnwovenClassFile classFile = (UnwovenClassFile) i.next();" + NL + "\t\t\t \t" + NL + "\t\t\tif(!AwesomeCore.hasAspectAnnotation(classFile) || " + NL + "\t\t\t\t!AwesomeCore.belongsToAspectMechanism(classFile, getName())) {" + NL + "\t\t\t\tcontinue;" + NL + "\t\t\t}" + NL + "\t\t\tSystem.out.println(\"Found \" + getName() + \" aspect class: \" + classFile.getClassName() + \".\");" + NL + "\t\t\t" + NL + "\t\t\tAspectClass ac = AwesomeCore.create(classFile);" + NL + "\t\t\t" + NL + "\t\t\taspectClasses.add(ac);" + NL + "\t\t}" + NL + "\t\t " + NL + "\t\tinitializeUserFields();" + NL + "\t}" + NL + "\t" + NL + "\tprivate void initializeUserFields() {" + NL + "\t\t// TODO Add initialization code for user defined fields" + NL + "\t}" + NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    String packageName = ((AspectMechanismDescriptor) argument).getPackageName();
    String aspectName = ((AspectMechanismDescriptor) argument).getAspectName();
    String id = ((AspectMechanismDescriptor) argument).getId();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(packageName);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(aspectName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(id);
    stringBuffer.append(TEXT_4);
    return stringBuffer.toString();
  }
}
