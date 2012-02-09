package awesome.config.spec;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.aspectj.weaver.AdviceKind;

public class FeatureInteractions 
{
	static final JoinPointType AdviceExecution = 
	  new JoinPointType(JoinPointType.ADVICE_EXECUTION, JoinPointType.ADVICE_EXECUTION_NAME);
	
	static final JoinPointType ConstructorCall = 
		  new JoinPointType(JoinPointType.CONSTRUCTOR_CALL, JoinPointType.CONSTRUCTOR_CALL_NAME);
	
	static final JoinPointType ConstructorExecution = 
		  new JoinPointType(JoinPointType.CONSTRUCTOR_EXECUTION, JoinPointType.CONSTRUCTOR_EXECUTION_NAME);
	
	static final JoinPointType ExceptionHandler = 
		  new JoinPointType(JoinPointType.EXCEPTION_HANDLER, JoinPointType.EXCEPTION_HANDLER_NAME);
	
	static final JoinPointType FieldGet = 
		  new JoinPointType(JoinPointType.FIELD_GET, JoinPointType.FIELD_GET_NAME);
		
	static final JoinPointType FieldSet = 
		  new JoinPointType(JoinPointType.FIELD_SET, JoinPointType.FIELD_SET_NAME);
		
	static final JoinPointType Initialization = 
		  new JoinPointType(JoinPointType.INITIALIZATION, JoinPointType.INITIALIZATION_NAME);
		
	static final JoinPointType MethodCall = 
		  new JoinPointType(JoinPointType.METHOD_CALL, JoinPointType.METHOD_CALL_NAME);
	
	static final JoinPointType MethodExecution = 
		  new JoinPointType(JoinPointType.METHOD_EXECUTION, JoinPointType.METHOD_EXECUTION_NAME);
	
	static final JoinPointType PreInitialization = 
		  new JoinPointType(JoinPointType.PREINITIALIZATION, JoinPointType.PREINITIALIZATION_NAME);
	
	static final JoinPointType StaticInitialization = 
		  new JoinPointType(JoinPointType.STATICINITIALIZATION, JoinPointType.STATICINITIALIZATION_NAME);

	private List<JoinPointType> emergentTypes;
	
	//private Map<String, List<JoinPointType>> extNameToTypes;
	
	private Map<String, Map<JoinPointType, List<AdviceKind >>> extNameToAdviceTypes;
	
