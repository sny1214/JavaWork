package com.jica.game;

import java.util.Arrays;

//간단한 야구게임을 수행하는 메서드
public class Baseball {
	public static final int MAX = 4;		//클래스변수이면서 final -->  변하지 않는 변수, Max를 정수 4로 정함

	//컴퓨터가 발생시킨 4개의 난수
	int target[] = new int [MAX];		    //4개짜리 배열 요소 필요함
	//사용자가 입력한 숫자
	int user[] = new int [MAX];
	
	int count; 			//시도 횟수
	int strikeCount;	//스트라이크 갯수
	int ballCount;		//볼 갯수

	//생성자 - 컴퓨터가 발생시킨 중복없는 4개 난수 저장
	public Baseball()	{
		//중복되지 않은 4개의 숫자를 발생시켜 target 배열에 저장
		target[0] = (int)(Math.random() * 10);		//첫번째 난수
		//						0  1  2  3
		//target 0x100 ----> [예)7, 0, 0, 0]
		
		int i=1;
		while ( i < MAX) {
			int num = (int)(Math.random() * 10);
			boolean duplicate = false;
			for(int j=0 ; j<=i-1 ; j++) {
				if( num == target[j] ) {	//중복됐다! -> break 빠져나와
					duplicate = true;
					break;
				}
			}
			if( !duplicate ) {				//중복되지 않았다면
				target[i] = num;
				i++;
			}
		}

	}		
	
	//생성자 - 사용자가 직접 지정한 숫자 4개
	public Baseball(int n1, int n2, int n3, int n4) {
		user[0] = n1; 
		user[1] = n2;
		user[2] = n3;
		user[3] = n4;
	}
	
	//생성자
	public Baseball(String strNumber) {
		//strNumber "7615"
		for(int i=0 ; i<MAX ; i++) {
			char ch = strNumber.charAt(i); // '7'
			user[i] = ch - 48;		   // '7' -> 7
		}
	}
	
	//생성자
		public Baseball(String scanner.nextLine()) {
			//strNumber "7615"
			for(int i=0 ; i<MAX ; i++) {
				char ch = strNumber.charAt(i); // '7'
				user[i] = ch - 48;		   // '7' -> 7
			}
		}
	
	//사용자가 맞춘 숫자를 지정한다.
	void userNumber() {
		System.out.println("사용자가 지정한 숫자 : " + Arrays.toString(user));
	}
	
	//스트라이크 갯수를 판별한다.
	int decideStrike() {
		return 0;
	}
	
	//볼의 갯수를 판별한다.
	int decideBall() {
		return 0;
	}
	
	//메서드 - 컴퓨터가 만든 중복없는 난수 4개 출력!
	void display() {
		System.out.println("맞쳐야할 숫자 : " + Arrays.toString(target));
	}
}

