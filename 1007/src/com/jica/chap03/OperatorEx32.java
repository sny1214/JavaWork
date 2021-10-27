package com.jica.chap03;

class OperatorEx32 {
	public static void main(String args[]) { 
		int  x, y, z;
		int  absX, absY, absZ;		//절대값
		char signX, signY, signZ;	//부호

		x = 10;
		y = -5;
		z = 0;

	//삼항 연산자 ? :
		
		absX = x >= 0 ? x : -x;  // absX >=0 이 true 면 x, false면 -x
		absY = y >= 0 ? y : -y;  
		absZ = z >= 0 ? z : -z;
		
	// 삼항 연산자 내에 삼항 연산자
		signX = x > 0 ? '+' : ( x==0 ? ' ' : '-');  
		signY = y > 0 ? '+' : ( y==0 ? ' ' : '-'); 	// 거짓일 때, y==0 따져 거짓이니까 -, 부호가 -
		signZ = z > 0 ? '+' : ( z==0 ? ' ' : '-');  // 거짓일 때, z==0 참, 부호 ' '공백으로 출력

		System.out.printf("x=%c%d\n", signX, absX);
		System.out.printf("y=%c%d\n", signY, absY);
		System.out.printf("z=%c%d\n", signZ, absZ);
	}
}
