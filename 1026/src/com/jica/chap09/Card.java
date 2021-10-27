package com.jica.chap09;

final class Card {
	String kind;
	int number;

	Card() {
		this("SPADE", 1);  // Card(String kind, int number)�� ȣ��
	}

	Card(String kind, int number) {
		this.kind = kind;
		this.number = number;
	}

	public static Card getInstance() {
		Card c = new Card();
		return c;
	}
	
	@Override
	public String toString() {
		return "kind : " + kind + ", number : " + number;
	}
}