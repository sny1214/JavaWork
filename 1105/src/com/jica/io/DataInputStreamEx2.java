package com.jica.io;

import java.io.*;

class DataInputStreamEx2 {
	public static void main(String args[]) {
		int sum   = 0;
		int score = 0;

		FileInputStream fis = null;
		DataInputStream dis = null;

		try {
			fis = new FileInputStream("score.dat");
			dis = new DataInputStream(fis);
			//최종결과로 score.dat화일
			//||||||||||||||||||||| <--20byte
			// 100  90  95  85  50
			//sum   420
			//score 50
			while(true) {
				score = dis.readInt();    // 마지막에 읽을때 예외발생
				System.out.println(score);	
				sum += score;
			}
		} catch (EOFException e) {
			System.out.println("점수의 총합은 " + sum +"입니다.");
		} catch (IOException ie) {
			ie.printStackTrace();
		} finally {
			try {
				if(dis!=null)
					dis.close();			
			} catch(IOException ie){
				ie.printStackTrace();			
			}
		} // try
	} // main
}
