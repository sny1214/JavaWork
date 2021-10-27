package com.jica.sort;

import java.util.Arrays;

// 선택정렬 개선형 - 스스로 코딩해보기

public class SelectionSortTest2 {

	public static void main(String[] args) {
		int data[] = { 7, 9, 2, 3, 6, 8};	//뒤에거는 정렬 안돼..  i<5까지만 정렬했으므로 --> i를 바꿀 필요 있음, 배열요소갯수 관련 변수로
		int size = data.length;
		int low[] = new int[size];

		
		System.out.println("정렬 전 : " + Arrays.toString(data));
		System.out.println("정렬 전 : " + Arrays.toString(low));

		for( int i = 0 ; i < size-1 ; i++) {		

			for( int j = i+1 ; j < size ; j++) {				 
				 if(data[i] > data[j]) {
					low[i] = data[j];

				}


			}
		}
		



		
		System.out.println("정렬 후 : " + Arrays.toString(low));
	}

}
