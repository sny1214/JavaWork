package com.jica.virtual2;

public class NumberPrint {

	public static void main(String[] args) throws InterruptedException {
		//1초에 한번씩 숫자를 10부터 1까지 카운팅하는 프로그램을 작성한다.
		for(int i=10; i>=0; i--) {
			System.out.println(i);
			
			Thread.sleep(1000); // 1은 1/1000초이다
			                    //1000은 1초를 의미한다.
		}

	}

}
