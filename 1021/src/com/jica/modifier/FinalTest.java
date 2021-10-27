package com.jica.modifier;

import java.util.Random;

public class FinalTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Random random = new Random();
		for(int i=0; i<5; i++) {
			System.out.println(random.nextInt(100)); //0~99
		}
		
		MyRandom mRandom = new MyRandom();		
		System.out.println(mRandom.nextInt(50, 60));
	}

}

//String클래스는 final클래스이므로 상속받을수 없다.
//class MyString extends String{
//	
//}

class MyRandom extends Random{

	public MyRandom() {
		super();
	}
	
	int nextInt(int from, int to) {
        //from~to까지 범위의 난수를 발생시키는 코드 
		return 0;
	}
}

class Test{
	int a;
	//final int b = 10; 명시적 초기화
	final int b;
	
	Test(){
		b = 10; //생성자 내부에서의 최초 값지정 
	}
	
	void method1(int x, final int y) {
		//final int f = 5;
		final int f;
		f = 5;    //선언시 값을 할당하지 않았으므로 최초 한번은 값을 할당할 수 있다.
		          //이후에는 변경할 수 없다.
		int c = 5;
		//...
		c = f * 10;
		//f = 10;  final 지역변수  
		
		x = 100;
		//y = 200; final 매개변수
	}
	
	final void method2() {  //final 메서드
		System.out.println("method2()는 final메서드 이므로 하위클래스에서 ");
		System.out.println("재정의(overriding) 할 수 없는 메서드이다.");
	}
}

class Test2 extends Test{
    //...
	@Override
	void method1(int x, final int y) {
		//....
	}
	
	//@Override        상위클래스의 final메서드는 하위클래스에서 재정의(override) 할수 없다.
	//void method2() {
	//	
	//}
}

final class A{  //final클래스
  //....	
}

//class B extends A{ //final클래스는 상속할 수 없는 클래스
  //....	 
//}

