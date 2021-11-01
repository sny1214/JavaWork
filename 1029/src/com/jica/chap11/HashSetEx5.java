package com.jica.chap11;

import java.util.*;

class HashSetEx5 {
	public static void main(String args[]) {
		HashSet setA    = new HashSet();	//원래 다 타입 파라미터 <String> 붙여줘야함
		HashSet setB    = new HashSet();
		HashSet setHab = new HashSet();
		HashSet setKyo = new HashSet();		//교집합의 객체
		HashSet setCha = new HashSet();		//합집합

		setA.add("1");		setA.add("2");
		setA.add("3");		setA.add("4");
		setA.add("5");
		System.out.println("A = "+setA);

		setB.add("4");		setB.add("5");
		setB.add("6");		setB.add("7");
		setB.add("8");
		System.out.println("B = "+setB);

		Iterator it = setB.iterator();		//2번째(B) 집합 요소를 꺼내 1번째(A) 집합에 포함되는지 물어봄
		while(it.hasNext()) {				//-> 포함 되어 있으면(겹치면) 교집합에 추가
			Object tmp = it.next();
			if(setA.contains(tmp))
				setKyo.add(tmp);
		}

		it = setA.iterator();
		while(it.hasNext()) {
			Object tmp = it.next();
			if(!setB.contains(tmp))
				setCha.add(tmp);
		}

		it = setA.iterator();
		while(it.hasNext())
			setHab.add(it.next());

		it = setB.iterator();
		while(it.hasNext())
			setHab.add(it.next());

		System.out.println("A u B = "+setKyo);  // �ѱ� ���� ������ ����Ű
		System.out.println("A n B = "+setHab);  // �ѱ� ���� ������ ����Ű
		System.out.println("A - B = "+setCha); 
	}
}
