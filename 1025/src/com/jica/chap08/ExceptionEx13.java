package com.jica.chap08;

class ExceptionEx13 {
	public static void main(String[] args) {
		method1(); 	  // ���� Ŭ�������� static����̹Ƿ� ��ü�������� ���� ȣ�Ⱑ��.
  	}	// main�޼����� ��

	static void method1() {
		try {
		     throw new Exception();
		} catch (Exception e) {
			System.out.println("method1자체에서 예외처리를 마무리 한다.");
			e.printStackTrace();
		}
	}	// method1�� ��
}
