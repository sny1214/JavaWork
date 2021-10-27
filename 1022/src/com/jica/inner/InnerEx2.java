package com.jica.inner;

class InnerEx2 {
	class InstanceInner {}      // 인스턴스 내부클래스 
	static class StaticInner {} // static 내부클래스

	// 인스턴스멤버간에는 서로 직접 접근이 가능하다.
	InstanceInner iv = new InstanceInner();
	// static 멤버간에는 서로 직접 접근이 가능하다.
	static StaticInner cv = new StaticInner();

	static void staticMethod() {
        // static멤버는 인스턴스 멤버를 직접 접근 할수 없다(Java버전에 따라 다르다)
		// InstanceInner obj1 = new InstanceInner();	//예전 버전에서는 error
		
		// static메서드 내부에서는 static내부클래스를 사용할 수 있다.
		StaticInner obj2 = new StaticInner();

        // 외부클래스 InnerEx2로 객체를 생성
		InnerEx2 outer = new InnerEx2();
		// 외부클래스 객체를 사용하여 인스턴스 내부클래스의 객체를 생성한다.
		InstanceInner obj1 = outer.new InstanceInner(); //14라인이 error일때 인스턴스 내부클래스의 개체생성방법
	}

	void instanceMethod() {
        //인스턴스메서드에서는 인스턴스 내부클래스나 static 내부클래스 모두 객체 생성이 가능하다.
		InstanceInner obj1 = new InstanceInner();
		StaticInner obj2 = new StaticInner();
		//LocalInner클래스는 myMethod()메서드에 선언된 지역내부클래스이므로 
		//myMethod()내부에서만 객체를 생성할 수 있다.
		//LocalInner lv = new LocalInner();  //error
	}

	void myMethod() {
		class LocalInner {} //지역내부 클래스
		LocalInner lv = new LocalInner();
	}
}
