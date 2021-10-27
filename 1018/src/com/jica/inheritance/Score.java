package com.jica.inheritance;

import java.util.Arrays;

//성명과 세점수를 관리하는 클래스
//학점을 관리하는 기능을 추가하였다
//1. char grade
//2. char calGrade()
//3. display(), toString()메서드를 변경하였다.

public class Score{	
	String name;
	int score[] = new int[3];
	int total;
	double average;
	char grade;
	
    Score() {		
	}
	
	Score(String name){
		this.name = name;
	}
	
	Score(String name, int score1, int score2, int score3){
		this.name = name;
		score[0] = score1;
		score[1] = score2;
		score[2] = score3;
	}
	
	int calTotal() {
		total = 0;
		for( int i=0; i<score.length;i++) {
			total += score[i];
		}
		return total;
	}
	
	double calAverage() {
		average = total / 3.0;
		return average;
	}
	
	void display() {
		System.out.println("성명: " + name);
		System.out.println("점수들: " + score[0] + "," + score[1] + "," + score[2]);
		System.out.printf("총점:%d, 평균: %6.2f, 학점:%c", total , average, grade);
		System.out.println();
	}

	char calGrade() {
		if( average >= 90.0) {
			grade = 'A';
		}else if( average >= 80.0) {
			grade = 'B';
		}else if( average >= 70.0) {
			grade = 'C';
		}else if( average >= 60.0) {
			grade = 'D';
		}else {
			grade = 'F';
		}
		return grade;
	}


	//현재의 객체 상태를 대표하는 문자열을 리턴하는 메서드
	//아래의 @Override는 어노테이션이라고 부른다.
	//의미는 toString()메서드는 현재 클래스 Score에서 단독으로 만든것이 아니라
	//상위클래스의 메서드를 재정의해서 만든것이라는 의미이다.
	//참고) Java언어의 모든 클래스는 자동으로 Object클래스를 상속받는다.
	@Override
	public String toString() {
		return "Score [name=" + name + ", score=" + Arrays.toString(score) + ", total=" + total + ", average=" + average
				+ ", grade=" + grade + "]";
	}

}
