package com.jica.polymorphism;

class InstanceofTest {
	public static void main(String args[]) {
		//Objcet
		//  Car
		//    FireEngine
		//    Ambulance
		
		
		FireEngine fe = new FireEngine();

		if(fe instanceof FireEngine) {
			System.out.println("This is a FireEngine instance.");
		} 

		if(fe instanceof Car) {
			System.out.println("This is a Car instance.");
		} 

		if(fe instanceof Object) {
			System.out.println("This is an Object instance.");
		} 

		//실행시점에 특정 객체를 생성한 클래스의 정보를 얻고 싶다면 getClass()를 사용한다.
		//getClass()는 Object클래스의 메서드이다.
		//getClass()는 Class형 객체를 리턴한다 <-- 클래스정보객체
		
		Class clsInfo = fe.getClass();
		String cName = clsInfo.getName();
		System.out.println("fe객체를 생성한 클래스명은 " + cName + " 입니다.");
		
		System.out.print("fe객체를 생성한 클래스명은 ");
		System.out.println(fe.getClass().getName() + " 입니다.");
		
		//실행시점에 객체의 클래스정보를 얻어서 작동하는 프로그램 기법있다.
		//java 계열에서는 리플렉션(refrection)이라고 하고
		//c언어 계열에서는 RTTI(runtime type information)이라고 한다.
	}
} 
