package com.jica.chap06;
//class 순서는 상관없음

class MyMathTest2 {
	public static void main(String args[]) {
		// MyMath2클래스로 객체를 생성하지 않고 --> static메서드 이다.
		// 클래스명.메서드() 형태로 출력했다. 
		// 호출된 모든 메서드들은 static 메서드 즉, 클래스 메서드임을 짐작할 수 있다.
		
		//MyMath2 중 static 메서드, 객체 생성필요 없음
		System.out.println("객체 생성없이 클래스명.메서드() 혀애의 호출 ==> 클래스 메서드");
		System.out.println(MyMath2.add(200L, 100L));
		System.out.println(MyMath2.subtract(200L, 100L));
		System.out.println(MyMath2.multiply(200L, 100L));
		System.out.println(MyMath2.divide(200.0, 100.0));

		System.out.println();
				
		//객체 생성
		MyMath2 mm = new MyMath2();
		//					 a b
		//mm 0x100 -------->[0,0];
		mm.a = 200L;
		mm.b = 100L;
		
		System.out.println("객체 생성 후 객체를 이용한 메서드 호출 ===> 인스턴스 메서드");
		System.out.println(mm.add());
		System.out.println(mm.subtract());
		System.out.println(mm.multiply());
		System.out.println(mm.divide());
		
		mm.add(500L,300L);		//인스턴스메서드 호출하는 식(mm.add())으로 보이지만 인자값 호출했으므로  static 메서드. --> 헷갈릴 수 있으므로 사용 자제
		MyMath2.add(500L,300L);	//권장하는 코드 -- static 메서드 호출 시 코드
	
		double r = MyMath2.divide(10.5, 2.8);
		System.out.println("실수 나눗셈 결과 : " + r);
		r = MyMath2.divide(10.0, 0.0);
		System.out.println("실수 나눗셈 결과 : " + r);		//결과값 : Infinity 내부적으로 값을 가질 수 없다
		
		int r2 = MyMath2.divide(5,  2);		//결과값 나옴
		System.out.println("정수 나눗셈 결과 : " + r2);
		r2 = MyMath2.divide(5, 0);						//// 유효성 검사로 error가 발생하지는 않는다.(프로그램 중단되지는 않는다)
		System.out.println("정수 나눗셈 결과 : " + r2);		//error 발생 (예외 발생), java.lang.ArithmeticException: / by zero
	}
}

class MyMath2 {
	long a, b;			//인스턴스 멤버변수
	
	// 인스턴스 멤버변수를 사용하는 메서드들 -- 인스턴스 메서드(일반 메서드)  --> 객체 생성 필요
	// a, b 인스턴스 변수 (지역변수랑 매개변수 없으므로)
	long add() 	    { return a + b; }		//메서드 이름 add, 인자정보 없음
	long subtract() { return a - b; }
	long multiply() { return a * b; }
	double divide() { return a / b; }

	// 인자값만 사용하고 인스턴스 멤버변수는 사용하지 않는 메서드들 (밑에 a,b는 인스턴스 멤버변수 아닌 지역변수인데 이름만 같을 뿐이다)
	// 인스턴스 멤버변수를 쓰지 않으므로 객체생성할 필요 없음 -> static 메서드로 작성하여 객체 생성없이 호출할 수 있도록 한다.
	
	//아래 코드의 a, b는 모두 매개변수를 사용한다.
	static long   add(long a, long b) 	   	 { return a + b; }  //메서드 이름 add, 인자정보 a,b ---> 똑같은 메서드 있는데 인자정보 다르면 구분됨(오버로딩)
	static long   subtract(long a, long b)   { return a - b; }
	static long   multiply(long a, long b)	 { return a * b; }
	static double divide(double a, double b) {
		// 주의) 모든 컴퓨터 언어에서는 실수 나누는 기능을 수행되지만, 0으로 나눈 계산 결과값은 Infinity이다.
		return a / b; }
	
	static int divide(int a, int b) {
		// 주의) 모든 컴퓨터 언어에서는 정수연산에서 0으로 나눌 수 없다.
		//		예외(error)가 발생한다. = "프로그램 강제 중단" 발생
		//미리 연산에 참여하는 변수가 유효한지 검사하는 기능이 필요한다.
		//이러한 기능을 매개변수의 유효성 검사라고 한다.
		if(b==0) {
			System.out.println("0으로 나눌 수 없습니다.");
			return 0;		//프로그램 안 멈추고 0으로 결과값이 나오도록 --> 에러가 발생하지는 않는다
		}
		return a / b; }
	
	
	
	
	//주의) 메서드 내부에서 매개변수명과 멤버변수명이 동일할 때
	//변수명을 사용하면 매개변수가 우선적으로 사용된다.
	//멤버변수로 인식하게 하려면 this.멤버변수를 사용해야 한다.
	
	long plus(long a, long b) {	//매개변수
		//위의 매개변수명 a 또는 b와 동일한 지역변수를 선언할 수 없다.
		//long a;	//지역변수
		
		long result;
		result = a + b;		// 매개변수에도 a,b 있고 멤버변수에도 a,b 있을 땐 우선적으로 매개변수가 사용됨. 매개변수 a,b 임을 알 수 있다.
		result = this.a + this.b;	//멤버변수 a,b를 쓰려면 this.멤벼변수 식으로 써야한다.
		return result;
	}
	
	//메서드명은 같고 매개변수 정보가 다른 다양한 메서드를 작성할 수 있다.
	//이를 메서드 오버로딩(overloading)이라고 한다.
}