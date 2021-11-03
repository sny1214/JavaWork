package com.jica.thread;

public class DaemonTest {

	public static void main(String[] args) {
		// 현재의 쓰레드는 main쓰레드이다 -- 일반쓰레드
		
		// 아래의 쓰레드는 작업쓰레이다. 
		TestThread th = new TestThread();
		th.setDaemon(true);  // 데몬쓰레드가 된다.
		
		th.start();
		
		// main쓰레드에서는 100부터 500까지 출력
		for(int i=100; i<=500; i += 100) {
			System.out.println(i);
			System.out.println(th.isDaemon());
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		System.out.println("main쓰레드 끝!");
	}

}

class TestThread extends Thread{

	@Override
	public void run() {
		for(int i=10; i>0; i--) {
			System.out.println(i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}