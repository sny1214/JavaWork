package com.jica.io.character;

import java.io.*;

class StandardIOEx1 {
	public static void main(String[] args) {
		try {
			int input = 0;
            
			//키보드 -----------키보드버퍼[A|B|C|D|\r|\n|....]
			//'a' 출력하면 키보드 버퍼[|B|C|D|\r|\n|....]
			//....
			//\r : 아스키 코드 13, \n : 아스키 코드 10   --> 상응하는 문자값은 없음
			//키보드 버퍼 결국 [||||||||...] 비면서 반복문 끝나
			//키보드 입력 끝났다는 신호 : ENTER or Ctrl+z
			//키보드로 ctrl-z을 눌렀을때가 -1이다
			
			while((input=System.in.read()) != -1) {
				System.out.println("input :" + input + ", (char)input :" + (char)input);	//'a', 'b', 'c', 'd'
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	} // main
}
