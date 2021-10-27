package com.jica.chap07;

class Tv {
	boolean power; 	// 전원상태(on/off)
	int channel;	// 채널

	void power()        {   power = !power; }
	void channelUp()    { 	 ++channel;     }
	void channelDown()  {	 --channel;	    }
}

class CaptionTv extends Tv {
	boolean caption;		// 캡션상태(on/off)
	
	void displayCaption(String text) {
		if (caption) {	// 캡션상태가 on(true)이면 인자로 전달된 text를 출력한다.
			System.out.println(text);
		}
	}
	
	void method() {
		channel += 10;  //상위클래스의 멤버변수 및
		power();        //메서드를 하위클래스 메서드 내부에서 자유롭게 사용할 수 있다. 
	}
}

class CaptionTvTest {
	public static void main(String args[]) {
		CaptionTv ctv = new CaptionTv();
		//             CaptionTv      Tv 
		//               caption  power  channel
		//ctv  0x100---->[true, false, 11]
		
		ctv.channel = 10;				// 상위클래스의 멤버변수와
		ctv.channelUp();				// 메서드를 자유롭게 사용할 수 있다.

		System.out.println(ctv.channel); //11
		ctv.displayCaption("Hello, World");	//ctv객체의 caption값이 false이므로
		                                    //아무일도 하지 않는다.
		
		ctv.caption = true;				    
		ctv.displayCaption("Hello, World");	//ctv객체의 caption값이 true이므로
		                                    //"Hello, World" 를 출력한다.  
	}
}
