package com.jica.tv;

public class VariableTest {

	public static void main(String[] args) {
		System.out.println("객체 생성전입니다.");
		System.out.println("클래스변수 sv의 값 : " + Variable.sv);   // ok
		Variable.changeValue();  //클래스 메서드(static 메서드) 호출
		
		
		
		System.out.println("Variable클래스로 객체를 생성합니다.");
		
		Variable v1 = new Variable(1000);
		Variable v2 = new Variable(2000);
		Variable v3 = new Variable(3000);
		
		//             iv1  iv2  iv3 iv4 
		//v1 0x100--->[ 10, 20,  50, 1000 ]
		//v2 0x200--->[ 50, 60,  70, 2000 ]		
		//v3 0x300--->[100, 90,  80, 3000 ]	  Variable::sv  200	
		//스택영역      동적영역(heap)        정적영역(static)
		
		//개별 멤버변수에 직접 접근하여 값을 할당
		v1.iv1 = 10;
		v1.iv2 = 20;
		v1.iv3 = 30;
		
		//v1.iv4 = 670;   //final 인스턴스 멤버변수는 객체 생성후에는 
		                   //그 값을 변경할 수 없으므로 error 이다.
		
		//메서드를 사용하여 멤버변수에 값을 할당
		v2.setData(50, 60, 70);
		v3.setData(100, 90, 80);
	
		v3.display();
		v2.display();
		v1.display();
		
		int max = v3.calculateMax();
		System.out.println("v3객체의 최대값은 " + max + " 입니다.");
		System.out.println("------------------------");
		
		//v1.sv = 700; // 모두 동일한 클래스변수 sv값을 500으로 변경한다.
		//v2.sv = 700;
		//v3.sv = 700; 
		//위의 표현도 가능하지만 static 변수 즉, 클래스 멤버변수를 접근할때는
		//클래스명.static멤버변수   형태로 코딩하기를 권장합니다.
		
		Variable.sv = 700;
		
		
		v3.display();
		v2.display();
		v1.display();
	}

}
