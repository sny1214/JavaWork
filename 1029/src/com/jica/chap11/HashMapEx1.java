package com.jica.chap11;

import java.util.*;

class HashMapEx1 {
	public static void main(String[] args) {
		HashMap<String,String> map = new HashMap<String,String>();
		
		//추가
		map.put("myId", "1234");
		map.put("asdf", "1111");
		map.put("asdf", "1234");
		//                            key    value
		//                      |-->["myId","1234"] 
		//                      |    |-->["asdf","1234"] 		
		//                      |    |
		//                      |    |
		//               |--->[0x11,0x12,null,......]  Entry[]
		//map 0x100--->[0x10, ....]
		
		System.out.println(map);
		System.out.println("------------------------------");
		Scanner s = new Scanner(System.in);	

		while(true) {
			System.out.println("id와 password를 입력하시오.");
			System.out.print("id :");
			String id = s.nextLine().trim();  //"jica","asdf"

			System.out.print("password :");
			String password = s.nextLine().trim(); //"1234","1111"
			System.out.println();

			if(!map.containsKey(id)) {
				System.out.println("입력하신 id가 존재하지 않습니다. 다시 입력해 주세요.");
				continue;
			} else {
				if(!(map.get(id)).equals(password)) {
					System.out.println("비밀번호가 일치하지 않습니다. 다시 입력해 주세요.");
				} else {
					System.out.println("id와 패스워드가 일치합니다.");						
					break;
				}
			}
		} 
	} 
}
