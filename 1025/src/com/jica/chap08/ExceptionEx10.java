package com.jica.chap08;

class ExceptionEx10 {
	public static void main(String[] args) throws Exception {
		Exception e = new Exception("사용자가 만든 예외.");
		throw e;		//예외를 던지는 문장은
						//1) try절에서 던지거나
						//2) throws 절을 가진 메서드 내부에서 던질 수 있다.
		//throw new Exception();		// Exception�� ���Ƿ� �߻���Ų��.
	}
}
