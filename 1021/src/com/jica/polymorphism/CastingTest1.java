package com.jica.polymorphism;

class CastingTest1 {
	public static void main(String args[]) {
		Car car = null;
		
		//car 0x100 --|
		//            v  FireEngine:: Car::color,door
		//fe  0x100 --------------->[ ,null,0]  
		//fe2 0x100 --^ 
		FireEngine fe = new FireEngine();
		FireEngine fe2 = null;

		fe.water();       // ok
		car = fe;         // car = (Car)fe; 명시적인 형변환
		//Car   FireEngine
		//상위형  하위형
				
 		//car.water();    //컴파일 에러
 		//컴파일시 car는 Car형으로 선언되어 있으므로 water()메서드는 Car클래스의 멤버가 아니므로 
 		//오류가 발생한다.
 		
		//상위형을 하위형으로 형변환할때 반드시 명시적으로  cast연산자를 사용해야 한다.
		((FireEngine)car).water();  //정상적으로 실행
		
		//상위형을 하위형으로 형변환할때 반드시 명시적으로  cast연산자를 사용해야 한다.
		fe2 = (FireEngine)car; 
		fe2.water();
	}
}

class Car {
	String color;
	int door;

	void drive() { 		// 운전하는 기능
		System.out.println("drive, Brrrr~");
	}

	void stop() {		// 멈추는 기능	
		System.out.println("stop!!!");	
	}
}

class FireEngine extends Car {	// 소방차
	void water() {		// 물뿌리는 기능
		System.out.println("water!!!");
	}
}

class Ambulance extends Car{ //앰블런스
	void siren() {
		System.out.println("siren~~~");
	}
}