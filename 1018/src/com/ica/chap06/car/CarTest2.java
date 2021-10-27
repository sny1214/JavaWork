package com.ica.chap06.car;

class Car {
	String color;		// 색상
	String gearType;	// 기어종류 - auto(자동), manual(수동)
	int door;			// 문의갯수

	Car() {
		this("white", "auto", 4);
		//다른 생성자 호출 ==> Car(String,String,int)
		System.out.println("Car::Car()");
	}

	Car(String color) {
		this(color, "auto", 4);
		//다른 생성자 호출 ==> Car(String,String,int)
		System.out.println("Car::Car(String)");
	}
	
	Car(String color, String gearType, int door) {
		System.out.println("Car::Car(String,String,int)");
		this.color    = color;
		this.gearType = gearType;
		this.door     = door;
	}
}

class CarTest2 {
	public static void main(String[] args) {
		Car c1 = new Car();	
		//c1 0x100---->["white","auto", 4]
		
		Car c2 = new Car("blue");
		//c2 0x200---->["blue","auto",4]
		System.out.println("c1의 color=" + c1.color + ", gearType=" + c1.gearType+ ", door="+c1.door);
		System.out.println("c2의 color=" + c2.color + ", gearType=" + c2.gearType+ ", door="+c2.door);
	}
}
