package awesome.ide.gen;

public class AntFileGen
{
  protected static String nl;
  public static synchronized AntFileGen create(String lineSeparator)
  {
    nl = lineSeparator;
    AntFileGen result = new AntFileGen();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "<project name=\"";
  protected final String TEXT_2 = "\" basedir=\".\">\t" + NL + "\t<target name=\"jar\">" + NL + "\t\t<jar destfile=\"";
  protected final String TEXT_3 = ".jar\" basedir=\"bin\"></jar>" + NL + "\t</target>" + NL + "</project>";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     String projectName = ((String[])argument)[0]; 
    stringBuffer.append(TEXT_1);
    stringBuffer.append(projectName);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(projectName);
    stringBuffer.append(TEXT_3);
    return stringBuffer.toString();
  }
}
