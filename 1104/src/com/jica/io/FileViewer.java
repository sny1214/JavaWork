package com.jica.io;
import java.io.*;

class FileViewer {
	public static void main(String args[]) throws  IOException {
		//FileInputStream(String name) throws FileNotFoundException
		//화일명을 기술할때 path를 지정하지 않으면 현재프로젝트의 디렉토리에서 화일을 찿ㄴ는다.		
		//FileInputStream fis = new FileInputStream("Hello.java");	
		
		//경로(path)를 지정
		//문자열 내부에서 슬래쉬(\)를 사용하면 이후 문자는 제어문자로 해석되므로
		//슬래쉬를 문자값으로 인식시키려면 슬래쉬를 한번 더 사용해야 한다.
		FileInputStream fis = null;
		
		//화일관련 io스트림 객체를 생성하면 io스트림을 open했다고 한다.
		//화일관련 io스트림 객체는 사용이 끝나면 close하기를 권장 
		fis = new FileInputStream("C:\\JKWork\\JavaWork\\0928\\src\\Hello.java");
		
		
		//한글을 포함한 화일은 FileInputStream은 1byte단위로만 읽으므로
		//문자변환시 깨져나타나는것에 주의해야 합니다.(해결책-FileReader 사용)

		int data = 0;

		int cnt = 0;
		while((data=fis.read())!=-1) {
			cnt++;
			char c = (char)data;
			System.out.print(c);
			//System.out.print(data);
		}

		fis.close();
		System.out.println();
		System.out.println("--------------------------");
		System.out.println("읽은 byte수 : " + cnt);
	} 
}
