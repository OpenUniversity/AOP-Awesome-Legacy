package awesome.ide.gen;

public class EndUserReadmeGen
{
  protected static String nl;
  public static synchronized EndUserReadmeGen create(String lineSeparator)
  {
    nl = lineSeparator;
    EndUserReadmeGen result = new EndUserReadmeGen();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "Thank you for using Awesome!" + NL + "" + NL + "Awesome allows you to use domain-specific aspect languages (DSALs) in your Java" + NL + "project. The kind of DSALs you may use depends on the Awesome weaver you have added." + NL + "" + NL + "Here are some basic Awesome guidelines:" + NL + "- You keep writing Java code as usual." + NL + "- You may define new DSAL code, anywhere in the project. However..." + NL + "- DO NOT write any code in src-gen. This folder holds code generated by the Xtext front-end." + NL + "- The weaving and execution of your application should be done solely using the" + NL + "  two provided launch files (see below)." + NL + "- Before each execution of your code, you should first weave the base system with the" + NL + "  various aspects. Run ";
  protected final String TEXT_2 = ".weave.launch for that." + NL + "- Execute your code using ";
  protected final String TEXT_3 = ".execute.launch. (Note that you should first" + NL + "  update the launch file with the correct Main class.)";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     String projectName = (String)argument; 
    stringBuffer.append(TEXT_1);
    stringBuffer.append(projectName);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(projectName);
    stringBuffer.append(TEXT_3);
    return stringBuffer.toString();
  }
}
