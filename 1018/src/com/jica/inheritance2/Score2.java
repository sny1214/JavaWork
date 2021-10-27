package com.jica.inheritance2;

import java.util.Arrays;

//기존 Score클래스에 학점을 관리하는 기능을 
//상속받아 추가하자
public class Score2 extends Score{
	char grade;
	
	//생성자는 상속받을수 없다.
	public Score2() {		
	}

	public Score2(String name, int score1, int score2, int score3) {
		this.name = name;
		score[0] = score1;
		score[1] = score2;
		score[2] = score3;
		//현재 클래스에는 name, score[] 가 없다. 그런데도 사용할 수 있다.
		//이유는 상속받은 클래스에서는 상위클래스의 멤버를 자유롭게 접근할 수 있기 때문이다.
	}

	public Score2(String name) {
		this.name = name;
	}
	
	public char calGrade() {
		int tAverage = (int)(average * 0.1);
		
		switch(tAverage) {
		case 10:
		case 9 : grade = 'A'; break;
		case 8 : grade = 'B'; break;
		case 7 : grade = 'C'; break;
		case 6 : grade = 'D'; break;
		default: grade = 'F';			
		}
		
		return grade;
	}
	
	@Override
	void display() {
		super.display();  //부모클래스의 display()호출
		System.out.println(" 학점: " + grade);
	}

	@Override
	public String toString() {
		return "Score2 [grade=" + grade + ", name=" + name + ", score=" + Arrays.toString(score) + ", total=" + total
				+ ", average=" + average + "]";
	}
		
}
