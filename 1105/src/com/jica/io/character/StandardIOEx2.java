package com.jica.io.character;

class StandardIOEx2 {
	public static void main(String[] args) {
		//표준 출력과 표준 에러는 출력장치를 공유하므로
		//구분할 필요성이 있어서 색상을 다르게 출력한다.
		//내부적으로 별도의 쓰레드처리가 이루어져 출력순서가 바뀌어 보일 때도 있다.
		System.out.println("out : Hello World!");
		System.err.println("err : Hello World!");
	}
}
