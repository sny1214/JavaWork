package com.jica.thread;

public class ThreadTest2 {

	public static void main(String[] args) {
		System.out.println("쓰레드 갯수 : " + Thread.activeCount());	//1
		//main(현재)쓰레드에서 1~100까지 합계를 계산 --|
		//작업쓰레드에서 101~200까지 합계를 계산 ------| 1~200까지 합계
		
		//101부터 200까지 합계를 계산하는 기능을 쓰레드로 만들자
		
		//0) 작업쓰레드 class 만들기
		//1) 작업쓰레드 객체 생성
		UserThread ut = new UserThread();
		//2) 작업쓰레드 시작
		ut.start();	//멀티쓰레드ㅡ ㅏㄱ동
		
		int sum = 0;
		for(int i=1; i<=100; i++) {
			sum += i;
			System.out.println("main Thread: " + i +"," + sum);
			
			if( i % 20 == 0) {
				System.out.println("                 쓰레드 갯수 : " + Thread.activeCount());
			}
		}
		System.out.println("main Thread: sum = " + sum);	
		System.out.println("main Thread 종료!!!");
		
		//메인쓰레드가 먼저 종료하면 결과합이 다르다.
		
		//1~200까지의 합계 : 17020 <== 원래 20100이 나와야함<ThreadTest결과>
		//옳은 결과값이 나오기 위해선 다른(user) 쓰레드가 끝날 때까지 현재(main) 쓰레드를 멈춰 기다리게 해라
		//ut.join() 작성해서 try catch구문
		try {
			ut.join();	//ut가 종료할 때 까지 현재 쓰레드 즉, main쓰레드를 멈춘다
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		System.out.println("1~200까지의 합계 : " + (sum + ut.sum2));
	}
}

//쓰레드 작성방법 - Thread class 상속
class UserThread extends Thread{
	//필요하다면 다양한 멤버변수와 메서드 및 생성자를 작성할 수 있다.
	int sum2 = 0;
	//가장 핵심 메서드인 run() 메서드 재정의함 -> 101부터 200까지의 합계를 계산하는 코드
	@Override
	public void run() {
		//int sum2 = 0;
		for(int number = 101; number<=200;number++) {
			sum2 += number;
			System.out.println("작업쓰레드 " + number + "," + sum2);
		}
		System.out.println("작업쓰레드 : sum2 = " + sum2);
		System.out.println("작업쓰레드 종료!!!");
	}
	
}

