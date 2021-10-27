package com.jica.chap02;

class FloatToBinEx {
	public static void main(String args[]) {
		//실수형  부호부+지수부+가수부의 형태로 정규화되어 저장된다.
		//float    4byte  7자리
		//double   8byte  15자리
		//출력시 %전체자릿수.소숫점이하자리수 를 사용한다.
		
		float f = -9.1234567f;
		float f2 = 324.1234567f;
		
		int i = Float.floatToIntBits(f);

		System.out.printf("%f%n", f);		
		//-9.123457
		System.out.printf("%f%n", f2);
		
		//실제 메모리에 저장된값의 구조
		System.out.printf("%X%n", i);
		//C   1   1   1   F   9   A   E
		//11000001000100011111100110101110
	} // main�� ��
}
