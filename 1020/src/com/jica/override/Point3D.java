package com.jica.override;



public class Point3D extends Point{		//Point 상속받음
	int z;

	//오버라이딩
	
	//오른쪽 클릭 - source - generate override~
	//부모클래스와 똑같은 형태의 메서드로 작성 후, 내부내용에 변화를 줌 = 재정의(부모 메서드 변경x)
	@Override
	public String getLocation(){
		//return "x : " + super.x + ", y : "+ super.y + ", z : " + this.z;
		//return "x : " + x + ", y : "+ y + ", z : " + z;
		//x,y는 현재 클래스에 없음, 부모 클래스에 있음 확인, super. 붙여도 돼
		//z는 부모클래스에 없는 자식 클래스 것이라면 this.붙여도 돼
		return super.getLocation() + ", z : " + z;	//this.z라 써도 ok
	}

	@Override
	public String toString() {
		return " Point3D [ " + super.toString() + ", z=" + z + "]";
	}
	
	
}
