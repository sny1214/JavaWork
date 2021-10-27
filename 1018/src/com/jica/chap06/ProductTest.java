package com.jica.chap06;

class Product {
	static int count = 0;   // 생성되는 인스턴스의 갯수를 저장하는 변수
	int serialNo;	        // 생성되는 객체의 고유번호

	{
		++count;
		serialNo = count;
	}

	public Product() {}     // 인자가 없는 생성자
}

class ProductTest {
	public static void main(String args[]) {
		Product p1 = new Product();
		Product p2 = new Product();
		Product p3 = new Product();
		
		// Product::count 3                      정적영역(static)
		// 
		// serialNo    serialNo  serialNo        동적영역(heap)
		// [ 1 ]       [ 2 ]     [ 3 ]
		// ^           ^         ^
		// |---|       |--|      |--| 
		//     |          |         |
		// p1 0x100  p2 0x200   p3 0x300          main() 스택영역
		System.out.println("p1의 제품번호(serial no)는 " + p1.serialNo);
		System.out.println("p2의 제품번호(serial no)는 " + p2.serialNo);
		System.out.println("p3의 제품번호(serial no)는 " + p3.serialNo);
		System.out.println("생성된 제품의 수는 모두 "+Product.count+"개 입니다.");  
	}
}
