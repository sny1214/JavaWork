package com.jica.io.ra;

import java.io.*;

class RandomAccessFileEx3 {
	public static void main(String args[]) {
		int sum = 0;

		try {
			RandomAccessFile raf = new RandomAccessFile("score2.dat", "r");
	      	//				       번호 국어  영어  수학				
			//		int[] score = {	1, 100,  90,  90,	
			//					    2,  70,  90, 100,
			//						3, 100, 100, 100, 
			//						4,  70,  60,  80, 
			//						5,  70,  90, 100
			//					   }; 
			
			//				  |--> score2.data
	        //				  |	   0   4   8    12  16 
			//				  |	   v bof(파일포인터의 최초 위치, 0번째) 		      
			//				  |bof0||||v|||||||||||||| 				<--번호 4byte, 국어,영어, 수학 점수 4byte씩
	      	//				  |	 16||||v||||||||||||||
	      	//				  |	 32||||v||||||||||||||
	      	//				  |	 48||||v||||||||||||||
	      	//				  |	 64||||v||||||||||||||
			//				  |	   	  				^ eof (파일의 종료 위치)
			//raf 0x100 ---> [|...]
			//i   4   20   36   52   68				=> 국어 점수끼리만 더함
			//sum 100 70   170  240  310
			int i=4;

			while(true) {
				raf.seek(i);
				sum += raf.readInt();	//100
				i+=16;
			}
		} catch (EOFException e) {
			System.out.println("sum : " + sum);
		} catch (IOException e) {
			e.printStackTrace();		
		}
	}
}
