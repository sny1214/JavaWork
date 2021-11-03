package com.jica.thread;

public class SleepTest {

	public static void main(String[] args) throws InterruptedException {
		for(int i=10; i>0; i--) {
			System.out.println(i);
			
			//아래의 코드는 시간지연효과를 노리고 작성한 코드이다.
			//for(int x=0; x < 10000000; x++);
			
			//위의 인위적인 코드는 효과를 확인하기가 어렵다.
			
			//Thread의 sleep()메서드를 사용해 보자
			//try {
				Thread.sleep(50); //1초
			//} catch (InterruptedException e) {
			//	e.printStackTrace();
			//}
		}

	}

}
