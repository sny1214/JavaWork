package com.jica.io.ra;

import java.io.*;

class RandomAccessFileEx1 {
	public static void main(String[] args) {
		try {
			RandomAccessFile raf = new RandomAccessFile("test.dat", "rw");
			//				  |--> test,.data
			//				  |	   v bof(파일포인터의 최초 위치, 0번째) 
			//				  |	   |100||||
			//				  |	   		  ^ eof (파일의 종료 위치)
			//			  	  |	   |100||||||||||||
			//				  |          		  ^ eof (파일의 종료 위치)
			//raf 0x100 ---> [|...]
			System.out.println("파일 포인터의 위치 : " + raf.getFilePointer());	//0
			raf.writeInt(100);
			System.out.println("파일 포인터의 위치 : " + raf.getFilePointer());	//4
			raf.writeLong(100L);
			System.out.println("파일 포인터의 위치 : " + raf.getFilePointer()); //12
			
			raf.seek(0);	//파일포인터의 위치를 처음 위치로 이동시킨다.
			raf.writeInt(75);
			System.out.println("파일 포인터의 위치 : " + raf.getFilePointer()); //4
			raf.seek(0);
			int value = raf.readInt();
			System.out.println("첫 4byte를 읽은 값 : " + value);				//75
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
