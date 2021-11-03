package com.jica.thread;

class ThreadEx15 {
	public static void main(String args[]) {
		RunImplEx15 r = new RunImplEx15();
		
		Thread th1 = new Thread(r, "*");
		Thread th2 = new Thread(r, "**");
		Thread th3 = new Thread(r, "***");

		th1.start();
		th2.start();
		th3.start();

				
		try {								
			Thread.sleep(2000);	//th1,2,3 작동			
			//		대기큐 			실행중			일시정지큐
			//  th1, th2, th3						 mT	2초	
			System.out.println("-------------------");
			th1.suspend();	// 쓰레드 th1을 잠시 중단시킨다.(2초)->일시정지큐로 들어가
			Thread.sleep(2000);	//th2,3 작동
			System.out.println("-------------------");
			th2.suspend();	// 쓰레드 th2을 잠시 중단시킨다.(3초)						
			Thread.sleep(3000); //th3 작동
			System.out.println("-------------------");	
			th1.resume();	// 쓰레드 th1이 다시 동작하도록 한다.
			Thread.sleep(3000); //th3,1 작동
			System.out.println("-------------------");
			th1.stop();		// 쓰레드 th1을 강제종료시킨다.
			th2.stop();		// 쓰레드 th2을 강제종료시킨다.
			Thread.sleep(2000);	//th3 작동
			System.out.println("-------------------");
			th3.stop();		// 쓰레드 th3을 강제종료시킨다.--> th1(x),2(x),3(x)
		} catch (InterruptedException e) {}
	} // main
}

class RunImplEx15 implements Runnable {
	public void run() {
		while(true) {
			System.out.println(Thread.currentThread().getName());
			try {
				Thread.sleep(1000);			//1초씩 지연효과
			} catch(InterruptedException e) {}
		}
	} // run()
}
