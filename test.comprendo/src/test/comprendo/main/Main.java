package test.comprendo.main;

import test.comprendo.types.A;
import test.comprendo.types.B;

public class Main {

	/**
	 * This is an example application that demonstrates the capabilities
	 * of the Comprendo DSAL, and its combination with AspectJ. We create
	 * two classes in the package test.comprendo.types. Each of the classes
	 * has both public and private methods. Main calls their public methods,
	 * and implicitly their private ones are called. A single Comprendo type is
	 * defined in the folder Comprendo/. It monitors these public and private methods. 
	 * An AspectJ aspect also
	 * participates in the game. It is defined in the same test.comprendo.types 
	 * package. The aspect logs each public call in the package, where the actual
	 * logging is handled by a private method defined in the aspect. Thus we expect
	 * the Comprendo type to monitor these method executions either.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		A a = new A();
		B b = new B();
		
		for ( int i=0; i < 10; i++ ) {
			a.aPublic1();
			b.bPublic1();
		}
		for ( int i=0; i < 20; i++ ) {
			a.aPublic2();
			b.bPublic2();
		}
	}

}
