package com.jica.chap07;

class SuperTest2 {
	public static void main(String args[]) {
		CChild c = new CChild();
		
		//		 			CChild::x  PParent::x
		//c 0x100 -------->  [20]        [10]
		
		
		
		c.method();
	}
}
class PParent {
	int x=10;
}

class CChild extends PParent {
	int x=20;		//부모클래스와 똑같은 인자, 하위 클래스에서도 허용함.<JAVA>

	void method() {
		System.out.println("x=" + x);
		//매개변수나 지역변수에 없다 --> CChild의 x
		System.out.println("this.x=" + this.x);	//무조건 CChild의 x, 지역&매개 보지도 않음
		System.out.println("super.x="+ super.x);//무조건 PParent의 x, CChild&지역&매개 보지도 않음
												//PParent에 x 없으면 에러남!!!!
	}
}
