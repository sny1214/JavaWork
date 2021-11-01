package com.jica.chap11;

import java.util.*;

class TreeSetLotto {
	public static void main(String[] args) {
		Set<Integer> set = new TreeSet<Integer>();
		
		//set 0x100 ----> [0x200(root),...]
		//					|->[0x300,25,0x400]
		//	0x300[null,16,null]---^			^---0x400[null,42,null]
		//		
		
		for (int i = 0; set.size() < 6 ; i++) {
			int num = (int)(Math.random()*45) + 1;	//1~45까지 난수
			set.add(num);  // set.add(new Integer(num));
		}

		System.out.println(set);//출력결과 [1, 14, 19, 35, 43, 45]
								//저장된 순서대로의 내용이 아니라 (저장된 값은 트리구조)
								//In Order방식의 접근 결과로 순차적으로 보여준 것
	}
}
