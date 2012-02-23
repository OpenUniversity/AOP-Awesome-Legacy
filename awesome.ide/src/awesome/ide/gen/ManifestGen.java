package awesome.ide.gen;

import awesome.ide.wizards.*;

public class ManifestGen
{
  protected static String nl;
  public static synchronized ManifestGen create(String lineSeparator)
  {
    nl = lineSeparator;
    ManifestGen result = new ManifestGen();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "mechanism-id: ";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    String dsalName = ((ManifestDescriptor)argument).getDsalName();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(dsalName.toLowerCase());
    return stringBuffer.toString();
  }
}
