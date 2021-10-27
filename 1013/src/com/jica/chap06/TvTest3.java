package com.jica.chap06;

class TvTest3 {
	public static void main(String args[]) {
		Tv t1 = new Tv();
		Tv t2 = new Tv();
		
	
		//				 color  power channel	//참조값을 통해 직접 접근
		//t1   0x100--->  [null, false,   7]    
		//t2--x->(0x200) -x-> [null, false,   0]=======> 더이상 참조하는 변수가 없으므로 쓰레기가 되어 JVM에 의해 제거됨	
		//|===>0x100--->  [null, false,   7]
		System.out.println("t1의 channel값 " + t1.channel + "입니다.");
		System.out.println("t2의 channel값 " + t2.channel + "입니다.");

		t2 = t1;			//t1이 저장하고 있는 위치정보를 t2에 저장, t1,t2 동일한 인스턴스 값을 가리킴
		t1.channel = 7;	
		System.out.println("t1의 channel값을 7로 변경하였습니다..");

		System.out.println("t1의 channel값 " + t1.channel + "입니다.");
		System.out.println("t2의 channel값 " + t2.channel + "입니다.");
	}
}
