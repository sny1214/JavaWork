package com.jica.chap08;

class ExceptionEx17 {
	public static void main(String[] args) 
	{
		try  {
			method1();		
		} catch (Exception e)	{
			System.out.println("main메서드에서 예외처리 2차 마무리.");
		}
	}	// main�޼����� ��

	static void method1() throws Exception {
		try {
			throw new Exception();
		} catch (Exception e) {
			System.out.println("method1메서드에서 예외처리 1차 작업 마무리.");
			//예외로 던진다.
			throw e;			// 다시 예외를 발생시킨다.
		}
	}	// method1�޼����� ��
}
