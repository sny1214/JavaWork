package com.jica.polymorphism3;

class BindingTest3{
	public static void main(String[] args) {
		Parent p = new Child();
		Child  c = new Child();
		//            Child::x Parent::x
		//p 0x100-------->[200,100]
		//c 0x200-------->[200,100]
		
		System.out.println("p.x = " + p.x); //100
		p.method();                         //재정의된 메서드의므로 Child의 method()
		
		System.out.println();
		System.out.println("c.x = " + c.x); //200
		c.method();                         //재정의된 메서드의므로 Child의 method()
	}
}

class Parent {
	int x = 100;

	void method() {
		System.out.println("Parent Method");
	}
}

class Child extends Parent {
	int x = 200;
	
	@Override
	void method() {
		System.out.println("x=" + x);  // this.x�� ����.
		System.out.println("super.x=" + super.x);
		System.out.println("this.x="  + this.x);
	}
}
