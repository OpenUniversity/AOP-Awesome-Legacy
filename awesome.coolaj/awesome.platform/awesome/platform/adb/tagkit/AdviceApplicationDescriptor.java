package awesome.platform.adb.tagkit;

import awesome.platform.IEffect;

public class AdviceApplicationDescriptor 
{
	private IEffect effect;
	private JoinPointDescriptor jp;


	public AdviceApplicationDescriptor(IEffect application) {
		effect = application;
	}
	
	public IEffect getEffect()
	{
		return effect;
	}
	
	void setJoinpoint(JoinPointDescriptor jpd)
	{
		jp = jpd;		
	}
		

}
