package com.jica.chap06;

class CardTest{
	public static void main(String args[]) {
		//객체 생성전에 클래스 멤버를 사용할 수 있다.
		System.out.println("Card.width = "  + Card.width);
		System.out.println("Card.height = " + Card.height);
		System.out.println("------------------------------------------");

		//1장의 Card 객체 생성
		Card c1 = new Card();
		//	            kind number		Card.height = 250
		//c1 0x100----->[null,0]		Card.width = 100
		//스택영역		동적영역			정적영역
		c1.kind = "Heart";
		c1.number = 7;
		//			   ["Heart",7]
		
		Card c2 = new Card();
		//	            kind number		Card.height = 250
		//c2 0x200----->[null,0]		Card.width = 100
		//스택영역		동적영역			정적영역
		c2.kind = "Spade";
		c2.number = 4;
		//			   ["Spade",4]

		//System.out.println(c1.kind + ", " + c1.number + ", 크기 (" + c1.width + ", " + c1.height + ")" );
		//System.out.println(c2.kind + ", " + c2.number + ", 크기 (" + c2.width + ", " + c2.height + ")" );		
		
		//개별 객체가 아닌 클래스 명을 쓴다.
		System.out.println(c1.kind + ", " + c1.number + ", 크기 (" + Card.width + ", " + Card.height + ")" );
		System.out.println(c2.kind + ", " + c2.number + ", 크기 (" + Card.width + ", " + Card.height + ")" );		

		System.out.println("c1의 width과 height값을 50, 80으로 변경합니다.");
		//c1.width = 50;
		//c1.height = 80;
		//여러 객체에 공유되는 클래스 변수들을 변경
		
		Card.width = 50;
		Card.height = 80;
		//권장하는 표현
		
//		System.out.println(c1.kind + ", " + c1.number + ", 크기 (" + c1.width + ", " + c1.height + ")" );
//		System.out.println(c2.kind + ", " + c2.number + ", 크기 (" + c2.width + ", " + c2.height + ")" );
		//폭과 높이 모든 객체에서 값이 변경되어 있다, 클래스 (static)변수 --> 공용 메모리
		
		//개별 객체가 아닌 클래스 명을 쓴다.
		System.out.println(c1.kind + ", " + c1.number + ", 크기 (" + Card.width + ", " + Card.height + ")" );
		System.out.println(c2.kind + ", " + c2.number + ", 크기 (" + Card.width + ", " + Card.height + ")" );		
	}
 }

class Card {		
	//인스턴스 (일반 멤버)변수
	String kind ;				// 무늬 : "Spade", "Heart", "Diamond", "Clover"
	int number;				    // 숫자 : 1 ~ 10, 11(J),12(Q), 13(K)
	
	//클래스 (static)변수 --> 공용 메모리
	static int width = 100;		// 카드의 폭	 --| 52장의 카드가 카드 한 벌이 된다
	static int height = 250;	// 카드의 높이  --| 모든 카드의 폭과 높이는 동일하므로 공동으로 사용한다.
	
	//생성자와 메서드가 없는, 멤버변수만 있는 클래스
	Card(){
		
	}
	
	Card(String kind, int number) {
		this.kind = kind;
		this.number = number;
	}
	
	//Java의 모든 클래스는 자동으로 Object클래스를 상속받는다.
	//Object클래스에 toString()이라는 메서드가 있다.
	//상위클래스의 메서드와 동일한 메서드를 하위클래스에서 만들때에는
	//상위클래스의 메서드 형태를 그대로 따라야 한다.
	//String toString()의 상위 접근 제어자가 public .. public 안붙이면 오류생겨
	public String toString() {
		String result = kind + ", " + number + ", 크기 (" + width + ", " + height + ")" ;
		//내부적으로의 정확한 의미
		//              this.kind + ", " + this.number + ", 크기 (" + Card.width + ", " + Card.height + ")" ;
		//width, height는 static 변수이므로 this아닌 Card가 붙는다.
		return result;
	}

}
