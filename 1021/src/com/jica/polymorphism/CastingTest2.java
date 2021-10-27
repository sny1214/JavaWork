package com.jica.polymorphism;

class CastingTest2 {
	public static void main(String args[]) {
		Car car = new Car();
		Car car2 = null;
		FireEngine fe = null;
        //                               Car::color,door 
	    //Car        상위형 car  0x100-------->[ null,  0]
		//                car2 0x100    ^ 
		//                              |     
		//FireEngine 하위형 fe   0x100----|
						
		car.drive();    // ok
		
		fe = (FireEngine)car; // 하위형에  상위형을 저장할때는 반드시 형변환시켜야 한다.
		
		fe.drive();   // 컴파일 ok 
		fe.water();   // 컴파일 ok   실행시에는 실제 fe가 Car객체만 가리키므로
		              //           watrer()기능을 작동시킬수 없다.
		
		car2 = fe;    // ok 상위형에 하위형 객체 저장 
		car2.drive(); // ok
		//car2.water(); // 컴파일 error
		((FireEngine)car2).water(); // 컴파일은 ok, 실행시 오류발생
	}
}
