package com.jica.chap08;

class ExceptionEx6 {
	public static void main(String args[]) {
		System.out.println(1);			
		System.out.println(2);
		try {
			System.out.println(3);
			System.out.println(0/0);	//인위적인 예외 발생 - ArithmeticException발생을 정확히 알고 있다면 -> catch절에 기술
			System.out.println(4); 		//수행 안함
		} catch (Exception e)	{	// 예외의 종류가 정확하지 않다면 상위인 RuntimeException(으로 적어도 돼) -> 상위 exception으로 기술->상위의 Throwable 도 가능
			System.out.println(5);
		}	// try-catch�� ��
		System.out.println(6);
	}	// main�޼����� ��
}
