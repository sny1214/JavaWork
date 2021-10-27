package com.jica.chap05;

import java.util.Arrays;  // Arrays.toString() 메서드를 사용하기 위해 import

class ArrayEx2 {
	public static void main(String[] args) {
		int[] iArr1 = new int[10];
		int[] iArr2 = new int[10];
//		int[] iArr3 = new int[]{100, 95, 80, 70, 60};
		int[] iArr3 = {100, 95, 80, 70, 60};
		char[] chArr = {'a', 'b', 'c', 'd'};

		//iArr1 0x100 ------------> [0,0,0,0,0,0,0,0,0,0]
		//iArr2 0x200 ------------> [0,0,0,0,0,0,0,0,0,0]
		//iArr3 0x300 ------------> [100, 95, 80, 70, 60]
		//chArr 0x400 ------------> ['a', 'b', 'c', 'd']
		for (int i=0; i < iArr1.length ; i++ ) {
			iArr1[i] = i + 1; // 1~10까지 차례로 배열요소 값으로 저장된다.
		}
		//iArr1 0x100 ------------> [1,2,3,4,5,6,7,8,9,10]
		
		
		for (int i=0; i < iArr2.length ; i++ ) {
			iArr2[i] = (int)(Math.random()*10) + 1; // 1~10 숫자 중에서의 임의의 수를 저장
		}
		//iArr2 0x200 ------------> 예: [2,4,9,3,10,2,2,3,5,6]

		// iArr1의 모든 요소값을 차례로 출력
		for(int i=0; i < iArr1.length;i++) {
			System.out.print(iArr1[i]+",");	
		}
		System.out.println();		
		
		System.out.println(Arrays.toString(iArr2)); // ===> 실행시킬때마다 값 다르게 나와
		System.out.println(Arrays.toString(iArr3));
		System.out.println(Arrays.toString(chArr));
		
		//배열명 자체를 직접 출력하면 위치정보가 가공된 상태로 출력된다. ==> [@16진수문자열 형태)
		System.out.println(iArr3);
		
		//단, 문자배열은 배열의 내용값이 문자열 형태로 출력된다.
		System.out.println(chArr);
	}
}
