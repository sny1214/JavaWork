package com.jica.capsulation;

import java.util.Arrays;

public class Score{		
	private String name;
	private int score[] = new int[3];
	private int total;
	private double average;
	private char grade;
	
    public Score() {		
	}
	
	public Score(String name){
		this.name = name;
	}
	
	public Score(String name, int score1, int score2, int score3){
		this.name = name;
		score[0] = score1;
		score[1] = score2;
		score[2] = score3;
	}
	
	//setter/getter
	//total,average,grade는 외부에서 직접 값을 변경하면 
	//고유기능(서비스 메서드)에 영향을 미치므로 set Method는 작성하지 않는다.

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int[] getScore() {
		return score;
	}

	public void setScore(int[] score) {
		//this.score = score; //얕은복사
		for(int i=0; i<this.score.length;i++) {
			this.score[i] = score[i];
		}
	}

	public int getTotal() {
		return total;
	}

	public double getAverage() {
		return average;
	}

	public char getGrade() {
		return grade;
	}
	
	//서비스 메서드
	public int calTotal() {
		total = 0;
		for( int i=0; i<score.length;i++) {
			total += score[i];
		}
		return total;
	}
	public double calAverage() {
		average = total / 3.0;
		return average;
	}
	
	public void display() {
		System.out.println("성명: " + name);
		System.out.println("점수들: " + score[0] + "," + score[1] + "," + score[2]);
		System.out.printf("총점:%d, 평균: %6.2f, 학점:%c", total , average, grade);
		System.out.println();
	}

	public char calGrade() {
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
