package awesome.ide.gen;

import awesome.ide.model.*;

public class TestappMain
{
  protected static String nl;
  public static synchronized TestappMain create(String lineSeparator)
  {
    nl = lineSeparator;
    TestappMain result = new TestappMain();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package ";
  protected final String TEXT_2 = ";" + NL + "" + NL + "public class ";
  protected final String TEXT_3 = " {" + NL + "\tpublic static void main(String[] args) {" + NL + "\t\tSystem.out.println(\"Executing main...\");" + NL + "\t}" + NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    String packageName = ((String[])argument)[0];
    stringBuffer.append(TEXT_1);
    stringBuffer.append(packageName);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(AspectMechanismTestProject.TESTAPP_MAIN);
    stringBuffer.append(TEXT_3);
    return stringBuffer.toString();
  }
}
