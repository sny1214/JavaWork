package com.jica.chap06;

class TvTest4 {
	public static void main(String args[]) {
		Tv t1 = new Tv(); 
		Tv t2 = new Tv();
		Tv t3 = new Tv();
		
		// Tv 객체 3개 만든다 : t1, t2, t3
		//				  color  power channel
		// t1 0x100 ----> [null, false,   0]
		// t2 0x200 ----> [null, false,   0]
		// t3 0x300 ----> [null, false,   0]
		
		t1.display();
		t2.display();
		t3.display();	
	
		t1.color = "검정색";
		t1.power = true;	//t1.power();
		t1.channelUp();
		t1.channelUp();
		
		t2.color = "빨강색";
		t2.channel = 7;
		t2.channelDown();
		
		t3.color = "흰 색";
		t3.power();
		
		//				    color   power   channel
		// t1 0x100 ----> ["검정색",  true,     2]
		// t2 0x200 ----> ["빨강색", false,     6]
		// t3 0x300 ----> ["흰 색",  true,      0]
		
		t1.display();
		t2.display();
		t3.display();	
		System.out.println("----------------------------------");

		
	//여러개의 객체를 생성하여 관리하고 싶다면 객체 배열을 사용할 수 있다.
	//객체 배열의 요소값은 하나의 객체(기능을 수행)	
		
		String names[] = new String[3];
		//names 0x400 ------> [null, null, null]
		
		names[0] = new String("홍길동");
		names[1] = new String("장길산");
		names[2] = new String("이순신");
		//				        |-->"홍길동", ...
		//						|	    |-->"장길산", ...
		//						|		|		|--> "이순신", ...
		//names 0x400 ------> [0x500, 0x600, 0x700]
		
		
	//Tv형 객체 배열 tvArr를 선언하고 3개짜리로 생성
		Tv[] tvArr = new Tv[3]; 
		//tvArr 0x800 -----> [null, null, null]

		
		// Tv객체를 생성하여 Tv객체배열의 요소값에 저장
		for(int i=0; i < tvArr.length;i++) {
			tvArr[i] = new Tv();
			tvArr[i].channel = i+10; // tvArr[i]의 channel에 i+10을 저장
			tvArr[i].display();
		}

		// 배열의 요소값이 객체 역할을 한다.
		
		//                      |-->[null, false, 10]
		//                      |     |--> [null, false, 11]
	 	//                      |     |       |--> [null, false, 12]
		//tvArr 0x800 -----> [0x801, 0x802, 0x803]
		
		System.out.println("----------------------------------");
		
		for(int i=0; i < tvArr.length;i++) {
			tvArr[i].channelUp();  // tvArr[i]의 메서드를 호출, [i]번째 객체의 채널이 1증가
			System.out.printf("tvArr[%d].channel=%d%n",i,tvArr[i].channel);
		}
		
		//                      |-->[null, false, 11]
		//                      |     |--> [null, false, 12]
	 	//                      |     |       |--> [null, false, 13]
		//tvArr 0x800 -----> [0x801, 0x802, 0x803]
		
		
	} // main의 끝
}


