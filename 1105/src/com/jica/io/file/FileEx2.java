package com.jica.io.file;

import java.io.*;

class FileEx2 {
	public static void main(String[] args) {
		//실제 존재하는 디렉토리를 대상으로 한 File객체 생성
		File f = new File("C:\\JKWork\\JavaWork\\1105");

		if(!f.exists() || !f.isDirectory()) {
			System.out.println("유효하지 않은 디렉토리입니다.");
			System.exit(0);
		} 
		
		//File객체가 디렉토리를 대상으로 했다면 그 내부의 모든 파일 및 서브디렉토리 또한 File객체로 만들어서 리턴해준다.
		File[] files = f.listFiles();

		for(int i=0; i < files.length; i++) {
			String fileName = files[i].getName();
			System.out.println(files[i].isDirectory() ? "["+fileName+"]" : fileName);
		}
	} // main
}
