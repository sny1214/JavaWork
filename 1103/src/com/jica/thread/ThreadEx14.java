package com.jica.thread;

import javax.swing.JOptionPane;

class ThreadEx14 {
	public static void main(String[] args) throws Exception 	{
		ThreadEx14_2 th1 = new ThreadEx14_2();
		th1.start();

		String input = JOptionPane.showInputDialog("아무 값이나 입력하세요."); 
		System.out.println("입력하신 값은 " + input + "입니다.");
		th1.interrupt();   
		//위의 interrupt()를 호출하면, interrupted상태가 true가 된다.
		//th1이 sleep()메서드에 의한 일시정지 상태이므로
		//일시정지 상태를 깨우는 역할만 한다 -> 예외 발생한다 InterruptedException error
		//그러므로 예외 발생하면서 실행중인 코드가 되므로, interrupt()를 다시 걸어 반복문 빠져나가기 해결!
		System.out.println("isInterrupted():"+ th1.isInterrupted());
	}
}

class ThreadEx14_2 extends Thread {
	public void run() {
		int i = 10;

		while(i!=0 && !isInterrupted()) {
			System.out.println(i--);

			try {
				Thread.sleep(1000);  // 1초 지연
			} catch(InterruptedException e) {
				System.out.println("일시정지 상태에서 인위적으로 깨어났습니다.");
				//현재 실행 중일 때 interrupt를 인식시키기 위해 다시 interrupt()를 작동시킨다.
				interrupt();
			}
		}

		System.out.println("카운트가 종료되었습니다.");
	} // main
}
