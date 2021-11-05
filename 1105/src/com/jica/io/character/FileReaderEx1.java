package com.jica.io.character;
import java.io.*;

class FileReaderEx1 {
	public static void main(String args[]) {
		try {
			String fileName = "test.txt";
			//byte단위의 입력
			FileInputStream fis = new FileInputStream(fileName);

			int data =0;
			// FileInputStream을 이용해서 파일내용을 읽어 화면에 출력한다.
			while((data=fis.read())!=-1) {
				System.out.print((char)data);
			}
			System.out.println();
			fis.close();
			System.out.println("------------------------");
			
			//자체적으로 문자단위로 읽기 기능을 수행하는 문자기반 FileReader
			FileReader	    fr  = new FileReader(fileName);

			// FileReader를 이용해서 파일내용을 읽어 화면에 출력한다.
			while((data=fr.read())!=-1) {
				//System.out.println(data);
				System.out.print((char)data);
			}
			System.out.println();
			fr.close();				

		} catch (IOException e) {
				e.printStackTrace();		
		}
	} // main
}
