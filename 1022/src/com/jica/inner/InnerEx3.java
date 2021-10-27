package com.jica.inner;

class InnerEx3 {
	private int outerIv = 0;  //인스턴스 변수
	static int outerCv = 0;   //클래스 변수

	class InstanceInner {     //인스턴스 내부 클래스
		int iiv  = outerIv;   // 내부클래스안에서 외부클래스의 멤버를 직접 접근할수 있다(장점)
		int iiv2 = outerCv;
	}

	static class StaticInner {//static 내부 클래스
        //static 내부클래스는 InnerEx3과 관계없이 객체를 생성할수 있다.
		//static 내부클래스 객체가 생성되었을때 InnerEx3객체가 존재하지 않으므로 outerTv 인스턴스변수값을 사용할 수 없다.
        //int siv = outerIv;  
		
		//static 내부클래스 객체가 생성되었을때 InnerEx3객체가 않아도 클래스변수는 이미 정적영역에 확보되어 있으므로
		//outerCv 클래스 인스턴스변수값을 사용할 수 있다.    
		static int scv = outerCv;
	}

	void myMethod() {
		int lv = 0;         //지역변수
		final int LV = 0;   //final 지역변수
	
		class LocalInner { // 지역내부 클래스
			int liv = outerIv;
			int liv2 = outerCv;

			int liv3 = lv;	// 자바버전 8.0 부터 일반지역변수도 사용할 수 있다.
			int liv4 = LV;	// 자바버전 7.0 까지는 final지역변수만 사용할수 있었다.  
		}
	}
}
