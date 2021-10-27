package com.jica.profile;

import java.util.Scanner;

public class ManageProfile extends Profile {

	Profile profiles[];
		
		// 추가, 수정, 삭제, 검색 메서드

	
	int profileCount;

	public ManageProfile() {
		 profiles = new Profile[500];

	}
	
	public Profile add(Profile profile) {
		if(profileCount < 500) {
			Profile addProfile = new Profile();
			profiles[profileCount] = addProfile;
			
			profileCount++;
			return addProfile;
		}else {
			return null;
		}
	}
	public void modify() {
		
	}

	
}
//전체 목록 보기
public static void main(String[] args) {
	
	Scanner scanner = new Scanner(System.in);
	System.out.print("이름을 입력하시오 ==> ");
	profile.setName() = scanner.nextLine();
	
	Scanner scanner = new Scanner(System.in);
	System.out.print("나이를 입력하시오 ==> ");
	profile.setAge() = scanner.nextInt();
	
	Scanner scanner = new Scanner(System.in);
	System.out.print("이메일을 입력하시오 ==> ");
	profile.setEmail() = scanner.nextLine();
	
	Scanner scanner = new Scanner(System.in);
	System.out.print("번호를 입력하시오(예:010-****-****) ==> ");
	profile.setNumber() = scanner.nextLine();
	
	Scanner scanner = new Scanner(System.in);
	System.out.print("이름을 입력하시오(예: 남, 여) ==> ");
	profile.setSex() = scanner.nextchar();
	
	Scanner scanner = new Scanner(System.in);
	System.out.print("특이사항을 입력하시오 ==> ");
	profile.setCharacter() = scanner.nextLine();

	