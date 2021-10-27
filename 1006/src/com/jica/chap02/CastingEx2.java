package com.jica.chap02;

class CastingEx2 {
	public static void main(String[] args) {
		int  i = 10;
		byte b = (byte)i;
		System.out.printf("[int -> byte] i=%d -> b=%d%n", i, b); 
		
		i = 300;
		b = (byte)i; //강제형변환 -- 큰자료형을 작은자료형에 저장 
		System.out.printf("[int -> byte] i=%d -> b=%d%n", i, b); 

		b = 10;
		i = b;   //자동형변환-- 작은자료형을 큰자료형에 저장
		System.out.printf("[byte -> int] b=%d -> i=%d%n", b, i); 

		b = -2;  
		i = b;  //자동형변환 
		System.out.printf("[byte -> int] b=%d -> i=%d%n", b, i); 

		System.out.println("i="+Integer.toBinaryString(i));
	}
}
