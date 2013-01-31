package awesome.ide.gen;

import awesome.ide.actions.AddAwesomeSupport;

public class EndUserWeaveLaunchGen
{
  protected static String nl;
  public static synchronized EndUserWeaveLaunchGen create(String lineSeparator)
  {
    nl = lineSeparator;
    EndUserWeaveLaunchGen result = new EndUserWeaveLaunchGen();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"no\"?>" + NL + "<launchConfiguration type=\"org.eclipse.jdt.launching.localJavaApplication\">" + NL + "<listAttribute key=\"org.eclipse.debug.core.MAPPED_RESOURCE_PATHS\">" + NL + "<listEntry value=\"/";
  protected final String TEXT_2 = "/awesome/aspectjtools.jar\"/>" + NL + "</listAttribute>" + NL + "<listAttribute key=\"org.eclipse.debug.core.MAPPED_RESOURCE_TYPES\">" + NL + "<listEntry value=\"1\"/>" + NL + "</listAttribute>" + NL + "<mapAttribute key=\"org.eclipse.debug.core.environmentVariables\">" + NL + "</mapAttribute>" + NL + "<stringAttribute key=\"org.eclipse.jdt.launching.MAIN_TYPE\" value=\"org.aspectj.tools.ajc.Main\"/>" + NL + "<stringAttribute key=\"org.eclipse.jdt.launching.PROGRAM_ARGUMENTS\" value=\"-1.5 -sourceroots src:src-gen -outjar ";
  protected final String TEXT_3 = "/";
  protected final String TEXT_4 = ".jar\"/>" + NL + "<stringAttribute key=\"org.eclipse.jdt.launching.PROJECT_ATTR\" value=\"";
  protected final String TEXT_5 = "\"/>" + NL + "</launchConfiguration>";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     String projectName = (String)(argument);
    stringBuffer.append(TEXT_1);
    stringBuffer.append(projectName);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(AddAwesomeSupport.AWESOME_FOLDER);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(projectName);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(projectName);
    stringBuffer.append(TEXT_5);
    return stringBuffer.toString();
  }
}
