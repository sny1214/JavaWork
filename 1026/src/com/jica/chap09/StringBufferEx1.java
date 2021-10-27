package com.jica.chap09;

class StringBufferEx1 {
	public static void main(String[] args) {
		StringBuffer sb  = new StringBuffer("abc");
		StringBuffer sb2 = new StringBuffer("abc");
		//               |-->|a|b|c|  
		//sb  0x100--->[0x10,...]
		//               |-->|a|b|c|  
		//sb2 0x300--->[0x30,...]
		
		System.out.println("sb == sb2 ? " + (sb == sb2));        //false
		System.out.println("sb.equals(sb2) ? " + sb.equals(sb2));//false 이유? StringBuffer는 equals()메서드를 재정의해서 가지고있지 않으므로
		                                                         //Object의 equals()가 동작한다.
		
		
		// StringBuffer를  String으로 만들기
		String s  = sb.toString();	// String s = new String(sb);�� ����.
		String s2 = sb2.toString();

		System.out.println("s.equals(s2) ? " + s.equals(s2)); //true
	}
}
