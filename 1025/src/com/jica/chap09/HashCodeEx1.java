package com.jica.chap09;

import java.util.Scanner;

class HashCodeEx1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
	
		String str1 = new String("abc");
		String str2 = new String("abc");
		String str3 = null;
		String str4 = new String("abd");
		
		System.out.print("문자열 입력 ==>");
		str3 = scanner.nextLine();    //"abc"입력
		
		//                    |-->|'a'|'b'|'c'|
		//str2 0x200------->[0x10,...]
		//str1 0x100------->[0x10,...]
		//str3 0x300------->[0x30,...]
		//                    |-->|'a'|'b'|'c'|   
		//str4 0x400------->[0x40,...]
		//                    |-->|'a'|'b'|'d'|  	
		
		System.out.println(str1.equals(str2));  //true
		
		System.out.println(str1.hashCode());   //정수값--|같다
		System.out.println(str2.hashCode());   //정수값  |
		System.out.println(str3.hashCode());   //정수값--|	
		System.out.println(str4.hashCode());   //정수값 - 다르다
		
		
		//의도적으로 내용값이 같아도 해시코드값을 다르게 사용할 경우를 위해 아래의 메서드를 제공한다. 
		System.out.println(System.identityHashCode(str1));
		System.out.println(System.identityHashCode(str2));
	}
}
