package com.jica.polymorphism;

class CaptionTvTest {
	public static void main(String args[]) {
		
		Tv tv = new Tv();
		//            power   channel
		// tv 0x100---->[false, 0]
		System.out.println(tv.toString());
		
		CaptionTv ctv = new CaptionTv();
		//             CaptionTv      Tv 
		//             caption  power  channel
		//ctv 0x200---->[false, false, 0]
		System.out.println(ctv.toString());
		
        System.out.println("다형성과 관련 있는 코드--------------------");
        
        //상위형 참조변수를 선언하고 실제 객체는 하위형으로 생성하여 저장한다.
        Tv tv2 = new CaptionTv();
		//              CaptionTv      Tv 
		//              caption  power  channel
		//tv2 0x300---->[false, false, 6] 
        
        tv2.channel = 5;  //ok
        tv2.channelUp();  //ok
        
        //컴파일시 자료형을 검사하여 문맥을 해석하므로 에러가 발생한다.
        //tv2.caption = true;
        //tv2.displayCaption("안녕하세요");
        
        //이를 해결하는 방법은 
        //1) cast연산자를 이용하여 형변환을 시키는것 - 상위형을 하위형으로 형변환
        ((CaptionTv)tv2).caption = true;
        ((CaptionTv)tv2).displayCaption("형변환후 안녕하세요");
        
        //2) 일반멤버변수나 메서드는 사용하지 않지만 
        //   재정의된(overriding) 메서드는 자율롭게 사용할수 있도록 한다 
        //컴파일시에서는 tv2의 자료형이 Tv형이므로 Tv형에더 toString()메서드가 있으므로
        //에러를 발생시키지 않고 통과한다.  이후 실행 시점에서는 실제 tv2에 저장된 개체를 확인해보고
        //인스턴스는 CaptionTv형이므로 CaptionTv형의 toString()작동시킨다.
        System.out.println(tv2.toString());
        
        
        //하위형으로 선언하고 실제는 상위형 객체를 생성하여 저장하는 코드는 에러이다.
        //CaptionTv ctv2 = new Tv();  error
        
        //강제로 형변환을 시키면 저장할 수는 있지만 문제를 내포하고 있어서
        //실행시점에 실행에서가 발생한다.(그러므로 절대 사용하지 말자)
        CaptionTv ctv2 = (CaptionTv)new Tv();
        //정상적으로 실행된다고 가정하고 메모리를 그려보면
		//               power   channel
		// ctv2 0x500---->[false, 4]
        ctv2.channel = 5;
        ctv2.channelDown();
        
        //아래의 코드에서 심각한 에러가 발생한다. 즉, CaptionTv의 멤버변수
        //caption은 메모리에 존재하지 않는다
        ctv2.caption = true;
        ctv2.displayCaption("실행 안됩니다");
         
	}
}

class Tv {
	boolean power; 	// 전원상태(on/off)
	int channel;	// 채널

	void power()        {   power = !power; }
	void channelUp()    { 	 ++channel;     }
	void channelDown()  {	 --channel;	    }
	
	@Override
	public String toString() {
		return "Tv [power=" + power + ", channel=" + channel + "]";
	}	
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

	@Override
	public String toString() {
		return "CaptionTv [caption=" + caption + "]" + super.toString();
	}
	
	
}