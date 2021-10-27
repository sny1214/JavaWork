package com.jica.chap05;

class ArrayEx7 {
	public static void main(String[] args) {
		int[] numArr = new int[10];
		//numArr 0x100 ----> [ 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ]
		
		for (int i=0; i < numArr.length ; i++ ) {
             numArr[i] = i;  // 배열을 0~9의 숫자로 초기화한다.
           //numArr 0x100 ----> [ 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 ]
			System.out.print(numArr[i] + " ");  
		}
		System.out.println();

		//0번째 값과 임의의 위치번째 값을 100번 교환한다.-------------------------------> " 배열 요소를 섞은 효과 "
        //numArr 0x100 ----> [ 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 ]
		// n       
		for (int i=0; i < 100; i++ ) {
			int n = (int)(Math.random() * 10);	// 0~9 범위의 난수 발생

			//n번째 값과 i번째 값과 교환 (100번 반복)
			//전체 숫자를 섞은 효과가 나타난다.
			int tmp = numArr[0];
			numArr[0] = numArr[n];
			numArr[n] = tmp;
		}

		for (int i=0; i < numArr.length ; i++ )
			System.out.print(numArr[i] + " ");		
	} // main�� ��
}
