package com.jica.chap04;

class FlowEx24 {
	public static void main(String[] args) throws InterruptedException { 
		int i=11;

		System.out.println("카운트 다운을 시작합니다.");

		while(i--!=0) {		//i 11 10
			System.out.println(i);

			//시간지연효과를 위해 큰 수 까지 합계를 계산하도록 한다. --> 별로 효과가 없다
//			for(int j=0;j<2_000_000_000;j++) {
//					;	//빈 실행문장 즉, 실행할 문장이 없다는 의미
//			}
			//시간 지연 효과는 쓰레드를 이용한다.
			Thread.sleep(1000); //1초 멈춤
		}
			


		System.out.println("GAME OVER");
	}
}
