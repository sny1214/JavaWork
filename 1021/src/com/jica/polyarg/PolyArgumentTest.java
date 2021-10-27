package com.jica.polyarg;

//제품정보 클래스
class Product {
	int price;			// 단가
	int bonusPoint;		// 적립금

	Product(int price) {
		this.price = price;
		bonusPoint =(int)(price/10.0);	// 단가의 10%를 적립금으로 책정
	}
	
	@Override
	public String toString() {	// Object클래스의 toString() 재정의
		return "Product";
	}
}

//Product
//  Tv
//  Computer

//Tv제품
class Tv extends Product {
	Tv() {
		//상위클래스의 생성자 호출==>Product(int)
		super(100);
	}

	@Override
	public String toString() {	// Product클래스의 toString() 재정의
		return "Tv";
	}
}

//Computer제품
class Computer extends Product {
	Computer() {
		super(200);
	}

	@Override
	public String toString() {// Product클래스의 toString() 재정의
		return "Computer";
	}
}

class Buyer {			// 고객
	int money = 1000;	// 보유한 금액
	int bonusPoint = 0;	// 구매 물품에 따라 누적되는 적립금

	
	//buy()메서드의 매개변수가 상위형인 Product이다.
	//메서드를 호출할때는 하위형인 Tv형객체나 Computer객체를 인자로 전달한다.
	void buy(Product p) {
		
		//멤머변수는 자료형(Product)를 기준으로 멤버변수를 결정하고
		if(money < p.price) {
			System.out.println("잔액이 부족하여 구매할 수 없습니다.");
			return;
		}

		money -= p.price;			// 물건을 구매했으므로 보유금액이 물건금액만큼 감소한다.
		bonusPoint += p.bonusPoint;	// 구매물건의 적립금이 누적된다.
		System.out.println(p + "을/를 구매했습니다.");
		//               ----- toString()메서드가 동작할때
		// 실제 인스턴스가 Tv형이냐 Compter형이냐에 따라서 동작하는 toString()결정된다.
	}
}

class PolyArgumentTest {
	public static void main(String args[]) {
		Buyer b = new Buyer();
        //                money   bonusPoint
		//b   0x100--------->[200, 80]
		
		//              Tv:: Product::price,bonusPoint
		//tv  0x200--------->[   100,         10   ] 
		//         Computer:: Product::price,bonusPoint
		//com 0x300--------->[   200,         20   ] 
		
		
		Tv tv = new Tv();
		Computer com = new Computer();
		
		b.buy(tv);		
		b.buy(com);
		b.buy(com);
		b.buy(com);
		b.buy(tv);
		
		System.out.println("현재 남은 돈은 " + b.money + " 만원 입니다.");
		System.out.println("현재 보너스 점수는 " + b.bonusPoint + " 만원입니다.");
		
	}
}
