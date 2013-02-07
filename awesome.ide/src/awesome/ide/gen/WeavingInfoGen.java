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
  protected final String TEXT_2 = ";" + NL + "" + NL + "import java.io.Serializable;" + NL + "import java.util.ArrayList;" + NL + "import java.util.Collections;" + NL + "import java.util.HashMap;" + NL + "import java.util.List;" + NL + "import java.util.Map;" + NL + "" + NL + "import org.aspectj.weaver.Shadow;" + NL + "" + NL + "public class WeavingInfo implements Serializable {" + NL + "\tprivate static final long serialVersionUID = 1L;" + NL + "\tpublic static final String ADVICE_EXECUTION = Shadow.ADVICE_EXECUTION;" + NL + "\tpublic static final String CONSTRUCTOR_CALL = Shadow.CONSTRUCTOR_CALL;" + NL + "\tpublic static final String CONSTRUCTOR_EXECUTION = Shadow.CONSTRUCTOR_EXECUTION;" + NL + "\tpublic static final String EXCEPTION_HANDLER = Shadow.EXCEPTION_HANDLER;" + NL + "\tpublic static final String FIELD_GET = Shadow.FIELD_GET;" + NL + "\tpublic static final String FIELD_SET = Shadow.FIELD_SET;" + NL + "\tpublic static final String INITIALIZATION = Shadow.INITIALIZATION;" + NL + "\tpublic static final String METHOD_CALL = Shadow.METHOD_CALL;" + NL + "\tpublic static final String METHOD_EXECUTION = Shadow.METHOD_EXECUTION;" + NL + "\tpublic static final String PREINITIALIZATION = Shadow.PREINITIALIZATION;" + NL + "\tpublic static final String STATICINITIALIZATION = Shadow.STATICINITIALIZATION;" + NL + "\t" + NL + "\t/**" + NL + "\t * Holds for each class (the key) a list of its reified shadows" + NL + "\t */" + NL + "\tprivate Map<String, List<String>> refiedShadows = new HashMap<String, List<String>>();" + NL + "\tprivate Map<String, List<String>> matchedAdvice = new HashMap<String, List<String>>();" + NL + "\tprivate Map<String, List<String>> matchedBeforeAdvice = new HashMap<String, List<String>>();" + NL + "\tprivate Map<String, List<String>> matchedAfterAdvice = new HashMap<String, List<String>>();" + NL + "\t" + NL + "\tpublic void collectReifiedShadows(String className, List<String> shadows) {" + NL + "\t\tCollections.sort(shadows);" + NL + "\t\trefiedShadows.put(className, shadows);" + NL + "\t}" + NL + "\tpublic void collectMatchedAdvice(String method, List<String> advice) {" + NL + "\t\t// we first distinguish between before and after advice" + NL + "\t\tList<String> beforeAdvice = new ArrayList<String>();" + NL + "\t\tList<String> afterAdvice = new ArrayList<String>();" + NL + "\t\tfor(String adv : advice) {" + NL + "\t\t\tif(adv.endsWith(\".before\"))" + NL + "\t\t\t\tbeforeAdvice.add(adv);" + NL + "\t\t\telse if(adv.endsWith(\".after\"))" + NL + "\t\t\t\tafterAdvice.add(adv);" + NL + "\t\t}" + NL + "\t\tCollections.reverse(beforeAdvice); // so they will be kept in the order in which they are executed." + NL + "\t\tmatchedBeforeAdvice.put(method, beforeAdvice);" + NL + "\t\tmatchedAfterAdvice.put(method, afterAdvice);" + NL + "\t\t" + NL + "\t\t// want to save all before advice and then all after." + NL + "\t\t// originally, they are sorted by the mechanisms." + NL + "\t\tList<String> allAdvice = new ArrayList<String>();" + NL + "\t\tallAdvice.addAll(beforeAdvice);" + NL + "\t\tallAdvice.addAll(afterAdvice);" + NL + "\t\tmatchedAdvice.put(method, allAdvice);" + NL + "\t}" + NL + "\t/**" + NL + "\t * The shadows are alphabetically sorted." + NL + "\t */" + NL + "\tpublic List<String> getRefiedShadows(String className) {" + NL + "\t\treturn refiedShadows.get(className);" + NL + "\t}" + NL + "\t/**" + NL + "\t * Only advice applied at method-execution shadows are collected." + NL + "\t * The advice are sorted according to the order in which they are executed." + NL + "\t * @return each element in the list is in the form {mechanism_id}.{advice_kind}," + NL + "\t * e.g., cool.before, validate.after." + NL + "\t */" + NL + "\tpublic List<String> getMatchedAdvice(String method) {" + NL + "\t\treturn matchedAdvice.get(method);" + NL + "\t}" + NL + "\t/**" + NL + "\t * Only advice applied at method-execution shadows are collected." + NL + "\t * The advice are sorted according to the order in which they are executed." + NL + "\t * @return each element in the list is in the form {mechanism_id}.{advice_kind}," + NL + "\t * e.g., cool.before, validate.before." + NL + "\t */" + NL + "\tpublic List<String> getMatchedBeforeAdvice(String method) {" + NL + "\t\treturn matchedBeforeAdvice.get(method);" + NL + "\t}" + NL + "\t/**" + NL + "\t * Only advice applied at method-execution shadows are collected." + NL + "\t * The advice are sorted according to the order in which they are executed." + NL + "\t * @return each element in the list is in the form {mechanism_id}.{advice_kind}," + NL + "\t * e.g., cool.after, validate.after." + NL + "\t */" + NL + "\tpublic List<String> getMatchedAfterAdvice(String method) {" + NL + "\t\treturn matchedAfterAdvice.get(method);" + NL + "\t}" + NL + "}";
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
