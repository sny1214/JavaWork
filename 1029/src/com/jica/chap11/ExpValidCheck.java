package com.jica.chap11;

import java.util.*;

//컴파일러가 수식의 문법오류를 검증할 때 괄호의 짝이 맞지 않음을 검사할 때도
//스택을 이용할 수 있다.
public class ExpValidCheck {
	public static void main(String[] args) {
	  	
	     int a = ((2+3)*1)+3;
	     
		Stack<String> st = new Stack<String>();
		String expression = "((2+3)*1)+3";
		
		
		System.out.println("expression:"+expression);
		
		try {
			for(int i=0; i < expression.length();i++){
				char ch = expression.charAt(i); 
				
				if(ch=='('){
					st.push(ch+"");
				} else if(ch==')') {	//)나올때마다 이미 push 되어 있었던 ( pop
					st.pop();	//스택이 비어있을 때 pop() 선택했을 때 예외 발생한다.
				}
			}
			
			if(st.isEmpty()){
				System.out.println("괄호가 일치하므로 완전한 문장입니다.");
			} else {
				System.out.println("괄호가 일치하지 않으므로 불안전한 문장입니다.");
			}
		} catch (EmptyStackException e) {
			e.printStackTrace();
			System.out.println("괄호가 일치하지 않으므로 불안전한 문장입니다.");		
		} // try
	}
}
