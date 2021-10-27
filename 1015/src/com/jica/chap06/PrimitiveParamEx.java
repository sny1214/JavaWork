package com.jica.chap06;

class Data { int x; }

class PrimitiveParamEx {
	public static void main(String[] args) {
		Data d = new Data();
		//			     x
		//d 0x100 --->[ 10 ]
		
		
		d.x = 10;
		System.out.println("main() : x = " + d.x);	//10

		change(d.x);		//기본형 매개변수 메서드에서 사용후 다시 원래 값, 변경된 값 전달x
		System.out.println("After change(d.x)");
		System.out.println("main() : x = " + d.x);
	}

	//기본형 매개변수
	static void change(int x) {  
		x = 1000;
		System.out.println("change() : x = " + x);		//1000
	}
}
