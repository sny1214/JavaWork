package com.jica.chap05;

class ArrayEx4 {
	public static void main(String[] args) {
		char[] abc = { 'A', 'B', 'C', 'D'};			//char[] 배열
		char[] num = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
		
		//char[]의 배열명을 출력하면 배열요소값을 출력해 준다.
		System.out.println(abc);			//ABCD
		System.out.println(num);			//0123456789

		//abc 배열과 numb배열의 요솤기를 더한 크기의 새로운 배열 result 생성
		char[] result = new char[abc.length+num.length];
		
		//abc 0x100 ----> ['A', 'B', 'C', 'D']
		//num 0x200 ----> ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9']
		//result 0x300 -> [' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ']
		
		System.arraycopy(abc, 0, result, 0, abc.length);	
		//result 0x300 -> ['A', 'B', 'C', 'D', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ']
		
		System.arraycopy(num, 0, result, abc.length, num.length);
		System.out.println(result);
		//result 0x300 -> ['A', 'B', 'C', 'D', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9']


		
		//abc 배열 요소 4개를 num 배열의 0번째 위치부터 차례로 복사
		System.arraycopy(abc, 0, num, 0, abc.length);
		System.out.println(num);
		//num 0x200 ----> ['A', 'B', 'C', 'D', '4', '5', '6', '7', '8', '9']



		System.arraycopy(abc, 0, num, 6, 3);
		System.out.println(num);
		//num 0x200 ----> ['A', 'B', 'C', 'D', '4', '5', 'A', 'B', 'C', '9']

	}
}
