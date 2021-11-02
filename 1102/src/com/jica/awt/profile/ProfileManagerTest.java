package com.jica.awt.profile;

import java.util.ArrayList;

public class ProfileManagerTest {

	public static void main(String[] args) {
		ProfileManager manager = new ProfileManager("JICA");
		
		//int cCode, String name, int gender, int year, String phone, String email, String memo

		Profile profile1 = new Profile("홍길동",1,1994,"010-1111-1111","hgd@daum.net",null);
		manager.add(profile1);
		
		Profile profile2 = new Profile("장길산",2,1998,"010-2222-2222","jgs@naver.com",null);
		manager.add(profile2);
		
		Profile profile3 = new Profile("이순신",1,1997,"010-3333-3333","lss@gmail.net",null);
		manager.add(profile3);	
		
		Profile profile4 = new Profile("고주몽",2,1994,"010-4444-4444","gjm@naver.com",null);
		manager.add(profile4);		
		
		Profile profile5 = new Profile("강감찬",1,1995,"010-5555-5555","ggchan@daum.net","JICA 수강생");
		manager.add(profile5);	
		
		System.out.println(manager);
		
		Profile profile6 = new Profile("고주몽",1,2001,"010-6666-6666","gjm@gmail.com","전주 거주인");
		manager.add(profile6);
		
		System.out.println(manager);
		
		ArrayList<Profile> result = manager.getProfile("고주몽");
		System.out.println(result);
		
		//삭제 - 1건만 삭제
		//boolean removed = manager.remove(profile6); //고주몽
		//System.out.println("삭제 결과 : " + removed);
		//System.out.println(manager);
		
		//삭제 - 동일이름을 가진 모든 Profile객체 삭제
		int cnt = manager.removeAll(profile6);
		System.out.println("삭제된 갯수 : " + cnt);
		System.out.println(manager);
		
		//내용 수정
		Profile tmp = new Profile("장길산",1,2005,"010-7777-7777","jgs@jica.kr","변경 데이타");
		manager.set(1, tmp);
		//1번째 데이타 수정후 출력
		System.out.println(manager);
	}
}
