package com.jica.thread;

import javax.swing.JOptionPane;

class ThreadEx13 {
	public static void main(String[] args) throws Exception 	{
		ThreadEx13_2 th1 = new ThreadEx13_2();
		th1.start();

		String input = JOptionPane.showInputDialog("아무 값이나 입력하세요."); 
		System.out.println("입력하신 값은 " + input + "입니다.");
		th1.interrupt();   // interrupt()를 호출하면, interrupted상태가 true가 된다.
		System.out.println("isInterrupted():"+ th1.isInterrupted()); // true
	}
}

class ThreadEx13_2 extends Thread {
	public void run() {
		int i = 10;

		//  현재의 작업쓰레드는	i가 0과 같거나
		//				  	interrupt()메서트를 받으면 반복을 탈출한다.
		while(i!=0 && !isInterrupted()) {
			System.out.println(i--);
			for(long x=0;x<2500000000L;x++); // 시간 지연
			//위의 코드의 시간 지연 효과가 소용없다면
			//Thread.sleep 사용 --> ThreadEx14
		}
		
		//i = 0이거나 종료되었을 때..
		System.out.println("카운트가 종료되었습니다.");
	} // main
}
