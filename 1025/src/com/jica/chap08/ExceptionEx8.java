package com.jica.chap08;

class ExceptionEx8 {
	public static void main(String args[]) {
		System.out.println(1);			
		System.out.println(2);
		try {
			System.out.println(3);
			System.out.println(0/0); // 예외 발생
			System.out.println(4); 	 //샐행안됨
		} catch (ArithmeticException ae)	{

			System.out.println("예외메세지 : " + ae.getMessage());
			//예외발생 경로를 출력하는 메서드
			ae.printStackTrace();
		}	// try-catch�� ��
		System.out.println(6);
	}	// main�޼����� ��
}
