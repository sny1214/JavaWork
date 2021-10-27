package com.jica.chap06;

class MemberCall {
	int iv = 10;
	static int cv = 20;

	int iv2 = cv;        //ok
//	static int cv2 = iv; //error //cv2는 클래스변수이므로 객체생성이전에 미리 확보된다.
	                             //iv는 인스턴스 변수이므로 아직 확보되어 있지 않다. 
	static int cv2 = new MemberCall().iv;	 // ok

	static void staticMethod1() {
		System.out.println(cv); //클래스 변수   ok
//		System.out.println(iv); //인스턴스 변수 error
		MemberCall c = new MemberCall();	
		System.out.println(c.iv);   // 독자적인 객체를 생성했으므로 
		                            // 해당객체의 인스턴스 변수는 접근할 수 있다.

}

	void instanceMethod1() {
		System.out.println(MemberCall.cv);	// 클래스 변수  ok	
		System.out.println(iv);             // 인스턴스 변수 ok
		//return iv;
		
    }

	static void staticMethod2() {
		staticMethod1();   //클래스 메서드   ok
//		instanceMethod1(); //인스턴스 메서드 error 
		MemberCall c = new MemberCall();
		c.instanceMethod1(); // 독자적인 객체를 생성했으므로 
        //                   // 해당객체의 인스턴스 메서드 호출 가능
 	}
	
	void instanceMethod2() {	
		MemberCall.staticMethod1();		// 클래스 메서드 호출 가능
		instanceMethod1();              // 인스턴스 메서드도 호출 가능
	}
}
