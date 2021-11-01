package com.jica.chap11;

import java.util.*;

class HashMapEx3 {
	//static HashMap<String,HashMap<String,String>> phoneBook = new HashMap<String,HashMap<String,String>>();  
	static HashMap phoneBook = new HashMap();
    //그룹을 가진 주소록을 관리하는 HashMap
	// key       value
	//----------------------
	//        key         key 
	// 친구 - 010-111-1111,이자바
	//       010-222-2222,김자바
	//       010-333-3333,김자바
	// 회사 - 010-444-4444,김대리
	//       010-555-5555,김대리
	//       010-666-6666,박대리
	//       010-777-7777,이과장
	// 기타 - 010-888-8888,세탁


	public static void main(String[] args) {
		addPhoneNo("친구", "이자바", "010-111-1111");
		addPhoneNo("친구", "김자바", "010-222-2222");
		addPhoneNo("친구", "김자바", "010-333-3333");
		addPhoneNo("회사", "김대리", "010-444-4444");
		addPhoneNo("회사", "김대리", "010-555-5555");
		addPhoneNo("회사", "박대리", "010-666-6666");
		addPhoneNo("회사", "이과장", "010-777-7777");
		addPhoneNo("세탁", "010-888-8888");

		printList();
	} // main

	// 그룹을 추가하는 메서드
	static void addGroup(String groupName) {
		if(!phoneBook.containsKey(groupName))
			phoneBook.put(groupName, new HashMap());
	}
	//                                       
	//                                        |-->[["010-111-1111","이자바"],["010-222-2222","김자바"],["010-333-3333","김자바"]
	//                            |-->["친구",0x400]
	//                            |                 |-->[["010-444-4444","김대리"],["010-555-5555","김대리"],["010-666-6666","박대리"],["010-777-7777","이과장"]]
	//                            |     |-->["회사",0x600]
	//                            |     |                 |-->[["010-888-8888","세탁"]]
	//                            |     |     |-->["기타",0x800]
	//                      |-->[0x300,0x500,0x700,null,....]  
	//phoneBook 0x100---->[0x200,...]
	
	// 그룹에 전화번호를 추가하는 메서드 "기타", "세탁", "010-888-8888"
	static void addPhoneNo(String groupName, String name, String tel) {
		addGroup(groupName);
		HashMap group = (HashMap)phoneBook.get(groupName);
		group.put(tel, name);	
	}

	//"세탁", "010-888-8888"
	static void addPhoneNo(String name, String tel) {
		addPhoneNo("기타", name, tel);
	}

	//전체 주소록 목록을 출력하시오.
	static void printList() {
		Set set = phoneBook.entrySet();
		Iterator it = set.iterator();	

		while(it.hasNext()) {
			Map.Entry e = (Map.Entry)it.next();

			Set subSet = ((HashMap)e.getValue()).entrySet();
			Iterator subIt = subSet.iterator();	

			System.out.println(" * "+e.getKey()+"["+subSet.size()+"]");

			while(subIt.hasNext()) {
				Map.Entry subE = (Map.Entry)subIt.next();
				String telNo = (String)subE.getKey();
				String name = (String)subE.getValue();
				System.out.println(name + " " + telNo );
			}
			System.out.println();
		}
	} // printList()
} // class
