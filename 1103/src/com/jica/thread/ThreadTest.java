package com.jica.thread;

public class ThreadTest {

	public static void main(String[] args) {
		//지금까지 Java프로그램이 시작되면 main()메서드가 프로그램의 시작점 이었다.
		//또한 Process가 생성되고 그 내부에 main쓰레드가 생성되었고
		//main쓰레드의 내용이 main() 내부의 실행코드 이었다.
		//지금까지는 main()의 실행코드가 cpu를 독점하여 실행되고 있었으므로
		//단일(single)쓰레드 프로그램이었다.
		
		//현재 실행중인 쓰레드의 갯수를 알아보자
		System.out.println("쓰레드 갯수 : " + Thread.activeCount());

		//현재 실행중인 쓰레드 즉, main쓰레드 정보를 Thread객체로 얻어오자
		Thread curThread = Thread.currentThread();
		
		//현재 쓰레드의 정보 [쓰레드이름, 쓰레드 우선순위(1~10), 쓰레드 그룹이름] 알려준다.
		//normal thread는 우선순위 5정도인데, main thread가 5정도
		//메인쓰레드그룹 안에 메인쓰레드
		System.out.println("현재 쓰레드의 정보 : " + curThread);
		System.out.println("쓰레드 ID : " + curThread.getId());
		System.out.println("쓰레드 이름 : " + curThread.getName());
		System.out.println("쓰레드 우선순위(priority) : " + curThread.getPriority());
		System.out.println("쓰레드 그룹 : " + curThread.getThreadGroup());
		System.out.println("쓰레드 상태 : " + curThread.getState());
		
		//main Thread에서 다른 쓰레드 즉, 작업쓰레드를 만들면
		//작업쓰레드 입장에서 부모쓰레드는 main쓰레드이다.
		
		int sum = 0;
		for(int number = 1; number <= 200; number++) {
			sum += number;
		}
		System.out.println("1~200 까지 합계 : " + sum);
	}
	
}
