package com.jica.polymorphism2;

class BindingTest2 {
	public static void main(String[] args) {
		Parent p = new Child();
		Child c = new Child();
		//      Child::,Parent::x
		//p 0x100------>[ 100]
        //c 0x200------>[ 100]
		
		System.out.println("p.x = " + p.x); //멤버변수 p의 자료형으로 판단==>Parent의 x 
		p.method();                         //재정의가 안되었으므로 Parent의  method() 

		System.out.println("c.x = " + c.x); //멤ㅂ변수 c의 자료형으로 판단하는데
		//                                  //Child에는 x멤버가 없으므로 부모 즉, Parent의 x값
		c.method();
	}
}

class Parent {
	int x = 100;

	void method() {
		System.out.println("Parent Method");
	}
}

class Child extends Parent { }
