package awesome.config.spec;

import org.aspectj.lang.JoinPoint;

public class JoinPointType 
{
	static final int ADVICE_EXECUTION = 1;
	static final int CONSTRUCTOR_CALL = 2;
	static final int CONSTRUCTOR_EXECUTION = 3;          
	static final int EXCEPTION_HANDLER = 4;        
	static final int FIELD_GET = 5;	           
	static final int FIELD_SET = 6;	           
	static final int INITIALIZATION = 7;           
	static final int METHOD_CALL = 8;          
	static final int METHOD_EXECUTION = 9;       
	static final int PREINITIALIZATION = 10;	           
	static final int STATICINITIALIZATION = 11;
	
	static final String ADVICE_EXECUTION_NAME = JoinPoint.ADVICE_EXECUTION;
	static final String CONSTRUCTOR_CALL_NAME = JoinPoint.CONSTRUCTOR_CALL;
	static final String CONSTRUCTOR_EXECUTION_NAME = JoinPoint.CONSTRUCTOR_EXECUTION;          
	static final String EXCEPTION_HANDLER_NAME = JoinPoint.EXCEPTION_HANDLER;        
	static final String FIELD_GET_NAME = JoinPoint.FIELD_GET;	           
	static final String FIELD_SET_NAME = JoinPoint.FIELD_SET;;	           
	static final String INITIALIZATION_NAME = JoinPoint.INITIALIZATION;           
	static final String METHOD_CALL_NAME = JoinPoint.METHOD_CALL;          
	static final String METHOD_EXECUTION_NAME = JoinPoint.METHOD_EXECUTION;       
	static final String PREINITIALIZATION_NAME = JoinPoint.PREINITIALIZATION;	           
	static final String STATICINITIALIZATION_NAME = JoinPoint.STATICINITIALIZATION;
	         
	private int type;
	private String typeName;
	
	public JoinPointType(int type, String typeName)
	{
		this.type = type;
		this.typeName = typeName;
	}
	
	public int getType()
	{
		return type;		
	}
	
	public String getTypeName()
	{
		return typeName;
	}
	
	public String toString()
	{
		return getTypeName();
		
	}
	
	
}
