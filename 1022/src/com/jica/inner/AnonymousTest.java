package com.jica.inner;

public class AnonymousTest {

	public static void main(String[] args) {
		I obj = new IC();
		obj.display();
		
		//IC라는 명칭의 클래스를 만들지 않고 I interface를 사용하고 싶다.
		//이럴때 익명의 클래스(annymous class)를 사용한다.
		//상위형 참조변수 = new 상위형(){
		//                //상위형 interface나 abstract class의 추상메서드를 재정의한다. 
		//              };
		
		I iObj = new I() {  //I interface를 구현한 익명을 클래스를 만들고 객체를 생성한다.
			@Override
			public void display() {
				System.out.println("익명의 내부클래스를 이용 : 안녕하세요");
			}		
		};
		
		iObj.display();
	}

}

interface I{
	void display();
}

//I interface를 구현한 클래스 
class IC implements I{
	@Override
	public void display() {
		System.out.println("안녕하세요.");
	}
}