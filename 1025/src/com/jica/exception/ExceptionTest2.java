package com.jica.exception;

public class ExceptionTest2 {

	public static void main(String[] args) throws InterruptedException {	//예외처리 방법2 - 예외를 던지는 기능, 있으면 계속 예외처리 1or2 하면서 작성해야..
		// 10부터 1까지 1초에 1씩 카운트
		
		for(int i = 10; i >= 1; i--) {
			System.out.println(i);
		
			//예외처리 방법 1 - 직접 처리(try catch 블럭)
//			try {
//				//예외발생 가능성을 가진 실행문장
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				//예외객체의 정보를 해석하여 복구하거나 안내문구 출력후 프로그램을 종료한다.
//				e.printStackTrace();
//			}
			
			//예외처리 방법2 - 호출한 상위코드로 예외 객체를 던진다. -> 예외가 발생하자 마자 메인메소드로.. 아예 코드 실행되지 않아
			Thread.sleep(1000);
			
			//실행코드 -> 예외 발생하지 않으면 실행됨
			
			
		}

	}

}
