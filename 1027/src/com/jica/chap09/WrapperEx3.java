package com.jica.chap09;

class WrapperEx3 {
	public static void main(String[] args) {
		int i = 10;				//i 기본자료형

		//기본자료형 i를 객체로 저장하려면
		Integer intg = (Integer)i; // Integer intg = Integer.valueOf(i);

		Integer intg5 = i;		   //실행시켜도 아무 에러 안생김
								   //기본자료형이 자동으로 integer객체(Wrapper 클래스)로 저장되는 기능
								   //autoboxing기능

		
		Object   obj = (Object)i;  // Object obj = (Object)Integer.valueOf(i);
		
		Long     lng = 100L;  // Long lng = new Long(100L);

		int i2 = intg + 10;   // intg(integer형)이 기본자료형으로 바껴 => unboxing
		long l = intg + lng;  // ������ ���� ������ ����

		Integer intg2 = new Integer(20);
		int i3 = (int)intg2;  // �������� �⺻������ ����ȯ�� ����(����ȯ ��������)

		Integer intg3 = intg2 + i3; 

		System.out.println("i     ="+i);
		System.out.println("intg  ="+intg);
		System.out.println("obj   ="+obj);
		System.out.println("lng   ="+lng);
		System.out.println("intg + 10  ="+i2);
		System.out.println("intg + lng ="+l);
		System.out.println("intg2 ="+intg2);
		System.out.println("i3    ="+i3);
		System.out.println("intg2 + i3 ="+intg3);
	}
}
