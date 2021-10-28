package com.jica.chap11;

import java.util.*;

class VectorEx1 {
	public static void main(String[] args) {
		Vector<String> v = new Vector<String>(5);	// 초기용량을 5개로 지정
		//                 |-->["1","2","3",null,null]
		//v 0x100------->[0x10,....]
		v.add("1");
		v.add("2");
		v.add("3");
		print(v);
		
		v.trimToSize();	// capacity에서 빈공간(null)을 없앤다(capacity와 size가 같아진다)
		//                 |-->["1","2","3"]
		//v 0x100------->[0x10,....]		
		System.out.println("=== After trimToSize() ===");
		print(v);

		v.ensureCapacity(6); //강제로 저장공간을 늘린다.
		//                 |-->["1","2","3",null,null,null]
		//v 0x100------->[0x10,....]	
		System.out.println("=== After ensureCapacity(6) ===");
		print(v);

		v.setSize(7);  //0~6번째까지의 값을 유효데이타로 취급한다.(size)
		               //내부적으로 capacity 거의 모두 사용되었으므로 자동적으로 공간은 늘린다.(2배)
		//                 |-->["1","2","3",null,null,null,null,null,null,....]
		//v 0x100------->[0x10,....]	
		System.out.println("=== After setSize(7) ===");
		print(v);
		
		v.clear();
		System.out.println("=== After clear() ===");
		print(v);
	}

	public static void print(Vector<String> v) {
		System.out.println(v);
		System.out.println("size :" + v.size());
		System.out.println("capacity :" + v.capacity());
	}
}
