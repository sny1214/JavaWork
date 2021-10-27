package com.jica.object;

import java.util.Date;
import java.util.Objects;

public class ObjectTest {

	public static void main(String[] args) {
		//객체.멤버
		//public 메서드인 equal(),getClass(),hashCode(),toString()를 사용할수 있다.
		
		Item item = new Item("새우깡", 1000);
		Item item2 = new Item("콜라",   900);
		Item item3 = new Item("새우깡", 1000);
		Item item4 = item;
		Item item5 = new Item("새우깡", 3000);
		
		//item4 0x100 ---v
		//item  0x100 --->["새우깡",1000]
		//item2 0x200 --->["콜라",  900]
		//item3 0x300 --->["새우깡",1000]
		//item5 0x500 --->["새우깡",3000]		
		//item6 0x600 --->[년월일시분초정보]
		
		//등가비교 연산자는 객체의 참조값이 같은지 비교한다.
		System.out.println(item == item2); //false
		System.out.println(item == item3); //false
		System.out.println(item == item4); //true	
		System.out.println();
		
		//Object클래스의 equals()메서드는 내부적으로 참조값이 같은지 비교한다(즉, ==와 동일)
		System.out.println(item.equals(item2)); //false
		System.out.println(item.equals(item3)); //false
		System.out.println(item.equals(item4)); //true		
		System.out.println("----------------------------");
		
		System.out.println(item.equals(item)); //true
		System.out.println(item.equals(null)); //false
		//Item item6 = null;
		//System.out.println(item6.equals(item)); // null.equals(item) 컴파일 오류
		                                          // 실행시 NullPointerException 발생
		//item4 0x100 ---v
		//item  0x100 --->["새우깡",1000]
		//item2 0x200 --->["콜라",  900]
		//item3 0x300 --->["새우깡",1000]
		//item5 0x500 --->["새우깡",3000]		
		//item6 null 
		//today 0x700 --->[년월일시분초정보]
		
		Date today = new Date();  //오늘날짜와 시간정보
		System.out.println(item.equals(today)); //Item객체와 Date객체의 비교 false
		System.out.println(item.equals(item2)); //false
		System.out.println(item.equals(item3)); //true
		System.out.println(item.equals(item4)); //true
		
		//Item객체의 내용값이 같으면 같은 hashcode값을 만들도록하자.
		//item,item3,item4가 내용값이 같다.
		System.out.println("----------------------------");
		System.out.println("item의 해시코드 : " + item.hashCode());
		System.out.println("item2의 해시코드 : " + item2.hashCode());
		System.out.println("item3의 해시코드 : " + item3.hashCode());
		System.out.println("item4의 해시코드 : " + item4.hashCode());
	}

}