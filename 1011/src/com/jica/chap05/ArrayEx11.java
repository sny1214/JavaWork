package com.jica.chap05;

class ArrayEx11 {
	public static void main(String[] args) {
		int[] numArr  = new int[10];
		int[] counter = new int[10];

		//numArr  0x100 ---> [0,0,0,0,0,0,0,0,0,0]
		//counter 0x200 ---> [0,0,0,0,0,0,0,0,0,0]
		
		
		for (int i=0; i < numArr.length ; i++ ) {
			numArr[i] = (int)(Math.random() * 10); // 0~9범위의 난수 저장
			System.out.print(numArr[i]);
		}
		System.out.println();
		//numArr  0x100 --->  0~9범위의 난수 10개 저장
		

		for (int i=0; i < numArr.length ; i++ ) {	//numArr의 i(요소위치) 0 1 2 3 4 5 6 7 8 9
			counter[numArr[i]]++;					//numArr 요소값 수 만큼 counter i번째 요소 +1씩 해라
		}
		//numArr  0x100 ---> [4,1,0,2,8,8,1,5,6,1]
		//counter 0x200 ---> [1,3,1,0,1,1,1,0,2,0] ---> numArr에 0은 1개, 1은 3개, 2는 1개... 있다.
		
		
		// 배열의 요소값을 나타내는 정수값에 다른 배열의 요소값을 사용하였다.
		
		
		for (int i=0; i < numArr.length ; i++ ) {
			System.out.println( i +"값의 갯수 : "+ counter[i]);
		}
	} // main�� ��
}
