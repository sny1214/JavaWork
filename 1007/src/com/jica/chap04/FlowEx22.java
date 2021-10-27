package com.jica.chap04;

class FlowEx22 {
	public static void main(String[] args) { 
		
		//배열 선언 및 생성 후 초기값 지정
		int[] arr = {10,20,30,40,50};
		int sum = 0;
	
		//						 0  1  2  3  4
		//arr 0x100 이라면 ----> [10,20,30,40,50]
		//sum 0
		for(int i=0;i<arr.length;i++) {		//arr.length 배열 요소의 갯수
			System.out.printf("%d ", arr[i]);
		}
		System.out.println();		

		
		//향상된 for문
		for(int tmp : arr) {				// arr의 요소값을 차례로 tmp에 저장해 준다.
			System.out.printf("%d ", tmp);
			sum += tmp;
		}
		System.out.println();		
		System.out.println("sum="+sum);
	} // main�� ��
}
