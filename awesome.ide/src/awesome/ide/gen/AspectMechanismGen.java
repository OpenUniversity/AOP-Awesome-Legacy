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
  protected final String TEXT_2 = ";" + NL + "" + NL + "import java.util.List;" + NL + "import org.aspectj.weaver.bcel.BcelShadow;" + NL + "import awesome.platform.AbstractWeaver;" + NL + "import awesome.platform.IEffect;" + NL + "" + NL + "public aspect ";
  protected final String TEXT_3 = " extends AbstractWeaver {" + NL + "\t@Override" + NL + "\tpublic List<IEffect> match(BcelShadow arg0) {" + NL + "\t\t// TODO Auto-generated method stub" + NL + "\t\treturn null;" + NL + "\t}" + NL + "" + NL + "\t@Override" + NL + "\tpublic List<IEffect> order(BcelShadow arg0, List<IEffect> arg1) {" + NL + "\t\t// TODO Auto-generated method stub" + NL + "\t\treturn null;" + NL + "\t}" + NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    String packageName = ((NewAwesomeProjectWizard.AspectMechanismDescriptor) argument).getPackageName();
    String aspectName = ((NewAwesomeProjectWizard.AspectMechanismDescriptor) argument).getAspectName();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(packageName);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(aspectName);
    stringBuffer.append(TEXT_3);
    return stringBuffer.toString();
  }
}
