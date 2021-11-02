package com.jica.awt.profile;

import java.util.ArrayList;

public class ProfileManager {
	String owner;   
	
	//신상명세 데이타
	ArrayList<Profile> profiles = new ArrayList<Profile>();

	public ProfileManager() {
		super();		
	}

	public ProfileManager(String owner) {
		super();
		this.owner = owner;
	}
	
	//신규 신상명세 추가
	public Profile add(Profile profile) {
		//추가 하려는 데이타의 카테고리와 일치하는 카테고리가 있는지를 알아본다.
		profiles.add(profile);
		
		return profile;
	}
	
	//기존 데이타를 수정하는 메서드
	public Profile set(int index,Profile profile) {
		return profiles.set(index, profile);
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
	
	public boolean remove(Profile profile) {
		if( profile == null) {
			return false;
		}
		//아래의 remove()메서드 내부에서 equals()메서드를 이용하여
		//동일객체를 찾아서 제거해 준다.
		//현재의 예제에서는 성명이 같은 객체가 여러건이어도 첫번째로 찾아지는 객체를 삭제한다.
		return profiles.remove(profile);
	}
	
	//동일 성명을 가진 모든 Profile객체 삭제
	public int removeAll(Profile profile) {
		if( profile == null) {
			return 0;
		}
		
		//전체에서 로직으로 동일 성명을 가진 객체를 찿아서 삭제한다.
		int i = profiles.size()-1;
		if( i < 0 ) {
			return 0;
		}
		
		int cnt = 0;
		while(i >= 0) {
			Profile cur = profiles.get(i);
			if(profile.name.equals(cur.name)) {
				profiles.remove(i);
				cnt++;
			}
			i--;
		}
		return cnt; //삭제된 갯수
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
	
	int getIndex(String name) {
		
		int i = 0;
		boolean found = false;
		int pos = -1;
		while( !found && i< profiles.size() ) {
			Profile cur = profiles.get(i);
			if( name.equals(cur.name)) {
				found = true;
				pos = i;
			}
			i++;
		}
		return pos;
		
	}
	
	//이름으로 검색하여 객체를 리턴해 준다.
	ArrayList<Profile> getProfile(String name) {
		return getProfile(new Profile(name));
	}
	
	ArrayList<Profile> getProfile(Profile profile) {
		ArrayList<Profile> result = new ArrayList<Profile>();
		int i = 0;
		while(i < profiles.size()) {
			Profile cur = profiles.get(i);
			if( profile.name.equals(cur.name) ) {
				result.add(cur);
			}
			i++;
		}
		return result;
	}
	
	@Override
	public String toString() {
		return "ProfileManager [owner=" + owner + ", profiles=" + profiles + "]";
	}

}
