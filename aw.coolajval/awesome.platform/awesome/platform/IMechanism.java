package awesome.platform;
import java.util.*;
import org.aspectj.weaver.IClassFileProvider;
import org.aspectj.weaver.bcel.BcelShadow;
import org.aspectj.weaver.bcel.LazyClassGen;
import org.aspectj.weaver.patterns.PerClause;

public interface IMechanism 
{	
	public void setInputFiles(IClassFileProvider input);
	public List<IEffect> match(BcelShadow shadow);
	public List<IEffect> order(BcelShadow shadow, List<IEffect> effects);
	
	public boolean handledByMe(LazyClassGen aspectClazz);
	public List<IEffect> getEffects(LazyClassGen aspectClazz);
	
	public PerClause.Kind getPerClause(LazyClassGen aspectClazz);
	
	public String getName();
	
	//public String getInstanceFieldName();
}
