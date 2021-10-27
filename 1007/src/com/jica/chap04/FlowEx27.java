package com.jica.chap04;

import java.util.*;

class FlowEx27 {
	public static void main(String[] args) { 
		int num;
		int sum = 0;
		boolean flag = true;   // while반복의 조건

		System.out.println("합계 구할 숫자를 입력하시오 (끝내려면 0 입력)");
		Scanner scanner = new Scanner(System.in); //while문밖에 놓으면 scanner 객체 1개만 생성하고 계속 사용, while문 안에 위치시키면 객체 매번생성
		
		while(flag) {    // flag가 true인 동안 반복한다.
			System.out.print(">> ");

			//매번 입력 전용 객체를 신규생성하여 사용
			String tmp = scanner.nextLine();		//   "100"  "51"   "4"   "0"
			num = Integer.parseInt(tmp);  			//    100    51     4     0
													//sum 100   151   155   155
			if(num!=0) {  
				sum += num; // num�� 0�� �ƴϸ�, sum�� ���Ѵ�.
			} else {
				flag = false;   // num�� 0�̸�, flag�� ���� false�� ����.
			}
		} // while���� ��
		
		scanner.close();
		System.out.println("합계 : "+ sum);
	}
}
