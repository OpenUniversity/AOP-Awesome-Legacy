package test.comprendo.types;

public class B {
	public void bPublic1(){
		System.out.println("bPublic1");
		bPrivate1();
	}

	private void bPrivate1() {
		System.out.println("bPrivate1");
	}
	
	public void bPublic2(){
		System.out.println("bPublic2");
		bPrivate2();
	}

	private void bPrivate2() {
		System.out.println("bPrivate2");
	}
}
