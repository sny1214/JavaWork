package com.jica.virtual;

public class Tank extends Unit {
	String mode = "general";
	
	public Tank() {
		super();
	}

	public Tank(int x, int y) {
		super(x, y);
	}

	void changeMode() {
		if( mode.equals("general")) {
			mode = "sege";
		}else {
			mode = "general";
		}
		System.out.println("mode를 " + mode + " 로 변경했습니다.");
	}

	@Override
	void move(int tx, int ty) {
        System.out.println("Tank가  ("+tx+","+ty+") 위치로 굴러서 빠르게 이동합니다.");
        x = tx;
        y = ty;
	}

	@Override
	public String toString() {
		return "Tank [mode=" + mode + ", x=" + super.x + ", y=" + super.y + "]";
	}


}
