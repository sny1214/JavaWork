package com.jica.inner.inner;

class Outer {
	int value=10;	// Outer.this.value				

	class Inner {   // 인스턴스 내부클래스 -- 인스턴스 내부클래스에서는 
		            //                  외부클래스의 멤버를 자유롭게 접근할 수 있다.
		int value=20;	// this.value

		void method1() {
			int value=30;
			System.out.println("           value :" + value);
			System.out.println("      this.value :" + this.value);
			System.out.println("Outer.this.value :" + Outer.this.value);  //명칭이 중복되지 않으면 vv도 가능
		}
	} 
} 

class InnerEx5 {
	public static void main(String args[]) {
		Outer outer = new Outer();
		//                Outer::value  
		// outer 0x100------>[ 10 ] Outer.Inner::value
		//                      | 
		// inner 0x200------>[ 20 ] 
		Outer.Inner inner = outer.new Inner();
		inner.method1();   //           value : 30
		                   //      this.value : 20 
		                   //Outer.this.value : 10
	}
} // InnerEx5 ��
