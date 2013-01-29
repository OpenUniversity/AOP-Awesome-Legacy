package awesome.ide.gen;

import awesome.ide.actions.AddAwesomeSupport;

public class EndUserExecuteLaunchGen
{
  protected static String nl;
  public static synchronized EndUserExecuteLaunchGen create(String lineSeparator)
  {
    nl = lineSeparator;
    EndUserExecuteLaunchGen result = new EndUserExecuteLaunchGen();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>" + NL + "<launchConfiguration type=\"org.eclipse.jdt.launching.localJavaApplication\">" + NL + "<listAttribute key=\"org.eclipse.debug.core.MAPPED_RESOURCE_PATHS\">" + NL + "</listAttribute>" + NL + "<listAttribute key=\"org.eclipse.debug.core.MAPPED_RESOURCE_TYPES\">" + NL + "<listEntry value=\"1\"/>" + NL + "</listAttribute>" + NL + "<listAttribute key=\"org.eclipse.jdt.launching.CLASSPATH\">" + NL + "<listEntry value=\"&lt;?xml version=&quot;1.0&quot; encoding=&quot;UTF-8&quot; standalone=&quot;no&quot;?&gt;&#10;&lt;runtimeClasspathEntry containerPath=&quot;org.eclipse.jdt.launching.JRE_CONTAINER/org.eclipse.jdt.internal.debug.ui.launcher.StandardVMType/JavaSE-1.6&quot; javaProject=&quot;";
  protected final String TEXT_2 = "&quot; path=&quot;1&quot; type=&quot;4&quot;/&gt;&#10;\"/>" + NL + "<listEntry value=\"&lt;?xml version=&quot;1.0&quot; encoding=&quot;UTF-8&quot; standalone=&quot;no&quot;?&gt;&#10;&lt;runtimeClasspathEntry internalArchive=&quot;/";
  protected final String TEXT_3 = "/awesome/";
  protected final String TEXT_4 = ".jar&quot; path=&quot;3&quot; type=&quot;2&quot;/&gt;&#10;\"/>" + NL + "<listEntry value=\"&lt;?xml version=&quot;1.0&quot; encoding=&quot;UTF-8&quot; standalone=&quot;no&quot;?&gt;&#10;&lt;runtimeClasspathEntry id=&quot;org.eclipse.jdt.launching.classpathentry.defaultClasspath&quot;&gt;&#10;&lt;memento exportedEntriesOnly=&quot;false&quot; project=&quot;";
  protected final String TEXT_5 = "&quot;/&gt;&#10;&lt;/runtimeClasspathEntry&gt;&#10;\"/>" + NL + "</listAttribute>" + NL + "<booleanAttribute key=\"org.eclipse.jdt.launching.DEFAULT_CLASSPATH\" value=\"false\"/>" + NL + "<stringAttribute key=\"org.eclipse.jdt.launching.MAIN_TYPE\" value=\"dummy.DefineHereYourRealMainClass\"/>" + NL + "<stringAttribute key=\"org.eclipse.jdt.launching.PROJECT_ATTR\" value=\"";
  protected final String TEXT_6 = "\"/>" + NL + "</launchConfiguration>";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     String projectName = (String)(argument);
    stringBuffer.append(TEXT_1);
    stringBuffer.append(projectName);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(projectName);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(projectName);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(projectName);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(projectName);
    stringBuffer.append(TEXT_6);
    return stringBuffer.toString();
  }
}
