package com.jica.override;

public class PointTest {

	public static void main(String[] args) {
		Point p = new Point();
		p.x = 10;
		p.y = 20;
		
		System.out.println(p.getLocation());
		System.out.println(p);

		
		Point3D p3 = new Point3D();
		p3.x = 100;
		p3.y = 200;
		p3.z = 300;
		
		//p3객체에는 상위클래스(Point)의 getLocation()과
		//		   하위클래스(Point3D)의 getLocation()과 2개의 메서드가 있다.
		
		//p3의 인자를 보고 하위클래스(Point3D)의 getLocation() 동작시킴
		
		System.out.println(p3.getLocation());
		System.out.println(p3);
		
		
		//Point point = new Point3D(); //참조형은 상위, 실제객체는 하위에 담음 --> 다형성
	}

}
