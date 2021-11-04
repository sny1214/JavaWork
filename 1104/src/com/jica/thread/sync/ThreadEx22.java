package com.jica.thread.sync;

class ThreadEx22 {
	public static void main(String args[]) {
		Runnable r = new RunnableEx22();
		
		Thread th1 = new Thread(r,"성춘향");
		Thread th2 = new Thread(r,"이몽룡");
		
		th1.start();
		th2.start();
	}
}

class Account2 {
	private int balance = 1000; // private으로 해야 동기화가 의미가 있다.

	public  int getBalance() {
		return balance;
	}

	//synchronized 메서드
	public /*synchronized*/ void withdraw(int money){ // synchronized로 메서드를 동기화
		
		if (balance >= money) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
			}
			balance -= money;
		}

	} // withdraw
}

class RunnableEx22 implements Runnable {
	Account2 acc = new Account2();

	public void run() {
		while(acc.getBalance() > 0) {
			// 100, 200, 300중의 한 값을 임으로 선택해서 출금(withdraw)
			int money = (int)(Math.random() * 3 + 1) * 100;
			
			//synchronized block			
			synchronized (acc) {
				acc.withdraw(money);
			}
			
			Thread curThread = Thread.currentThread();
			System.out.println(curThread.getName() + " 이 " +  money + " 를 인출했습니다.");

			System.out.println("balance:"+acc.getBalance());
		}
	} // run()
}
