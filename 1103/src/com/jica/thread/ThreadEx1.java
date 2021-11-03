package com.jica.thread;

class ThreadEx1 {
	public static void main(String args[]) {
		
		//쓰레드를 상속받아 만들어진 Thread객체(t1 = Thread-0) 생성
		ThreadEx1_1 t1 = new ThreadEx1_1();
		
		//쓰레드 객체가 아니라 Runnable객체 생성
		Runnable r  = new ThreadEx1_2();
		
		//Runnable객체를 전달받은 Thread객체(t2 = Thread-1) 생성
		Thread   t2 = new Thread(r);	  // 생성자 Thread(Runnable target)

		//쓰레드 작동 시작 
        //아래의 2줄이 실행되면 실제 실행되는 쓰레드는 3개이다.
		//main Thread, thread-0, thread-1
		//start()하면 곧장 실행되는 건 아니지만 os가 관여해서 실행시켜줌, 어떤게 먼저 작동할지는 몰라, os가 알아서
		t1.start();	
		t2.start();
		
		//t1.run();
		//t2.run();	//--> 작성한 규칙에 의해 Thread-2아닌 main으로 결과 나옴
		//위처럼 run()메서드를 직접호출하면 작업쓰레드가 생성된것이 아니라
		//메인쓰레드에서 메서드를 호출하여 순차적으로 실행할 뿐이다.
		
		//위의 start()메서드는 실행즉시 동작할수도 있고 
		//약간 시간차를 두고 실행될수도 있다. -> os가 결정
		
		for(int i=0; i<5; i++) {
			System.out.println(Thread.currentThread().getName()); //main
		}
		
		//t1.run(); 절대 직접호출하지 않는다. 문법적인 에러는 아니지만 내가 원하는 식으로 결과 도출 안돼
	
		//작업 쓰레드 종료시점은 run()메서드의 내용이 모두 실행되면 종료된다.
		//또는 stop()메서드로 강제 종료시킬 수는 있지만 권장하지 않는다.
		//주의) 종료된 작업쓰레드 객체 다시 start()시킬 수 없다.
		//	   쓰레드 시작은 딱 한번만 할 수 있다.
	
	}
}
//결과에서 쓰레드코드가 적기 때문에 쓰레드간 교차되지 않고 끝내고 다른 쓰레드 작동시키는 결과가 나옴

class ThreadEx1_1 extends Thread {
	public void run() {
		for(int i=0; i < 5; i++) {
			System.out.println(getName()); // 부모클래스 즉, Thread의 getName()을 호출
								//this.getName() or super.getName() 도 가능
		}
	}
}

class ThreadEx1_2 implements Runnable {
	//run()메서드가 동작하는것은
	//쓰레드객체가 생성되었고 start()메서드가 적용된 이후에 
	//run()메서드의 코드가 실행되므로 이미 작업쓰레드 만들어져서 동작중이라는 뜻이다.
	public void run() {
		for(int i=0; i < 5; i++) {
			//System.out.println(getName()); // error <--Runnerble을 구현했는데, getName은 쓰레드 것
			Thread cThread =  Thread.currentThread();//현재 실행중인 Thread를 반환한다.
		    System.out.println(cThread.getName());	//쓰레드 객체를 구해서 그것의 getName을 구한 것이므로 가능
		    
		    //아래의 코드는 위의 2줄을 간결하게 표현한 것이다.
			// System.out.println(Thread.currentThread().getName());
			
		}
	}
}
