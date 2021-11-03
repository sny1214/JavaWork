package com.jica.thread;

import javax.swing.JOptionPane;

class ThreadEx7 {
	public static void main(String[] args) throws Exception 	{
		ThreadEx7_1 th1 = new ThreadEx7_1();
		th1.start();	
		
		//입력받는 기능은 메인 쓰레드에서 처리하고 백그라운드 작업(여기선, 카운팅)은 쓰레드로 처리하여
		//동시에 기능이 수행되게 하는 효과를 얻을 수 있다.
		String input = JOptionPane.showInputDialog("아무 값이나 입력하세요."); 
		System.out.println("입력하신 값은 " + input + "입니다.");	
	}
}

class ThreadEx7_1 extends Thread {
	public void run() {
		for(int i=10; i > 0; i--) {
			System.out.println(i);
			try {
				sleep(1000);	//하위에서는 상위클래스의 메서드 호출 가능하므로 Thread.sleep으로 쓰는 게 권장되지만 sleep이라고 써도 기능함
				//백그라운드 작업은 쓰레드로 처리 - 1초에 한번 씩 문자를 출력하는 기능(카운팅 하는 기능)
			} catch(Exception e ) {}
		}
	}
}
