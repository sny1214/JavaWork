package com.jica.object;

//1건의 제품정보를 나타내는 클래스
class Item implements Cloneable  {
	String maker;
	int arr[];
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
	public int hashCode() {//제품명과 단가 같으면 같은 해시코드값을 갖도록 재정의
		
		return title.hashCode() + price;
		//return Objects.hash(price, title);
	}
	
	@Override
	public boolean equals(Object obj) {		
		if (this == obj)   //같은 객체끼리 비교하므로 무조건 같다.
			return true;
		
		if (obj == null)   //null과 비교하면 무조건 거짓
			return false;
		
		//item객체의 클래스정보(Item)와 today객체의 클래스정보(Date)
		if (getClass() != obj.getClass()) //다른 클래스의 인스턴스와 비교하면 무조건 거짓
			return false;
		
		
		//Item객체끼리 상태값 즉, 멤버변수를 비교하여 결과를 리턴한다.
		Item other = (Item) obj;
		return title.equals(other.title) && price == other.price;
	}

	//Object클래스의 toString()메서드 기능
	//getClass().getName() + '@' + Integer.toHexString(hashCode());
	@Override
	public String toString() {
		return "Item [title=" + title + ", price=" + price + "]";
	}
	

	@Override
	protected Object clone() throws CloneNotSupportedException {
		//현재의 item객체를 복제한 객체를 만들어서 리턴해야 한다.
		//복제할때는 Object클래스의 clone()메서드를 사용하면 된다.
		
		//주의)아래의 코드처럼 super.clone()을 이용하여 복제하면 얖은복사가 이루어진다.
		//    깊은복사가 필요하다면 직접 코딩으로 완성해야 한다.
		return super.clone();
	}

	//객체가 메모리에서 완전히 소멸될때 자동으로 호출되어 마무리동작을 수행하는 메서드 이다.
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		System.out.println(this + " 인스턴스가 메모리에서 완전히 소멸됩니다.");
	}

	void method() {
		//필요하다면 Object클래스의 public멤버와 protected멤버를 접근할 수 있다.
		//                               ------------ clone(), finalize()
	}
}