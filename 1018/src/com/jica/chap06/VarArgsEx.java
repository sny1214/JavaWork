package com.jica.chap06;

class VarArgsEx {
	public static void main(String[] args) {
		String[] strArr = { "100", "200", "300" };
		
		System.out.println(VarArgsEx.concatenate("", "100", "200", "300"));
		System.out.println(concatenate("-", strArr));
		System.out.println(concatenate(",", new String[]{"1", "2", "3"}));
		System.out.println("["+concatenate(",", new String[0])+"]");
		System.out.println("["+concatenate(",")+"]");
	}

	static String concatenate(String delim, String... args) {
		//두번째 매개변수는 가변인자이므로 내부적으로는 String args[] 를 의미하다.
		String result = "";
		
		//delim 0x10 ---> ","
		//args  0x20 --->[]
		//result 0x100--->""
		for(String str : args) {
			result += str + delim;
		}
		
		return result;
	}

	/*
	static String concatenate(String... args) {
		return concatenate("",args);
	}
	*/

} // class
