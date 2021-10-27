package com.jica.game;

import java.util.Scanner;

public class BaseballTest {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);

		//Baseball baseball = new Baseball(7,6,1,5);
		//Baseball baseball = new Baseball("7615");		//-> 입력 값을 문자열로
		//Baseball baseball = new Baseball();			//	-> 사용자가 직접 입력
		
		System.out.println("0에서 9까지 중 숫자 4개를 중복없이 입력하세요. => ");
		Baseball baseball = new Baseball();
		
		Baseball(String strNumber){
			strNumber = scanner.nextLine();
		}
		baseball.user = scanner.nextLine();

		
		
		baseball.userNumber();
//		baseball.display();
		
		

	}

}
