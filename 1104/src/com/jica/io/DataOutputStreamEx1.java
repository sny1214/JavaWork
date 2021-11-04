package com.jica.io;

import java.io.*;

class DataOutputStreamEx1 {
	public static void main(String args[]) {
		FileOutputStream fos = null;
		DataOutputStream dos = null;

		try {
			fos = new FileOutputStream("sample.dat");
			dos = new DataOutputStream(fos);
			//              |--->sample.dat file
			//              |      4   4 1    ?            8  
			//              |    ||||||||||binary-     |||||||||
			//fos 0x100--->[|,...]  fos.write(1byte혹은 bytep[])
			//              |  
			//dos 0x200--->[|,...]  dos.writeInt(정수값)
			//                      dos.writeDouble(실수값)
			//                      dos.writeBoolean(논리값)
			//                      dos.writeUTF(문자열)
			//                           ...  
			
			//기본자료형의 값은 byte[] 변환하여 출력한다.
			dos.writeInt(75);         //4byte
			dos.writeFloat(3.14159f); //4byte
			dos.writeBoolean(true);   //1byte
			dos.writeUTF("binary-이진화일로 출력"); //31byte
			dos.writeDouble(185.5);   //8byte  
				                      //전체크기가48byte 
			dos.close();
		} catch (IOException e) {
			e.printStackTrace();		
		}
	} // main
}
