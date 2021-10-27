package com.jica.chap05;

class ArrayEx15 {
	public static void main(String[] args) {

		//영문자를 모스 부호로 변환하여 출력하시오.
		String source = "SOSHELP";
					//	   A      B       C     D      E
		String[] morse = {".-", "-...", "-.-.","-..", "."
						,"..-.", "--.", "....","..",".---"
						, "-.-", ".-..", "--", "-.", "---"
						, ".--.", "--.-",".-.","...","-"
						, "..-", "...-", ".--", "-..-","-.--"
						, "--.." };
					//      Z

		
		String result="";
		
		//source 0x05 --> "SOSHELP"
		//result 0x10 --> ""
		for (int i=0; i < source.length() ; i++ ) {		//i 0 ~ 6
			result+=morse[source.charAt(i)-'A'];		//A(모스 배열에서 0번째) 코드값 65
														//source.charAt(i)-'A' : 모스 배열에서의 순번 나옴	
		}

		System.out.println("source:"+ source);
		System.out.println("morse:"+result);
	}
}
