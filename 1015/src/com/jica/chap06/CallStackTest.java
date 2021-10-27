package com.jica.chap06;

class CallStackTest {  
	//main()메서드는 프로그램의 시작점
	public static void main(String[] args) {
		int m = 10;
		System.out.println("main()메서드 시작 " + m);
		firstMethod();
		System.out.println("main()메서드 시작 " + m);
	}

	static void firstMethod() {
		int f = 20;
		System.out.println("	first()메서드 시작 " + f);
		secondMethod();
		System.out.println("	first()메서드 끝 " + f);
	}

	static void secondMethod() {
		int s = 30;
		System.out.println("		second()메서드 시작 "+ s);
		System.out.println("		second()메서드 끝 " + s);		
	}
}
