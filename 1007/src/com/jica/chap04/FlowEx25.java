package com.jica.chap04;

import java.util.*;

class FlowEx25 {
	public static void main(String[] args) { 
		int num = 0; 
		int sum = 0;

		System.out.print("숫자를 입력하세요(예:12345) >> ");
		Scanner scanner = new Scanner(System.in);
		String tmp = scanner.nextLine(); // "12345"
		num = Integer.parseInt(tmp);      // 12345

		//num 12345   
		//sum   0 5
		
		while(num!=0) {    
			// num을 10으로 나눈 나머지를 sum에 더한다.
			sum += num%10; 	// sum = sum + num%10;
			System.out.printf("sum=%3d num=%d%n", sum, num);

			num /= 10;  // num = num / 10;  num�� 10���� ���� ���� �ٽ� num�� ����
		}
		
		System.out.println("각 자릿수의 합 :"+ sum);
	}
}
