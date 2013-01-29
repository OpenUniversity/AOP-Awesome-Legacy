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
  protected final String TEXT_1 = "Write Awesome tests!" + NL + "" + NL + "An aspect mechanism project has an associated test project. " + NL + "In this test project you make sure that your aspect mechanism works as expected." + NL + "It is done by defining a test application (a base system and some example aspects), " + NL + "passing the application to the weaver, and verify the results. The components of this" + NL + "test project are listed below." + NL + "" + NL + "lib/" + NL + "\tJar files required by Awesome. Don't touch..." + NL + "testapp1/" + NL + "\tHere you create your test application that usually consists of a base system (in base/)" + NL + "\tand additional aspects (aspects/). We have created a Main file and an initial aspect" + NL + "\tas a starting point. Note that other aspects you choose to add should have the same" + NL + "\tclass-level annotations. After defining the application, (1) execute weave.launch to" + NL + "\tweave the application (2) refresh, and (3) run execute.launch." + NL + "src/testapps" + NL + "\tUse the enclosing JUnit test case to verify that the results are as expected.";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     MechanismProject mechProj = (MechanismProject)argument; 
    stringBuffer.append(TEXT_1);
    return stringBuffer.toString();
  }
}
