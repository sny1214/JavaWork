package com.jica.inner;

class Outer {
	class InstanceInner {
		int iv=100;
	}
	static class StaticInner {
		int iv=200;
		static int cv=300;
	}

	void myMethod() {
		class LocalInner {
			int iv=400;
		}
	}
}

class InnerEx4 {
	public static void main(String[] args) {
		// 외부클래스 Outer객체를 생성한다.	
		Outer oc = new Outer();
		
		// Outer클래스의 InstanceInner객체를 생성해보자
		// 인스턴스 내부클래스의 객체는 반드시 외부클래스의 객체와 연동시켜 생성해야 한다.
		// 이런 문법이 필요한 이유는 내부클래스객체에서는 외부클래스의 멤버를 자유롭게 접근할수 있다.
		// Outer.InstanceInner ii = new Outer.InstanceInner(); //error
		
		// 그래서 아래와 같은 특이한 형태의 문법을 적용해야 한다.
		Outer.InstanceInner ii = oc.new InstanceInner();     //ok
		System.out.println("ii.iv : "+ ii.iv);
		
		// static내부클래스의 객체 생성은 외부클래스의 객체와 상관없이  자유롭게 생성할수 있다.
		Outer.StaticInner ss = new Outer.StaticInner();     //ok
		System.out.println("ss.iv : "+ ss.iv);
		System.out.println("ss.cv : "+ ss.cv);
		
		System.out.println("Outer.StaticInner.cv : " + Outer.StaticInner.cv);

	}
}
