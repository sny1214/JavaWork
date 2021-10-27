package com.jica.composition;

//2차원 평면에서의 위치를 나타내는 클래스
public class Point{
	int x;
	int y;
	
	//생성자
	public Point() {
	}

	public Point(int x, int y) {		
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}

}
