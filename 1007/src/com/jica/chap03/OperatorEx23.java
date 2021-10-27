package com.jica.chap03;

class OperatorEx23 {
	public static void main(String[] args) {
		// 아래의 코드는 모두 문자열 변수를 표현한다.
		// 주의사항) 문자열 변수는 참조형 변수 즉, 위치정보가 저장된다. 그러므로 메모리 구조는 다르다.
		//
		//System.out.println("abc");
		
		String str1 = "abc";
		String str2 = new String("abc");
		String str3 = "abc";
		//String str4 = new String("abc");
		
		//      메모리(참조값, 주소) -------------------------> 내용값
		//str1  0x10(static동적영역에 있음)                      abc
		//str2  0X500(new 써서 객체 생성 - heap정적영역에 있음)     abc

		System.out.printf("\"abc\"==\"abc\" ? %b%n", "abc"=="abc");	//true
		System.out.printf(" str1==\"abc\" ? %b%n",    str1=="abc"); //true
		System.out.printf(" str2==\"abc\" ? %b%n",    str2=="abc"); //false
		
		//equals는 내용값 비교
		System.out.printf("str1.equals(\"abc\") ? %b%n", str1.equals("abc")); //true
		System.out.printf("str2.equals(\"abc\") ? %b%n", str2.equals("abc")); //true
		System.out.printf("str2.equals(\"ABC\") ? %b%n", str2.equals("ABC")); //false 대문자는 동적영역에 따로 있음
		System.out.printf("str2.equalsIgnoreCase(\"ABC\") ? %b%n", str2.equalsIgnoreCase("ABC")); //대소문자 구분x, 주소,내용값 다르지만 글자 같으니 true
	}
}
