package com.jica.thread;

class ThreadEx5 {
	static long startTime = 0;

	public static void main(String args[]) {
		startTime = System.currentTimeMillis();
		
		ThreadEx5_1 th1 = new ThreadEx5_1();
		th1.start();		//쓰레드객체 생성

		for(int i=0; i < 500; i++) {
			System.out.print(new String("-"));
		}

		System.out.print("소요시간1:" + (System.currentTimeMillis() - ThreadEx5.startTime));
	}
}

	//-와 |가 교차로 나타난다, ThreadEx4보다 오히려 소요시간 더 짧게 나옴
	

class ThreadEx5_1 extends Thread {
	public void run() {
		for(int i=0; i < 500; i++) {
			System.out.print(new String("|"));
		}

		System.out.print("소요시간2:" + (System.currentTimeMillis() - ThreadEx5.startTime));
	}
}
