package com.jica.io.character;

import java.io.*;

class BufferedReaderEx1 {
	public static void main(String[] args) {
		try {
			FileReader fr = new FileReader("C:\\JKWork\\JavaWork\\1105\\src\\com\\jica\\io\\character\\BufferedReaderEx1.java");
			BufferedReader br = new BufferedReader(fr);
			//외부적인 사용법은 동일하고 내부에 버퍼를 이용하므로
			//물리적인 file의 접근횟수를 줄여서 처리속도를 향상시키는 기능을 가졌다.
			String line = "";
			for(int i=1;(line = br.readLine())!=null;i++) { 
				//  ";"을 포함하고 있는 줄만 라인번호와 함께 화면에 출력한다.
				if(line.indexOf(";") != -1)	
					System.out.println(i+":"+line);
			}
                     
            br.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	} // main
}
