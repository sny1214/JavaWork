package com.jica.chap06;

class ReturnTest {
	//멤버변수를 선언하는 위치
	//멤버변수 없다.
	//생성자도 없다. -> default 생성자
	
	//현재예에서 main()메서드는 시작위치 역할만 수행한다.
	public static void main(String[] args) {
		ReturnTest r = new ReturnTest();
		//r	0x100 -----------> []
		//result 8
		int result = r.add(3,5);	//r.add 호출 - 리턴값 받아서 출력
 		System.out.println(result);
 		//result2 0x200 ----> {0} 배열
		int[] result2 = {0}; // 요소의 갯수가 1개인 배열
		r.add(3,5,result2);  // result2 배열명은 참조값을 전달, 3,5는 기본형
							 // [3,5,0x200]전달함
		
		//result2 0x200 ----> {8} 로 리턴받음
		System.out.println(result2[0]);
	}
	
	//아래의 두 메서드는 인스턴스 메서드이므로 반드시 객체 생성 후에
	//객체를 이용하여 호출해야 한다.
	int add(int a, int b) {		//정수형(int)을 리턴값으로 전달
		return a + b;
	}

	//void -> 리턴값이 없지만, 3번째 인자 result[]를 이용하여
	//리턴받은 효과를 얻고 있다.
	void add(int a, int b, int[] result) {
		result[0] = a + b;  
	}
}
