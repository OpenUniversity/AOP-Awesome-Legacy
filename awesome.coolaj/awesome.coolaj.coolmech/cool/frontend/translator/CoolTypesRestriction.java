package cool.frontend.translator;
import java.util.*;

public class CoolTypesRestriction implements CoolTypeRestriction {

	private final CoolPrimType[] types;


	public CoolTypesRestriction(CoolPrimType[] types) throws Exception {
		int size = 0;
		if (types!=null) {
			for (CoolPrimType type:types)
				if (type!=null) size++;
		}
		if (size == 0) 
			throw new Exception("Cannot create a type restriction that satisfies no types!");
		this.types = new CoolPrimType[size];
		size=0;
		for (CoolPrimType type:types)
			if (type!=null) this.types[size++]=type;
	}
	
	public boolean satisfies(CoolType type) {
		if (type==null) return false;
		if (type instanceof CoolPrimType)  {
			CoolPrimType primType = (CoolPrimType)type;
			for (CoolPrimType thisType:types)
				if (thisType.isSameAs(primType))
					return true;
		} 
		return (type instanceof CoolUnknownType);
	}

	public CoolType getWidestAllowedType() {
		CoolPrimType result = types[0];
		for (int i=1;i<types.length;i++)
			if (types[i].isWiderThan(result))
				result = types[i];
		return result;
	}
	
	public String toString() {
		String result = ", ";
		for (CoolType type:types)
			result = ", "+type.toString();
		return result.substring(2);
	}

}
