package com.jica.modifier;

public class StaticTest {
	int s = 1;
	static int width = 200;  //--| 클래스 변수
	static int height = 120; //--|
	
	static {
		//위처럼 width,height 클래스 변수에 명시적으로 값을 지정하는 것이 아니라
		//복잡한 로직을 수행한 결과값을 초기값으로 지정할 때 유용하다.
	}
	
	static int max(int a, int b) {
		//System.out.println(s); 
		//method();
		return a>b ? a : b;
	}
	
	int method() {
		return 0;
	}
	
	public static void main(String args[]) {
		System.out.println(width);
		System.out.println(StaticTest.height);
		
		max(10,20);
		StaticTest.max(100, 200);
	}
}
