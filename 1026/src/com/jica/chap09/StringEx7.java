package com.jica.chap09;

class StringEx7 {
	public static void main(String[] args) {
		String fullName = "Hello.java";

		int index = fullName.indexOf('.'); //5

		String fileName = fullName.substring(0, index); //"Hello"


		// fullName.substring(index+1, fullName.length());�� ����� ����.
		String ext = fullName.substring(index+1); //"Java"

		System.out.println(fullName + "화일명은 " + fileName);
		System.out.println(fullName + "확장자 " + ext);
	}
}
