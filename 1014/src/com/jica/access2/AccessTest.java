package com.jica.access2;

//다른 패키지의 클래스를 사용하려면 import 구문을 사용해야 한다.
import com.jica.access.Tv;

public class AccessTest {

	public static void main(String[] args) {
		//객체 선언 및 생성, tv 객체명, Tv 참조
		Tv tv;
		tv = new Tv();
		
		//Tv 클래스 정보를 보고 Tv 클래스의 멤버변수를 동적영역에 확보
		//              color  power channel
		//tv 0x100----->[null, false, 0] 으로 메모리 확보됨
		
		//default 접근제어자를 가지는 클래스의 멤버(멤버변수나 메서드)는
		//다른 패키지에서 사용할 수 없다.
		//tv.color = "검정색";	 // default 접근제어자 --> 패키지가 다르므로 error
		
		
		//tv 메서드 다 public 으로 설정해 놨으므로 에러 안나
		
		
		//tv.power = true;	 	 // private 접근제어자 - -> error
		tv.power();				 // default 접근제어자 --> 패키지가 다르므로 error
		//tv.channel = 7;		 // private 접근제어자 - -> error
		tv.changeChannel(7);	 // default 접근제어자 --> 패키지가 다르므로 error
		//tv 0x100----->["검정색", true, 7] 으로 메모리 확보됨
		
		tv.channelUp(); //메서드 호출 시, 메서드 내부에서 멤버변수 접근
		tv.display();
		
	}

}
