package com.jica.chap06;

class ReferenceParamEx2 {
	public static void main(String[] args) 
  {
		int[] x = {10};  // 요소 1개짜리 배열
		// x 0x100 ----> {10} //배열값도 참조값 가짐
		System.out.println("main() : x = " + x[0]);	//x[0] = 10

		change(x);	//참조값을 전달, 기본형매개변수로 전달하려면 x[0]식으로 써야...
		System.out.println("After change(x)");
		System.out.println("main() : x = " + x[0]);
	}

	static void change(int[] x) { // 배열명을 인자로 전달(참조값을 전달)
		x[0] = 1000;
		System.out.println("change() : x = " + x[0]);
		// x 0x100 ----> x[0] = {10} ----> {1000}
	}
}
