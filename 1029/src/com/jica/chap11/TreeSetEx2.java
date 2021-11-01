package com.jica.chap11;

import java.util.*;

class TreeSetEx2 {
	public static void main(String[] args) {
		TreeSet<Integer> set = new TreeSet<Integer>();	//set1
		int[] score = {80, 95, 50, 35, 45, 65, 10, 100};

		for(int i=0; i < score.length; i++)
			set.add(Integer.valueOf(score[i]));	

		
		//subSet : 부분 set
		//headSet : 특정 값 앞부분 set
		//tailSet: 특정 값 뒷부분 set
		
		//HashSet은 데이터들을 트리 구조로 가지기 때문에 headSet,tailSet 등의 메서드 가질 수 있다.
		// 정렬된 구조x
		
		
		System.out.println("50보다 작은 값 :"	+ set.headSet(Integer.valueOf(50)));	//set2
		System.out.println("50보다 큰 값 :"	+ set.tailSet(Integer.valueOf(50)));		
			//50포함//set3
	}
}
