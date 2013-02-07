package awesome.ide.gen;

import awesome.ide.model.*;

public class AMTestReadmeGen
{
  protected static String nl;
  public static synchronized AMTestReadmeGen create(String lineSeparator)
  {
    nl = lineSeparator;
    AMTestReadmeGen result = new AMTestReadmeGen();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "Write Awesome tests!" + NL + "" + NL + "In this test project you make sure that your aspect mechanism works as expected" + NL + "(or that the composition of multiple mechanisms is well functioning in the multi-mechanism case)." + NL + "It is done by defining a test application (a base system and some example aspects), " + NL + "passing the application to the weaver, and verify the results. The project's components" + NL + "are listed below." + NL + "" + NL + "lib/" + NL + "\tJar files required by Awesome. Don't touch...";
  protected final String TEXT_2 = NL;
  protected final String TEXT_3 = "/" + NL + "\tHere you create your test application that usually consists of a base system (in base/)" + NL + "\tand additional aspects (in aspects/). We have created a Main file and initial aspects," + NL + "\tone for each mechanism, as a starting point. Note that other aspects you choose to add" + NL + "\thave appropriate class-level annotations. After defining the application, (1) execute weave.launch to" + NL + "\tweave the application (2) refresh, and (3) run execute.launch." + NL + "weaving-info/" + NL + "\tHolds information collected during the weaving of the test application. The info is" + NL + "\tin binary form, and is used by the test case mentioned below." + NL + "src/testapps" + NL + "\tUse the enclosing JUnit test case to verify that the results are as expected. See" + NL + "\tits Javadoc for more details.";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     MechanismProject mechProj = (MechanismProject)argument; 
    stringBuffer.append(TEXT_1);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(AspectMechanismTestProject.TESTAPP_FOLDER);
    stringBuffer.append(TEXT_3);
    return stringBuffer.toString();
  }
}
