package com.jica.chap05;

class ArrayEx8 { 
	public static void main(String[] args) { 
		// 로또번호 발생
		int[] ball = new int[45];       
						  
		// i			    0					   44
		//ball 0x100 ---> [ 1, 2, 3, 4, 5, ... 44, 45]
		for(int i=0; i < ball.length; i++)       
			ball[i] = i+1;    // 1 ~ 45까지 차례로 저장

		int temp = 0;  
		int j = 0;     

		for(int i=0; i < 6; i++) {       	// i 0 1 2 ...5 
			j = (int)(Math.random() * 45);  // 0~44 임의의 수를 발생
			temp     = ball[i]; 			// i번째 값과 난수번째 값 교환
			ball[i] = ball[j]; 
			ball[j] = temp; 
		} 

		// 첫 6개의 요소값 출력 ---> 로또번호
		for(int i=0; i < 6; i++) 
			System.out.printf("ball[%d]=%d%n", i, ball[i]); 
	} 
} 
