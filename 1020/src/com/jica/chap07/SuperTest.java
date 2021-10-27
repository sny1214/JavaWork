package com.jica.chap07;

class SuperTest {
	public static void main(String args[]) {
		Child c = new Child();
		//		 	Child::x  parent::x
		//c 0x100--------->     [10]
		
		c.method();
	}
}

class Parent {
	int x=10;
}

class Child extends Parent {
	void method(/*int x*/) {
		//매개변수나 지역변수명과 멤버변수명이 일치하면
		//매개변수나 지역변수가 우선한다.
		
		//int x에서 x : 매개변수
		//int x = (int)(Math.random() *100);
		
		System.out.println("x=" + x);			//매개변수,지역변수에 x 없음
												// --> child에 x없음, parent에 x 있음
												//Parent의 x --> 10
		System.out.println("this.x=" + this.x);	 //내 클래스의 x 없으면 부모 클래스의 x --> Parent의 x --> 10
		System.out.println("super.x="+ super.x); //무조건 부모 클래스의 x --> Parent의 x --> 10
	}
}
