package awesome.platform.shadows;

public class AddShadowGen
{
  protected static String nl;
  public static synchronized AddShadowGen create(String lineSeparator)
  {
    nl = lineSeparator;
    AddShadowGen result = new AddShadowGen();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package awesome.platform.shadows;" + NL + "" + NL + "public aspect ";
  protected final String TEXT_2 = " {" + NL + "" + NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     String id = ((ShadowSpec)argument).getId(); 
    stringBuffer.append(TEXT_1);
    stringBuffer.append(AddShadowWriter.getAspectName(id));
    stringBuffer.append(TEXT_2);
    return stringBuffer.toString();
  }
}
