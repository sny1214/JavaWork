package com.jica.chap05;

class ArrayEx12 {
	public static void main(String[] args) {
		// 문자열 배열을 생성하고 초기값을 지정		
		
		//기본 자료형의 배열과 String형의 배열은 사용법은 유사하지만
		//메모리 저장구조 가 다르다

		String[] names = {"Kim", "Park", "Yi"};

		// 개념적인 이해				   0       1	  2
		//names 0x100 -----------> [ "kim", "Park", "Yi"]
		
		for(int i=0; i < names.length;i++) {
			System.out.println("names["+i+"]:"+names[i]);
		}
		System.out.println();
		
		// tmp에 names[2] 요소값인 "Yi"가 직접 들어가는가? --> 실제 메모리 모습
		//							  0     1      2
		//names 0x100 -----------> [ 0x10, 0x20, 0x30]
		//							 "kim""Park" "Yi"
//												 tmp[2]
		
		String tmp = names[2]; 	//names의 2번째 요소값 즉, "Yi" 위치정보를 tmp에 저장한다.
		System.out.println("names[2]:" + names[2]);
		System.out.println("tmp:"+tmp);

		names[0] = "Yu"; // names[0] 0x10 가르키고 있었는데 0x40으로 바뀜 -->  "Yu"
						 // names의 0번째 요소값으로 "YU"의 위치정보를 저장
		
		
		// 향상된 for문
		for(String str : names)  // <--배열명이나 콜렉션명, for문 나오면 str 사라짐
			System.out.print(str + " ");
		
		//기본 자료형의 배열과 String형의 배열은 사용법은 유사하지만
		//메모리 저장구조 가 다르다
		
	} // main
}
