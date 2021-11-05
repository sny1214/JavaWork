package com.jica.io.serializable;

import java.io.*;
import java.util.ArrayList;

public class SerialEx2 {
	public static void main(String[] args) {
		try {
			String fileName = "UserInfo.ser";
			FileInputStream     fis = new FileInputStream(fileName);
			BufferedInputStream bis = new BufferedInputStream(fis);

			ObjectInputStream ois = new ObjectInputStream(bis);

			//사용자 객체를 역직렬화를 시도하는 코드
			UserInfo u1 = (UserInfo)ois.readObject();
			UserInfo u2 = (UserInfo)ois.readObject();
			
			//ArrayList를 역직렬화를 시도하는 코드
			ArrayList<UserInfo> list = (ArrayList<UserInfo>)ois.readObject();

			//직렬화 결과 확인
			System.out.println(u1);
			System.out.println(u2);
			System.out.println(list);
			ois.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	} // main
} // class
