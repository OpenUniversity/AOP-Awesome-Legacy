package awesome.ide.gen;

public class TestappAspect
{
  protected static String nl;
  public static synchronized TestappAspect create(String lineSeparator)
  {
    nl = lineSeparator;
    TestappAspect result = new TestappAspect();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package ";
  protected final String TEXT_2 = ";" + NL + "" + NL + "import org.aspectj.lang.annotation.Aspect;" + NL + "import awesome.platform.annotations.AwAspectMechanism;" + NL + "" + NL + "@Aspect" + NL + "@AwAspectMechanism(id=\"";
  protected final String TEXT_3 = "\")" + NL + "public class ";
  protected final String TEXT_4 = " {" + NL + "\t// define your aspect here..." + NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    String packageName = ((String[])argument)[0];
    String aspectName = ((String[])argument)[1];
    String mechanismId = ((String[])argument)[2];
    stringBuffer.append(TEXT_1);
    stringBuffer.append(packageName);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(mechanismId);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(aspectName);
    stringBuffer.append(TEXT_4);
    return stringBuffer.toString();
  }
}
