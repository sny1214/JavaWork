package com.jica.chap05;

class ArrayEx5 {
	public static void main(String[] args) {
		int sum =0;				// 합계
		float average = 0.0f;		// 평균

		int[] score = {100, 88, 100, 100, 90};

		//score 0x100 ---> [100, 88, 100, 100, 90]
		//i			0     1     2     3     4
		//sum	  100   188   288   388   478
		for (int i=0; i < score.length ; i++ ) {	//i 0 1 2 3 4 5
			sum += score[i];
		}

		average = sum / (float)score.length ; // 총점을 요소의 갯수로 나눈다

		System.out.println("총점 : " + sum);
		System.out.println("합계 : " + average);
	}
}
