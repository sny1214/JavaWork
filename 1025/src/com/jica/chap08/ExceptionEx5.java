package com.jica.chap08;

class ExceptionEx5 {
	public static void main(String args[]) {
			System.out.println(1);			
			System.out.println(2);
			try {
				System.out.println(3);
				System.out.println(0/0);	// 인위적으로 예외 발생
				System.out.println(4); 		//4 실행되지 않고 곧장 예외발생 시 복구코드(아래의 catch절)로 넘어감
			} catch (ArithmeticException ae)	{
				System.out.println(5);
			}	// try-catch�� ��
			System.out.println(6);			//무조건 실행
	}	// main 끝
}
