package com.jica.chap02;

class CharToCode { 
	public static void main(String[] args) { 
		char ch = 'A';	     // char ch = 65;         
		int code = ch;       // int code = (int)ch;

		System.out.printf("%c=%d(%#X)%n", ch, code, code); //A=65(0X41)


		char hch = '가';     // char hch = 0xAC00; 
		System.out.printf("%c=%d(%#X)%n", hch, (int)hch, (int)hch);
	} 
} 
