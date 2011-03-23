package test.comprendo.types;

public class A {
	public void aPublic1(){
		System.out.println("aPublic1");
		aPrivate1();
	}

	private void aPrivate1() {
		System.out.println("aPrivate1");
	}
	
	public void aPublic2(){
		System.out.println("aPublic2");
		aPrivate2();
	}

	private void aPrivate2() {
		System.out.println("aPrivate2");
	}
}
