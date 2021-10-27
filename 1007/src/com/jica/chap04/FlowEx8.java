package com.jica.chap04;

import java.util.*;

class FlowEx8 {
	public static void main(String[] args) { 
		char gender;
		String regNo = "";

		Scanner scanner = new Scanner(System.in);
		System.out.print("당신의 주민번호를 입력하세요(011231-1111222). >> ");

								   //           1111
								   // 01234567890123
		regNo = scanner.nextLine();//"871213-2414293" 문자열로 입력

		gender = regNo.charAt(7); 

		switch(gender) {
			case '1':
			case '3':
				System.out.println("당신은 남자 입니다.");
				break;
			case '2':
			case '4':
				System.out.println("당신은 여자 입니다.");
				break;
			default:
				System.out.println("유효하지 않은 주민번호 입니다.");;
		}
	} // main�� ��
}
