package com.jica.composition;

public class Circle {
	//방법1
	//Point center = new Point(); //중심점
	
	//방법2
	Point center;
	int radius;                  //반지름
	
	{
		//개별생성자나 초기화블럭에서 반드시 포함관계의 멤버변수의 객체를 생성해야 한다.
		this.center = new Point();
	}
	
	public Circle() {
	}

	public Circle(Point center, int radius) {
		//this.center = center;   //얕은 복사	
		this.center.x = center.x; //인자로 전달된 객체의 값을 복사
		this.center.y = center.y;
		this.radius = radius;
	}
	
	public Circle(int x, int y, int radius) {
		this.center.x = x;
		this.center.y = y;
		this.radius = radius;
	}

	@Override
	public String toString() {
		return "Circle [center=" + center + ", radius=" + radius + "]";
	}
	
	
}
