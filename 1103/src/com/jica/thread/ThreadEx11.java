package com.jica.thread;

import java.util.*;

//이클립스에서 Java코드를 실행시킬 때 내부적으로
//여러개의 작업쓰레드들이 만들어져서 동작합니다.
//이중에는 데몬 쓰레드들도 있습니다. -- 확인 차원의 코드
class ThreadEx11 {
	public static void main(String args[]) throws Exception {
		ThreadEx11_1 t1 = new ThreadEx11_1("작업쓰레드 1");
		ThreadEx11_2 t2 = new ThreadEx11_2("작업쓰레드 2");
		t1.start();
		t2.start();
	}
}

class ThreadEx11_1 extends Thread {
	ThreadEx11_1(String name) {
		super(name);
	}

	public void run() {
		try {
			sleep(5 * 1000);	// 5초 동안 기다린다.
		} catch(InterruptedException e) {}
	}
}

class ThreadEx11_2 extends Thread {
	ThreadEx11_2(String name) {
		super(name);
	}

	public void run() {
		//현재 진행 중 또는 대기상태의 모든 쓰레드의 호출 스택정보를 얻어온다.
		Map map = getAllStackTraces();
		Iterator it = map.keySet().iterator();	//map객체 구성요소 중 key값만 가져와서 set으로 만들어 그 set에 접근할 수 있는 iterator만들어라

		int x=0;
		while(it.hasNext()) {
			Object obj = it.next();
			Thread t = (Thread)obj;	//쓰레드로 형변환
			StackTraceElement[] ste = (StackTraceElement[])(map.get(obj));

			System.out.println( "["+ ++x + "] name : " + t.getName() 
                                       + ", group : "  + t.getThreadGroup().getName() 
                                       + ", daemon : " + t.isDaemon());

			for(int i=0; i < ste.length; i++) {
				System.out.println(ste[i]);
			}

			System.out.println();
		}
	}
}
