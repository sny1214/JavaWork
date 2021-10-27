package com.jica.chap06;

class Car {
	String color;		// 색상
	String gearType;	// 기어종류 - auto(자동), manual(수동)
	int door;			// 문의갯수

	Car() {
		System.out.println("Car::Car() : " );
	}
	
	Car(String color, String gearType, int door) {
		System.out.println("Car::Car(String,String,int) : ");
		
		this.color = color;
		this.gearType = gearType;
		this.door = door;
	}
	
	public String toString() {
		return "["+color + "," + gearType + "," + door + "]";
	}
}

class CarTest {
	public static void main(String[] args) {
		Car c1 = new Car();
		//       color gearType door  
		//c1 0x100---->["white","auto", 4]
		
		c1.color = "white";
		c1.gearType = "auto";
		c1.door = 4;

		Car c2 = new Car("white", "auto", 4);
		//       color gearType door  
		//c2 0x200---->["white","auto", 4]
		
		System.out.println(c1);  //toString()메서드가 있으면 작동시켜 그 결과를 출력한다.
		System.out.println(c2);  //없으면 패지키명.클래스명@16진수문자열 형태로 출력한다.
		
		System.out.println("c1�� color=" + c1.color + ", gearType=" + c1.gearType+ ", door="+c1.door);
		System.out.println("c2�� color=" + c2.color + ", gearType=" + c2.gearType+ ", door="+c2.door);
	}
}
