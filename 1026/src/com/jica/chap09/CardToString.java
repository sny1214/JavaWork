package com.jica.chap09;

/*
class Card {
	String kind;
	int number;

	Card() {
		this("SPADE", 1);
	}

	Card(String kind, int number) {
		this.kind = kind;
		this.number = number;
	}
}
*/

class CardToString {
	public static void main(String[] args) {
		Card c1 = new Card();
		Card c2 = new Card();
		//               kind   number  
		//c1 0x100---->["SPADE",1]
		//c2 0x200---->["SPADE",1]
		
		System.out.println(c1.toString()); //Object클래스의 toString()동작
		System.out.println(c2.toString());
	}
}
