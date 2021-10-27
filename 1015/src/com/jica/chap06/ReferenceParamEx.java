package com.jica.chap06;

class ReferenceParamEx {
	public static void main(String[] args) {

		Data d = new Data();
		//			     x
		//d 0x100 --->[ 10 ] ---> [1000]
		
		d.x = 10;
		System.out.println("main() : x = " + d.x);

		change(d); 	//d.x(기본형 매개변수)가 아닌 d를 전달(참조값)
		System.out.println("After change(d)");
		System.out.println("main() : x = " + d.x);	//참조값 변경된채로 전달

	}

	static void change(Data d) { // d : 참조값 전달
		d.x = 1000;
		System.out.println("change() : x = " + d.x);
	}
}

