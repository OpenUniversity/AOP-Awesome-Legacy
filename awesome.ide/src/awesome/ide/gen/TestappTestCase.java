package awesome.ide.gen;

public class TestappTestCase
{
  protected static String nl;
  public static synchronized TestappTestCase create(String lineSeparator)
  {
    nl = lineSeparator;
    TestappTestCase result = new TestappTestCase();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package ";
  protected final String TEXT_2 = ";" + NL + "" + NL + "import org.junit.Test;" + NL + "import static org.junit.Assert.*;" + NL + "import awesome.platform.utils.WeavingLogManager;" + NL + "import awesome.platform.utils.WeavingLog;" + NL + "" + NL + "public class Testapp";
  protected final String TEXT_3 = " {" + NL + "\t@Test" + NL + "\tpublic void test() {" + NL + "\t\t// define you first test here..." + NL + "\t}" + NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     String packageName = ((String[])argument)[0]; 
     String testappId = ((String[])argument)[1]; 
    stringBuffer.append(TEXT_1);
    stringBuffer.append(packageName);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(testappId);
    stringBuffer.append(TEXT_3);
    return stringBuffer.toString();
  }
}
