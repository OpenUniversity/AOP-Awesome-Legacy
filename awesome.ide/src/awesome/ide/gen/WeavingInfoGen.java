package awesome.ide.gen;

public class WeavingInfoGen
{
  protected static String nl;
  public static synchronized WeavingInfoGen create(String lineSeparator)
  {
    nl = lineSeparator;
    WeavingInfoGen result = new WeavingInfoGen();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package ";
  protected final String TEXT_2 = ";" + NL + "" + NL + "import java.io.Serializable;" + NL + "import java.util.HashMap;" + NL + "import java.util.List;" + NL + "import java.util.Map;" + NL + "" + NL + "public class WeavingInfo implements Serializable {" + NL + "\tprivate static final long serialVersionUID = 1L;" + NL + "\t/**" + NL + "\t * Holds for each class (the key) a list of its reified shadows" + NL + "\t */" + NL + "\tprivate Map<String, List<String>> refiedShadows = new HashMap<String, List<String>>();" + NL + "\t" + NL + "\tpublic void collectReifiedShadows(String className, List<String> shadows) {" + NL + "\t\trefiedShadows.put(className, shadows);" + NL + "\t}" + NL + "\tpublic void printReifiedShadows() {" + NL + "\t\tSystem.out.println(\"Reified Shadows:\");" + NL + "\t\tfor (String key : refiedShadows.keySet()) {" + NL + "\t\t\tSystem.out.println(\"Class \" + key + \": \" + refiedShadows.get(key));\t\t\t" + NL + "\t\t}" + NL + "\t}" + NL + "}";
  protected final String TEXT_3 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     String projectName = (String)argument; 
    stringBuffer.append(TEXT_1);
    stringBuffer.append(projectName);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(TEXT_3);
    return stringBuffer.toString();
  }
}
