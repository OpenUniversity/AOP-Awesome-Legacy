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
  protected final String TEXT_1 = "Welcome to Awesome!" + NL + "" + NL + "You have asked to create an aspect mechanism project so here we are..." + NL + "Within this project you will develop a weaver (mechanism) for your new DSAL." + NL + "In some cases, the default (generated) mechanism will answer all your needs. " + NL + "Otherwise,  the mechanism should be refined. To get started, review the different" + NL + "components of the project, and don't forget to look at the README of the corresponding" + NL + "test project." + NL + "" + NL + "src/";
  protected final String TEXT_2 = NL + "\tThis is the package where the implementation of the mechanism resides." + NL + "\tInitially, there exist a single file of the default aspect mechanism." + NL + "\tSee its javadoc for details. You may add other auxiliary files if needed." + NL + "src-dev/" + NL + "\tThis source folder is used during development. It contains utilities" + NL + "\tfor collecting information during the weaving of the test application." + NL + "\tThe info will help you in testing your aspect mechanism." + NL + "lib/" + NL + "\tJar files required by Awesome. Please don't touch." + NL + "build.xml" + NL + "\tAn ant file that packs the class files of the mechanism and the platform into" + NL + "\ta single jar file (created within the project, may require a 'refresh'). This" + NL + "\tis actually the weaver you will use for deployment. Note: in case your weaver" + NL + "\twill be part of a multi-weaver, this jar is useless.";
  protected final String TEXT_3 = NL;
  protected final String TEXT_4 = ".manifest" + NL + "\tA manifest describing the aspect mechanism (currently not in use, a future feature).";

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
