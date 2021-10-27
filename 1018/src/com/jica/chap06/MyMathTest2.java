package com.jica.chap06;

class MyMath2 {
	//인스턴스 변수 -- 객체 생성시마다 메모리 확보 
	//              인스턴스 메서드에서 사용
	long a, b;
	
	//인스턴스 메서드
	long add() 	    { 
		//return this.a + this.b;
		return a + b;
	}  
	long subtract() { return a - b; }
	long multiply() { return a * b; }
	double divide() { return a / b; }

	// 클래스 변수
	// 객체생성이전에 메모리에 1개만 확보되어 
	// 여러객체에서 공통으로 사용
	static long   add(long a, long b) 	   	 {
		//return this.a + this.b; // this를 사용할 수 없으므로 인스턴스 멤버 접근불가
		//클래스 메서드 내부에서는 매개변수나 지역변수 혹은
		//클래스 변수만 사용할 수 있다.
		return a + b;
	} 
	static long   subtract(long a, long b)   { return a - b; }
	static long   multiply(long a, long b)	 { return a * b; }
	static double divide(double a, double b) { return a / b; }
}

class MyMathTest2 {
	public static void main(String args[]) {
		// 클래스 메서드 호출
		// 클래스.메서드()
		// 객체 생성 없이 사용할수 있다.
		System.out.println(MyMath2.add(200L, 100L));
		System.out.println(MyMath2.subtract(200L, 100L));
		System.out.println(MyMath2.multiply(200L, 100L));
		System.out.println(MyMath2.divide(200.0, 100.0));
		System.out.println();
		
		//객체 생성
		MyMath2 mm = new MyMath2();
		mm.a = 200L;
		mm.b = 100L;
		
		//객체를 사용하여 인스턴스 메서드 호출 - ok
		//클래스 메서드도 호출할 수 있다.
		//mm.add(10L, 20L);  //권장 MyMath2.add(10L,20L);
		System.out.println(mm.add());
		System.out.println(mm.subtract());
		System.out.println(mm.multiply());
		System.out.println(mm.divide());
	}
}
