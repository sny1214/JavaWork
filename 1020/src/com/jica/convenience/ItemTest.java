package com.jica.convenience;

import java.util.Scanner;

// 실제 문제 해결 클래스
public class ItemTest {

	public static void main(String[] args) {

		//객체 생성
		Item item1 = new Item();				//인자없는 생성자 동작
		Item item2 = new Item("새우깡");			//인자 title만 있는 생성자 동작
		Item item3 = new Item("컵라면", 1200); 	//인자 두개 title, price 받는 생성자 동작
		//Item item4 = new Item(item3);		 	//아이템 인자 다 입력한 복사생성자 동작 (title, price, quantity)

		

//
//		item1.title = "커피";
//		item1.price = "500";
		
		item1.setTitle("커피");		//정해진 방법으로만 값 지정하거나 변경할 수 있게 -> private 변수로 두고 setter, getter 사용
		item1.setPrice(500);
		item2.setPrice(800);
		
		
		
		System.out.println(item1);//객체의 참조값을 출력한다. com.jica.convenicence.Item@16진수
		System.out.println(item2);//객체의 참조값을 출력한다. com.jica.convenicence.Item@16진수
		System.out.println(item3);//객체의 참조값을 출력한다. com.jica.convenicence.Item@16진수
		//System.out.println(item4);//객체의 참조값을 출력한다. com.jica.convenicence.Item@16진수
		
		
		System.out.println(item1.toString());	//객체의 상태를 보여주고 싶을 때 미리 toString 메서드 만들어놓고 사용 -> 참조값 아닌 값이 표현된다.
		System.out.println(item2.toString());	
		System.out.println(item3.toString());
		//System.out.println(item4.toString());

		
		
		//특정 제품 입력하고 싶을 때							----------> 가급적 메인 메서드에 집어넣음
		//키보드로 판매제품명과 수량을 입력받자 ---> Scanner 객체 선언
		Scanner scanner = new Scanner(System.in);	
		System.out.print("판매제품명 입력 ==> ");
		String title = scanner.nextLine();     			//한줄의 입력값 받음
		
		System.out.print("판매 수량 입력 ==> ");
		int count = scanner.nextInt();					//한줄의 입력값 받음
		
		
		
		//어떤 Item 객체의 sale()메서드를 적용할 것인지를 위해 검색해야 한다.
		
		if(item3.sale(count) > 0 ) {
			System.out.println("정상적으로 판매가 이루어졌습니다.");
			System.out.println(item3);	
			
		}else {
			System.out.println("수량 오류 입니다.");
		}
	
		
		
		
		
	
		
		if(item3.sale(3) > 0 ) {
			System.out.println("정상적으로 판매가 이루어졌습니다.");
			System.out.println(item3);		//--> item3 컵라면의 수량이 3으로 늘어난다.
			
		}else {
			System.out.println("수량 오류 입니다.");
		}
	
	
	
	}

}
