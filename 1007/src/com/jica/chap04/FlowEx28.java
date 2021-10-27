package com.jica.chap04;

import java.util.*;

class FlowEx28 {
	public static void main(String[] args) { 
		int input  = 0;
		int answer = 0;

		answer = (int)(Math.random() * 100) + 1; // 1~100까지 숫자 중 임의의 수가 저장된다.
		Scanner scanner = new Scanner(System.in);

		do {
			System.out.print("1과 100 사이의 정수를 입력하시오 > ");

			String tmp = scanner.nextLine();
			input = Integer.parseInt(tmp);

			if(input > answer) {
				System.out.println("더 작은 수로 다시 시도해 보세요");	
			} else if(input < answer) {
				System.out.println("더 큰 수로 다시 시도해 보세요");			
			}
		} while(input!=answer);

		scanner.close();
		System.out.println("정답입니다!");
	}
}
