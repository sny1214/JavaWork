package com.jica.chap06;

class BlockTest {
	int a;
	int b;
	int c; 
	static int s;
	
	static {
		System.out.println("static 초기화 블럭 { }");
		BlockTest.s = 500;  //this 사용 불가
	}

	{
		System.out.println("초기화 블럭 { }");
		this.c = (int)(Math.random() * 100) + 1; //this사용 가능
	}

	public BlockTest() {     
		System.out.println("인자가 없는 기본 생성자");
	}
	
	public BlockTest(int a, int b) {
		System.out.println("인자가 2개인 생성자");
		this.a = a;
		this.b = b;		
	}
	//  BlockTest::s   500
	//
	//   a  b  c      a   b   c
	//  [0, 0, 55]   [10, 20, 76]
	//  ^            ^	
	//  |            |
	//  |            |---|
	//  |---|            |
	//      |            |
	// bt  0x100   bt2  0x200

	public static void main(String args[]) {
		System.out.println("BlockTest bt = new BlockTest(); ");
		BlockTest bt = new BlockTest();

		System.out.println("BlockTest bt2 = new BlockTest(10,20); ");
		BlockTest bt2 = new BlockTest(10,20);
	}
}
