package com.jica.io;

import java.io.*;

class DataInputStreamEx1 {
	public static void main(String args[]) {
		try {
			//반드시 sample.dat 화일이 존재해야 한다.
			FileInputStream fis = new FileInputStream("sample.dat");
			DataInputStream dis = new DataInputStream(fis);
			//              |--->sample.dat file
			//              |      4   4 1    ?            8  
			//              |    ||||||||||binary-     |||||||||
			//              |                                  ^
			//fis 0x100--->[|,...]  fis.read(1byte혹은 byte[])
			//              |  
			//dis 0x200--->[|,...]  dis.readInt()
			//                      dis.readDouble()
			//                      dis.readBoolean()
			//                      dis.readUTF()
			
			//아래의 코드에서 중요한것을 출력시킨 순서대로 읽어야 올바르게 읽혀진다.
			//저장된 데이타의 구조를 모르면 올바르게 읽을수가 없다.
			int score = dis.readInt();
			float height = dis.readFloat();
			boolean flag = dis.readBoolean();
			String message = dis.readUTF();
			double height2 = dis.readDouble();
			
			System.out.println(score);
			System.out.println(height);
			System.out.println(flag);
			System.out.println(message);
			System.out.println(height2);
			dis.close();
		} catch (IOException e) {
			e.printStackTrace();		
  		}
	} // main
}
