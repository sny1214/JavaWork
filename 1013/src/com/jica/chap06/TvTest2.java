package com.jica.chap06;

class TvTest2 {
	public static void main(String args[]) {
		Tv t1 = new Tv();  // Tv t1; t1 = new Tv();�� �� �������� ����
		Tv t2 = new Tv();
		
		//				color  power channel
		//t1 0x100--->  [null, false,   7]
		//t2 0x200--->  [null, false,   0]	//참조값을 통해 직접 접근
		System.out.println("t1의 channel값 " + t1.channel + "입니다.");
		System.out.println("t2의 channel값 " + t2.channel + "입니다.");


		t1.channel = 7;	// channel 값을 7로 변경한다.
		System.out.println("t1의 channel값을 7로 변경했습니다.");

		System.out.println("t1의 channel값 " + t1.channel + "입니다.");
		System.out.println("t2의 channel값 " + t2.channel + "입니다."); //t1,t2 참조값이 다르므로 가리키는 값도 다르다
	}
}
