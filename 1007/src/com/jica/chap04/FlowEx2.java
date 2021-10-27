package com.jica.chap04;

import java.util.Scanner;

class FlowEx2 {
	public static void main(String[] args) {  
		int input;

		System.out.print("숫자를 하나 입력하세요 > ");

		//입력전용객체 생성
		Scanner scanner = new Scanner(System.in);
		String tmp = scanner.nextLine(); // 문자열 입력
										 // "25"
										 // "2a" --> 잘못 입력
		input = Integer.parseInt(tmp);   // 문자열 입력 시, 정수형으로 바꿔줌 "25" -> 25, "2a" -> 오류
		
		if(input==0) {
			System.out.println("입력하신 숫자는 0 입니다.");	
		}

		if(input!=0)
			System.out.println("입력하신 숫자는 0 이 아닙니다.");		
			System.out.printf("입력 숫자 : %d ",input);
	} // main�� ��
}
