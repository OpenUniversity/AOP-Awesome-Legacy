package awesome.ide.gen;

import awesome.ide.model.*;

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
  protected final String TEXT_2 = ";" + NL + "" + NL + "import java.io.FileInputStream;" + NL + "import java.io.ObjectInputStream;" + NL + "import java.util.Arrays;" + NL + "import java.util.List;" + NL + "" + NL + "import org.junit.Before;" + NL + "import org.junit.Test;" + NL + "import static org.junit.Assert.*;" + NL + "" + NL + "import ";
  protected final String TEXT_3 = ".WeavingInfo;" + NL + "import static ";
  protected final String TEXT_4 = ".WeavingInfo.*;" + NL + "" + NL + "/**" + NL + " * Here you test your example application (Of course, you may define other test cases as well).<br/>" + NL + " * The testing approach is as follows:<br/>" + NL + " * <ul>" + NL + " * <li>During the weaving of your application, weaving information is being collected," + NL + " * and serialized to a file in the folder <b>weaving-info</b>.</li>" + NL + " * <li>The <b>setup</b> method reads that file to the <b>info</b> field, which is available to" + NL + " * all test methods.</li>" + NL + " * <li>A test method may verify (via <b>info</b>) that a particular aspect of the weaving" + NL + " * , e.g., the <b>match</b> process, was handled as expected.</li>" + NL + " * <li>Don't forget to re-weave your application after each change so the weaving info will" + NL + " * be re-collected.</li>" + NL + " * <li>The tests method generated below hold example tests that also introduce" + NL + " * the {@link WeavingInfo}'s API.</li> " + NL + " * </ul>" + NL + " * @author oren" + NL + " */" + NL + "public class ";
  protected final String TEXT_5 = " {" + NL + "\tprivate WeavingInfo info;" + NL + "\t" + NL + "\t@Before" + NL + "\tpublic void setup() {" + NL + "\t\tinfo = getWeavingInfo();" + NL + "\t}" + NL + "\t/**" + NL + "\t * An example test for the reify process" + NL + "\t */" + NL + "\t@Test" + NL + "\tpublic void testReify() {" + NL + "\t\t// test reify of ";
  protected final String TEXT_6 = ".";
  protected final String TEXT_7 = NL + "\t\tList<String> shadows = info.getRefiedShadows(\"";
  protected final String TEXT_8 = ".";
  protected final String TEXT_9 = "\");" + NL + "\t\tList<String> expected = Arrays.asList(CONSTRUCTOR_EXECUTION," + NL + "\t\t\t\tFIELD_GET, METHOD_CALL, METHOD_EXECUTION, STATICINITIALIZATION);" + NL + "\t\tassertEquals(expected, shadows);" + NL + "\t\t// test reify of ";
  protected final String TEXT_10 = ".My";
  protected final String TEXT_11 = "Aspect" + NL + "\t\tshadows = info.getRefiedShadows(\"";
  protected final String TEXT_12 = ".My";
  protected final String TEXT_13 = "Aspect\");" + NL + "\t\texpected = Arrays.asList(ADVICE_EXECUTION, ADVICE_EXECUTION);" + NL + "\t\tassertEquals(expected, shadows);" + NL + "\t}" + NL + "\t/**" + NL + "\t * An example test for the match process" + NL + "\t */" + NL + "\t@Test" + NL + "\tpublic void testMatch() {" + NL + "\t\tList<String> advice = info.getMatchedAdvice(\"";
  protected final String TEXT_14 = ".";
  protected final String TEXT_15 = ".main\");" + NL + "\t\tassertEquals(\"";
  protected final String TEXT_16 = ".before\", advice.get(0));" + NL + "\t\tassertEquals(\"";
  protected final String TEXT_17 = ".after\", advice.get(1));" + NL + "\t}" + NL + "\tprivate WeavingInfo getWeavingInfo() {" + NL + "\t\ttry {" + NL + "\t\t\tObjectInputStream in = new ObjectInputStream(" + NL + "\t\t\tnew FileInputStream(\"weaving-info/WeavingInfo.out\"));" + NL + "\t\t\treturn (WeavingInfo)in.readObject();" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\tthrow new RuntimeException(e);" + NL + "\t\t}" + NL + "\t}" + NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     String packageName = (String)(((Object[])argument)[0]); 
     String amProjectName = (String)(((Object[])argument)[1]); 
     String[] mechanismNames = (String[])(((Object[])argument)[2]); 
    stringBuffer.append(TEXT_1);
    stringBuffer.append(packageName);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(amProjectName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(amProjectName);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(AspectMechanismTestProject.TESTCASE_NAME);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(AspectMechanismTestProject.BASE_FOLDER);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(AspectMechanismTestProject.TESTAPP_MAIN);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(AspectMechanismTestProject.BASE_FOLDER);
    stringBuffer.append(TEXT_8);
    stringBuffer.append(AspectMechanismTestProject.TESTAPP_MAIN);
    stringBuffer.append(TEXT_9);
    stringBuffer.append(AspectMechanismTestProject.ASPECTS_FOLDER);
    stringBuffer.append(TEXT_10);
    stringBuffer.append(Utils.capitalize(mechanismNames[0]));
    stringBuffer.append(TEXT_11);
    stringBuffer.append(AspectMechanismTestProject.ASPECTS_FOLDER);
    stringBuffer.append(TEXT_12);
    stringBuffer.append(Utils.capitalize(mechanismNames[0]));
    stringBuffer.append(TEXT_13);
    stringBuffer.append(AspectMechanismTestProject.BASE_FOLDER);
    stringBuffer.append(TEXT_14);
    stringBuffer.append(AspectMechanismTestProject.TESTAPP_MAIN);
    stringBuffer.append(TEXT_15);
    stringBuffer.append(mechanismNames[0]);
    stringBuffer.append(TEXT_16);
    stringBuffer.append(mechanismNames[0]);
    stringBuffer.append(TEXT_17);
    return stringBuffer.toString();
  }
}
