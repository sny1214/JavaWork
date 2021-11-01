package com.jica.address;

import java.util.ArrayList;
import java.util.List;

/*  실습한 Profile객체를 사용하여  ProfileManager 클래스를 만들어서
	주소록 관리 기능을 작성하시오.

	class ProfileManager{
   		ArrayList<Profile> profiles = new ArrayList<Profile>();
   
   생성자
   추가메서드()
   수정메서드()
   삭제메서드()
   검색메서드()
   정렬메서드()
   전체목록보기메서드()
} */

public class ProfileManager {
	ArrayList<Profile> profiles = new ArrayList<Profile>();

	ProfileManager() {
		super();
	}

	ProfileManager(ArrayList<Profile> profiles) {
		super();
		this.profiles = profiles;
	}
	
	
	//추가 메서드
	 void addProfile(Profile p){
		 profiles.add(p);		
	}

	 
	//검색 메서드
	void searchProfile(String n) {
		Profile newp = new Profile(n);						
		boolean found = profiles.contains(newp);
		System.out.println( n + "데이터 존재여부 : " + found);		
	}
	 	 
	//수정 메서드
	Profile modifyProfile(String o,int index, Profile n) {
		
		int pos = profiles.indexOf(o);				//indexOf : 객체를 찾아라, pos : 몇번째 인지 알고 싶어 준 변수
		if(pos == -1) {								//디버깅용 출력열이 출력되는 것을 보면, indexOf도 equals 작동함을 알 수 있음
			System.out.println("데이터는 존재하지 않습니다");
		}else {
			Profile result = profiles.get(pos);		//profiles의 몇번째 데이터
			System.out.println("데이터 위치는 " + pos + "번째 이고 아래는 자세한 신상명세 입니다.");
			System.out.println(result);
		}
		Profile result = profiles.get(pos);	
		
		return ((List<Profile>) result).set(index, n);
	}	
		

	 //삭제 메서드
	 void removeProfile(String n) {
		 Profile newp = new Profile(n);	
		 boolean removed = profiles.remove(newp);	
		 System.out.println(newp.name + " 객체의 삭제 결과 : " + removed);
		 System.out.println(profiles);		
	}


	
	//정렬 메서드
	 void sortProfile() {
		 
	 }
	 
	//전체보기 메서드
	
	@Override
	public String toString() {
		return "ProfileManager [profiles=" + profiles + "]";
	}
	
}


