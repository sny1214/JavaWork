package com.jica.io;

import java.io.*;

class BufferedOutputStreamEx1 {
	public static void main(String args[]) {
		try {
		     FileOutputStream fos = new FileOutputStream("123.txt");
		     
		     // BufferedOutputStream의 버퍼 크기를 5로 한다.
		     BufferedOutputStream bos = new BufferedOutputStream(fos, 5);
		     // 파일 123.txt에  1 부터 9까지 출력한다.
		     //               |--->123.txt화일
		     //               |    123456789
		     //fos 0x050--->[ | ,...]
		     //               ^
		     //bos 0x100--->[ | ,[54,55,56,57,0]] <== 실제값은 문자 '1','2','3','4','5'
		     //                     
		     //int i='1';  i의 값은 49이다 
		     for(int i='1'; i <= '9'; i++) {
			     bos.write(i);  //bos에 의한 출력은 내부버퍼에 먼저 출력되고
		     }                  //내부버퍼가 가득차면 fos에 연결된 123.txt화일에
		                        //한꺼번에 출력시킨다.  
		     bos.close();       //내부버퍼에 남아있는 데이타를 비워라-연결된 123.txt화일로 출력	
		     //결론으로 버퍼의 잔재를 비우려면
		     //1. bos.flush()
		     //2. bos.close()---->내부에서 flush()호출해준다.
		} catch (IOException e) {
		     e.printStackTrace();		
		}
	}
}
