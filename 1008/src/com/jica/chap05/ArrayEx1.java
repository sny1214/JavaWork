package com.jica.chap05;

class ArrayEx1 {
	public static void main(String[] args) { 
		int[] score = new int[5];
		int k = 1;

		score[0] = 50;
		score[1] = 60;
		score[k+1] = 70;   // score[2] = 70
		score[3] = 80;
		score[4] = 90;

		int tmp = score[k+2] + score[4];  // int tmp = score[3] + score[4]

	    // for문을 사용하여 전체요소 출력
		for(int i=0; i < 5; i++) {
			System.out.printf("score[%d]:%d%n",i, score[i]);		
		}
		
		System.out.println();
		
		for(int i=score.length - 1 ; i >= 0; i--) {
			System.out.printf("score[%d]:%d%n",i, score[i]);		
		}
		
		System.out.println();

		//향상된 for문은 무조건 0번째 요소부터 끝요소까지의 순서로 접근함
		// 중간에 몇번째 요소인지 출력 못함, 원하는 요소에만 접근 불가, 역순 불가
		for(int value : score) {
			System.out.printf("%d%n",value);
		}
		System.out.println();
		
		int j = 0;
		for(int value : score) {
			System.out.printf("score[%d]:%d%n",j, value);
			j++;
		}
		System.out.println();

		System.out.printf("tmp:%d%n", tmp);
		System.out.printf("score[%d]:%d%n",7,score[7]); //index를 벗어나므로 실행에러 발생
	} // main
}
