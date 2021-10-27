package com.jica.sort;

import java.util.Arrays;

// 선택 정렬 (오름차순)
// 내림 차순이라면 data[i] < data[j] 로 부호만 교환 하면 됨

public class SelectionSortTest {

	public static void main(String[] args) {
		int data[] = { 12, 48, 9, 78, 32, 15, 30, 28, 61, 50};	//뒤에거는 정렬 안돼..  i<5까지만 정렬했으므로 --> i를 바꿀 필요 있음, 배열요소갯수 관련 변수로
		
		System.out.println("정렬 전 : " + Arrays.toString(data));
		selectionSort(data);		//selectionSort() : 메서드
		
		System.out.println("정렬 후 : " + Arrays.toString(data));
	}

	static void selectionSort(int data[]) {
		int size = data.length;								//요소갯수
															//  6      10	   20
		for( int i = 0 ; i < size-1 ; i++) {			    //  5       9      19
			for( int j = i + 1; j < size ; j++) {		    //  6      10      20
				if(data[i] > data[j]) {				// 내림 차순이라면 data[i] < data[j] 로 부호만 교환
					int tmp = data[i];
					data[i] = data[j];
					data[j] = tmp;
				}
			}
		}
	}
}
