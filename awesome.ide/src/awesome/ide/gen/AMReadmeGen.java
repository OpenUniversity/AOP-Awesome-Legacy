package awesome.ide.gen;

import awesome.ide.model.*;

public class AMReadmeGen
{
  protected static String nl;
  public static synchronized AMReadmeGen create(String lineSeparator)
  {
    nl = lineSeparator;
    AMReadmeGen result = new AMReadmeGen();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "Here we explain the different components of the aspect mechanism project." + NL + "Note also the README for the corresponding test project." + NL + "" + NL + "src/";
  protected final String TEXT_2 = NL + "\tThis is the package where the source files of the aspect mechanism should" + NL + "\treside. Initially, there exist a single file representing the aspect mechanism." + NL + "\tSee its javadoc for details. You may add more files if needed." + NL + "lib/" + NL + "\tJar files required by Awesome." + NL + "build.xml" + NL + "\tAnt file that packs the class files of the mechanism and the platform into" + NL + "\ta single jar file (created within the project, may require a 'refresh'). This" + NL + "\tis actually your mechanism weaver.";
  protected final String TEXT_3 = NL;
  protected final String TEXT_4 = ".manifest" + NL + "\tA manifest describing the aspect mechanism (to be used in future versions).";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     MechanismProject mechProj = (MechanismProject)argument; 
    stringBuffer.append(TEXT_1);
    stringBuffer.append(mechProj.getProjectName());
    stringBuffer.append(TEXT_2);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(mechProj.getDsalName());
    stringBuffer.append(TEXT_4);
    return stringBuffer.toString();
  }
}
