package com.jica.chap05;

class ArrayEx14 {
	public static void main(String[] args) {
		String src = "ABCDE";
		//				   01234
		//src 0x100  ---> "ABCDE",...,+메서드
		
		
		for(int i=0; i < src.length(); i++) {	// i 0 1 2 3 4
			char ch = src.charAt(i); // src의 내용중 i번째 문자 추출
			System.out.println("src.charAt("+i+"):"+ ch);
		}
		System.out.println();
		
		char[] chArr = src.toCharArray();  // String객체를 char[]로 변환시킨 것
		//chArr : src의 데이터값을 char[]로 만들어라
		//chArr 0x200 ---> ['A','B','C','D','E']
		
		System.out.println(chArr); // char배열(char[])을 출력하면 내용값이 연속적으로 출력된다.
								   // char[] 이외의 다른 배열명을 출력하면 위치정보가 가공되어 출력된다.
		
		int a[] = {1,2,3,4};
		double b[] = {1.1, 3.14, 6.2f};
		//a        0x300 ---> [1,2,3,4]
		//b        0x400 ---> [1.1, 3.14, 6.2f]
		System.out.println(a);
		System.out.println(b);
		
	}
}
