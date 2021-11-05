package com.jica.io.serializable;

import java.io.*;
import java.util.ArrayList;

public class SerialEx3 {
	public static void main(String[] args) {
		try {
			String fileName = "UserInfo2.ser";
			
			FileOutputStream     fos = new FileOutputStream(fileName);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			ObjectOutputStream out = new ObjectOutputStream(bos);
			
//			//사용자가 만든 클래스(SuperUserInfo-직렬화가 불가능)의 인스턴스
//			SuperUserInfo u1 = new SuperUserInfo("JavaMan","1234");
//			SuperUserInfo u2 = new SuperUserInfo("JavaWoman","4321");
//	
//			// 객체를 1개씩 직렬화 시켜 출력한다.
//			out.writeObject(u1);	//NotSerializableException 발생
//			out.writeObject(u2);
			
			
			UserInfo2 u1 = new UserInfo2("JavaMan","1234",25);
			UserInfo2 u2 = new UserInfo2("JavaWoman","4321",36);
	
			// 객체를 1개씩 직렬화 시켜 출력한다.
			out.writeObject(u1);	//정상? -> 실행은 되지만, writeObject와 readObject를 재정의 하지 않으면
			out.writeObject(u2);	//		  age만 직렬화되어 저장되고, 상위클래스 SuperUserInfo의 멤버변수들은 저장되지 않는다.
			
			
			// 기존의 jdk에서 제공되는 클래스들도 Serializable interface를 구현해서 만든 클래스의 객체는
			// 직렬화가 가능하다.
			ArrayList<UserInfo2> list = new ArrayList<UserInfo2>();
			list.add(new UserInfo2("JICA","1111", 21));
			list.add(new UserInfo2("Jeonju","2222", 1000));

			//ArrayList를 통채로 직렬화시켜 화일에 저장하는 것이 가능한다.
			out.writeObject(list);
			
			out.close();
			System.out.println("직렬화가 정상적으로 작동했습니다.");
		} catch(IOException e) {
			e.printStackTrace();
		}
	} // main
} // class
