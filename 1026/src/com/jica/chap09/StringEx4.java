package com.jica.chap09;

import java.util.StringJoiner;

class StringEx4 {
	public static void main(String[] args) {
		String animals = "dog,cat,bear";
		String[] arr   = animals.split(",");
		//arr 0x200--->["dog","cat","bear"]
		
		//String.join("연결자",가변인자나 문자열배열)
		
		System.out.println(String.join("-", arr)); //"dog-cat-bear"
		System.out.println(String.join("|", "70","80","90")); //"70|80|90"

		//java.util패키지에 문자열을 연결시키는 전용클래스가 있다 -- StringJoiner
		StringJoiner sj = new StringJoiner("-","<<",">>");
		//sj 0x700---->"[dog/cat/bear]"
		for(String s : arr)
			sj.add(s);

		System.out.println(sj.toString());
	}
}
