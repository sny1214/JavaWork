package com.jica.thread;

import javax.swing.JOptionPane;

class ThreadEx6 {
	public static void main(String[] args) throws Exception{
		
		//간단한 입력을 받을수 있는 대화상자를 생성하여 보여주고 입력이 끝날때까지 기다린다.
		//입력이 끝나면 대화상자는 사라진다.
		String input = JOptionPane.showInputDialog("아무 값이나 입력하세요."); 
		System.out.println("입력하신 값은 " + input + "입니다.");

		for(int i=10; i > 0; i--) {
			System.out.println(i);
			
			try {
				//현재 실행중인 (main)쓰레드를 지정된 시간만큼(1초) 일시정지상태로 만든다.
				Thread.sleep(1000); //1--> 1/1000초, 100-->100/1000초, 1000-->1000/1000초
				//try-catch로 안묶으면 InterruptedException 에러남.static이라 객체 생성 없이 Thread.sleep 바로 사용 가능
				
			} catch(Exception e ) {}
		}
	}
}
