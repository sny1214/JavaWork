package com.jica.io;

import java.io.*;

class DataInputStreamEx3 {
	public static void main(String args[]) {
		int sum   = 0;
		int score = 0;
		//DataInputStreamEx2.java에서는 
		//try 블럭에서 스트림을 open하고(객체를 생성) finally블럭에서
		//close를 시켰다.
		//이를 단순화 시킨 try의 사용법을 현재예제에서 설명 --> 자동으로 close해준다.
		
		try (FileInputStream fis = new FileInputStream("score.dat");
		     DataInputStream dis = new DataInputStream(fis)) 
		{
			
			while(true) {
				score = dis.readInt();
				System.out.println(score);	
				sum += score;
			}
		} catch (EOFException e) {
			System.out.println("점수의 총합은 " + sum +"입니다.");
		} catch (IOException ie) {
			ie.printStackTrace();
		} // try
	} // main
}
