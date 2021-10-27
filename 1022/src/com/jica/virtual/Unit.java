package com.jica.virtual;

//테란종족의 움직이는 유닛을 표현하는 클래스
public abstract class Unit { //추상클래스
	int x,y;
	
	public Unit() {
	}

	
	public Unit(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	abstract void move(int tx, int ty); //추상 메서드
	
	void stop() {
		System.out.println("현재위치(" + x +","+y+")위치에 정지합니다.");
	}


	@Override
	public String toString() {
		return "Unit [x=" + x + ", y=" + y + "]";
	}

}
