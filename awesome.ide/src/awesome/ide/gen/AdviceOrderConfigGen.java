package awesome.ide.gen;

import awesome.ide.model.manifests.*;
import awesome.ide.model.*;
import java.util.*;

public class AdviceOrderConfigGen
{
  protected static String nl;
  public static synchronized AdviceOrderConfigGen create(String lineSeparator)
  {
    nl = lineSeparator;
    AdviceOrderConfigGen result = new AdviceOrderConfigGen();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package ";
  protected final String TEXT_2 = ";" + NL + "" + NL + "import java.util.ArrayList;" + NL + "import java.util.Arrays;" + NL + "import java.util.Collections;" + NL + "import java.util.List;" + NL + "" + NL + "import org.aspectj.weaver.AdviceKind;" + NL + "import org.aspectj.weaver.bcel.BcelShadow;" + NL + "" + NL + "import awesome.platform.IEffect;" + NL + "import awesome.platform.MultiMechanism;" + NL + "" + NL + "public aspect BeforeAdviceOrderConfig {" + NL + "\tList<IEffect> around(MultiMechanism mm, List<List<IEffect>> multiEffects, BcelShadow shadow):" + NL + "\t\texecution(List MultiMechanism.multiOrder(List, BcelShadow))" + NL + "\t\t\t&& this(mm) && args(multiEffects, shadow) {" + NL + "\t\t\t\t\t" + NL + "\t\t\tList<IEffect> effects = proceed(mm, multiEffects, shadow);" + NL + "" + NL + "\t\t\t// we remove the effects to be sorted from the list of effects," + NL + "\t\t\t// sort them separately, and then append to the list." + NL + "\t\t\tList<IEffect> removedEffects = removeEffects(effects, AdviceKind.Before);" + NL + "\t\t\tCollections.sort(removedEffects, new EffectComparator(AdviceKind.Before, " + NL + "\t\t\t\t\tArrays.asList(";
  protected final String TEXT_3 = "\"";
  protected final String TEXT_4 = "\"";
  protected final String TEXT_5 = ", ";
  protected final String TEXT_6 = ")));" + NL + "\t\t\t" + NL + "\t\t\teffects.addAll(removedEffects);" + NL + "\t\t\t" + NL + "\t\t\treturn effects;" + NL + "\t}" + NL + "\t" + NL + "\t/**" + NL + "\t * Removes all effects of the given kind from the list of effects, and returns" + NL + "\t * a list of the removed effects." + NL + "\t * @param effects" + NL + "\t * @param kind" + NL + "\t * @return" + NL + "\t */" + NL + "\tprivate List<IEffect> removeEffects(List<IEffect> effects, AdviceKind kind) {" + NL + "\t\tList<IEffect> result = new ArrayList<IEffect>();" + NL + "\t\tfor(IEffect effect : effects)" + NL + "\t\t\tif(effect.getKind().equals(kind))" + NL + "\t\t\t\tresult.add(effect);" + NL + "" + NL + "\t\tfor(IEffect effect : result)" + NL + "\t\t\teffects.remove(effect);" + NL + "\t\t" + NL + "\t\treturn result;" + NL + "\t}" + NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     List<Advice> adviceOrder = (List<Advice>)argument; 
    stringBuffer.append(TEXT_1);
    stringBuffer.append(MultiMechanismProject.CONFIG_FOLDER);
    stringBuffer.append(TEXT_2);
    for(int i=0; i<adviceOrder.size(); i++){
    stringBuffer.append(TEXT_3);
    stringBuffer.append(adviceOrder.get(i).getMechanism());
    stringBuffer.append(TEXT_4);
    if(i!=adviceOrder.size()-1){
    stringBuffer.append(TEXT_5);
    }}
    stringBuffer.append(TEXT_6);
    return stringBuffer.toString();
  }
}
