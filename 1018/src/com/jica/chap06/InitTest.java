package com.jica.chap06;

public class InitTest {
	static int cv = 1;
	int iv = 1;
	
	static {
		cv = 2;
	}
	
	{
		iv = 2;
	}
	
	InitTest(){
		iv = 3;
	}
	public static void main(String[] args) {
		//  InitTest::cv   2
		//
		//  iv
		//  [ 3 ]
		//  ^
		//  |
		//  |----|
		//       | 
		//       |
		//  obj 0x100 
		
		InitTest obj = new InitTest();

		//1. static 변수가 확보되고 0을 가진다.
		//2. static변수의 명시적 초기값이 저장된다.
		//3. static초기화블럭에 의해 값이 저장된다.
		//--------------------------------
		//4. new InitTest()에 의해 동적영역에 인스턴스변수가 확보되고 0을 가진다.
		//5. 인스턴스 변수의 명시적 초기값이 저장된다.
		//6. 초기화 블럭에서의 값이 저장된다.
		//7. 생성자에서 지정한 값이 인스턴스 변수에 저장된다.
	}

}
