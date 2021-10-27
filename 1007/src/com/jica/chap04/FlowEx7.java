package com.jica.chap04;

import java.util.*;


// 가위, 바위, 보 게임
class FlowEx7 {
	public static void main(String[] args) { 
		int user, com;

		//입력전용객체 선언 및 생성
		Scanner scanner = new Scanner(System.in);
		//안내문구
		System.out.print("가위(1), 바위(2), 보(3) 중 하나를 입력하세요! >> ");
		String tmp = scanner.nextLine(); 	// "1", "2", "3"
		user = Integer.parseInt(tmp);    	//  1 ,  2 ,  3
		
		//컴퓨터가 난수(임의의 수)를 발생시켜 1,2,3 중에 하나를 결정한다.
		com = (int)(Math.random() * 3) + 1;  // Math.random() 리턴값 없고, static 메서드이므로 객체 생성 필요 없음.
											 // 결과 값은 double형 : 0.0~1.0사이의 임의의 실수값
											 // (int)(Math.random() * 3) : 3을 곱한 값을 정수값으로 바꾸면 0, 1, 2 중 하나
											 // (int)(Math.random() * 3) + 1 : 1, 2, 3 중 하나
		
		System.out.println("당신은 "+ user +"입니다.");
		System.out.println("컴은  "+ com +"입니다.");

		
		//승자 따지기
		switch(user-com) {
			case 2: case -1:
				System.out.println("당신이 졌습니다.");
				break;
			case 1: case -2:
				System.out.println("당신이 이겼습니다.");
				break;
			case 0:
				System.out.println("비겼습니다.");
	//			break;		// 안써도 빠져나감
				
		}
	} // main�� ��
}
