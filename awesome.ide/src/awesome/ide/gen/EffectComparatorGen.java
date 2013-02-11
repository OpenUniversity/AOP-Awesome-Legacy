package awesome.ide.gen;

import awesome.ide.model.*;

public class EffectComparatorGen
{
  protected static String nl;
  public static synchronized EffectComparatorGen create(String lineSeparator)
  {
    nl = lineSeparator;
    EffectComparatorGen result = new EffectComparatorGen();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package ";
  protected final String TEXT_2 = ";" + NL + "" + NL + "import java.util.Comparator;" + NL + "import java.util.List;" + NL + "" + NL + "import org.aspectj.weaver.AdviceKind;" + NL + "" + NL + "import awesome.platform.AwesomeCore;" + NL + "import awesome.platform.IEffect;" + NL + "" + NL + "" + NL + "public class EffectComparator implements Comparator<IEffect> {" + NL + "" + NL + "\tprivate AdviceKind advKind;" + NL + "\tprivate List<String> mechanismOrder;" + NL + "\t" + NL + "\tpublic EffectComparator(AdviceKind advKind, List<String> mechanismOrder) {" + NL + "\t\tthis.advKind = advKind;" + NL + "\t\tthis.mechanismOrder = mechanismOrder;" + NL + "\t}" + NL + "\t@Override" + NL + "\tpublic int compare(IEffect eff1, IEffect eff2) {" + NL + "\t\tif(!eff1.getKind().equals(advKind) || !eff2.getKind().equals(advKind)) {" + NL + "\t\t\tthrow new RuntimeException(\"The compared effects should be of kind \" + advKind);" + NL + "\t\t}" + NL + "\t\t" + NL + "\t\tString mech1 = AwesomeCore.getMechanismId(eff1.getDeclaringAspect());" + NL + "\t\tString mech2 = AwesomeCore.getMechanismId(eff2.getDeclaringAspect());" + NL + "\t\t" + NL + "\t\tint index1 = mechanismOrder.indexOf(mech1);" + NL + "\t\tint index2 = mechanismOrder.indexOf(mech2);" + NL + "\t\t" + NL + "\t\tif(index1 < index2)" + NL + "\t\t\treturn 1;" + NL + "\t\telse" + NL + "\t\t\treturn -1;" + NL + "\t}" + NL + "" + NL + "}";
  protected final String TEXT_3 = NL;

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    stringBuffer.append(TEXT_1);
    stringBuffer.append(MultiMechanismProject.CONFIG_FOLDER);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(TEXT_3);
    return stringBuffer.toString();
  }
}
