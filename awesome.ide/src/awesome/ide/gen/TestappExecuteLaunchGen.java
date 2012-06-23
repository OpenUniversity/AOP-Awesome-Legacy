package awesome.ide.gen;

public class TestappExecuteLaunchGen
{
  protected static String nl;
  public static synchronized TestappExecuteLaunchGen create(String lineSeparator)
  {
    nl = lineSeparator;
    TestappExecuteLaunchGen result = new TestappExecuteLaunchGen();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>" + NL + "<launchConfiguration type=\"org.eclipse.jdt.launching.localJavaApplication\">" + NL + "<listAttribute key=\"org.eclipse.debug.core.MAPPED_RESOURCE_PATHS\">" + NL + "<listEntry value=\"/";
  protected final String TEXT_2 = "\"/>" + NL + "</listAttribute>" + NL + "<listAttribute key=\"org.eclipse.debug.core.MAPPED_RESOURCE_TYPES\">" + NL + "<listEntry value=\"4\"/>" + NL + "</listAttribute>" + NL + "<listAttribute key=\"org.eclipse.jdt.launching.CLASSPATH\">" + NL + "<listEntry value=\"&lt;?xml version=&quot;1.0&quot; encoding=&quot;UTF-8&quot; standalone=&quot;no&quot;?&gt;&#13;&#10;&lt;runtimeClasspathEntry id=&quot;org.eclipse.jdt.launching.classpathentry.defaultClasspath&quot;&gt;&#13;&#10;&lt;memento exportedEntriesOnly=&quot;false&quot; project=&quot;";
  protected final String TEXT_3 = "&quot;/&gt;&#13;&#10;&lt;/runtimeClasspathEntry&gt;&#13;&#10;\"/>" + NL + "<listEntry value=\"&lt;?xml version=&quot;1.0&quot; encoding=&quot;UTF-8&quot; standalone=&quot;no&quot;?&gt;&#13;&#10;&lt;runtimeClasspathEntry internalArchive=&quot;/";
  protected final String TEXT_4 = "/";
  protected final String TEXT_5 = ".jar&quot; path=&quot;3&quot; type=&quot;2&quot;/&gt;&#13;&#10;\"/>" + NL + "</listAttribute>" + NL + "<booleanAttribute key=\"org.eclipse.jdt.launching.DEFAULT_CLASSPATH\" value=\"false\"/>" + NL + "<stringAttribute key=\"org.eclipse.jdt.launching.MAIN_TYPE\" value=\"base.Main\"/>" + NL + "<stringAttribute key=\"org.eclipse.jdt.launching.PROJECT_ATTR\" value=\"";
  protected final String TEXT_6 = "\"/>" + NL + "</launchConfiguration>";
  protected final String TEXT_7 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     String projectName = ((String[])argument)[0]; 
     String testapp = ((String[])argument)[1]; 
    stringBuffer.append(TEXT_1);
    stringBuffer.append(projectName);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(projectName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(projectName);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(testapp);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(projectName);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(TEXT_7);
    return stringBuffer.toString();
  }
}
