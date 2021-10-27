package com.jica.override;

import java.io.IOException;

public class Point {
	int x;
	int y;
	
	String getLocation() {
		return "x: " + x + ", y: " + y;
	}

	@Override
	public String toString() {
		return "Point[x=" + x + ", y=" + y + "]";
	}


}
