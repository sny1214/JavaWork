package com.jica.thread;

class ThreadEx4 {
	public static void main(String args[]) {
		//현재의 예제는 main()쓰레드만 사용
		//1970/1/1 0:0:0:0 					0                         
		//            1     			 1000
		// ~
		//			2021/11/03 13:18:49  	?
		long startTime = System.currentTimeMillis();

		for(int i=0; i < 500; i++)
			System.out.printf("%s", new String("-"));		
				//"-" 500개 찍는 데 걸린 시간 
		System.out.print("소요시간1:" +(System.currentTimeMillis()- startTime)); 

		for(int i=0; i < 500; i++) 
			System.out.printf("%s", new String("|"));		
				//"|" 500개 찍는 데 걸린 시간 
		System.out.print("소요시간2:"+(System.currentTimeMillis() - startTime));
	}
}
