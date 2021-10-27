package com.jica.chap07.point;

class PointTest2 {
	public static void main(String argsp[]) {
		//Point3D p3 = new Point3D();
		Point3D p3 = new Point3D(100,200,300); //실행시 (1)->(2)->(3)->(4) 순
		//				Point3D::z  Point3D::x,y
		//p3 	? --->   [0,            0,0] //(0)this.x,y,z
		//p3 0x100--->   [30,          10,20]
		
		System.out.println("p3.x=" + p3.x);
		System.out.println("p3.y=" + p3.y);
		System.out.println("p3.z=" + p3.z);
	}
}

class Point {
	int x=10;	//(1)
	int y=20;	//(1)

	//클래스를 만들 때 인자 없는 기본 생성자 만들도록 권장
	//하위클래스에서 상위클래스 인자 필요할 때 super()안써도 에러뜨지 않도록
	Point(){
		System.out.println("Point::Point()");	//(2)
	}
	
	
	Point(int x, int y) {
		System.out.println("Point::Point(int,int)"); //(3)
		this.x = x; //(3) x값인 100이 this 로 들어가
		this.y = y; //(3) y값인 200이 this 로 들어가
	}
}

class Point3D extends Point {
	int z=30;	//(4)

	Point3D() {
		//자동으로 상위클래스의 인자가 없는 생성자 동작
		//super();    
		System.out.println("Point3D::Point3D()");
	}
	
//	
//	Point3D() {
//		this(100, 200, 300);	// Point3D(int x, int y, int z)�� ȣ���Ѵ�.
//	}

	Point3D(int x, int y, int z) {
		super(x,y);	//상위클래스의 인자가 2개인 생성자를 명시적 호출
		//(1)->(2)->(3)
		
		System.out.println("Point3D::Point3D(int,int,int)");
		
		this.z = z;	//(4) z값인 300이 this 로 들어가
	}
}
