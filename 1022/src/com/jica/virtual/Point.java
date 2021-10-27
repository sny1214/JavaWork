package com.jica.virtual;

abstract class Point {
	int x;	
	int y;

	Point(){}

	Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}

}