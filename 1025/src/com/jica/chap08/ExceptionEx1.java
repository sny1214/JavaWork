package com.jica.chap08;

class ExceptionEx1 {
	public static void main(String[] args) {
		//try - catch 블럭 구조가 중첩될 수 있다.
		try  {
			//실행문장 1
		
			try	{	
				//실행문장 2
			} catch (Exception e)	{
				//실행문장 2를 수행하면서 예외 발생시의 복구 코드
			}
			
			//실행문장 3
		
		} catch (Exception e)	{
			//복구코드 1
		
			try	{	
				//복구코드 2
			} catch (Exception e2) { 
				//복구코드 2 실행중 또다른 예외 발생 시의 복구 코
			}	
			//복구코드 3
		
		} // try-catch 블럭 끝

		try  {

		} catch (Exception e)	{

		} // try-catch�� ��
	}	// main�޼����� ��
}
