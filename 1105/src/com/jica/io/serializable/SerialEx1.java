package com.jica.io.serializable;

import java.io.*;
import java.util.ArrayList;

public class SerialEx1 {
	public static void main(String[] args) {
		try {
			String fileName = "UserInfo.ser";
			FileOutputStream     fos = new FileOutputStream(fileName);
			BufferedOutputStream bos = new BufferedOutputStream(fos);

			ObjectOutputStream out = new ObjectOutputStream(bos);
			
			//사용자가 만든 클래스(UserInfo - 직렬화가 가능)의 인스턴스
			UserInfo u1 = new UserInfo("JavaMan","1234",30);
			UserInfo u2 = new UserInfo("JavaWoman","4321",26);

			//객체를 1개씩 직렬화시켜 출력한다.
			out.writeObject(u1);
			out.writeObject(u2);
			
			//기존의 jdk에서 제공되는 클래스들도 Serializable interface를 구현해서 만든 클래스의 객체는
			//직렬화가 가능하다.
			ArrayList<UserInfo> list = new ArrayList<UserInfo>();
			list.add(new UserInfo("JICA","1111",21));
			list.add(new UserInfo("Jeonju","2222",1000));
			
			//ArrayList를 통채로 직렬화시켜 파일에 저장하는 것이 가능하다.
			out.writeObject(list);
			out.close();
			System.out.println("직렬화가 정상적으로 작동했습니다.");
		} catch(IOException e) {
			e.printStackTrace();
		}
	} // main
} // class
