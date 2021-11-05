package com.jica.io.serializable;

import java.io.*;
import java.util.ArrayList;

public class SerialEx4 {
	public static void main(String[] args) {
		try {
			String fileName = "UserInfo2.ser";
			
			FileInputStream     fos = new FileInputStream(fileName);
			BufferedInputStream bos = new BufferedInputStream(fos);
			ObjectInputStream ois = new ObjectInputStream(bos);
					
			//역직렬화 시켜 객체를 생성
			UserInfo2 u1 = (UserInfo2)ois.readObject();
			UserInfo2 u2 = (UserInfo2)ois.readObject();

			ArrayList<UserInfo2> list = new ArrayList<UserInfo2>();
			
			//ArrayList를 역직렬화시켜 파일에서 읽어서 생성한다.
			list = (ArrayList<UserInfo2>)ois.readObject();
			
			ois.close();
			
			System.out.println(u1);
			System.out.println(u2);
			System.out.println(list);
			System.out.println("역직렬화가 정상적으로 작동했습니다.");
		} catch(IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} // main
} // class

