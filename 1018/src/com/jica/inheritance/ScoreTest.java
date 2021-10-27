package com.jica.inheritance;

public class ScoreTest {

	public static void main(String[] args) {
		Score s1 = new Score();
		s1.name = "홍길동";
		s1.score[0] = 70;
		s1.score[1] = 80;
		s1.score[2] = 88;
		s1.calTotal();
		s1.calAverage();
		s1.calGrade();
		s1.display();		
		System.out.println(s1);
		//                 name     score[]   total average    grade
		//s1 0x100-------->["홍길동",[70,80,88], 238,  79.333333, 'C']

		Score s2 = new Score("장길산", 60, 70 ,48);
		//                 name     score[]   total average  
		//s2 0x200-------->["장길산",[60,60,48], 178,  59.333333, 'F']
		s2.calTotal();
		s2.calAverage();
		System.out.println(s2);
	}

}
