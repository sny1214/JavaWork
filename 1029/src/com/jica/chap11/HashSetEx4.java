package com.jica.chap11;

import java.util.*;

class HashSetEx4 {
	public static void main(String[] args) {
		HashSet<Object> set = new HashSet<Object>();
		
		//					 |--> ["abc",["David",10],...]16개 공간
		//set 0x100 ------>[0x10,..]
		
		set.add(new String("abc"));
		set.add(new String("abc"));
		set.add(new Person2("David",10));
		set.add(new Person2("David",10));	//표현값이 같으므로 해시코드 같은걸로 인식해 안들어가
											//결과에 디버깅 출력 되는 걸 보면
											//따로 equals 등 메서드 사용 직접 안했음에도 동일데이터 확인하면서 자동으로 실행했음 알수 있다

		System.out.println(set);
	}
}

class Person2 {
	String name;
	int age;

	Person2(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public boolean equals(Object obj) {
		//디버깅용 출력
		System.out.println("Persong2::equals()...");
		if(obj instanceof Person2) {
			Person2 tmp = (Person2)obj;
			return name.equals(tmp.name) && age==tmp.age;
		}

		return false;
	}
	@Override
	public int hashCode() {
		//디버깅용 출력
		System.out.println("Persong2::hashCode()...");
		return (name+age).hashCode();
	}

	public String toString() {
		return name +":"+ age;
	}
}
