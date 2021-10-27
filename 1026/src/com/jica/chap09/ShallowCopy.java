package com.jica.chap09;

import java.util.*;

class Circle implements Cloneable {
	Point p;  // 참조변수 - Point객체
	double r; // 중심점

	Circle(Point p, double r) {
		this.p = p;
		this.r = r;
	}

	public Circle shallowCopy() { // 얕은 복사
		Object obj = null;

		try {
			obj = super.clone();
		} catch (CloneNotSupportedException e) {}

		return (Circle)obj;
	}

	public Circle deepCopy() { // 깊은복사
		Object obj = null;

		try {
			obj = super.clone();
		} catch (CloneNotSupportedException e) {}

		Circle c = (Circle)obj; 
		c.p = new Point(this.p.x, this.p.y); 

		return c;
	}

	public String toString() {
		return "[p=" + p + ", r="+ r +"]";
	}
}


class ShallowCopy {
	public static void main(String[] args) {
		Circle c1 = new Circle(new Point(1, 1), 2.0);			
		Circle c2 = c1.shallowCopy();
		Circle c3 = c1.deepCopy();
		//                       x y
		//              |------>[1,1]
		//c1 0x100--->[0x200, 2.0]
		//c2 0x300--->[0x200, 2.0] 
		//              |------>[1,1]
		//c3 0x500--->[0x600, 2.0]
	
		System.out.println("c1="+c1);
		System.out.println("c2="+c2);
		System.out.println("c3="+c3);
		c1.p.x = 9;
		c1.p.y = 9;
		System.out.println("= c1�� ���� �� =");
		System.out.println("c1="+c1);
		System.out.println("c2="+c2);
		System.out.println("c3="+c3);
	}
}
