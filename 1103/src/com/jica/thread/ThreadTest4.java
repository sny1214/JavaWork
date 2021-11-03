package com.jica.thread;

public class ThreadTest4 {

	public static void main(String[] args) {
		System.out.println("쓰레드 갯수 : " + Thread.activeCount());
		
		//101부터 200까지 합계를 계산하는 기능을 쓰레드로 만들자
		//0) Runnable을 구현(implements)한 class 만들기
		//1) UserRunnable 객체 생성 --> 단독으로 os가 인지하는 쓰레드가 될 수 없다.--> os가 인지하도록 반드시 2)~3)단계 필요
		UserRunnable ur = new UserRunnable();
		//2)★Thread객체를 생성하면서 UserRunnable객체를 인자로 전달★
		Thread th = new Thread(ur,"JICA작업쓰레드");		//(runnable객체를 전달,쓰레드 이름)
		//3) 작업쓰레드 시작
		th.start();
		
		//현재의 코드는 main()메서드 내부이므로 main Thread정보가 얻어진다.		
		Thread mt = Thread.currentThread();
		
		int sum = 0;
		for(int i=1; i<=100; i++) {
			sum += i;
			System.out.println( mt + " " + i + "," + sum);
			
			if( i % 20 == 0) {
				System.out.println("                 쓰레드 갯수 : " + Thread.activeCount());
			}
		}
		System.out.println(mt + " sum = " + sum);	
		System.out.println(mt + " 종료!!!");
		
	}

}

//쓰레드 작성방법2 - Runnable interface를 구현(implements)
//UserRunnable 내부에서는 Thread클래스의 메서드를 직접 사용할수는 없다.
//이걸 직접 이용한게 아니라 쓰레드를 생성해 runnalbe 객체를 전달하고, 쓰레드를 실행시키면서 간접적으로 runnable 객체 실행됨
class UserRunnable implements Runnable{

	@Override
	public void run() {
		//현재실행중인 쓰레드정보를 얻는다.
		Thread wt = Thread.currentThread();

		int sum2 = 0;
		for(int number = 101; number<=200;number++) {
			sum2 += number;
			System.out.println(wt + " " + number + "," + sum2);
		}
		System.out.println(wt + " sum2 = " + sum2);
		System.out.println(wt + " 종료!!!");
	}
	
}

