package com.jica.convenience;

import java.util.Scanner;


//사용자와 직접 대면하는 프로그램
//메인 메서드
public class ConvenienceTest {

	public static void main(String[] args) {
		ItemSale itemSale = new ItemSale();
		
		//ItemSale 정보 알고싶다
		//System.out.println(itemSale);

		
		Item item = new Item("콜라", 850);
		itemSale.add(item);
		
		item = new Item("풍선껌", 500);	//방금 위에 만들었던 item 객체 이용해 새로 객체 생성 안하고 내용만 바꿔서 또 추가할 수도 있다.
		itemSale.add(item);
		
		
		System.out.println("아래의 제품들의 판매를 시작합니다.");
		System.out.println(itemSale);
		
		
		
		
		//판매 시작!!!
		
		//특정 제품 입력하고 싶을 때							                ----------> 가급적 메인 메서드에 집어넣음
		//키보드로 판매제품명과 수량을 입력받자 ---> Scanner 객체 선언
		Scanner scanner = new Scanner(System.in);	
		
		
		//키보드 입력을 반복구조 내부에서 수행할 때
		//키보드 버퍼의 잔재로 인해 정상적인 수행이 이루어지지 않을 때가 있다.
		
		//한번 수행해 보고, 인위적으로 nextLine()을 한번 더 수행해 준다.
		
		//컵라면 엔터 치면 nextline()은 컵라면\r\n ---> nextInt 2\r\n에서 2만 읽고 enter(\r\n)는 인식 못해.. 다음 반복에서 남아있는 엔터(\r\n)를 타이틀에 넣어버린다.

		boolean isRunning = true;
		while(isRunning) {			
			System.out.print("판매제품명 입력( 영업종료 : end ) ==> ");
			String title = scanner.nextLine();     			//한줄의 입력값 받음
			
			if(title.equals("end")) {
				isRunning = false;
			}else {
				System.out.print("판매 수량 입력 ==> ");
				int count = scanner.nextInt();					//한줄의 입력값 받음
				
				scanner.nextLine();  //키보드 버퍼 잔재 문제 해결 위해 인위적으로 입력해줌
				
				//제품정보에서 제품명이 일치하는 제품객체를 찾는다.
				//검색을 먼저 해야함 --> itemSale에 find()메서드 만들어서 title과 맞는 객체item 찾아야 함
				String rMessage = itemSale.sales(title, count); //결과 값 보여줌
				System.out.println(rMessage);

			}
			
			
			
		}
		
	
		
		System.out.println();
		System.out.println("--판매 수량 순(내림차순) 판매 현황입니다.-------------");
		itemSale.sort();   //정렬하겠다
		
		
		System.out.println(itemSale);
		
	}

}
