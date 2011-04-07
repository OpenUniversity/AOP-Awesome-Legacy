package test.comprendo.types;

import comprendo.gen.*;

public class B {
	private Comprendo_PublicPrivateExecutions _comprendo = new Comprendo_PublicPrivateExecutions();
	
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
