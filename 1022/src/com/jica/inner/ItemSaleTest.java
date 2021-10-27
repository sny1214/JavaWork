package com.jica.inner;

public class ItemSaleTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class ItemSale{
	//멤버변수
	Item curItem = new Item("새우깡", 500);
	
	
	class Item{  // 인스턴스 내부 클래스
		String title;
		int price;
		int quantity;
		
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
			return "Item [title=" + title + ", price=" + price + ", quantity=" + quantity + "]";
		}

	}
	
	
}