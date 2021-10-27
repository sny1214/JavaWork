package com.jica.chap03;

class OperatorEx22 {
	public static void main(String args[]) { 
		float  f  = 0.1f;
		double d  = 0.1;
		double d2 = (double)f; //float 4byte, double 8byte 그래서 cast연산자 (double) 생략 가능

		// 가급적이면 실수형에서는 등가비교사용을 자제하기를 권장한다. ---> 두값을 빼서 차이가 내가 원하는 오차범위 내에 있으면 같은 값으로 생각
		// 명시적인 변수값과 Literal value는 정확한 비교가 가능하지만
		// 계산의 결과값으로 만들어진 실수값은 저장구조의 특성으로 값이 정확히 일치하지 않을 가능성을 내포하고 있다.
		
		System.out.printf("10.0==10.0f  %b\n", 10.0==10.0f); //실수형 직접 계산 double 10.0== float10.0f
		System.out.printf("0.1==0.1f    %b\n",  0.1==0.1f);	 // %b boolean형, /n 줄바꿈(=enter)
		System.out.printf("f =%19.17f\n", f);
		System.out.printf("d =%19.17f\n", d);
		System.out.printf("d2=%19.17f\n", d2);
		System.out.printf("d==f   %b\n", d==f);
		System.out.printf("d==d2  %b\n", d==d2);
		System.out.printf("d2==f  %b\n", d2==f);
		System.out.printf("(float)d==f  %b\n", (float)d==f);
	}
}
