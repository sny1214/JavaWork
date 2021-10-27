package com.jica.chap03;

import java.util.Scanner;  // Scanner클래스를 사용하기 위해서 import한다. <권장>
//import java.util.*;	//java.util 패키지의 어떤 클래스를 쓸지 정하지 않음. 모든 클래스를 쓸 수있게 하겠다.

class OperatorEx25 {
	public static void main(String args[]) { 
		//입력전용객체 선언 및 생성
		Scanner scanner = new Scanner(System.in);
		char ch = ' ';	//빈공간으로 초기화함

		System.out.printf("문자를 하나 입력하세요 >> ");

		String input = scanner.nextLine();	//값을 쓰면 input이라는 기억장소에 저장	"ABC"	"A"	  "전주"	  "1000"	"9"		"가나다"
		ch = input.charAt(0);	//input이 가르키는 곳의 첫 문자만 추출					 'A'	'A'	   '전'     '1'		'9'		  '가'

		if('0'<= ch && ch <= '9') {		//숫자 입력 시
			System.out.printf("입력하신 문자는 숫자입니다.\n");
		}

		if(('a'<= ch && ch <= 'z') || ('A'<= ch && ch <= 'Z')) {	//영문자 (대문자 이거나 소문자 이거나) 입력 시
			System.out.printf("입력하신 문자는 영문자입니다.\n");

			//한글 입력 시, 아무것도 출력안함
		
		}
	} // main
}
