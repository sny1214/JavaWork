package com.jica.chap03;

class OperatorEx26 {
	public static void main(String[] args) { 
		int a = 5;
		int b = 0;

		System.out.printf("a=%d, b=%d%n", a, b);	// a b
													// 5 0 
		System.out.printf("a!=0 || ++b!=0 = %b%n", a!=0 || ++b!=0);
												// 앞 조건식이 true --> 뒤 조건식은 실행도 안하고 전체가 true 그러므로 ++b 되지 않음
		
		System.out.printf("a=%d, b=%d\n", a, b);
		System.out.printf("a==0 && ++b!=0 = %b%n", a==0 && ++b!=0);
												// 앞 조건식이 false --> 뒤 조건식은 실행도 안하고 전체가 false 그러므로 ++b 되지 않음
		System.out.printf("a=%d, b=%d%n", a, b);
	} // main�� ��
}
