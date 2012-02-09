package awesome.platform.adb.tagkit;

import org.aspectj.weaver.bcel.BcelShadow;

import awesome.platform.IEffect;

public class EffectApplication 
{
	public EffectApplication(IEffect effect, BcelShadow shadow)
	{
		this.effect = effect;
		this.shadow = shadow; 		
	}
	
	public BcelShadow getShadow()
	{
		return shadow;
	}
	
	public IEffect getEffect()
	{
		return effect;
	}
	
	private BcelShadow shadow;
	private IEffect effect;

}
