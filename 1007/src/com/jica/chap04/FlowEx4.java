package com.jica.chap04;

import java.util.Scanner;

class FlowEx4 {
	public static void main(String[] args) { 
		int score  = 0;   
		char grade =' ';  

		Scanner scanner = new Scanner(System.in);
		System.out.print("점수를 입력하세요 >> ");

		String tmp = scanner.nextLine(); // 문자열 입력     - "87", "96"
		score = Integer.parseInt(tmp);   // 정수 값으로 변환 -  87 ,  96
		
		if (score >= 90) {         
			 grade = 'A';             
		} else if (score >=80) {   
			 grade = 'B'; 
		} else if (score >=70) {   
			 grade = 'C'; 
		} else {                   
			 grade = 'D'; 
		}
            
		System.out.println("당신의 학점은 "+ grade +"입니다."); 
	}
}
