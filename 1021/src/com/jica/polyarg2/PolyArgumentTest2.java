package com.jica.polyarg2;

class Product {
	int price;			// 제품단가
	int bonusPoint;		// 적립금

	Product(int price) {
		this.price = price;
		bonusPoint =(int)(price/10.0);
	}

	Product() {} // 기본생성자
}
 
class Tv extends Product {
	Tv() {
		super(100);	
	}

	@Override
	public String toString() { return "Tv"; }
}

class Computer extends Product {
	Computer() { super(200); }
	
	@Override
	public String toString() { return "Computer"; }
}

class Audio extends Product {
	Audio() { super(50); }

	@Override
	public String toString() { return "Audio"; }
}
//상속계층구조
//Object
//  Product
//    Tv
//    Computer
//    Audio

class Buyer {			// 고객, 물건을 사는 사람
	int money = 1000;	// 소유금액
	int bonusPoint = 0;	// 보너스 점수
	
	Product[] item = new Product[10];	//구입한 제품정보를 저장하는 객체배열
	int i = 0;			// 구입한 물건의 순번

	//물건을 구매하다.
	void buy(Product p) {               

		if(money < p.price) {
			System.out.println("잔액이 부족하여 물건을 살수 없습니다.");
			return;
		}

		money -= p.price;	        // 물건값 지불(보유금액 - 물건값)
		bonusPoint += p.bonusPoint;	// 보너스 점수 획득
		item[i++] = p;		        // 배열요소에 구매물건정보를 저장
		System.out.println(p + "을/를 구입하였습니다.");
	}
	
	void returnItem(String name) {		//제품 반품처리

		/*item[]배열의 첫요소부터 차례로 name과 동일한 객체를 찾는다.
		 0번째 제품의 제품명 알아내기 ==> item[0].toString() 이용하여 제품명을 알아낸다.
		 찾아서 배열요소에서 삭제하기전에 가격을 알아온다.
		 
		[0x100,0x300,0x500,null,null,null,null,null,null,null]
		   Tv   Audio Com 
		최종적으로 보유금액을 증가시키고 가격을 리턴하고 i를 1감소시킨다.
		*/
		
		
		int rMoney = 0;					//환불될 가격
		int rPoint = 0;
		for(int i=0 ; i<10 ; i++) {
			if(item[i] != null) {
				if (item[i].toString().equals(name)) {		//환불할 이름이 같으면
					System.out.println("환불할 제품은 " + item[i].toString() +" 입니다");	//환불할 제품 이름 출력
	
					rMoney += item[i].price;
					rPoint += item[i].bonusPoint;
					item[i] = null;
				}
			}
		}
		System.out.println("환불될 총 가격 : " + rMoney +" 원, 환불될 보너스 포인트 : "+ rPoint +" 점"); //환불 가격, 포인트 출력
		money += rMoney;
		bonusPoint += rPoint;
		
	}

	
	
	//정산하다 
	void summary() {		    // 구매한 물품정보를 요약해서 보여준다.
		int sum = 0;		 	// 구매한 물품의 가격총합
		String itemList =""; 	// 구매내역

		// 구매물품의 총가격과 제품명을 요약한다.
		// sum      350
		// itemList "Tv,Computer,Audio,"
		for(int i=0; i<item.length;i++) {
			if(item[i]==null) break;
			sum += item[i].price;
			itemList += item[i] + ", ";
		}
		System.out.println("구매하신 물품의 총금액은 " + sum + " 입니다.");
		System.out.println("구매하신 제품은 " + itemList + " 입니다.");
	}
}

class PolyArgumentTest2 {
	public static void main(String args[]) {

		Buyer b = new Buyer();
		//                                         price bp  
		//                                     |-->[100,10] 
		//                                     |    |-->[200, 20]
		//                                     |    |    |-->[50, 5]
		//                                     |    |    |
		//                               |-->[0x10,0x20,0x30,null,....null]
        //             money  bonusPoint | item[] i
		//b   0x100--------->[650, 35, 0x200,     3]
		
		b.buy(new Tv());		
		b.buy(new Computer());
		b.buy(new Audio());
		b.buy(new Audio());
		b.buy(new Computer());
		
		b.summary();
		
		b.returnItem("Audio");
		b.returnItem("Computer");
		
		b.summary();
	}
}
