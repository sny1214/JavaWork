package com.jica.chap02;

class CastingEx4 {
	public static void main(String[] args) {
		int   i  = 91234567;   
		float f  = i;         //자동형변환 
		int   i2 = (int)f;	  //int형으로 강제형변환

		double d = i;         //자동형변환
		int   i3 = (int)d;    //int형으로 강제형변환

		float f2 = 1.666f;
		int   i4 = (int)f2;   //int형으로 강제형변환
		
		//결론 : 강제형변환은 l-value의 타입에 일치시킨다.
		//      l-value의 자료형이 작은 자료형일때
		
		//        정수형                    실수
		// byte-->short-->int-->long ===> float --> double
		//        char --^ 

		System.out.printf("i=%d\n", i);
		System.out.printf("f=%f i2=%d\n", f, i2);
		System.out.printf("d=%f i3=%d\n", d, i3);
		System.out.printf("(int)%f=%d\n", f2, i4);
	}
}
