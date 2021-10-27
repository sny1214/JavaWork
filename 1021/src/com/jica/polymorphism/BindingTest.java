package com.jica.polymorphism;

class BindingTest{
	//1) 상위형참조변수에 하위형객체를 저장할수 있다
	public static void main(String[] args) {
		Parent p = new Child();
		Child c = new Child();

		//         Child::x  Parent::x  
		//p 0x100----->[200, 100]
		//c 0x200----->[200, 100]
		
		System.out.println("p.x = " + p.x); // 멤버변수값은 참조변수의 자료형을 기준으로
		                                    // 결정한다. Parent의 x멤버변수값==>100
		p.method();   //메서드는 재정의(overriding)된 메서드일때는
		              //실제로 가리키는 인스턴스가 무슨형인가가 결정의 기준이다.
                      //Child의 method()가 작동한다.
		p.pMethod();    //ok
		//p.cMethod();  //컴파일 error
		((Child)p).cMethod();

		System.out.println("----------------------");
		
		System.out.println("c.x = " + c.x);
		c.method();   //Child의 method()가 작동한다.
		
		c.pMethod();  //당연히 컴파일 ok
		c.cMethod();  //당연히 컴파일 ok  
	}
}

class Parent {
	int x = 100;

	void method() {
		System.out.println("Parent Method");
	}
	
	void pMethod() {
		System.out.println("pMethod()");
	}
}

class Child extends Parent {
	int x = 200;

	@Override
	void method() {
		System.out.println("Child Method");
	}
	
	void cMethod() {
		System.out.println("cMethod()");
	}
}
