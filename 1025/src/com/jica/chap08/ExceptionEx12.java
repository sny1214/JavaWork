package com.jica.chap08;

class ExceptionEx12 {
	//예외처리
	//최종적으로 JVM에 예외객체가 전달되어 예외정보가 출력된다.
	public static void main(String[] args) /*throws Exception*/ {
		try {			//예외 상위로 안던지고 여기서 해결
		method1();
		}catch(Exception e) {
		}
  	}	// main�޼����� ��

	static void method1() throws Exception{
		//try {
			method2();	//예외 발생되어 오면 또 메인으로 던져
		//}catch(Exception e) {
		//}
		
	}	// method1�� ��

	static void method2() throws Exception {
		throw new Exception();	//예외 발생시 method1(호출한 놈)으로 던져
	}	// method2�� ��
}
