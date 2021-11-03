package com.jica.thread;

public class ThreadTest3 {

	public static void main(String[] args) {
		System.out.println("쓰레드 갯수 : " + Thread.activeCount());//1
		
		//101부터 200까지 합계를 계산하는 기능을 쓰레드로 만들자
		//0) 작업쓰레드 class 만들기
		//1) 작업쓰레드 객체 생성
		//	 쓰레드명을 별도로 지정하지 않으면 Thread-0,1,2,...으로 명칭이 부여된다.
		UserThread2 ut = new UserThread2("JICA");	
			//쓰레드 이름 변경하고 싶을 때, 생성자 생성 후, 이름 부여 or setName() 사용
		//2) 작업쓰레드 시작
		ut.start();
		
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

//쓰레드 작성방법 - Thread class 상속
//UserThread2 내부코드에서 Thread클래스의 다양한 메서드를 사용할 수 있다.
class UserThread2 extends Thread{
	
	public UserThread2(String name) {
		super(name);
		//쓰레드 이름 변경하고 싶을 때, 생성자 생성 후, 이름 부여 or setName() 사용
	}

	@Override
	public void run() {
		//현재실행중인 쓰레드정보를 얻는다.--->작업쓰레드(UserThread2)
		//.currentThread();를 어디에서 쓰느냐에 따라 얻어지는 쓰레드정보가 달라짐
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

