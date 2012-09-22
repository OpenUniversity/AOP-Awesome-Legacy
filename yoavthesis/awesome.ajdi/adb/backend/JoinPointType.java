package adb.backend;

import java.util.LinkedList;
import java.util.List;

public class JoinPointType 
{
	static final int METHOD_CALL = 1;
	static final int CONSTRUCTOR_CALL = 2;
	static final int METHOD_EXECUTION = 3;          
	static final int CONSTRUCTOR_EXECUTION = 4;        
	static final int FIELD_GET = 5;	           
	static final int FIELD_SET = 6;	           
	static final int STATICINITIALIZATION = 7;           
	static final int PREINITIALIZATION = 8;          
	static final int ADVICE_EXECUTION = 9;       
	static final int INITIALIZATION = 10;	           
	static final int EXCEPTION_HANDLER = 11;
	
	static final String ADVICE_EXECUTION_NAME = "Advice Execution";
	static final String CONSTRUCTOR_CALL_NAME = "Constructor Call";
	static final String CONSTRUCTOR_EXECUTION_NAME = "Constructor Execution";          
	static final String EXCEPTION_HANDLER_NAME = "Exception Handler";        
	static final String FIELD_GET_NAME = "Field Get";	           
	static final String FIELD_SET_NAME = "Field Set";	           
	static final String INITIALIZATION_NAME = "Initialization";           
	static final String METHOD_CALL_NAME = "Method Call";          
	static final String METHOD_EXECUTION_NAME = "Method Execution";       
	static final String PREINITIALIZATION_NAME = "Pre-Initialization";	           
	static final String STATICINITIALIZATION_NAME = "Static Initialization";
	         
	
	
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

	private int type;
	private String typeName;
	
	private static List<JoinPointType> types;
	
	
	public JoinPointType(int type, String typeName)
	{
		
		
		this.type = type;
		this.typeName = typeName;
	}
	
	private static void initTypes()
	{
		if(null == types)
		{
			types = new LinkedList<JoinPointType>();
			types.add(AdviceExecution);
			types.add(ConstructorCall);
			types.add(ConstructorExecution);
			types.add(ExceptionHandler);
			types.add(FieldGet);
			types.add(FieldSet);
			types.add(ConstructorExecution);
			types.add(Initialization);
			types.add(MethodCall);
			types.add(MethodExecution);
			types.add(PreInitialization);
			types.add(StaticInitialization);
		}
	}
	
	public static String getTypeName(int id)
	{
		initTypes();
		
		for(JoinPointType t: types)
		{
			if(t.getType() == id)
			{
				return t.getTypeName();
			}
		}
		
		return "unkown";
	}
	
	public int getType()
	{
		return type;		
	}
	
	public String getTypeName()
	{
		return typeName;
	}
	

}
