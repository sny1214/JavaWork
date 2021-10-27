package com.jica.store;

import java.util.Scanner;

class Item{	
  
	String name;
	int price;
	
//	for(int i = 0 ; i < name)
//	
	Item(){
	}
	
	Item(String name) {
		this.name = name;
	}
	
	Item(String name, int price) {
		this.name = name;	//제품명
		this.price = price;	//단가
	}
	
//	void inputItems(String name, int price) {
//		this.name = name;
//		this.price = price;
//		System.out.println("제품명 " + name + "의 가격 : " + price + "으로 입력되었습니다.");
//	}
	
	
	void display() {
		System.out.println("제품명 " + name + "의 가격 : " + price);
		System.out.println("-------------------------------------");
		
		
	}
}

class Manage extends Item{
	
	int total;	//총 갯수
	int number;	//팔린 갯수
	int store = total - number;	//남은 갯수
	
	int totalPrice;	//결제금액
	
	{
		totalPrice = 0;
	}
	
	Manage(String name, int total) {
		super(name);
		this.total = total;		
	}
	
	void indexItem(String name, int price, int total) {
		super.display();
		System.out.println("매장에 있는 갯수는 총 " + total + "개 입니다.");
	}
	
	void calItem(String name, int number) {
		totalPrice = super.price * number;
		System.out.println("총 결제금액은 " + totalPrice +"원 입니다.");
	}
	
	int storeItem(String name, int number) {
		display();
		store = this.total - number;
		System.out.println("매장 내에 남아있는 갯수는 총 " + store + "개 입니다.");
		return store;
	}


}

public class Store{
	public static void main(String[] args) {
		
		Item items[] = new Item[5];
		items[0] = new Item("새우깡", 2000);
		items[1] = new Item("감자깡", 1800);
		items[2] = new Item("꽃게랑", 1500);
		items[3] = new Item("고구마깡", 2200);
		items[4] = new Item("양파링", 1300);
		
		System.out.println(items);
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("입력하세요 => 1. 입력 2. 검색 3. 현황 4. 구매 5. 끝");		
		System.out.println("===============================================");		
		int keyword = scanner.nextInt();
		
		if(keyword == 5) {
			System.exit(0);
		}else if(keyword == 1) {
		}
		

		
	}
}




