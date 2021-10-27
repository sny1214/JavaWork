package com.jica.chap03;

class OperatorEx27 {
	public static void main(String[] args) { 
		boolean  b  = true; 
		char ch = 'C';
		//									b  true
		//									ch 67 		'C'
		System.out.printf("b=%b\n", b);	      //true
		System.out.printf("!b=%b\n", !b);     //false
		System.out.printf("!!b=%b\n", !!b);   //true
		System.out.printf("!!!b=%b\n", !!!b); //false
		
		System.out.printf("b=%b\n", b);	      //b 값은 변하지 않음
		System.out.println();

		System.out.printf("ch=%c\n", ch);	  //C 67
		System.out.printf("ch < 'a' || ch > 'z'=%b\n", ch < 'a' || ch > 'z');	 // 앞조건식 true //a 97 z 122
	    System.out.printf("!('a'<=ch && ch<='z')=%b\n", !('a'<= ch && ch<='z')); // 위의 식을 전체적으로 부정한 것 // 위 식 = 아래 식
	    System.out.printf("  'a'<=ch && ch<='z' =%b\n",   'a'<=ch && ch<='z');
	} // main�� ��
}
