package com.jica.inter;

public class ItemTest {

	public static void main(String[] args) {
		Item item = new Item("새우깡", 800);
		Item item2 = new Item("콜라", 1000);
		
		//item객체와 item2객체를 비교하여 어느 객체가 큰가를 판별하고 싶다.
		//제목이 큰것 큰객체라고 판단기준을 세웠다면
		
		if( item.compareTo(item2) > 0) {
			System.out.println("item객체가 크다.");
		}else {
			System.out.println("item2객체가 크다.");
		}
	}

}

class Item implements Comparable{
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
	public String toString() {
		return "Item [title=" + title + ", price=" + price + "]";
	}

	@Override
	public int compareTo(Object o) {
		Item i = (Item)o;
		
		return this.title.compareTo(i.title);
	}

}