	private FeatureInteractions()
	{
		emergentTypes = new LinkedList<JoinPointType>();
		emergentTypes.add(AdviceExecution);
		emergentTypes.add(ConstructorCall);
		emergentTypes.add(ConstructorExecution);
		emergentTypes.add(ExceptionHandler);
		emergentTypes.add(FieldGet);
		emergentTypes.add(FieldSet);
		emergentTypes.add(Initialization);
		emergentTypes.add(MethodCall);
		emergentTypes.add(MethodExecution);
		emergentTypes.add(PreInitialization);
		emergentTypes.add(StaticInitialization);
				
		extNameToAdviceTypes = new HashMap<String, Map<JoinPointType, List<AdviceKind >>>();
		
		//AspectJ
		
		List<AdviceKind> ajAdviceKinds = new LinkedList<AdviceKind>();
		ajAdviceKinds.add(AdviceKind.Before);
		ajAdviceKinds.add(AdviceKind.Around);
		ajAdviceKinds.add(AdviceKind.After);
		ajAdviceKinds.add(AdviceKind.AfterThrowing);
		ajAdviceKinds.add(AdviceKind.AfterReturning);
		
		Map<JoinPointType, List<AdviceKind>> ajJPTypeToAdviceKinds = 
			new HashMap<JoinPointType, List<AdviceKind>>();
		
		ajJPTypeToAdviceKinds.put(AdviceExecution, ajAdviceKinds);
		ajJPTypeToAdviceKinds.put(ConstructorCall, ajAdviceKinds);
		ajJPTypeToAdviceKinds.put(ConstructorExecution, ajAdviceKinds);
		ajJPTypeToAdviceKinds.put(ExceptionHandler, ajAdviceKinds);
		ajJPTypeToAdviceKinds.put(FieldGet, ajAdviceKinds);
		ajJPTypeToAdviceKinds.put(FieldSet, ajAdviceKinds);
		ajJPTypeToAdviceKinds.put(Initialization, ajAdviceKinds);
		ajJPTypeToAdviceKinds.put(MethodCall, ajAdviceKinds);
		ajJPTypeToAdviceKinds.put(MethodExecution, ajAdviceKinds);
		ajJPTypeToAdviceKinds.put(PreInitialization, ajAdviceKinds);
		ajJPTypeToAdviceKinds.put(StaticInitialization, ajAdviceKinds);
		
		extNameToAdviceTypes.put("AspectJ", ajJPTypeToAdviceKinds);
		
		//COOL
		List<AdviceKind> coolAdviceKinds = new LinkedList<AdviceKind>();
		coolAdviceKinds.add(AdviceKind.Before);
		coolAdviceKinds.add(AdviceKind.After);
		
		Map<JoinPointType, List<AdviceKind>> coolJPTypeAdviceKinds  = 
			new HashMap<JoinPointType, List<AdviceKind>>();
		coolJPTypeAdviceKinds.put(MethodExecution, coolAdviceKinds);
		
		extNameToAdviceTypes.put("COOL", coolJPTypeAdviceKinds);
		
		//Validator
		List<AdviceKind> validAdviceKinds = new LinkedList<AdviceKind>();
		validAdviceKinds.add(AdviceKind.Before);
		
		Map<JoinPointType, List<AdviceKind>> validJPTypeAdviceKinds  = 
			new HashMap<JoinPointType, List<AdviceKind>>();
		validJPTypeAdviceKinds.put(MethodExecution, validAdviceKinds);
		validJPTypeAdviceKinds.put(ConstructorExecution, validAdviceKinds);
		validJPTypeAdviceKinds.put(FieldSet, validAdviceKinds);
		extNameToAdviceTypes.put("Validator", validJPTypeAdviceKinds);
		
		/*
		extNameToTypes = new HashMap<String, List<JoinPointType>>();
		
		extNameToTypes.put("AspectJ", emergentTypes); //all
		
		List<JoinPointType> coolTypes = new LinkedList<JoinPointType>();
		coolTypes.add(MethodExecution);
		extNameToTypes.put("COOL", coolTypes);
		
		List<JoinPointType> validatorTypes = new LinkedList<JoinPointType>();
		validatorTypes.add(MethodExecution);
		validatorTypes.add(ConstructorExecution);
		validatorTypes.add(FieldSet);
		
		extNameToTypes.put("Validator", validatorTypes);
		*/		
	}
	
	private static FeatureInteractions _instance  = new FeatureInteractions();
	
	public static FeatureInteractions instance()
	{
		return _instance;
	}
	
	public List<AdviceKind> getAdviceKinds(String typeName, String extName)
	{
		Map<JoinPointType, List<AdviceKind >> jpTypesToAKind = 	extNameToAdviceTypes.get(extName);
		Set<JoinPointType> visibleTypes = jpTypesToAKind.keySet();
		
		for(JoinPointType jpType : visibleTypes)
		{
			if(jpType.getTypeName().equals(typeName))
			{
				return jpTypesToAKind.get(jpType);
			}
		}
		
		return null;
	}
	
	public boolean isVisible(String typeName, String extName)
	{
		boolean b = false;
		
		Map<JoinPointType, List<AdviceKind >> jpTypesToAKind = 	extNameToAdviceTypes.get(extName);
		if(null == jpTypesToAKind)
			return b;
		
		Set<JoinPointType> visibleTypes = jpTypesToAKind.keySet(); 
		
		for(JoinPointType jpType : visibleTypes)
		{
			if(jpType.getTypeName().equals(typeName))
			{
				b = true;
				break;
			}
		}
		
		return b;
	}
	
	public boolean isInEMJPG(String typeName)
	{
		boolean b = false;
		
		for(JoinPointType jpType : emergentTypes)
		{
			if(jpType.getTypeName().equals(typeName))
			{
				b = true;
				break;
			}
		}
		
		return b;
	}
	
}
