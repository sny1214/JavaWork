package com.jica.object;

import java.util.Date;
import java.util.Objects;

public class ObjectTest {

	public static void main(String[] args) {
		// 객체.멤버
		// public 메서드인 equal(), getClass(), hashCode(), toString()를 사용할 수 있다.
		
		Item item = new Item("새우깡", 1000);
		Item item2 = new Item("콜라", 900);
		Item item3 = new Item("새우깡", 1000);
		Item item4 = item;
		Item item5 = new Item("새우깡", 3000);

		//item4 0x100 ---v
		//item  0x100 --->["새우깡",1000]
		//item2 0x200 --->["콜라",  900]
		//item3 0x300 --->["새우깡",1000]
		//item5 0x300 --->["새우깡",3000]
		//item6 null
		//today 0x700 --->[년월일시분초정보]
		
		//등가비교 연산자는 객체의참조값이 같은지 비교한다.
		System.out.println(item == item2);	//false
		System.out.println(item == item3);	//false
		System.out.println(item == item4);	//true
		System.out.println();
		
		//Object클래스의 equals()메서드는 내부적으로 참조값이 같은지 비교한다(즉, ==와 동일)
		Date today = new Date(); //오늘 날짜와 시간 정보
		System.out.println(item.equals(today));	//false, Item 객체와 Date 객체의 비교
		System.out.println(item.equals(item2));	//false
		System.out.println(item.equals(item3));	//true
		System.out.println(item.equals(item4));	//true
		System.out.println("------------------------------------------");
		
		System.out.println(item.equals(item));	//true

		System.out.println(item.equals(null));	//false
		//System.out.println(null.equals(item));	//실행도 전에 compile오류
		//Item item6 = null;
		//System.out.println(item6.equals(item));	//실행시 NullPointerException발생



	}

}

class Item  {
	String title;
	int price;
	
	public Item() {
		super();
	}

	public Item(String title, int price) {
		super();
		this.title = title;
		this.price = price;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)	//같은 객체끼리 비교하므로 무조건 같다 --> 무조건 true
			return true;
		
		if (obj == null)	//null과 비교하면 무조건 거짓
			return false;
		
		//item객체의 클래스정보(Item)와 today 객체의 클래스 정보(Date)
		//if (this.getClass() != obj.getClass())
		if (getClass() != obj.getClass())	//다른 클래스의 인스턴스와 비교하면 무조건 거짓
			return false;
		
		//Item객체끼리 상태값 즉, 멤버변수를 비교하여 결과를 리턴한다.
		Item other = (Item) obj;
		return price == other.price && Objects.equals(title, other.title);
	}

	void method() {
		//필요하다면 Object클래스의 public멤버와 protected멤버를 접근할 수 있다.
		//                               ------------ clone(), finalize()
	}
}
