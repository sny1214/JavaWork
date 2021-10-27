package com.jica.access;

public class AccessTest {

	public static void main(String[] args) {
		//객체 선언 및 생성, tv 객체명, Tv 참조
		Tv tv;
		tv = new Tv();
		
		//Tv 클래스 정보를 보고 Tv 클래스의 멤버변수를 동적영역에 확보
		//              color  power channel
		//tv 0x100----->[null, false, 0] 으로 메모리 확보됨
		
		//default 접근제어자를 가지는 클래스의 멤버(멤버변수나 메서드)는
		//같은 패키지에서는 자유롭게 사용할 수 있다.
		tv.color = "검정색";
		
		//tv.power = true;	//private이므로 직접 접근은 error
		tv.power();
		
		//tv.channel = 7;	//private이므로 직접 접근은 error
		tv.changeChannel(7);	//changeChannel default메서드 이므로 같은 패키지에서 사용 가능
		//tv 0x100----->["검정색", true, 7] 으로 메모리 확보됨
		
		tv.channelUp(); //메서드 호출 시, 메서드 내부에서 멤버변수 접근
		tv.display();
		
	}

}
