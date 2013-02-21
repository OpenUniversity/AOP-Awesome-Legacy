package awesome.ide.gen;

import awesome.ide.model.*;

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
  protected final String TEXT_2 = ";" + NL + "" + NL + "import org.aspectj.lang.annotation.*;" + NL + "import org.aspectj.lang.ProceedingJoinPoint;" + NL + "" + NL + "import awesome.platform.ReifyStrategy;" + NL + "import awesome.platform.annotations.AwAspectMechanism;" + NL + "import awesome.platform.annotations.AwReify;" + NL + "" + NL + "@Aspect";
  protected final String TEXT_3 = NL + "@AwAspectMechanism(id=\"";
  protected final String TEXT_4 = "\")";
  protected final String TEXT_5 = NL + "@AwReify(ReifyStrategy.SUPPRESS_STATICINITIALIZATION)" + NL + "public class ";
  protected final String TEXT_6 = " {" + NL + "\t" + NL + "\t@AwReify(ReifyStrategy.SUPPRESS_ALL)" + NL + "\tpublic ";
  protected final String TEXT_7 = "() {}" + NL + "\t" + NL + "\t@AwReify(ReifyStrategy.SUPPRESS_WITHIN)" + NL + "\t@Around(\"execution(* ";
  protected final String TEXT_8 = ".";
  protected final String TEXT_9 = ".main(..))\")" + NL + "\tpublic void ";
  protected final String TEXT_10 = "Around(ProceedingJoinPoint pjp) {" + NL + "\t\tSystem.out.println(\"Around main... (";
  protected final String TEXT_11 = ")\");" + NL + "\t\tpjp.proceed();" + NL + "\t}" + NL + "\t" + NL + "\t@AwReify(ReifyStrategy.SUPPRESS_WITHIN)" + NL + "\t@Before(\"execution(* ";
  protected final String TEXT_12 = ".";
  protected final String TEXT_13 = ".main(..))\")" + NL + "\tpublic void ";
  protected final String TEXT_14 = "Before() {" + NL + "\t\tSystem.out.println(\"Before main... (";
  protected final String TEXT_15 = ")\");" + NL + "\t}" + NL + "\t" + NL + "\t@AwReify(ReifyStrategy.SUPPRESS_WITHIN)" + NL + "\t@After(\"execution(* ";
  protected final String TEXT_16 = ".";
  protected final String TEXT_17 = ".main(..))\")" + NL + "\tpublic void ";
  protected final String TEXT_18 = "After() {" + NL + "\t\tSystem.out.println(\"After main... (";
  protected final String TEXT_19 = ")\");" + NL + "\t}" + NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    String packageName = ((String[])argument)[0];
    String aspectName = ((String[])argument)[1];
    String mechanismId = ((String[])argument)[2];
    stringBuffer.append(TEXT_1);
    stringBuffer.append(packageName);
    stringBuffer.append(TEXT_2);
    if(!mechanismId.equals(MultiMechanismProject.ASPECTJ_ID)) {
    stringBuffer.append(TEXT_3);
    stringBuffer.append(mechanismId);
    stringBuffer.append(TEXT_4);
    }
    stringBuffer.append(TEXT_5);
    stringBuffer.append(aspectName);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(aspectName);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(AspectMechanismTestProject.BASE_FOLDER);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(AspectMechanismTestProject.TESTAPP_MAIN);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(mechanismId);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(aspectName);
    stringBuffer.append(TEXT_11);
    stringBuffer.append(AspectMechanismTestProject.BASE_FOLDER);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(AspectMechanismTestProject.TESTAPP_MAIN);
    stringBuffer.append(TEXT_13);
    stringBuffer.append(mechanismId);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(aspectName);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(AspectMechanismTestProject.BASE_FOLDER);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(AspectMechanismTestProject.TESTAPP_MAIN);
    stringBuffer.append(TEXT_17);
    stringBuffer.append(mechanismId);
    stringBuffer.append(TEXT_18);
    stringBuffer.append(aspectName);
    stringBuffer.append(TEXT_19);
    return stringBuffer.toString();
  }
}
