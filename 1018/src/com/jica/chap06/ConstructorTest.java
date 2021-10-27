package com.jica.chap06;

class Data1 {   //생성자가 없다 - 내부적으로 디폴트 생성자만 사용 가능하다.
	int value;
}

class Data2 {
	int value;

	Data2(){ // 인자가 없는 기본 생성자
		
	}      
	
	Data2(int x) { 	// 인자가 1개인 생성자
		            // 생성자를 1개라도 만들면 디폴트 생성자는 동작하지 않는다.
		value = x;
	}
}

class ConstructorTest {
	public static void main(String[] args) {
		Data1 d1 = new Data1();
		//             value 
		//d1 0x100---->[ 0 ]
		
		Data2 d2 = new Data2();		// 기본생성자 작동
		//             value 
		//d2 0x200---->[ 0 ]
		//주의) 생성자의 기능이 끝난 후에서 객체의 위치변수가 참조변수에 대입된다.
	}
}
