package com.jica.io.serializable;

import java.io.*;

//상위클래스는 직렬화가 가능하지 않다.
class SuperUserInfo {
	String name;
	String password;

	SuperUserInfo() {
		this("Unknown","1111");
	}

	SuperUserInfo(String name, String password) {
		this.name = name;
		this.password = password;
	}
} // class SuperUserInfo


//하위 클래스는 직렬화가 가능하도록 Serializable을 구현한다.
public class UserInfo2 extends SuperUserInfo implements java.io.Serializable {
	int age;

	public UserInfo2() {
		this("Unknown", "1111", 0);
	}

	public UserInfo2(String name, String password, int age) {
		super(name, password);
		this.age = age;	
	}

	public String toString() {
		return "("+ name + "," + password + "," + age + ")";		
	}

	//아래의 메서드를 재정의 하지 않으면 age만 직렬화되어 저장되고,
	//상위클래스 SuperUserInfo의 멤버변수들은 저장되지 않는다.
	private void writeObject(ObjectOutputStream out)		//재정의함
		throws IOException {
		
		//디버깅용
		System.out.println("UserInfo2::writeObject(ObjectOutputStream).....");
		//사용자가 직접 상위클래스 멤버를 직렬화 메서드를 이용하여 저장한다.
		out.writeUTF(name);	
		out.writeUTF(password);	
		//현재 클래스의 멤버변수를 직렬화 시킨다.
		out.defaultWriteObject();
	}

	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {	//재정의함
		//디버깅용
		System.out.println("UserInfo2::readObject(ObjectInputStream).....");
		//사용자가 직접 상위클래스 멤버를 역직렬화 메서드를 이용하여 읽는다.
		name = in.readUTF();
		password = in.readUTF();
		//현재 클래스의 멤버변수를 역직렬화 시킨다.
		in.defaultReadObject();
	
	}
} // class UserInfo2 
