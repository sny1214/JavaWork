package com.jica.exam;

public class ScoreProcess2 {

	public static void main(String[] args) {
		//객체 선언 및 생성
//		Student student1; //선언
//		student1 = new Student(); //생성
		Student student1 = new Student();
		
		//					   name	  score[]   total  average  grade
		//							  [0,0,0] 
		//student1 0x100 ---> [null,   0x500,     0,      0.0,    ' ' ]
		//					 "홍길동",[70,80,95],|------메서드로 계산------|
		
		//객체 사용
		student1.name = "홍길동";
		student1.score = new int[] {70, 80, 95};
		//student1.score[0] = 70;
		//student1.score[1] = 80;
		//student1.score[2] = 95;
		
		student1.calTotal();
		student1.calAverage();
		student1.calGrade();
	
		student1.display();
		
	}

	
	
}
