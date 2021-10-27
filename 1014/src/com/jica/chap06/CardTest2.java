package com.jica.chap06;

public class CardTest2 {

	public static void main(String[] args) {
		//객체 생성전에 클래스 멤버를 사용할 수 있다.
		System.out.println("Card.width = "  + Card.width);
		System.out.println("Card.height = " + Card.height);
		System.out.println("------------------------------------------");

		//1장의 Card 객체 생성
		Card c1 = new Card("Heart",7);
		Card c2 = new Card("Spade",4);
		Card c3 = new Card("Diamond", 9);
		
		//	            kind number		
		//c1 0x100----->["Heart",7]		Card.width = 100
		//c2 0x200----->["Spade",4]		Card.height = 250
		//c3 0x300----->["Diamond",9]	
		//스택영역		동적영역			정적영역
	
		System.out.println(c1.toString());
		System.out.println(c2.toString());
		System.out.println(c3.toString());
		
		System.out.println();
		System.out.println("c1의 width과 height값을 50, 80으로 변경합니다.");

		//권장하는 표현
		Card.width = 50;
		Card.height = 80;

		System.out.println(c1);			
		System.out.println(c2);
		System.out.println(c3);
		//Card클래스에 toString메서드 인위적으로 만들어 놓지않더라도 내부에서 toString메서드가 있으면 자동으로 작동시킨다.
		//toString메서드 현재 상태를 대표할수있는 문자열로 만들어 줄수 있는 기능
		//System.out.println(c1.toString());
		//System.out.println(c2.toString());
		//System.out.println(c3.toString());

	}

}
