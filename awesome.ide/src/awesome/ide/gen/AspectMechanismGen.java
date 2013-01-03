package awesome.ide.gen;

public class AspectMechanismGen
{
  protected static String nl;
  public static synchronized AspectMechanismGen create(String lineSeparator)
  {
    nl = lineSeparator;
    AspectMechanismGen result = new AspectMechanismGen();
    nl = null;
    return result;
  }

  public final String NL = nl == null ? (System.getProperties().getProperty("line.separator")) : nl;
  protected final String TEXT_1 = "package ";
  protected final String TEXT_2 = ";" + NL + "" + NL + "import awesome.platform.*;" + NL + "import java.util.ArrayList;" + NL + "import java.util.Iterator;" + NL + "import java.util.List;" + NL + "import org.aspectj.weaver.IClassFileProvider;" + NL + "import org.aspectj.weaver.bcel.BcelShadow;" + NL + "import org.aspectj.weaver.bcel.UnwovenClassFile;" + NL + "" + NL + "/**" + NL + " * <p>Every aspect mechanism extends <b>awesome.platform.AwesomeMechanism</b>. By that, your mechanism may reuse the" + NL + " * <b>match</b> and <b>order</b> services of AspectJ. In other words, you may translate" + NL + " * your DSAL program into AspectJ aspects and enjoy its weaving services for free. To allow that," + NL + " * your front-end <b>MUST</b> add to each generated aspect the annotation @AwAspectMechanism(id=\"";
  protected final String TEXT_3 = "\")." + NL + " * The @Aspect annotation is optional, depending on whether you are using @AspectJ or not.</p>" + NL + " * " + NL + " * <p>Of course, you may refine the AspectJ <b>match</b> and <b>order</b> processes" + NL + " * by overriding the corresponding <i>match</i> and <i>order</i> methods. You may want to" + NL + " * do that, e.g., in case your mechanism utilizes new join points that are not part of AspectJ. In" + NL + " * such a case, you will probably appreciate these notes:" + NL + " * <ul>" + NL + " * <li>The protected field <i>List&lt;AspectClass&gt; aspectClasses</i> holds all your DSAL aspects (those marked with" + NL + " * the @AwAspectMechanism(id=\"";
  protected final String TEXT_4 = "\") annotation. You will surely need to access them so hopefully" + NL + " * this list will make your life easier. The list is getting initialized by the <b>AwesomeMechanism.setInputFiles</b> method.</li>" + NL + " * <li>The class <b>awesome.platform.InvokeMethodsEffect</b> may significantly help you" + NL + " * in creating the effects (advice) you like.</li>" + NL + " * </ul></p>" + NL + " * @author oren" + NL + " */" + NL + "public aspect ";
  protected final String TEXT_5 = " extends AwesomeMechanism {" + NL + "\t" + NL + "\tpublic String getId() {" + NL + "\t\treturn \"";
  protected final String TEXT_6 = "\";" + NL + "\t}" + NL + "\t" + NL + "\t@Override" + NL + "\tpublic List<IEffect> match(BcelShadow shadow) {" + NL + "\t\treturn super.match(shadow);\t" + NL + "\t}" + NL + "}";

  public String generate(Object argument)
  {
    final StringBuffer stringBuffer = new StringBuffer();
    String packageName = ((String[])argument)[0];
    String aspectName = ((String[])argument)[1];
    String id = ((String[])argument)[2];
    stringBuffer.append(TEXT_1);
    stringBuffer.append(packageName);
    stringBuffer.append(TEXT_2);
    stringBuffer.append(id);
    stringBuffer.append(TEXT_3);
    stringBuffer.append(id);
    stringBuffer.append(TEXT_4);
    stringBuffer.append(aspectName);
    stringBuffer.append(TEXT_5);
    stringBuffer.append(id);
    stringBuffer.append(TEXT_6);
    return stringBuffer.toString();
  }
}
