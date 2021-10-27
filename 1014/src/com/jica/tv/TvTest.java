package com.jica.tv;

public class TvTest {

	public static void main(String[] args) {
		//1) 객체 선언 및 생성
		Tv tv1 = new Tv();
		//       ---1-- 2= 생성자가 없으면 디폴트생성자동작
		// -------3--------있으면 사용자 만든 인자가 없는 기본생성자동작     
		//               
		//tv1 0x100---->[null,true,13]
		
		//2) 객체 사용
		//tv1.color = "빨강색"; //에러
		
		tv1.power();
		tv1.changeChannel(13);
		tv1.display();
		
		Tv tv2 = new Tv("검정색", true, 7);
        //       ---1--- ======2=========
		// ----3--------------------------
		
		//tv2 0x200---->["검정색",false,6]
		tv2.display();
		
		tv2.channelDown();
		tv2.power();
		tv2.display();
		
		Tv tv3 = new Tv("흰색");
		//tv3 0300----->["흰색",true,19]
		
		tv3.power();
		tv3.channelUp();
		tv3.channelUp();
		tv3.changeChannel(20);
		tv3.channelDown();
		
		//객체의 현재상태를 알려주는 메서드
		tv3.display();
		
		tv3.method(); //ok
	}

}
