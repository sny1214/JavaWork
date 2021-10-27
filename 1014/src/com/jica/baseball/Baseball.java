package com.jica.baseball;

import java.util.Random;

class Baseball {
	int num1;
	int num2;
	int num3;
	int num4;

	
//1~10까지 난수 만들기
	int shuffle() {
		int arr[] = new int[10];
		int tennum[] = {0,1,2,3,4,5,6,7,8,9};
		Random random = new Random();
		
		
		for (int i=0; i < 4 ; i++) {
			arr[i] = tennum[random.nextInt(10)];
			System.out.println(i+"번째 랜던값 : " + arr[i]);
		}

	
		return.result
	
	}

}
