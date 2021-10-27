package com.jica.chap02;

import java.util.*;    // java.lang패키지의 클래스들은 import 구문 없이 사용할 수 있다.
					   // 그외의 다른 패키지의 클래스들은 반드시 import 구문을 사용해야 한다. Scanner(java.util패키지 내 클래스)를 사용하기 위해 추가


class ScannerEx { 
	public static void main(String[] args) { 
		//입력 전용객체 선언 및 생성
		Scanner scanner = new Scanner(System.in);

		System.out.print("두자리 정수를 입력해주세요");
		/*
		//문자값 입력
		String input = scanner.nextLine(); // 문자열 입력 -- "52"--두자리 정수를 문자열로 받아 기억장소에 저장
		
		int num = Integer.parseInt(input); // "52" 문자열의 값을 정수(숫자)로 변환 -- 52 : Integer.parseInt(문자열)

		System.out.println("입력내용 :"+input);
		System.out.printf("num = %d%n", num);	//숫자이므로 %d
		*/
		
		//정수값 입력
		int number = scanner.nextInt(); //문자"52"를 한번에 숫자 52로 바꿔서 기억장소에 저장
		System.out.printf("number = %d%n", number + 8);
		
		//실수값 입력
		double height = scanner.nextDouble(); //"185.4" --> 185.4 실수값으로 바꾸어 height에 저장됨
		
		//단일문자 입력
		char ch = scanner.nextLine().charAt(0);	//scanner.nextLine():문자열...? //"A" --> 'A'
		
		//논리값 입력
		boolean sw = scanner.nextBoolean(); //"true" --> true
	} 
}
