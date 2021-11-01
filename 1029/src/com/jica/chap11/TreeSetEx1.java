package com.jica.chap11;

import java.util.*;

class TreeSetEx1 {
	public static void main(String[] args) {
		TreeSet<String> set = new TreeSet<String>();

		String from = "b";
		String to	= "d";

		set.add("abc");	//root	[null,"abc",null]
		set.add("alien");
		set.add("bat");
		set.add("car");
		set.add("Car");
		set.add("disc");
		set.add("dance");
		set.add("dZZZZ");
		set.add("dzzzz");
		set.add("elephant");
		set.add("elevator");
		set.add("fan");
		set.add("flower");

		//결과 : 사향 트리..? 한쪽으로만 가게 예제가 만들어짐
		//root->    "abc"
		//		       "alien"
		//				   "bat"
		//				 "Car" "car"
		//					    "disc"
		//					 "dance"
		//				 "dZZZZ"   "dzzzz"
		//						    "elephant"	
		//							   "elevator"
		//								      "fan"
		//									   "flower"
		//set2 0x200 ---> [0x400,...]
		//					"bat"
		//					   "car" 
		
		//set3
		// ......."dZZZ" 까지!!!
		
		System.out.println(set);		//In Order 방식으로 출력되므로 "Car"부터 출력
		System.out.println("range search : from " + from  +" to "+ to);	//from : b, to : d 라고 위에 작성
		System.out.println("result1 : " + set.subSet(from, to));		//b~d까지 별도의 트리구조 생성
		System.out.println("result2 : " + set.subSet(from, to + "zzz"));	//dzzz 이전까지
	}
}
