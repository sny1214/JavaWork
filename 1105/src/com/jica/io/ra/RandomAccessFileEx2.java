package com.jica.io.ra;

import java.io.*;

class RandomAccessFileEx2 {
	public static void main(String args[]) {
//				       번호 국어  영어  수학				
		int[] score = {	1, 100,  90,  90,	
					    2,  70,  90, 100,
						3, 100, 100, 100, 
						4,  70,  60,  80, 
						5,  70,  90, 100
					   }; 

		try {
		      RandomAccessFile raf = new RandomAccessFile("score2.dat", "rw");
				//				  |--> score2.data
		        //				  |	   0   4   8    12  16 
				//				  |	   v bof(파일포인터의 최초 위치, 0번째) 		      
				//				  |bof0|||||||||||||||||| 				<--번호 4byte, 국어,영어, 수학 점수 4byte씩
		      	//				  |	 16||||||||||||||||||
		      	//				  |	 32||||||||||||||||||
		      	//				  |	 48||||||||||||||||||
		      	//				  |	 64||||||||||||||||||
				//				  |	   	  				^ eof (파일의 종료 위치)
				//raf 0x100 ---> [|...]
		      for(int i=0; i<score.length;i++) {
		             raf.writeInt(score[i]);				
		      }

		      while(true) {
			     System.out.println(raf.readInt());
		      }
		} catch (EOFException eof) {
			   System.out.println("파일포인터가 파일의 끝에 있으므로 데이타를 읽는데 예외가 발생했습니다.");
		} catch (IOException e) {
		       e.printStackTrace();		
		}
	} // main
}
