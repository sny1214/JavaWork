package com.jica.chap07;

class DrawShape {
	public static void main(String[] args) {
		int arr[] = { 10, 20 , 30 };
		//arr 0x100--->[10,20,30]
		
		Point[] p = {   new Point(100, 100),
                        new Point(140,  50),
                        new Point(200, 100)
				};
		
		//Point p[] = new Point[3];
		//p[0] = new Point(100,100);
		//p[1] = new Point(140, 50);
		//p[2] = new Point(200,100);
		
		
		//              |-->[100,100]
		//              |       |-->[140, 50]
		//              |       |     |-->[200,100]
		//              |       |     |
		//p 0x100---->[0x200, 0x300, 0x400]
		//            ^-- 
		//              |
		//t 0x500---->[0x100,"black"]
		//             p[]    color 
		Triangle t = new Triangle(p);
		t.draw();
		//t.p[1].x, t.p[1].y, t.p[1].getXY()  ok
		
		//               |--> [150,150] 
		//		   center|    r   color		
		//c 0x700----> [0x600, 50,"black"]         
		Circle   c = new Circle(new Point(150, 150), 50);
        c.draw();         
	}
}

//현재의 예제에서는 상속과 포함관계를 한꺼번에 사용하고 있다.
//        도형(Shape)            --|상속  
//  원(Circle)  삼각형(Triangle)  --|
//     |          | 포함
//     | 1        |3
//   점(Point)  점(Point)

class Shape {
	String color = "black";
	
	void draw() {
		System.out.printf("[color=%s]%n", color);
	}
}

class Point {
	int x;
	int y;

	Point() {
		this(0,0);
	}
	
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	String getXY() {  
		return "("+x+","+y+")"; // x�� y�� ���� ���ڿ��� ��ȯ
	}
}

//원(Circle)클래스는 모양(Shape)클래스를 상속받고
//점(Point) 클래스를 멤버변수로 가진다.(포함)
class Circle extends Shape {
	Point center;	// 원의 원점좌표(중심점)
	int r;			// ������

	Circle() {		
		this(new Point(0, 0), 100); // Circle(Point center, int r)�� ȣ��
	}

	Circle(Point center, int r) {
		this.center = new Point(center.x, center.y);
		this.r = r;
	}

	@Override
	void draw() { // 상위클래스의 메서드를 하위클래스에서 그대로 재정의 하는것을
		          // 오버라이딩(overring)이라고 한다 <-- 중요한 문법
		System.out.printf("[center=(%d, %d), r=%d, color=%s]%n", center.x, center.y, r, super.color);
	}
}

//삼각형(Triangle)클래스는 모양(Shape)클래스를 상속받고
//점(Point)클래스를 3개 멤버변수로 가지고 있다(포함)
class Triangle extends Shape {
	//현재의 코딩은 Point배열을 확보했을뿐이고
	//Point객체가 3개 만들어진것은 아니다.
	Point[] p = new Point[3];

	//
	Triangle(Point[] p) {
		this.p = p;
		//for(int i=0; i<p.length; i++) {
		//	this.p[i] = p[i];
		//}
	}

	@Override
	void draw() { 
		System.out.printf("[p1=%s, p2=%s, p3=%s, color=%s]%n", p[0].getXY(), p[1].getXY(), p[2].getXY(), super.color);
	}
}
