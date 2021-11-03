package com.jica.thread;

class ThreadEx3 {
	public static void main(String args[]) throws Exception {
		ThreadEx3_1 t1 = new ThreadEx3_1();
		t1.run();//OS가 인지하는 쓰레드가 아닌 단순한 메서드 호출에서 예외발생
				 //작업쓰레드 스택stack 안 만들어짐
				 //run() 사용 권장하지 않음 -> start() 이용해라..<ThreadEx2.java>
	} 
	// |            
	// |throwException()        3        
	// |run()          			2
	// |main()              	1번으로 출력   
	// |----------    
	// main Thread 스택     
}

class ThreadEx3_1 extends Thread {
	public void run() {
		throwException();
	}

	public void throwException() {
		try {
			throw new Exception();		
		} catch(Exception e) {
			System.out.println("예외 발생");
			e.printStackTrace();	
		}
	}
}

//java.lang.Exception
//at com.jica.thread.ThreadEx3_1.throwException(ThreadEx3.java:17)
//at com.jica.thread.ThreadEx3_1.run(ThreadEx3.java:12)
//at com.jica.thread.ThreadEx3.main(ThreadEx3.java:6)