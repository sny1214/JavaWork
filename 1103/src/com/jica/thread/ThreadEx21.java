package com.jica.thread;

class ThreadEx21 {
	public static void main(String args[]) {
		Runnable r = new RunnableEx21();
		
		Thread th1 = new Thread(r, "이몽룡");
		Thread th2 = new Thread(r, "성춘향");
		
		th1.start();
		th2.start();
	}
}

class Account {
	private int balance = 1000;

	public  int getBalance() {
		return balance;
	}

	//인출하다.
	public void withdraw(int money){
		if(balance >= money) {
			try { Thread.sleep(1000);} catch(InterruptedException e) {}
			balance -= money;
		}
	} // withdraw
}

class RunnableEx21 implements Runnable {
	//공유데이타 -- 통장계좌
	Account acc = new Account();

	public void run() {
		while(acc.getBalance() > 0) {
			// 100, 200, 300중의 한 값을 임으로 선택해서 출금(withdraw)
			int money = (int)(Math.random() * 3 + 1) * 100;
			
			acc.withdraw(money);
			Thread curThread = Thread.currentThread();
			System.out.println(curThread.getName() + " 이 " +  money + " 를 인출했습니다.");
			System.out.println("balance: " + acc.getBalance());
		}
	} // run()
}
