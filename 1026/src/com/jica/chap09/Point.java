package com.jica.chap09;

class Point implements Cloneable {
	int x;
	int y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "x="+x +", y="+y;
	}

	@Override
	
	//Object클래스의 clone()메서드
	//protected Object clone() throws CloneNotSupportedException
	//clone()메서드를 재정의하면서 아래의 코드처럼 코딩을 했다. 에러가 발생하지 않는 이유는?
	public Object clone()  {
		Object obj = null;
		try {
			obj = super.clone();  // clone()은 반드시 예외처리를 해주어야 한다.
		} catch(CloneNotSupportedException e) {}
		return obj;
	}
}