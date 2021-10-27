package com.jica.chap08;

class ExceptionEx11 {
	public static void main(String[] args) /*throws Exception*/ {
		//throw new Exception();	// RuntimeException�� ���Ƿ� �߻���Ų��.
		//main() 메서드에 throws가 없고, try절 내부가 아니여도 에러를 던질 수 있는 예외종류는
		//RuntimeException이나 그 하위 예외 클래스 객체이다.
	
		throw new RuntimeException();
	
	}
}
