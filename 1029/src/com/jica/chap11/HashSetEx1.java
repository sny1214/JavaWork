package com.jica.chap11;

import java.util.*;

class HashSetEx1 {
	public static void main(String[] args) {
		//Object[] objArr = {"1",new Integer(1),"2","2","3","3","4","4","4"};
		Object[] objArr = {"1",Integer.valueOf(1),"2","2","3","3","4","4","4"};
		
		Set<Object> set = new HashSet<Object>();	//Object의 배열 객체인 objArr이므로 모든 자료형 받을 수 있음 -> set도 타입파라메터 지정 불가, 한다면 Object

		//					|-->[1,"1","2","3",...] HashSet() 쓸때 16개의 저장공간 만들어짐, 중복저장x
		//set 0x100 ----> [0x10,...]
		for(int i=0; i < objArr.length; i++) {
			System.out.println(set.add(objArr[i]));	// 중복된 데이터 추가시 false 리턴
		}
		System.out.println(set);	
	}
}
