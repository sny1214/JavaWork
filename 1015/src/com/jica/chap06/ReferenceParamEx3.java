package com.jica.chap06;

class ReferenceParamEx3 {
	public static void main(String[] args) 
	{
		int[] arr = new int[] {3,2,1,6,5,4};
		//arr 0x100 ---> [3,2,1,6,5,4]
		printArr(arr);  
		sortArr(arr);   
		printArr(arr);  
		System.out.println("sum="+sumArr(arr)); // 요소값 다 합함
		
		//위의 메서드 중에서 printArr()과 SumArr()은 배열명을 전달받지만
		//내부에서 내용값 읽어서 사용만 했고 변경시키지 않았으므로 원본 그대로 이다.
		//SortArr()는 배열명을 전달받아 내부에서 요소값을 변경시키므로 원본을 변경시킨 것이다.
		
	}

	static void printArr(int[] arr) {  // 배열명을 전달
		System.out.print("[");

		for(int i : arr)  // 향상된 for문
			System.out.print(i+",");
		System.out.println("]");
	}

	static int sumArr(int[] arr) {  // 배열명을 전달
		int sum = 0;

		for(int i=0;i<arr.length;i++)
			sum += arr[i];
		return sum;
	}

	//버블정렬기본형 -> [1,2,3,4,5,6,]
	static void sortArr(int[] arr) {  // 배열명을 전달
		for(int i=0;i<arr.length-1;i++)
			for(int j=0;j<arr.length-1-i;j++)
				if(arr[j] > arr[j+1]) {
					int tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
	} // sortArr(int[] arr)
}
