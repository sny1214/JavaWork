package com.jica.chap07;

class DeckTest {
	public static void main(String args[]) {
		Deck d = new Deck();	   // 카드 한벌 생성
		//                          'SPADE',1
		//          |------------>|-->[4,1]
		//          |             |     |-->[4,2]
		//          |             |     |     |-->[4,3]
		//          |             |     |     |              'CLOVER''K'
		//		    |             |     |     |            |-->[1,13]
		//c 0x300---|       |-->[0x300,0x200,0x300, .....,0x500]  
		//d 0x100--->[52   0x200]
		//    CARD_NUL  cardArr[]  
		//c 
		Card c = d.pick(0);	       // 첫번째 카드 뽑기
		System.out.println(c);     // toString() 동작한다.
		System.out.println();
		
		d.display();		
		System.out.println("-------------------");
		
		d.shuffle();			   // 카드를 섞는다.
		d.display();
		System.out.println();
		
		c = d.pick(0);		       // 섞은 카드중에서 첫번째 카드를 뽑는다.
		System.out.println(c);
	}
}

// Deck클래스 - 카드한벌(카드 52장)
class Deck {
	static final int CARD_NUM = 52;	          // 카드의 갯수
	
	//객체배열로 카드객체를 52개 관리
	Card cardArr[] = new Card[CARD_NUM];  // Card 객체 배열

	Deck () {	// 인자가 없는 생성자
		        // 52장의 카드를 만들어서 cardArr[]에 차례로 저장
		int i=0;

		for(int k=Card.KIND_MAX; k > 0; k--)     //k 4, 3, 2, 1, 0
			for(int n=0; n < Card.NUM_MAX ; n++) //n 0123456789012
				cardArr[i++] = new Card(k, n+1);
	}

	//메서드 오버로딩(overloading)
	Card pick(int index) {	// 지정된 순서번째 카드 뽑기
		return cardArr[index];
	}

	Card pick() {			// 임의의 순서번째 카드 뽑기
		int index = (int)(Math.random() * CARD_NUM);
		return pick(index);
	}

	void shuffle() { // 난수를 52번 발생시켜 순서번째와 교환한다.
		for(int i=0; i < cardArr.length; i++) {
			int r = (int)(Math.random() * CARD_NUM); //0~51

			//i번째 r번째 카드의 참조값을 교환한다.
			Card temp = cardArr[i];	
			cardArr[i] = cardArr[r];
			cardArr[r] = temp;
		}
	}
	
	void display() {
		for(int i=0; i<Deck.CARD_NUM; i++) {
			Card c = pick(i);
			System.out.println(c);		
		}
	}
} // DeckŬ������ ��

// Card클래스 - 카드 1장
class Card{
	//클래스변수이면서 final특성을 갖는다.
	static String[] kinds = {"", "CLOVER", "HEART", "DIAMOND", "SPADE"};
	static String numbers = "0123456789XJQK";
	
	static final int KIND_MAX = 4;	// 무늬종류 갯수
	static final int NUM_MAX  = 13;	// 카드숫자의 가장큰값(1~10,11(J),12(Q),13(K)

	static final int SPADE   = 4;   // 무늬
	static final int DIAMOND = 3;
	static final int HEART   = 2;
	static final int CLOVER  = 1;

	//인스턴스 변수
	int kind;
	int number;

	Card() {
		this(SPADE, 1);
	}

	Card(int kind, int number) {
		this.kind = kind;
		this.number = number;
	}

	@Override
	public String toString() {
		return "kind : " + kinds[this.kind] 
			+ ", number : " + numbers.charAt(this.number);
	} 
}
