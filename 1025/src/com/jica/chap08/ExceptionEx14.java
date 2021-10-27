package com.jica.chap08;

class ExceptionEx14 {
	public static void main(String[] args) {		//main도 예외 안던져도 된다.
		try  {
				method1();		
		} catch (Exception e)	{
				System.out.println("main에서 예외처리 마무리 한다.");	
				e.printStackTrace();
		}
	}	// main�޼����� ��

	static void method1() throws Exception {
		throw new Exception();
	}	// method1()�� ��
} // class�� ��
