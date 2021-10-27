package com.jica.chap08;

class FinallyTest3 {
	public static void main(String args[]) {

		FinallyTest3.method1();		
        System.out.println("method1()을 마치고 main으로 돌아왔습니다.");
	}	// main�޼����� ��

	static void method1() {
		try {
			System.out.println("method1() 실행 중.");
			throw new Exception("고의로 발생시킨 예외");
			//return;		// 현재 실행중인 메서드를 멈추고 finally 블럭을 실행하고 즉시 호출한 곳으로 되돌아 간다.
		}	catch (Exception e)	{
			e.printStackTrace();
			return;	
		} finally {
			System.out.println("method1()의 finally 블럭 실행.");
		}
	}	// method1�޼����� ��
}
