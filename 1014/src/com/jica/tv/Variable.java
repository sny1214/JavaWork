package com.jica.tv;

public class Variable {
	int iv1;              //인스턴스 멤버변수 - 일반 멤버변수
	int iv2;
	int iv3;
	final int iv4;        //final 인스턴스 멤버변수
	                      //final int iv4 = 555;(명시적 초기화)
	
	static int sv = 100;  //클래스 멤버변수 - static 멤버변수
	
	Variable(int value){
		iv4 = value;  //생성자에서 최초로 값을 할당
	}
		
	void setData(int iv1, int iv2, int iv3) {
		this.iv1 = iv1;
		this.iv2 = iv2;
		this.iv3 = iv3;
		
		//this.iv4 = 600;  //error - final멤버변수는 값을 변경할 수 없다.
	}
	
	int calculateMax() {
		int max;   //지역변수-local variable

		if( iv1 > this.iv2) {
			max = iv1;
		}else {
			max = iv2;
		}
		
		if( max < iv3) {
			max = iv3;
		}
		return max;
	}
	
	//클래스 메서드 - static 메서드
	static void changeValue() {
		//1) 객체 생성 없이 호출할 수 있다.
		System.out.println("클래스 메서드 changeValue()가 실행됩니다.");
		//2) 클래스 멤버만 접근할 수 있다.
		//   일반멤버변수나 메서드는 호출할 수 없고
		//   static 멤버변수, static 메서드만 호출할 수 있다.
		
		//iv1 = 90;  //error
		//display(); //error
		sv = 200;    //ok
		
		//3) this를 사용할 수 없다.
		//this.iv1 = 5;   //error
	}
	
	void display() {
		System.out.println("sv값은 " + sv + "입니다.");
		System.out.printf("iv1:%d,iv2:%d,iv3:%d%n", this.iv1, iv2,iv3);
	}
}
