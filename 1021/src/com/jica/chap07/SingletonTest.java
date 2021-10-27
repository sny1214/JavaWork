package com.jica.chap07;

final class Singleton {
	//private멤버변수이면수 static으로 미리 객체를 생성하여 멤버변수로 가진다.
	private static Singleton s = new Singleton();
	
	//생성자를 private으로 적용하여 임의로 객체를 생성할 수 없게 한다.
	private Singleton() {
		System.out.println("미리 Singleton객체가 1개 생성되었습니다.");
		//...
	}

	public static Singleton getInstance() {
		if(s==null) {
			s = new Singleton();
		}
		return s;
	}	

	//...
	void method1() {}
	void method2() {}
}

class SingletonTest {
	public static void main(String args[]) {
		//직접 생성자를 이용하여 객체를 생성할 수 없다.
		//Singleton s = new Singleton();
		
		System.out.println("-----------------");
		
		//아래의 static 메서드를 이용해야만 객체를 얻을 수 있다.
		Singleton s = Singleton.getInstance();
		System.out.println(s); //패키지명.Singleton@16진수문자열
		s.method1();
		s.method2();
		//....
		
		Singleton s2 = Singleton.getInstance();
		System.out.println(s2);
		//....
		
		Singleton s3 = Singleton.getInstance();
		System.out.println(s3);
	}
}
