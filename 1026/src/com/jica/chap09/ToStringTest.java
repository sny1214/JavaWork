package com.jica.chap09;

class ToStringTest {
	public static void main(String args[]) {
		String str = new String("KOREA");
		
		//아래표현처럼 패키지명.클래스명을 사용하면 import구문을 생략할수 있다.
		java.util.Date today = new java.util.Date();

		//                   |-->|K|O|R|E|A|
		//str    0x100---->[0x10,...]
		//today  0x200---->[..년월일시분초정보..]
		
		//String과 Date 클래스에는 toString()메서드가 재정의 되어 있다.
		System.out.println(str);
		System.out.println(str.toString());
		System.out.println(today);
		System.out.println(today.toString());
	}
}
