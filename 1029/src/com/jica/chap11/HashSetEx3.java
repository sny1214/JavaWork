package com.jica.chap11;

import java.util.*;

class HashSetEx3 {
	public static void main(String[] args) {
		HashSet<Object> set = new HashSet<Object>();
		//					 |--> ["abc",["David",10],...]16개 공간
		//set 0x100 ------>[0x10,..]
		
		set.add("abc");			//String
		set.add("abc");			//String class엔 해시코드 값 인식하므로 이미 추가되어 있던 값이 있으므로 추가되지 않음
		set.add(new Person("David",10)); //Person객체 만듬. 여기엔 HashCode 없음. Person의 상위 코드인 Object의 해시코드를 실행
		set.add(new Person("David",10)); //Person의 상위 코드인 Object의 해시코드를 실행시키는데 다른 해시코드로 인식 -> 중복된 데이터 또 들어간다.
										 //equals 메서드로 해시코드 재정의 해야 중복 데이터 들어가지 않는다 --> HashSetEx4.java
		System.out.println(set);
	}
}
//Person 멤버변수 : String, int --> HashSet 타입 파라미터 : <Object>
class Person extends Object{
	String name;
	int age;

	Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String toString() {
		return name +":"+ age;
	}
}
