package com.jica.chap08;

class ExceptionEx2 {
	public static void main(String args[]) {
		int number = 100;
		int result = 0;
		
		//아래의 코드에서 발생가능한 예외의 종류가 ArithmeticException이므로 가능하다.
		//(RuntimeException이나 그 하위 예외는 예외처리를 하지 않아도 컴파일을 통과한다.)

		for(int i=0; i < 10; i++) {
			int value = (int)(Math.random() * 10); // 0~9까지 숫자 중 임의의 수 발생
			System.out.println("발생 난수 : " + value);
//			if(value ==0) {
//				continue;
//			}
			result = number / value;			   // 예외발생 가능성 있음. 0으로 나누었을 때 ArithmeticException 일어나
			System.out.println(result);
		}
	} 
}
