package com.jica.sort;

public class SelectionSort {

	public static void main(String[] args) {
		int arr[] = new int[20];
		for(int i=0; i<arr.length; i++) {
			arr[i] = (int)(Math.random() * 100) + 1; //1~100까지의 임의의 수
		}
		
		printArray(arr);
		//selectionSort(arr);
		//selectionSortAdvance(arr);
		
		//bubbleSort(arr);
		bubbleSortAdvance(arr);
		printArray(arr);

	}

	//버블 sort 개선형
	static void bubbleSortAdvance(int a[]) {
		boolean sw = false;   //아직 정렬이 완료되지 않았다고 가정
		int i= 0;
		while(!sw && i<a.length-1) {
			sw = true;  //이미 정렬되어 있다고 가정
			for(int j=0; j<a.length-1-i; j++) {
				if( a[j] > a[j+1]) {  //j번째와 j+1번째 비교
					int tmp = a[j];
					a[j] = a[j+1];
					a[j+1] = tmp;
					sw = false;  //교환하면 정렬이 안되었다는 의미이다.
				}
			}
			//중간출력
			System.out.print(i + "==> ");
			printArray(a);
			i++;
		}
	}	
	
	//버블 sort 기본형
	static void bubbleSort(int a[]) {
		for(int i=0; i<a.length-1; i++) {
			for(int j=0; j<a.length-1-i; j++) {
				if( a[j] > a[j+1]) {  //j번째와 j+1번째 비교
					int tmp = a[j];
					a[j] = a[j+1];
					a[j+1] = tmp;
				}
			}
			//중간출력
			System.out.print(i + "==> ");
			printArray(a);
		}
	}
	
	static void printArray(int a[]) {
		for(int value : a) {
			System.out.print(value + " ");
		}
		System.out.println();
	}
	
	//선택정렬 개선형
	static void selectionSortAdvance(int a[]) {
		for(int i=0; i<a.length-1; i++) {
			int k = i;        //i번째값을 가장작은값의 위치로 가정하고 시작 
			for(int j=i+1; j<a.length; j++) {
				if(a[k]>a[j]) {
					k = j;
				}
			}
			int tmp = a[k];   //i번째와 k번째 교환
			a[k] = a[i];
			a[i] = tmp;
		}		
	}	
	
	//선택정렬 기본형
	static void selectionSort(int a[]) {
		for(int i=0; i<a.length-1; i++) {
			for(int j=i+1; j<a.length; j++) {
				if(a[i]>a[j]) {
					int tmp = a[i];
					a[i] = a[j];
					a[j] = tmp;
				}
			}
		}		
	}

}
