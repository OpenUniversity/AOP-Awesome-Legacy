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
  protected final String TEXT_2 = ";" + NL + "" + NL + "import java.io.FileInputStream;" + NL + "import java.io.ObjectInputStream;" + NL + "import org.junit.Test;" + NL + "import static org.junit.Assert.*;" + NL + "import ";
  protected final String TEXT_3 = ".WeavingInfo;" + NL + "" + NL + "public class Testapp";
  protected final String TEXT_4 = " {" + NL + "\t@Test" + NL + "\tpublic void test() {" + NL + "\t\tWeavingInfo info = getWeavingInfo();" + NL + "\t\t// now start to test using the weaving information..." + NL + "\t}" + NL + "\tprivate WeavingInfo getWeavingInfo() {" + NL + "\t\ttry {" + NL + "\t\t\tObjectInputStream in = new ObjectInputStream(" + NL + "\t\t\tnew FileInputStream(\"";
  protected final String TEXT_5 = "/WeavingInfo.out\"));" + NL + "\t\t\treturn (WeavingInfo)in.readObject();" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\tthrow new RuntimeException(e);" + NL + "\t\t}" + NL + "\t}\t" + NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     String packageName = ((String[])argument)[0]; 
     String testappId = ((String[])argument)[1]; 
     String aspectName = ((String[])argument)[2]; 
     String amProjectName = ((String[])argument)[3]; 
    stringBuffer.append(TEXT_1);
    stringBuffer.append(packageName);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(amProjectName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(testappId);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(AspectMechanismTestProject.WEAVING_INFO_FOLDER);
    stringBuffer.append(TEXT_5);
    return stringBuffer.toString();
  }
}
