package com.jica.chap07;

//아래코드의 의미는 java.lang.System클래스를 사용하겠다!
//이때 아래의 static import 구문에서
//패키지명.클래스명.static멤버변수명 을 기술했다면
//out 객체의 메서드를 사용할 때 System이라는 클래스명을 생략하겠다는 의미이다.
// (예: System.out.println(Math.random()); -> out.println(random()); )
import static java.lang.System.out;

//아래 코드의 의미는 java.lang 패키지의 Math 클래스를 사용하겠다!
//그런데 Math 클래스 static메서드를 호출 할 때
//원칙적으로는 클래스.static메서드()형태로 호출해야 한다.
// (예 : System.out.println(Math.random()); )

//import 구문 시 static 붙이면 이 효과로 클래스명을 생략할 수 있다.
// (예: random(); )
import static java.lang.Math.*;

class StaticImportEx1 {
	public static void main(String[] args) {	
		//System.out.println(Math.random());
		out.println(random());

		//System.out.println("Math.PI :"+Math.PI);
		//Math.PI 값 정해져 있음(3.141592653589793) -> 클래스명 제외하고 PI라고만 써도 돼.
		out.println("Math.PI :" + PI);
	}
}
