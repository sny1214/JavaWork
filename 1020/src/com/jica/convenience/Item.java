package com.jica.convenience;



//1건의 제품정보를 나타내는 클래스
//이것처럼 순수하게 데이터 자체를 표현하는 클래스를 '자바빈' 이라고 부르기도 한다.
public class Item {
	
	//item 정보 보호를 위해 private 접근 제어자 붙임 -> 다른 class에서 읽고 가져올 목적으로 getter(읽기), setter(값 변경) 만들어줘야 함.
	private String title;			//제품명
	private int price;				//단가
	private int quantity;			//판매된 수량
	
	

	//생성자 하나만 만들어도 되지만 편하게 쓰라고 여러형태 만들어놓음
	
	

	public Item() {				//인자없는 생성자 - 오른쪽 클릭 - source -generate~super~
		super();				//첫 실행문장으로 상위 클래스(Object)의 인자가 없는 생성자를 호출한다.
			
	}

	
	public Item(String title) {				//인자없는 생성자 - 오른쪽 클릭 - source -generate counstructor using fields(멤버변수)
		//super();							//없어도, 하위클래스의 생성자에서 첫 실행문장으로 상위클래스 생성자 호출 문장이 없으면(super()가 아니면)
		this.title = title;				    //자동으로 상위클래스(Object)의 인자가 없는 생성자가 호출된다. (compiler에 의해 자동으로 super() 적용된다)
											//굳이 super() 쓸 필요 없음
	}
	

	public Item(String title, int price) {
		//상위에서는 this()로 시작하는 생성자 호출해야함
		//하위에서는 this() or super() -> 생성자 호출해야한다. super() 없어도 자동으로 인자없는 생성자 호출함 (super())
		this.title = title;
		this.price = price;
	}
	

	public Item(Item item) { 		//복사 생성자 - 클래스와 동일한 생성자, 이땐 멤버변수 다 써야 함
		this.title = item.title;
		this.price = item.price;
		this.quantity = item.quantity;
	}



	//getter, setter 메서드

	//setter(외부에서 바꿀 수 있음 -> 대신 멤버변수 private으로 접근 제어자), getter(읽음) 생성
	//이땐, title, price는 가져오고 quantity는 getter만 가능하게, 왜냐믄 setter까지하면 양 바뀌므로 -> 계산이라는 메서드에 의해 양이 누적으로 바뀌도록 나중에 설정할 것이므로
	//오른쪽 클릭 - source - generate setter, getter -> 각 필드에서 setter, getter 중 선택 가능함
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	
	
	public int getQuantity() {
		return quantity;
	}

	
	
	//서비스 메서드
	
	
	int sale(int count) {			//기왕이면 리턴값 있는 메서드 만들어주는 게 좋다.
		if (count <= 0 ) {			//수량이 0이거나 음수
			return 0;				//아무것도 안함 -> 세일 메서드 당장 중단하고 돌아가라
									//판매수량이 잘못됏음을 알려주는 신호로 쓸 수 있다.
		}
		//판매 수량 0이 아니면 누적한다.
		quantity += count;			
		
		return count;				//정상적으로 판매됐음을 알려주는 신호. 0이 아닌 숫자가 리턴 된다.
	}
	
	
	
	
	
	
	//현재 객체의 상태를 대표하는 문자열을 리턴하는 메서드 -Object클래스의 toString
	//오른쪽 클릭-source-generate toString;
	
	@Override							//클래스를 컴파일하거나 사용할 때, 컴파일러나 실행기에게 참조할 수 있는 정보를 제공하는 (@뒤의) 별도의 표현
										//상위클래스(Object)의 메서드를 하위에서 그대로 재정의했다. 상위에도 똑같은 메서드 있다는 정보를 제공, 강조할 목적의 표현
										//다른 클래스에서 그냥 클래스명(item) 불러오면, 참조값이 출력되므로
										//toString 메서드에 의해 참조값에 해당하는 내용값을 출력할 수 있게 도와주는 메서드, Object클래스에 존재하는 메서드임
	
	public String toString() {			
		return "[title=" + title + ", price=" + price + ", quantity=" + quantity + "]\n";		//표현하고 싶은 필드 선택 가능, 만들고 일부 표현 지워도 돼
	}
	
	
	
}
