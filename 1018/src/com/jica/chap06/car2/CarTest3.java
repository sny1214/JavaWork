package com.jica.chap06.car2;

class Car {
	String color;		// 색상
	String gearType;	// 기어종류 - auto(자동), manual(수동)
	int door;			// 문의갯수

	Car() {
		this("white", "auto", 4);
	}

	Car(Car c) {	// 생성자의 인자값이 동일한 클래스형일때
		            // 복사 생성자
		this.color    = c.color;
		this.gearType = c.gearType;
		this.door     = c.door;
	}

	Car(String color, String gearType, int door) {
		this.color    = color;
		this.gearType = gearType;
		this.door     = door;
	}
}
class CarTest3 {
	public static void main(String[] args) {
		int a = 10;
		int b = a;
		// a 10
		// b 10
		
		Car c1 = new Car("red","manual",4);
		//c1 0x100----->["red","manual",4]
		
		Car c2 = new Car(c1);	// c1의 참조값을 c2 생성자로 전달
		//결과적으로 c1의 상태값 동일한 상태값을 가지는 c2객체를 생성한다.
		//이러한 형태의 생성자를 복사생성자라고 한다.
		
		//c2 0x200----->[null,null,0]
		//
		//      |--> ["red","manual",100]
		//      |      ^
		//      |      |           ["red","manual",4]
		//      |      |           ^ ^ 
		//      |      |           | |--|
		//      |   c 0x100  this 0x200 |  <== 생성자끝나면 사라짐 
		//  c1 0x100       c2 0x200-----|
		
		System.out.println("c1의 color=" + c1.color + ", gearType=" + c1.gearType+ ", door="+c1.door);
		System.out.println("c2의 color=" + c2.color + ", gearType=" + c2.gearType+ ", door="+c2.door);

		c1.door=100;	
		System.out.println("c1.door=100; 수행후");
		System.out.println("c1의 color=" + c1.color + ", gearType=" + c1.gearType+ ", door="+c1.door);
		System.out.println("c2의 color=" + c2.color + ", gearType=" + c2.gearType+ ", door="+c2.door);
	}
}
