package awesome.ide.gen;

import awesome.ide.model.manifests.*;
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
  protected final String TEXT_1 = "public aspect BeforeAdviceOrderConfig {" + NL + "\tList around(MultiMechanism mm, List multiEffects, BcelShadow shadow):" + NL + "\t\texecution(List MultiMechanism.multiOrderBefore(List, BcelShadow))" + NL + "\t\t\t&& this(mm) && args(multiEffects, shadow) {" + NL;
  protected final String TEXT_2 = NL + "\t\t\tint ";
  protected final String TEXT_3 = "Pos = mm.getMechanismPos(";
  protected final String TEXT_4 = "Mechanism.class);";
  protected final String TEXT_5 = NL + "\t\t\tList<IEffect> result = new ArrayList<IEffect>();" + NL + "" + NL + "\t\t\t// multiEffects is a List of List<IEffect>";
  protected final String TEXT_6 = NL + "\t\t\tList<IEffect> ";
  protected final String TEXT_7 = "Effects = (List<IEffect>)multiEffects.get(";
  protected final String TEXT_8 = "Pos);";
  protected final String TEXT_9 = NL + NL + "\t\t\t// setting the desired advice order";
  protected final String TEXT_10 = NL + "\t\t\tresult.addAll(";
  protected final String TEXT_11 = "Effects);";
  protected final String TEXT_12 = NL + NL + "\t\t\treturn result;" + NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
     List<Advice> advice = (List<Advice>)(((Object[])argument)[0]); 
     List<String> mechanisms = (List<String>)(((Object[])argument)[1]); 
    stringBuffer.append(TEXT_1);
    for(String mech : mechanisms) {
    stringBuffer.append(TEXT_2);
    stringBuffer.append(mech.toLowerCase());
    stringBuffer.append(TEXT_3);
    stringBuffer.append(mech);
    stringBuffer.append(TEXT_4);
    }
    stringBuffer.append(TEXT_5);
     for(String mech : mechanisms) {
    stringBuffer.append(TEXT_6);
    stringBuffer.append(mech.toLowerCase());
    stringBuffer.append(TEXT_7);
    stringBuffer.append(mech.toLowerCase());
    stringBuffer.append(TEXT_8);
    }
    stringBuffer.append(TEXT_9);
     for(Advice adv : advice) { 
    stringBuffer.append(TEXT_10);
    stringBuffer.append(adv.getMechanism().toLowerCase());
    stringBuffer.append(TEXT_11);
    }
    stringBuffer.append(TEXT_12);
    return stringBuffer.toString();
  }
}
