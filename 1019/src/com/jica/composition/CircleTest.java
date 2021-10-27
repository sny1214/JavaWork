package com.jica.composition;

public class CircleTest {

	public static void main(String[] args) {
		Point p1 = new Point();
		p1.x = 100;
		p1.y = 150;
		System.out.println("p1 : " + p1);
		
		Point p2 = new Point(200, 300);
		System.out.println("p2 : " + p2);
		//              x   y
		//p1 0x100--->[100,150]
		//p2 0x200--->[200,300]		
	    // 	     
		System.out.println();
		
		
        //               |-->[200,300]    
		//         center| radius
		//c1 0x500--->[0x400, 0]
		Circle c1 = new Circle(p2, 100);
		p2.x = 120;
		
		Circle c2 = new Circle(50,80,20);
        //               |-->[50,80]    
		//         center| radius
		//c2 0x700 = [0x600, 20]
		
		System.out.println("c1 : " + c1);
		System.out.println("c2 : " + c2);
	}

}
