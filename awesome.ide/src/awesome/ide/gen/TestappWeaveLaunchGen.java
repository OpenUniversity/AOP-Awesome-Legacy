package awesome.ide.gen;

public class TestappWeaveLaunchGen
{
  protected static String nl;
  public static synchronized TestappWeaveLaunchGen create(String lineSeparator)
  {
    nl = lineSeparator;
    TestappWeaveLaunchGen result = new TestappWeaveLaunchGen();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>" + NL + "<launchConfiguration type=\"org.eclipse.jdt.launching.localJavaApplication\">" + NL + "<stringAttribute key=\"bad_container_name\" value=\"\\";
  protected final String TEXT_2 = "\\testapp\"/>" + NL + "<listAttribute key=\"org.eclipse.debug.core.MAPPED_RESOURCE_PATHS\">" + NL + "<listEntry value=\"/";
  protected final String TEXT_3 = "/lib/aspectjtools.jar\"/>" + NL + "</listAttribute>" + NL + "<listAttribute key=\"org.eclipse.debug.core.MAPPED_RESOURCE_TYPES\">" + NL + "<listEntry value=\"1\"/>" + NL + "</listAttribute>" + NL + "<mapAttribute key=\"org.eclipse.debug.core.environmentVariables\">" + NL + "<mapEntry key=\"ENABLE_WEAVING_TRACE\" value=\"1\"/>" + NL + "<mapEntry key=\"TEST_APP\" value=\"";
  protected final String TEXT_4 = "\"/>" + NL + "</mapAttribute>" + NL + "<stringAttribute key=\"org.eclipse.jdt.launching.MAIN_TYPE\" value=\"org.aspectj.tools.ajc.Main\"/>" + NL + "<stringAttribute key=\"org.eclipse.jdt.launching.PROGRAM_ARGUMENTS\" value=\"-1.5 -sourceroots ";
  protected final String TEXT_5 = " -outjar ";
  protected final String TEXT_6 = ".jar\"/>" + NL + "<stringAttribute key=\"org.eclipse.jdt.launching.PROJECT_ATTR\" value=\"";
  protected final String TEXT_7 = "\"/>" + NL + "</launchConfiguration>";
  protected final String TEXT_8 = NL;

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
    stringBuffer.append(testapp);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(testapp);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(testapp);
    stringBuffer.append(TEXT_6);
    stringBuffer.append(projectName);
    stringBuffer.append(TEXT_7);
    stringBuffer.append(TEXT_8);
    return stringBuffer.toString();
  }
}
