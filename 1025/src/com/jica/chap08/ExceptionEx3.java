package com.jica.chap08;

class ExceptionEx3 {
	public static void main(String args[]) {
		int number = 100;
		int result = 0;

		for(int i=0; i < 10; i++) {
			try {
				//예외 발생 가능성이 있는 코드
				result = number / (int)(Math.random() * 10);
				System.out.println(result);
			} catch (ArithmeticException e)	{
				System.out.println("0");		//예외 발생시 그냥 "0" 출력하라 -> 프로그램 중단은 막음
			} // try-catch�� ��
		} // for�� ��
	} 
}
