package com.jica.sort;

import java.util.Arrays;

public class Search {

	public static void main(String[] args) {
		int a[] =  new int[50];
		for(int i = 0; i<a.length ; i++) {
			a[i] = (int)(Math.random() * 100) + 1;		//1~100 안의 랜덤값
		}
		
		System.out.println("정렬된 원본배열 : " + Arrays.toString(a));
		int data = 60;	//위치 찾고자 하는 데이터 값 
		int index = sequenceSearch(a, data);		//순차검색 메서드
		System.out.println("순차검색 결과 index : " + index);
	
		//이진 검색(전제조건 : 원본 데이터가 정렬되어 있어야 한다)
		
		selectionSort(a);					//정렬 메서드, 이진 검색은 정렬부터
		System.out.println("정렬된 원본배열 : " + Arrays.toString(a));
//		data = 60;
		
		index = binarySearch(a, data);		//이진검색 메서드
		System.out.println("이진검색 결과 index : " + index);
	}
	
	//이진검색 메서드
	static int binarySearch(int a[], int data) {
		int low = 0;
		int high = a.length -1;
		int mid;
		
		boolean found = false;		//초기 값이 '못 찾음'
		int pos = -1;				//값 못찾으면 -1 출력
		while(!found && low <= high) {
			mid = (low + high) / 2;
			if ( data == a[mid]) {
				found = true;
				pos = mid;
			}else if (data > a[mid]) {
				low = mid +1 ;
			}else {
				high = mid - 1;
			}
		}
		return pos;
	}
	
	
	//정렬 메서드
	static void selectionSort(int a[]) {
		for(int i = 0; i<a.length - 1; i ++) {
			for(int j = i+1; j<a.length ; j++) {
				if(a[i] > a[j]) {
					int tmp = a[i];
					a[i] = a[j];
					a[j] = tmp;
				}
				
			}
		}
	}

	//순차 검색
	static int sequenceSearch(int a[], int data) {
		boolean found = false;
		int pos = -1;
		int i = 0;
		//                           data 30 
		//                            pos -1     3
		//                          found false  true 
		//                              a 0x100---> [70,40,20,30,60]
		while(!found && i<a.length) { //i 0  1  2  3  4
			if(a[i] == data) {
				found = true;
				pos = i;
			}
			i++;
		}
				
		return pos;
	}
}
