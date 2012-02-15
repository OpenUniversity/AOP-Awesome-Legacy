package awesome.platform.adb.tagkit;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.aspectj.weaver.AdviceKind;
import org.aspectj.weaver.AjAttribute;
import org.aspectj.weaver.bcel.BcelShadow;

import awesome.config.spec.FeatureInteractions;
import awesome.platform.MultiMechanism;

public class JoinPointGranularityAttribute extends AjAttribute
{
	private List<BcelShadow> allShadows;
	private MultiMechanism mm;
	
	public JoinPointGranularityAttribute(MultiMechanism mm, List<BcelShadow> allShadows)
	{
		this.allShadows = allShadows;
		this.mm = mm;		
	}

	@Override
	protected void write(DataOutputStream s) throws IOException 
	{
		List<String> mechNames = mm.getNames();
		
		s.writeInt(allShadows.size());
		
		for(BcelShadow shadow : allShadows)
		{						
			Map<String, List<AdviceKind>> visibleIn = new HashMap<String, List<AdviceKind>>();
			
			for(String name : mechNames)
			{
				if(FeatureInteractions.instance().isVisible(shadow.getKind().getName(), 
						name))
				{
					List<AdviceKind> adviceKinds = 
						FeatureInteractions.instance().getAdviceKinds(shadow.getKind().getName(), name);
					
					visibleIn.put(name,	adviceKinds);
				}
			}
						
			s.writeByte(shadow.getKind().getKey());
			s.writeInt(shadow.getSourceLine());
		
			String sourceFile = shadow.getEnclosingClass().getFileName();
				
			s.writeUTF(sourceFile);

			s.writeInt(visibleIn.keySet().size());
			for(String name : visibleIn.keySet() )
			{				
				s.writeUTF(name);
				List<AdviceKind> adviceKinds = visibleIn.get(name);
				
				s.writeInt(adviceKinds.size());
				for(AdviceKind kind : adviceKinds)
				{
					String kindName = kind.getName();
					s.writeUTF(kindName);
				}				
			}				
		}
	}

	@Override
	public String getNameString() {
		return "JoinPointGranularityAttribute";
	}
	
}
