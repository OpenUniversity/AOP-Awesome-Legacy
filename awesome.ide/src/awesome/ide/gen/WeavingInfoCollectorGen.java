package awesome.ide.gen;

import awesome.ide.model.*;

public class WeavingInfoCollectorGen
{
  protected static String nl;
  public static synchronized WeavingInfoCollectorGen create(String lineSeparator)
  {
    nl = lineSeparator;
    WeavingInfoCollectorGen result = new WeavingInfoCollectorGen();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package ";
  protected final String TEXT_2 = ";" + NL + "" + NL + "import java.io.FileOutputStream;" + NL + "import java.io.ObjectOutputStream;" + NL + "import java.util.ArrayList;" + NL + "import java.util.List;" + NL + "import org.aspectj.weaver.bcel.LazyClassGen;" + NL + "import org.aspectj.weaver.bcel.BcelShadow;" + NL + "import awesome.platform.MultiMechanism;" + NL + "" + NL + "public aspect WeavingInfoCollector {" + NL + "\tprivate WeavingInfo winfo = new WeavingInfo();" + NL + "\t/**" + NL + "\t * Collecting the shadows being reified from each class." + NL + "\t * @param clazz" + NL + "\t * @param shadows" + NL + "\t */" + NL + "\tafter(LazyClassGen clazz) returning(List<BcelShadow> shadows):" + NL + "\t\texecution(List<BcelShadow> MultiMechanism.reify(LazyClassGen)) && args(clazz) {" + NL + "\t\tList<String> result = new ArrayList<String>();" + NL + "\t\tfor(BcelShadow shadow : shadows)" + NL + "\t\t\tresult.add(shadow.getKind().toString());" + NL + "\t\t" + NL + "\t\twinfo.collectReifiedShadows(clazz.getName(), result);" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * Serializing WeavingInfo when weaving is complete." + NL + "\t */" + NL + "\tafter() : execution(* org.aspectj.weaver.bcel.BcelWeaver.allWeavingComplete()) {" + NL + "\t\tserialize();" + NL + "\t}" + NL + "\t/**" + NL + "\t * Note: object is serialized to the test project." + NL + "\t */" + NL + "\tprivate void serialize() {" + NL + "\t\tObjectOutputStream out;" + NL + "\t\ttry {" + NL + "\t\t\tout = new ObjectOutputStream(" + NL + "\t\t\t\t\tnew FileOutputStream(\"";
  protected final String TEXT_3 = "/WeavingInfo.out\"));" + NL + "\t\t\tout.writeObject(winfo);" + NL + "\t\t\tout.close(); // Also flushes output" + NL + "\t\t} catch (Exception e) {" + NL + "\t\t\tthrow new RuntimeException(e);" + NL + "\t\t} " + NL + "\t}" + NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     String projectName = (String)argument; 
    stringBuffer.append(TEXT_1);
    stringBuffer.append(projectName);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(AspectMechanismTestProject.WEAVING_INFO_FOLDER);
    stringBuffer.append(TEXT_3);
    return stringBuffer.toString();
  }
}
