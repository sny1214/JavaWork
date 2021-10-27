package com.jica.chap07;

class PointTest {
	public static void main(String args[]) {
		Point3D p3 = new Point3D(1,2,3);
	
		//              Point3D::z Point::x,y 
		//p3 ? --------> [3         1,2]
	
	}
}

class Point {
	int x;	
	int y;

	//인자가 없는 디폴트 생성자는 작동할 수 없다.
	//인자가 있는 생성자 있으므로...

	Point(int x, int y) {
		//실제로는 여기에도 super(); 존재 <-- Object의 생성자
		super();
		
		this.x = x;
		this.y = y;
	}

	String getLocation() {
		return "x :" + x + ", y :"+ y;
	}
}

class Point3D extends Point {
	int z;

	//인자가 없는 디폴트 생성자는 작동할 수 없다.
	
	Point3D(int x, int y, int z) {
		//첫 실행문이 상위클래스의 생성자를 호출하는 문장이여야 하는데 없음
		//자동으로 super();를 적용하여 부모클래스 인자가 없는 생성자를 호출함
		
		//super();          //-----> error
		//근데 이때 부모(상위)클래스의 인자가 없는 디폴드 생성자 없으므로 오류..
		
		//그러므로 상위클래스의 다른 생성자를 호출하도록 한다.
		super(x,y); 
		
		//super(x,y)로 인해 밑의 super.x = x; super.y = y; 작성할 필요 없음
		
		//super.x = x;	//this.x보다 super.x가 더 타당
		//super.y = y;	//this.y보다 super.y가 더 타당
		this.z = z;
		// super(x,y); 무조건 첫번째 실행문장이여야 함 
	}

	String getLocation() {	// 오버라이딩
		return "x :" + x + ", y :"+ y + ", z :" + z;
	}	
}
