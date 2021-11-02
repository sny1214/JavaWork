package com.jica.awt.profile;

import java.util.ArrayList;

public class ProfileManager0 {
	String owner;   
	
	//신상명세 데이타
	ArrayList<Profile> profiles = new ArrayList<Profile>();

	public ProfileManager0() {
		super();		
	}

	public ProfileManager0(String owner) {
		super();
		this.owner = owner;
	}
	
	//신규 신상명세 추가
	public Profile add(Profile profile) {
		//추가 하려는 데이타의 카테고리와 일치하는 카테고리가 있는지를 알아본다.
		profiles.add(profile);
		
		return profile;
	}
	
	// 데이타 삭제
	public boolean remove(int index) {
		if( index < 0 || index > profiles.size()-1) {
			return false;
		}else {
			profiles.remove(index);
			return true;
		}
	}
	
	//전체내용에서 성명만을 배열로 만들어서 리턴하는메서드
	String[] getNames() {
		String names[] = new String[profiles.size()];
		for(int i=0; i<profiles.size(); i++) {
			names[i] = profiles.get(i).name;
		}
		return names;
	}
	
	//지정된 순서번째 객체를 리턴해 준다.
	Profile getProfile(int index) {
		if(index >= 0 && index < profiles.size()) {
			return profiles.get(index);
		}else {
			return null;
		}
	}
	
	@Override
	public String toString() {
		return "ProfileManager [owner=" + owner + ", profiles=" + profiles + "]";
	}

}
