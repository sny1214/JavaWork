package com.jica.chap11;

import java.util.*;

class HashMapEx2 {
	public static void main(String[] args) {
		HashMap<String,Integer> map = new HashMap<String,Integer>();
		
		map.put("김자바", new Integer(90));
		map.put("김자바", new Integer(100));
		map.put("이자바", new Integer(100));
		map.put("강자바", new Integer(80));
		map.put("안자바", new Integer(90));
		//                            key  value
		//                      |-->["김자바",100] 
		//                      |    |-->["이자바",100] 		
		//                      |    |    |-->["강자바",80]
		//                      |    |    |    |-->["안자바",90]
		//                      |    |    |    |  
		//               |--->[0x11,0x12,0x13,0x14,null,....,null]  Entry[]
		//map 0x100--->[0x10, ....]
		
		Set<Map.Entry<String, Integer>> set = map.entrySet();
		//it  0x202------------------------------------------------------v
		//set 0x200--->[["김자바",100],["이자바",100],["강자바",80],["안자바",90],...]
		//e   0x201 ------------------------------------------^   
		Iterator<Map.Entry<String, Integer>> it = set.iterator();

		while(it.hasNext()) {
			Map.Entry<String,Integer> e = (Map.Entry<String,Integer>)it.next();
			System.out.println("이름: "+ e.getKey() + ", 점수 : " + e.getValue());
		}

		Set<String> set2 = map.keySet();
		//                  |-->["김자바","이자바","강자바","안자바",null,null,...]     
		//set2 0x300----->[0x301,...]
		System.out.println("참가자 명단 : " + set2);

		Collection<Integer> values = map.values();
		//it2  0x401---------------------------v
		//                   |-->[100,100,80,90,null,null,...]     
		//values 0x400----->[0x401,...]
		
		Iterator<Integer> it2 = values.iterator();
		int total = 0;

		while(it2.hasNext()) {
			Integer i = (Integer)it2.next();
			total += i.intValue();
		}

		System.out.println("총점 : " + total);
		System.out.println("평균 : " + (float)total/set.size());
		System.out.println("최고점수 : " + Collections.max(values));
		System.out.println("최저점수 : " + Collections.min(values));
	}
}
