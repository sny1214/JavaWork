package com.jica.thread;

class ThreadEx2 {
	//main()메서드 선언부의 throws Exception의 의미
	//main()메서드가 실행되는 과정에서 예외가 발생하면 직접 처리(try-catch)하지 않고
	//JVM으로 예외정보를 던지겠다는 뜻이다.
	public static void main(String args[]) throws Exception {
		ThreadEx2_1 t1 = new ThreadEx2_1();
		
		t1.start();	//os가 인지하는 작업쓰레드를 시작-여기서 오류발생
					//main Thread 스택 =/= 작업쓰레드 스택stack
	}
	// |                  |
	// |                  |
	// |                  |throwException() 
	// |                  |run()
	// |----------        |---------
	// main Thread 스택     작업쓰레드 stack	
}

class ThreadEx2_1 extends Thread {
	public void run() {
		throwException();	//t1 start하면 메서드 호출 <--Thread 내부에서 예외가 발생함
	}

	public void throwException() {	//메서드 내용 실행
		try {
			throw new Exception();		
		} catch(Exception e) {
			System.out.println("예외처리 코드");
			e.printStackTrace();	
			//결과
			//java.lang.Exception
			//			at com.jica.thread.ThreadEx2_1.throwException(ThreadEx2.java:20)
			//			at com.jica.thread.ThreadEx2_1.run(ThreadEx2.java:15)

		}
	}
}
//java.lang.Exception
//at com.jica.thread.ThreadEx2_1.throwException(ThreadEx2.java:17)
//at com.jica.thread.ThreadEx2_1.run(ThreadEx2.java:12)
