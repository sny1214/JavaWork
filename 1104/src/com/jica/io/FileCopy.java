package com.jica.io;

import java.io.*;

class FileCopy {
	public static void main(String args[]) {
		//예외처리구문 내부에 코드를 작성한 이유
		//FileInputStream의 생성자와 read()메서드에서 예외를 던지기 때문이다.
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		FileOutputStream fos = null;
		BufferedOutputStream bos = null;
		try {
			//test.txt를 복사하여 test2.txt를 만들자
			//FileInputStream 생성자에서 지정된 화일이 존재하지 않으면 예외발생(FileNotFoundException)
			fis = new FileInputStream("Hello.java");
			bis = new BufferedInputStream(fis);
			
			//FileOutputStream 생성자에서 지정된 화일이 존재하지 않아도 예외가 발생하지 않는다.
			//그리고 0byte로 화일이 생성되고, 존재하면 기존내용을 지우고 내용만 덮어쓴다.
			fos = new FileOutputStream("Hello2.java");
			bos = new BufferedOutputStream(fos);
			
			
			int data = 0;
			//더이상 화일로부터 읽을 데이타가 없을때 read()메서드가 -1을 리턴한다.
			//-1을 EOF(End Of File)라고 표현하기도 한다
			while((data = bis.read()) != -1) {
				bos.write(data);	 // void write(int b)
				//읽은 1byte를 문자로 변환없이 그대로 출력시키므로 한글이 깨지는 문제등은 발생하지 않는다.
			}

			//아래의 코드를 권장한다.
			//FileInputStream,FileOutputStream객체를 생성하면
			//내부적으로 많은 메모리를 사용하여 준비기능이 동작한다.
			//모든 작업이 끝났다면 메모리를 소거시키는 close() 사용을 권장한다.
			//fis.close();
			//fos.close();
			bis.close();
			bos.close();
		} catch (IOException e) {
			e.printStackTrace();		
		}
	}
}
