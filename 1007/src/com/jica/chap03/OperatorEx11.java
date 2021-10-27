package com.jica.chap03;

class OperatorEx11 {
	public static void main(String args[]) { 
		char a = 'a'; 		//코드값 97	//char 코드값이 저장된다.
		char d = 'd';		//코드값100

		char zero = '0';	//코드값 48
		char two  = '2';	//코드값 50

		System.out.printf("'%c' - '%c' = %d\n", d, a, d - a); // 'd' - 'a' = 3 (연산), 코드값 알고싶을 땐 %d
		System.out.printf("'%c' - '%c' = %d\n", two, zero, two - zero);
		System.out.printf("'%c'=%d\n", a, (int)a);
		System.out.printf("'%c'=%d\n", d, (int)d);
		System.out.printf("'%c'=%d\n", zero, (int)zero);
		System.out.printf("'%c'=%d\n", two,  (int)two);
	}
}
