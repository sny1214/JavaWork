package com.jica.chap11;

import java.util.*;

class StackQueueEx {
	public static void main(String[] args) {
		Stack<String> st = new Stack<String>();

		
		st.push("0");
		st.push("1");
		st.push("2");

		System.out.println("= Stack =");
		while(!st.empty()) {
			System.out.println(st.pop());	//"2", "1", "0"
		}

		//Queue는 별도의 클래스가 없으므로 LinkedList를 사용했다
		Queue<String> q = new LinkedList<String>();	 
									//Queue형으로 선언하고 실제 객체는 LinkedList형으로 생성
								    // 상위형 참조변수에 하위형 인스턴스를 저장할 수 있다.
		
		q.offer("0");
		q.offer("1");
		q.offer("2");


		System.out.println("= Queue =");
		while(!q.isEmpty()) {
			System.out.println(q.poll());	//"0","1","2"
		}
	}
}
