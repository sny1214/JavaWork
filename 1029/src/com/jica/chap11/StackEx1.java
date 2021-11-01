package com.jica.chap11;

import java.util.*;


//웹브라우저에서 앞으로 가기/뒤로 가기, 직접 url 입력 or 링크클릭 등 방문 기록에 대한 history 관리하는 기능이
//어떻게 동작하는지를 스택을 이용하여 작성

//스택은 pop(읽고 없앰), push, peek(끄집어내서 읽어주기만 하고 없애진 x)
public class StackEx1 {
	public static Stack<String> back    = new Stack<String>();
	public static Stack<String> forward = new Stack<String>();  

	public static void main(String[] args) {
		goURL("1.네이트");
		goURL("2.야후");
		goURL("3.네이버");
		goURL("4.다음");

		printStatus();

		goBack();
		System.out.println("= 뒤로가기 버튼 누른 후 =");  
		printStatus();

		goBack();
		System.out.println("= 뒤로가기 버튼 누른 후 =");  
		printStatus();

		goForward();
		System.out.println("= 앞으로가기 버튼 누른 후 =");  
		printStatus();

		goURL("JICA 사이트로 이동");
		System.out.println("= 새로운 주소로 이동후 =");  
		printStatus();
	}
	//back 	  0x100--------->[1.네이버,2.야후,3.네이버,JICA 사이트로 이동]
	//forward 0x200--------->goURL에 의해 지워짐
	
	
	//현재의 스택 상태를 보여주기
	public static void printStatus() {
		System.out.println("back:"+back);
		System.out.println("forward:"+forward);
		System.out.println("현재 화면은 '" + back.peek()+"' 입니다.");  
		System.out.println();
	}

	//특정 사이트로 직접 이동(Url 입력 또는 링크 클릭) -> back에 url 넣음, forword가 비어있지 않다면 비어준다.
	public static void goURL(String url){
		back.push(url);
		if(!forward.empty()) 
			forward.clear(); 
	}

	//앞으로가기 버튼
	public static void goForward(){			//forward가 비어있지 않으면 forward를 pop 시켜 back에 push
		if(!forward.empty())
			back.push(forward.pop());
	}

	//뒤로가기 버튼
	public static void goBack(){			//back이 비어있지 않으면 back을 pop(=끄집어내라)시켜라 -> forward에 push 시켜라
		if(!back.empty())
			forward.push(back.pop());
	}
}
