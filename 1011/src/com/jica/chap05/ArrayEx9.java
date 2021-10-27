package com.jica.chap05;

import java.util.Arrays;  // Arrays.toString()

class ArrayEx9 {
	public static void main(String[] args) {
		int[] code = { -4, -1, 3, 6, 11 };  
		int[] arr = new int[10];

		//code 0x100 ---> [-4, -1, 3, 6, 11]
		//arr  0x200 ---> [ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ]
		for (int i=0; i < arr.length ; i++ ) {				//i 0 ~ 9
			int tmp = (int)(Math.random() * code.length);	// 0 ~ 4 임의의 정수
			arr[i] = code[tmp];								// code배열의 0 ~ 4번째 요소 중 임의로 10개 뽑기
		}

		System.out.println(Arrays.toString(arr));
	} // main의 끝
}
