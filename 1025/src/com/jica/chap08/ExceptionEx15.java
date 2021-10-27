package com.jica.chap08;

import java.io.*;

class ExceptionEx15 {
	public static void main(String[] args) {
        // command line 명령행 인자로 전달받은 이름으로 파일을 생성한다.
		String fName = null;
		File f = createFile(fName);		//createFile 메서드 실행하라
		System.out.println( f.getName() + " 파일이 성공적으로 생성되었습니다.");
	} // main�޼����� ��

	@SuppressWarnings("finally")
	static File createFile(String fileName) { //"jica.txt"		
		try {
			if (fileName==null || fileName.equals(""))
				throw new Exception("파일이름이 유효하지 않습니다.");
		} catch (Exception e) {
             // fileName이 null이거나 빈 문자열("")이면 파일 이름을 제목없음.txt로 한다.
			fileName = "제목없음.txt";	 
		} finally {
			File f = new File(fileName); // File형 객체생성
			createNewFile(f);		     // 사용자가 만든 실제 file 메서드
			return f;
		}
	}	// createFile�޼����� ��

	static void createNewFile(File f) {
		try {
			f.createNewFile();		// File객체의 정보를 이용하여 실제 물리적인 file이 생성된다.
		} catch(Exception e){ 
			//file 생성 중 오류발생 시의 처리
		}
	}	// createNewFile�޼����� ��
} 
