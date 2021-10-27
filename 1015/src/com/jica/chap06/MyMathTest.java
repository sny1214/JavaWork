package com.jica.chap06;

class MyMathTest {
	public static void main(String args[]) {
		MyMath mm = new MyMath();	//객체 생성
		
		//mm 0x100 ---------->[]  <<멤버변수가 없는 클래스의 객체 - 멤버변수가 하나도 없지만 내부적으로는 1byte 사용
		//						  <<값은 없지만 참조값은 존재한다.
		
		//mm.add() : 괄호 안에 들어가는 게 실매개변수
		long result1 = mm.add(5L, 3L);
		long result2 = mm.subtract(5L, 3L);
		long result3 = mm.multiply(5L, 3L);
		double result4 = mm.divide(5L, 3L);
		
		System.out.println("add(5L, 3L) = "      + result1);
		System.out.println("subtract(5L, 3L) = " + result2);
		System.out.println("multiply(5L, 3L) = " + result3);
		System.out.println("divide(5L, 3L) = "   + result4);
	}
}

class MyMath {
	//멤버변수와 생성자가 없다.
	//메서드들이 다 인스턴스 메서드 이므로 다 객체를 생성해주고 사용해야 한다.
	
	//메서드들 - a,b 형식매개변수, result 지역변수 -> 메서드 끝나면 다 사라진다.
	long add(long a, long b) {
		long result = a+b;
		return result;
	//	return a + b;	// 위의 두줄을 한 문장으로도 가능하다.
	}

	long subtract(long a, long b) {
		return a - b;
	}

	long multiply(long a, long b) {
		return a * b;
	}

	double divide(double a, double b) {
		return a / b;
	}
}
