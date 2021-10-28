package com.jica.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ArrayListTest {

	
	public static void main(String[] args) {
		//정수값을 관리하는 ArrayList
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		//					 |--->[null,null,...null]
		//list	0x100 ---> [0x10, ...]
		System.out.println(list.isEmpty());		//true
		System.out.println(list.size());   		//0
		
		//get : 0부터 size()-1 사이의 순서번째 데이터 읽어오기
		//System.out.println(list.get(0));    	//0부터 size()-1 범위 벗어나므로
												//IndexOutOfBoundsException
		
		//데이터 추가 - 내부에서 순차적으로 관리된다.
		//					 |--->[10,45,...null]
		//list	0x100 ---> [0x10, ...]
		
		list.add(10);		//끝에 데이터 추가
		list.add(45);
		System.out.println(list.size());   		//2
		
		//순서번째 데이터 추가
		list.add(1,30);
		//					 |--->[10,30,45,...null]
		//list	0x100 ---> [0x10, ...]

		//list.add(4,30);	//=>0~size()까지 가능 벗어나면 IndexOutOfBoundsException
		//					 |--->[10,30,45,null,30...null] => 중간에 null 있음--^
		//					 |								   add()는 순차적 관리이므로
		//list	0x100 ---> [0x10, ...]

		list.add(25);
		list.add(17);
		System.out.println(list.isEmpty());
		System.out.println(list.size());
		
		//					 |--->[10,30,45,25,17,...null]
		//list	0x100 ---> [0x10, ...]
		System.out.println(list);
		
		
		
		//데이터 삭제 -- 순서번째 데이터 삭제
		Integer result = list.remove(2);	//제거되는 값 뒤의 값들은 앞으로 당겨진다.
		//					 |--->[10,30,25,17,...null]
		//list	0x100 ---> [0x10, ...]
		System.out.println("삭제된 값 : " + result);

		//데이터 삭제 -- 주어진 데이터를 찾아서 삭제
		boolean ok = list.remove(Integer.valueOf(25));	//데이터 값을 명시적으로 지정 후 삭제 --> boolean형
		System.out.println("삭제 결과 : " + ok);
		System.out.println(list);
		
		list.add(25);
		
		boolean ok2 = list.remove(Integer.valueOf(36));	//없는 값 제거하라 하면 false 나옴
		System.out.println("삭제 결과 : " + ok2);
		System.out.println(list);
		
		//데이터의 위치 알아오기 - 검색 (17의 위치-순서 알아오기)
		int pos = list.indexOf(Integer.valueOf(17));
		System.out.println("검색 위치는 " + pos + " 입니다.");
		System.out.println(list);
		//데이터의 위치 알아오기 - 검색 (없는 값 입력 시)
		int pos2 = list.indexOf(Integer.valueOf(42));
		System.out.println("검색 위치는 " + pos2 + " 입니다.");	//찾는 값 없으므로 -1로 출력
		System.out.println(list);	
		
		//특정 데이터가 있는지 여부
		boolean found = list.contains(Integer.valueOf(30));
		System.out.println("존재 여부 : " + found);		//true
		System.out.println(list);
		boolean found2 = list.contains(Integer.valueOf(12));
		System.out.println("존재 여부 : " + found2);		//false
		System.out.println(list);
		
		//전체 데이터를 출력하는 기능
		System.out.println("다양한 전체요소 접근 방법 ------------");
		System.out.println(list);
		
		//개별 데이터 출력하는 기능 - 개별요소를 처음부터 끝까지 얻어내서 출력
		for(int i=0 ; i <list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
		System.out.println();
	
		for(Integer value : list) {			//빠른 for문을 이용하여 개별요소를 처음부터 끝까지 얻어내서 출력
			System.out.print(value + " ");
		}
		System.out.println();
		
		//Iterator를 이용한 전체 데이터 접근
		Iterator<Integer> it = list.iterator();
		while(it.hasNext()) {		//다음 요소 있는지? -> true 이면 밑에 실행코드 수행함
			System.out.print(it.next() + " ");
		}
	
		System.out.println();
		System.out.println("------------------------------------------");
		
		//순서번째의 데이터 변경
		Integer oldValue = list.set(3, 47);
		System.out.println(list);
		System.out.println("변경되기 이전의 2번째 값 : " + oldValue);
		
		//현재의 ArrayList내용을 부분 발췌(분리) 하기
		//                   |-->[30,50,null...null]
		//list    0x100--->[0x10,...] ^ 불일치
		//                   |--------|
		//subList 0x200--->[0x20,...]
		
		List<Integer> subList = list.subList(1, 3);
		subList.set(1, 50);
		System.out.println("list    : " + list);
		System.out.println("subList : " + subList);
		
		
		//public boolean retainAll​(Collection<?> c)
		//list에서 subList의 구성요소만 남기고 모든요소를 제거하시오
		/*
		ok = list.retainAll(subList);
		System.out.println("retainAll()의 결과 : " + ok);
		System.out.println("list    : " + list);
		System.out.println("subList : " + subList);  //run-time 에러 발생
		*/
	}

}
