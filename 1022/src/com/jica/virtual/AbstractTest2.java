package com.jica.virtual;

public class AbstractTest2 {

	public static void main(String[] args) {
		//Object
		//  Unit            ---  추상클래스
		//    Marine        ---| 
		//    Tank             | 일반클래스
		//    Dropship      ---|
		
		//Unit은 추상클래스이므로 객체를 생성할수 없다.
		//Unit unit = new Unit();
		
		Marine marine = new Marine(100,80);
		System.out.println(marine);
		marine.move(250, 80);
		System.out.println(marine);
		System.out.println();
		
		//상위형 Unit으로 참조변수를 선언하고
		//하위형 Marine 객체를 생성하여 저장할수 있다.
		Unit unit = new Marine(200,100);
		System.out.println(unit);   //Unit의 toString() 혹은 Marine의 toString()
		unit.move(300, 200);
		System.out.println(unit);	
		System.out.println();
		
		Unit unit2 = new Tank(40, 90);
		((Tank)unit2).changeMode();
		unit2.move(40,350);
		System.out.println(unit2);
		System.out.println();
		
		DropShip dropShip = new DropShip(500,500);
		dropShip.load(marine);
		dropShip.load(unit2);
		dropShip.move(100, 100);
		System.out.println(dropShip);
	}

}
