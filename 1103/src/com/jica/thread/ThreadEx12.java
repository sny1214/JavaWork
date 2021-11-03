package com.jica.thread;

class ThreadEx12 {
	public static void main(String args[]) {
		ThreadEx12_1 th1 = new ThreadEx12_1();
		ThreadEx12_2 th2 = new ThreadEx12_2();

		th1.start();
		th2.start();

		//현재의 쓰레드 즉, main쓰레드를 2초동안 일시정지 시켜라
		//그동안에 위의 작업쓰레드 th1, th2만이 대기큐 <----> 실행중
		try {
			 Thread.sleep(2000); //권장
			                     //th1.sleep(2000);
			                     //th2.sleep(2000);
			                     //Thread.sleep(2000);   
		} catch(InterruptedException e) {}

		System.out.print("<<main 종료>>");
	} // main
}

class ThreadEx12_1 extends Thread {
	public void run() {
		for(int i=0; i < 300; i++) {
			System.out.print("-");
		}
		System.out.print("<<th1 종료>>");
	} // run()
}

class ThreadEx12_2 extends Thread {
	public void run() {
		for(int i=0; i < 300; i++) {
			System.out.print("|");
		}
		System.out.print("<<th2 종료>>");
	} // run()
}
