package com.jica.inter;

//class를 사용하지 않고 interface예약어를 사용한다.
public interface PlayingCard {
	//모든 멤버변수는 상수멤버변수 - public static final
	public static final int SPADE = 4;  // 권장
	final int DIAMOND = 3; //public static final int DIAMOND = 3와 동일
	static int HEART = 2;  //public static final int HEART = 2;
	int CLOVER = 1;        //public static final int CLOVER = 1;
	
	//모든 메서드는 public 추상메서드 이다.
	public abstract String getCardNumber();
	String getCardkind();  //public abstract String getCardkind(); 
}

