package awesome.ide.gen;

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
  protected final String TEXT_2 = ";" + NL + "" + NL + "import awesome.platform.AwesomeMechanism;" + NL + "" + NL + "public aspect ";
  protected final String TEXT_3 = " extends AwesomeMechanism {" + NL + "\tpublic String getId() {" + NL + "\t\treturn \"";
  protected final String TEXT_4 = "\";" + NL + "\t}" + NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    String packageName = ((String[])argument)[0];
    String aspectName = ((String[])argument)[1];
    String id = ((String[])argument)[2];
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
