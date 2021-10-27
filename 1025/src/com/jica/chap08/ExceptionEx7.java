package com.jica.chap08;

class ExceptionEx7 {
	public static void main(String args[]) {
		System.out.println(1);			
		System.out.println(2);
		try {
			System.out.println(3);
			System.out.println(0/0);	//try 절에서 발생할 가능성이 있는 예외의 종류가 여러가지 라면
										//해결방안 1 -- 여러개의 catch절 사용
										//            주의) 먼저 나오는 catch 절에 하위 예외클래스를 사용한다.
										//해결방안 2 -- catch절을 1개 사용하고 가장상위 예외클래스를 사용
			System.out.println(4); 		// 실행안함
		} catch (ArithmeticException ae)	{	
			if (ae instanceof ArithmeticException) //ArithmeticException이면 ArithmeticException출력, 아니면 다 Exception절로 점프
				System.out.println("true");	
			System.out.println("ArithmeticException");
		} catch (Exception e)	{
			System.out.println("Exception");
		}	// try-catch�� ��
		System.out.println(6);
	}	// main�޼����� ��
}
