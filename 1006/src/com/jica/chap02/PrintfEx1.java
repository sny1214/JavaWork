package com.jica.chap02;

class PrintfEx1 {
	public static void main(String[] args) {
		byte  b = 1;
		short s = 2;
		char  c = 'A';

		int  finger = 10; 
		long big = 100_000_000_000L;       
		long hex = 0xFFFF_FFFF_FFFF_FFFFL ;  // long hex = 0xFFFFFFFFFFFFFFFFL;

		int octNum = 010;       //  8진수 10, 10진수 값 8
		int hexNum = 0x10;      // 16진수 10, 10진수 값 16
		int binNum = 0b10;      //  2진수 10, 10진수 값 2

		System.out.printf("b=%d%n", b);
		System.out.printf("s=%d%n", s);
		System.out.printf("c=%c, %d %n", c, (int)c);
		System.out.printf("finger=[%5d]%n",  finger);
		System.out.printf("finger=[%-5d]%n", finger);
		System.out.printf("finger=[%05d]%n", finger);		//앞자리 빈 공간을 0으로 채움
		System.out.printf("big=%d%n", big);
		System.out.printf("hex=%x%n", hex);
		System.out.printf("hex=%X%n", hex);
		System.out.printf("hex=%#x%n", hex); // '#'기호를 사용하여 출력되는 값 앞에 0x를 표시한다.
		System.out.printf("hex=%#X%n", hex);
		System.out.printf("octNum=%o, %d%n", octNum, octNum);   
		System.out.printf("hexNum=%x, %d%n", hexNum, hexNum);   
		System.out.printf("binNum=%s, %d%n", Integer.toBinaryString(binNum), binNum);  
		
		//Integer.toBinaryString(정수값)
		//정수값을 이진수로 이루어진 문자열을 만들어준다.
		//문자열 출력 : %s
		System.out.println("============================================");
		for(int number = 1; number <300; number++) {
			System.out.printf("%d %s%n", number,  Integer.toBinaryString(number));
		}
			
	}
}
