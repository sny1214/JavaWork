package com.jica.io;

import java.io.*;

class DataOutputStreamEx3 {
	public static void main(String args[]) {
		int[] score = { 100, 90, 95, 85, 50 }; 

		try {
			FileOutputStream fos = new FileOutputStream("score.dat");
			DataOutputStream dos = new DataOutputStream(fos);

			for(int i=0; i<score.length;i++) {
				dos.writeInt(score[i]);				
			}
			//최종결과로 score.dat화일
			//||||||||||||||||||||| <--20byte
			// 100 90   95  85  50
			dos.close();
		} catch (IOException e) {
			e.printStackTrace();		
		}
	} // main
}
