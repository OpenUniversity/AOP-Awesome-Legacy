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
  protected final String TEXT_1 = "Here we explain the different components of the aspect mechanism test project. In" + NL + "this project you test your aspect mechanism by defining a test application, passing" + NL + "it to the weaver and verify the results." + NL + "" + NL + "lib/" + NL + "\tJar files required by Awesome." + NL + "testapp1/" + NL + "\tHere you create your test application that consists of a base system (in base/)" + NL + "\tand additional aspects (aspects/). We have created a Main file and an initial aspect" + NL + "\tas a starting point. After defining the application, use first weave.launch to" + NL + "\tweave the application (refresh) and then execute.launch." + NL + "src/testapps" + NL + "\tUse the enclosing JUnit test case to verify that the results are as expected.";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     MechanismProject mechProj = (MechanismProject)argument; 
    stringBuffer.append(TEXT_1);
    return stringBuffer.toString();
  }
}
