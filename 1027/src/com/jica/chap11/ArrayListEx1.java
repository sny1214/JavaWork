package com.jica.chap11;

import java.util.*;

//타입 파라메터를 추가하여 교재 예제의 내용이 달라짐
class ArrayListEx1{
	public static void main(String[] args) {
		//ArrayList 객체 선언 및 생성
		ArrayList<Integer> list1 = new ArrayList<Integer>(10);
		//					 |--->[null,null,null....]10개
		//list1 0x100 ---> [0x10, ...]
		
		list1.add(new Integer(5));
		//list1.add(5); 여도 ok
		//내부에서 autoboxing 기능이 동작하여 list1.add(Integer.valueOf(10));
		
		list1.add(Integer.valueOf(4));
		list1.add(Integer.valueOf(2));
		list1.add(Integer.valueOf(0));
		list1.add(1);
		list1.add(3);
		
		//list1.add(new Integer(2));
		//list1.add(new Integer(0));
		//list1.add(new Integer(1));
		//list1.add(new Integer(3));
		//					 |--->[5,4,2,0,1,3,....]10개
		//list1 0x100 ---> [0x10, ...]
		System.out.println(list1);		//.toString() 내부적으로 존재하고 있다.
		System.out.println("-------------------------");

		//list1.subList(1,4) list의 1(from)부터 4-1=3(to)까지 [4,2,0] 발췌
		//sublist의 리턴값은 list-->list는 Collection의 하위이므로 list 저장 가능
		ArrayList<Integer> list2 = new ArrayList<Integer>(list1.subList(1,4)); 
		
		//					 |--->[4,2,0,....]10개 -->int값만 있으므로 <Integer> 타입모양 지정해주면 노란색 줄 사라짐
		//list2 0x200 ---> [0x20, ...]
		
		print(list1, list2);

		//컬렉션 객체의 사용에서 유용한 기능을 제공하는 클래스가 Collections 이다.
		Collections.sort(list1);	
		//		 |--->[0,1,2,3,4,5,....] => sort에 의해 오름차순
		//list1 0x100 ---> [0x10, ...]
		
		Collections.sort(list2);	// Collections.sort(List l)
		//					 |--->[0,2,4,....] => sort에 의해 오름차순
		//list2 0x200 ---> [0x20, ...]
		
		print(list1, list2);

		boolean result =  list1.containsAll(list2);		//A.containsAll(B):B의 모든 요소가 A에 포함되어 있는가? 
		System.out.println("list1.containsAll(list2):" + result);
	
		//지금까지 list2는 Integer 값을 갖는 것, but 아래 추가하려는 건 String
		//밑의 코드를 추가로 작성해 준다. String값을 갖는 list3을 갖게 하고 초기화 값이 list2와 같게 설정해준다.
	
		ArrayList<String> list3 = new ArrayList<String>();
		for(int i = 0; i < list2.size(); i++) {
			list3.add(list2.get(i) + ""); // list2.get(i)는 Integer형이므로 "0","2","4" String값으로 가져오기 위해 "" 추가 
		}
		
		//					 |--->["0","2","4",....]
		//list3 0x300 ---> [0x30, ...]
		
		list3.add("B");
		list3.add("C");
		//					 |--->["0","2","4","B","C"....]
		//list3 0x300 ---> [0x30, ...]
		
		list3.add(3, "A");
		//					 |--->["0","2","4","A","B","C"....]
		//list3 0x300 ---> [0x30, ...]
		print2(list1, list3);
		
	
	
		list3.set(3, "AA");
		//		 |--->["0","2","4","AA","B","C"....]
		//list3 0x300 ---> [0x30, ...]
	
		print2(list1, list3);
		
		
		//A.retainAll(B) : A와 B 겹치는 부분만 남기고 나머지는 삭제한다.
		//list1에서 list3과 겹치는 부분만 남기고 나머지는 삭제한다.
		//list1 은 Integer로만 된 것, list3 은 String으로만 된 것
		
		System.out.println("list1.retainAll(list3):" + list1.retainAll(list3));	
		print2(list1, list3);
		
		//  list1에서 list3과 겹치는 부분만 남기고 나머지는 삭제하는 기능을 로직으로 직접 작성.
		for(int i= list3.size()-1; i >= 0; i--) {
			if(list1.contains(list3.get(i)))
				list3.remove(i);
		}
		print2(list1, list3);
		
	} // main�� ��

	static void print2(ArrayList<Integer> list1, ArrayList<String> list3) {
		System.out.println("list1:"+list1);
		System.out.println("list3:"+list3);
		System.out.println();		
	}
	
	static void print(ArrayList<Integer> list1, ArrayList<Integer> list2) {
		System.out.println("list1:"+list1);
		System.out.println("list2:"+list2);
		System.out.println();		
	}
} // class
