package com.jica.chap05;

class ArrayEx6 { 
	public static void main(String[] args) { 
		//최대값과 최소값 구하기
		int[] score = { 79, 88, 91, 33, 100, 55, 95}; 

		int max = score[0]; // 0번째 요소를 최대값으로 가정
		int min = score[0]; // 0번째 요소를 최소값으로 가정
		
		//					   0   1   2   3    4   5   6
		//score 0x100  ---> { 79, 88, 91, 33, 100, 55, 95}
		//max  100
		//min	33

		for(int i=1; i < score.length;i++) {			//i  0 ~ 6, 7되면 반복 탈출
			if(score[i] > max) { 
				max = score[i]; 
			} else if(score[i] < min) { 
				min = score[i]; 
			} 
		} // end of for 

		System.out.println("최대값 :" + max);       
		System.out.println("최소값 :" + min);       
	} // end of main 
} // end of class 
