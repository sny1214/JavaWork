package com.jica.chap06;

class StaticBlockTest {
	//클래스 변수 arr은 정수 배열이다.
	//명시적으로 배열을 위한 메모리공간을 할당할수 있다.
	static int[] arr = new int[10];
        
	static {
		for(int i=0;i<arr.length;i++) {
			// 클래스변수에 1~10까지의 난수를 발생시켜 저장한다.
			arr[i] = (int)(Math.random()*10) + 1;
		}
	}

	public static void main(String args[]) {
		// StaticBlockTest::arr 0x50 
		//                       |
		//            v----------|
		//           [7,2,5,4,2,1,6,9,1,2] 
		//
		//
		//
		// 
		for(int i=0; i<arr.length;i++)
			System.out.println("arr["+i+"] :" + arr[i]);
		System.out.println();
		
		for(int i=0; i<StaticBlockTest.arr.length;i++)
			System.out.println("arr["+i+"] :" + arr[i]);
	}
}
