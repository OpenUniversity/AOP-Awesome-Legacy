package awesome.ide.gen;

public class TestappTestCaseGen
{
  protected static String nl;
  public static synchronized TestappTestCaseGen create(String lineSeparator)
  {
    nl = lineSeparator;
    TestappTestCaseGen result = new TestappTestCaseGen();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package ";
  protected final String TEXT_2 = ";" + NL + "" + NL + "import org.junit.Test;" + NL + "import static org.junit.Assert.*;" + NL + "import awesome.tracing.weaving.WeavingTraceManager;" + NL + "import awesome.tracing.weaving.WeavingTrace;" + NL + "" + NL + "public class Testapp";
  protected final String TEXT_3 = " {" + NL + "\t@Test" + NL + "\tpublic void test() {" + NL + "\t\tWeavingTrace atrace = WeavingTraceManager.getTrace(\"testapp";
  protected final String TEXT_4 = "\", \"aspects.Aspect\");" + NL + "\t\tWeavingTrace ctrace = WeavingTraceManager.getTrace(\"testapp";
  protected final String TEXT_5 = "\", \"base.Main\");" + NL + "\t\t// define rest of the test here..." + NL + "\t}" + NL + "}";

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
    stringBuffer.append(testappId);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(testappId);
    stringBuffer.append(TEXT_5);
    return stringBuffer.toString();
  }
}
