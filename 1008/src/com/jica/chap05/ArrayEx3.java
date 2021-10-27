package com.jica.chap05;

class ArrayEx3{
	public static void main(String[] args) {
		int[] arr = new int[5];
		//arr 0x100 ----------> [0,0,0,0,0]
		
		//arr 배열요소값으로 1~5 저장
		for(int i=0; i < arr.length;i++) 
			arr[i] = i + 1;

		//arr 0x100 ----------> [1,2,3,4,5]
		System.out.println("변경전 - arr.length : "+arr.length);	
		for(int i=0; i < arr.length;i++) 
			System.out.println("arr["+i+"]:"+arr[i]);	

		//arr 배열의 2배 크기의 tmp 배열 생성
		int[] tmp = new int[arr.length*2];
		//tmp 0x200  ----------> [ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]
		
		//arr배열의 i번째 요소값을 tmp배열의 i번째로 복사
		for(int i=0; i < arr.length;i++) 
			tmp[i] = arr[i];
		
		//arr 0x100  ----------> [ 1, 2, 3, 4, 5]
		//tmp 0x200  ----------> [ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]

		arr = tmp;
		//arr 0x200  -----v      [ 1, 2, 3, 4, 5]<--이 메모리 공간(0x100)은 이제 못써
		//tmp 0x200  ----------> [ 1, 2, 3, 4, 5, 0, 0, 0, 0, 0]
		
		System.out.println("변경후 - arr.length : "+arr.length);	
		for(int i=0; i < arr.length;i++) 
			System.out.println("arr["+i+"]:"+arr[i]);	
	}
}
