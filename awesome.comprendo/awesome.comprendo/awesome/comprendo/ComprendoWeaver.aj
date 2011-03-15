package awesome.comprendo;

import java.util.List;

import org.aspectj.weaver.bcel.BcelShadow;

import awesome.platform.AbstractWeaver;
import awesome.platform.IEffect;

public aspect ComprendoWeaver extends AbstractWeaver {

	@Override
	public List<IEffect> match(BcelShadow shadow) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<IEffect> order(BcelShadow shadow, List<IEffect> effects) {
		// TODO Auto-generated method stub
		return null;
	}

}
