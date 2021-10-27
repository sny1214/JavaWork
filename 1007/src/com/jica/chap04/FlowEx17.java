package com.jica.chap04;

import java.util.*;

class FlowEx17 {
	public static void main(String[] args) { 
		int num = 0;

		System.out.print("* 를 출력할 라인수를 입력하시오 >> ");

		Scanner scanner = new Scanner(System.in);
		String tmp = scanner.nextLine();  // 문자열 "5" 입력
		num = Integer.parseInt(tmp);      // 숫자 5

		for(int i=0;i<num;i++) {
			for(int j=0;j<=i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	} // main�� ��
}
