package com.jica.chap09;

class StringEx3 {
	public static void main(String[] args) {
		
		char[] cArr = new char[0];   // char[] cArr = {};
		String s = new String(cArr); // String s = new String("");
                  
		//cArr 0x100------>[]  배열요소의 갯수가 0개 짜리인 배열
		//                ^   cArr[0] --->에러
		//                |
		//s    0x200---->[0x100,...]
		
		System.out.println("cArr.length="+cArr.length);  // 0
		System.out.println("@@@"+s+"@@@");               //@@@@@@
	}
}
