package com.jica.thread;

class ThreadEx10   {
	//워드프로세서에서 3초마다 작업내용을 자동저장하도록 설정했다고 하자
	static boolean autoSave = false;

	public static void main(String[] args) {
		
		//쓰레드를 생성
		//AutoSaveRunnable asr = new AutoSaveRunnable();
		//Thread t = new Thread(asr);
		
		Thread t = new Thread(new AutoSaveRunnable());//코드가 메인쓰레드 안에 있음 -> 부모 쓰레드 : 메인쓰레드
		
		//t.setDaemon(true);가 없으면 t는 일반 작업쓰레드이다.
		//t쓰레드의 부모쓰레드는 main쓰레드이다.
		t.setDaemon(true);		// 이 부분이 없으면 종료되지 않는다.
								// t가 데몬 작업쓰레드로 설정된다
								// t.start()이전에 설정해야 한다.
		t.start();

		for(int i=1; i <= 20; i++) {
			try{
				
				Thread.sleep(1000);	//1초마다
				
			} catch(InterruptedException e) {}
			System.out.println(i);
			
			if(i==5)
				autoSave = true;	//5초 되면 자동세이브 기능 켜라
									//6초 정도되면 밑에 오토세이브Runnable 코드에서
									//autoSave() 메서드 작동
									//이후 3초마다 자동저장 (20초 이전까지)
			//20초가 되면 반복문 끝남. 메인()메서드 종료
			//main()메서드가 종료하면 main 쓰레드도 종료
			//20초 지나서도 계속 저장되면 t는 일반 쓰레드
			//20초 지나고(main쓰레드(부모쓰레드)) 자동저장 기능도 종료된다면 t : 데몬쓰레드
		}

		System.out.println("프로그램을 종료합니다. 즉, 부모쓰레드인 main쓰레드가 종료합니다.");
	}
	
}

// Runnabled을 구현한 클래스
class AutoSaveRunnable implements Runnable{
	@Override
	public void run() {
		while(true) {
			try { 
				Thread.sleep(3 * 1000);	// 3초마다 멈춤
			} catch(InterruptedException e) {}	

			// autoSave의 값이 true이면 autoSave()를 호출한다.
			if(ThreadEx10.autoSave) {
				autoSave();
			}
		}
	}

	public void autoSave() {
		Thread curThread = Thread.currentThread();
		if ( !curThread.isDaemon() ) {				//t쓰레드가 데몬쓰레드가 아니면
			System.out.println("일반 쓰레드에서 작업파일이 자동저장되었습니다.");
		}else {
			System.out.println("데몬 작업 쓰레드에서 작업파일이 자동저장되었습니다.");
		}	
	}
}
