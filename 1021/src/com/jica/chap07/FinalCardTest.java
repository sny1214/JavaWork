package com.jica.chap07;

abstract class A{
    //...
    void method1(){  //일반메서드
      //....
    }      
    
    abstract void method2();  //추상메서드
 }


class Card {
	final int NUMBER;		// final멤버변수 - 명시적으로 초기값 지정이 없으므로 반드시
	final String KIND;		// 생성자에서 초기값을 지정해야 한다.
	static int width  = 100;	
	static int height = 250;

	Card(String kind, int num) {	
		KIND = kind;    //생성자에 최초 값의 할당이 가능
		NUMBER = num;   //이후 모든 코드에서 값 변경은 불가능하다.
	}

	Card() {
		this("HEART", 1);
	}

	public String toString() {
		return KIND +" "+ NUMBER;
	}
}

class FinalCardTest {
	public static void main(String args[]) {
		Card c = new Card("HEART", 10);
//		c.NUMBER = 5;
		System.out.println(c.KIND);
		System.out.println(c.NUMBER);
		System.out.println(c); // System.out.println(c.toString());
	}
}
