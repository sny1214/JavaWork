package com.jica.chap11;

import java.util.*;

class HashSetLotto {
	public static void main(String[] args) {
		Set<Integer> set = new HashSet<Integer>();
		
		//i = 			0 							1...6......(난수갯수 <--중복될 수록 i만 증가)
		//set.size()	0 -> 6보다 작으므로 난수 발생	1...5	   (set 내의 난수 총 갯수)
		//set 0x100 --------->[난수, ....., 난수] --> 난수 중복된다면 set에 포함 안되고 i만 증가
		for (int i = 0; set.size() < 6 ; i++) {
			int num = (int)(Math.random()*45) + 1;	//1~45
			set.add(Integer.valueOf(num));
		}
		System.out.println("로또번호 : " + set);
		//위의 set 요소를 차례로 접근하고 싶다? = 정렬시키고 싶다 -> 자체적으로는 방법이 없다.(set은 순서 관리x)
		//그래서 공통의 접근방법인 Iterator를 사용한다.	<--순서 관리 안하는 set이나 map에게 아주 유용!
		Iterator<Integer> it = set.iterator();
		while(it.hasNext()) {
			System.out.print(it.next() + " ");	//한줄로 출력 print, 각각 한칸씩 띄어쓰기
		}
		System.out.println();	//다음출력할 것은 다음 줄로 출력
		
		//사용자에게 숫자 순서대로 정렬시켜 보여주고 싶다.
		//그런데 set은 순서가 없으므로 정렬기능이 지원되지 않는다.
		//그래서 set을 List로 변형하여 객체를 생성한다.
		
		List<Integer> list = new LinkedList<Integer>(set);	// LinkedList(Collection c)	<-Collection을 생성자로 갖는 다는 건 List도 되고 Set도 된다(List, Set 서로 상속 다름)
		Collections.sort(list);				// Collections.sort(List list)
		System.out.println(list);
	}
}
