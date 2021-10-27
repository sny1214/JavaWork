package com.jica.virtual;

public class Marine extends Unit {

	public Marine() {
		super();
	}

	public Marine(int x, int y) {
		super(x, y);
	}

	void stimPack() {
		System.out.println("Marine이 스팀팩을 사용합니다.");
	}

	//상위 추상클래스의 추상메서드를 모두 재정의(override)하면 일반클래스가 된다.
	@Override
	void move(int tx, int ty) {
		System.out.println("Marine이 ("+tx+","+ty+") 위치로 뛰어서 이동합니다.");
		x = tx;
		y = ty;
	}

	@Override
	public String toString() {
		return "Marine [x=" + super.x + ", y=" + super.y + "]";
	}

}
