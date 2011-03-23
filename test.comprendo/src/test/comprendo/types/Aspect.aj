package test.comprendo.types;

public aspect Aspect {
	pointcut publicExecutions():
			execution(public * *.*(..)) && within(test.comprendo.types.*);
	
	before(): publicExecutions(){
		aspectPrivate();
	}
	
	private void aspectPrivate(){
		System.out.println("aspectPrivate");
	}
}
