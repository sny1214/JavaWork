package com.jica.profile;

import java.util.ArrayList;
import java.util.Scanner;

public class ManageProfile extends Profile {

	Profile profiles[];
	//총 갖고있는 프로필 갯수(사람수)
	public static final int MAX_ITEM_COUNT = 10;	//최대 10명 프로필 저장가능
	int profileCount;
	
	
	
	
	//프로필 관리 메서드 - 추가, 수정, 삭제, 검색, 전체 보여주는 기능
	
	//추가 기능
	public void add() {
		Scanner scanner = new Scanner(System.in);
		String inputProfile = scanner.nextLine();
		String[] arr  = inputProfile.split(",");
		
//		System.out.println(String.join("-", arr));
		
		Profile[] profile = new Profile[7];
		for(int i=0; i<7 ; i++) {
			profile[i] = arr[i];
			profileCount++;
		}
		
		
		
	}
	
	//수정 기능
	public void modify() {
		
	}

	//삭제
	
	//검색
	
	//전체 보여주기
	

//전체 목록 보기
	public static void main(String[] args) {

	}
}