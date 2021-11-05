package com.jica.io.character;

import java.io.*;

class StandardIOEx3 {
	public static void main(String[] args) {
		PrintStream      ps  = null;
		FileOutputStream fos = null;

		try {
			fos = new FileOutputStream("standardout.txt");
			ps  = new PrintStream(fos);
			
			//System.out의 메서드로 출력되는 내용은 ps와 연결된 standardout.txt화일로 출력되도록
			//출력방향 바꾼다(표준출력 변경)
			System.setOut(ps);   
		} catch(FileNotFoundException e) {
			System.err.println("File not found.");
		}

		System.out.println("Hello by System.out");	
		System.out.println("표준출력을 모니터에서 stardardout.txt파일로 최종 변경했습니다.");
		System.out.println(75);
		System.out.println(3.14);
		System.out.println('A');
		System.out.println("end");
		
		System.err.println("Hello by System.err");		
	}
}
