package com.jica.thread;

class ThreadEx8 {
	public static void main(String args[]) {
		ThreadEx8_1 th1 = new ThreadEx8_1();	//기본우선순위 5
		ThreadEx8_2 th2 = new ThreadEx8_2();	//기본우선순위 5

		//우선순위를 변경할 때는 반드시 start()메서드 이전에 실행시켜야 한다.
		th2.setPriority(7);		//우선순위 5 -> 7
		
		System.out.println("Priority of th1(-) : " + th1.getPriority() );
		System.out.println("Priority of th2(|) : " + th2.getPriority() );
		
		//cpu가 1개이고 core도 1개라면 th2가 확률적으로 좀더 먼저 끝나야 한다.
		//th2가 우선순위가 더 높으므로 cpu를 더 많이 차지하도록 cpu가 스케쥴링
		//그러므로 th2가 더 빨리 끝나도록
		//하지만!! 현재는 cpu가 1개이지만 core가 여러개이므로
		//효과가 적용되지 않아 두개 쓰레드가 같은 확률로 끝난다.
		th1.start();
		th2.start();

	}
}

class ThreadEx8_1 extends Thread {
	public void run() {
		for(int i=0; i < 300; i++) {
			System.out.print("-");
			//아래의 코드는 시간지연효과를 노리고 작성한 코드이다. --> 없으면 교체가 일어나지 않아
			for(int x=0; x < 10000000; x++);
		}
	}
}

class ThreadEx8_2 extends Thread {
	public void run() {
		for(int i=0; i < 300; i++) {
			System.out.print("|");
			//아래의 코드는 시간지연효과를 노리고 작성한 코드이다.
			for(int x=0; x < 10000000; x++);
		}
	}
}
