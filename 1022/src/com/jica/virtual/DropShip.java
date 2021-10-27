package com.jica.virtual;

import java.util.Arrays;

public class DropShip extends Unit {
	Unit units[] = new Unit[10];
	int count;
	
	public DropShip() {
		super();
	}
	
	public DropShip(int x, int y) {
		super(x, y);
	}

	void load(Unit unit) {
		units[count++] = unit;		
		System.out.println(unit + " 을 적재했습니다.");
	}
	
	void unload() { //모든 유닛 내리기
		for(int i=0;i<count;i++) {
			System.out.println(units[i] + "유닛을 내립니다");
			units[i] = null;
		}
		count = 0;
	}
	
	@Override
	void move(int tx, int ty) {
        System.out.println("DropShip이  ("+tx+","+ty+") 위치로 날라서 이동합니다.");
        x = tx;
        y = ty;
	}

	@Override
	public String toString() {
		return "DropShip [units=" + Arrays.toString(units) + ", count=" + count + ", x=" + x + ", y=" + y + "]";
	}

}
