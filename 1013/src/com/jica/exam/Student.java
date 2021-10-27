package com.jica.exam;


//학생의 성적정보를 관리하는 클래스
public class Student {
	//멤버변수 - 필드(field)
	String name;
	int score[] = new int [3];
	int total;
	double average;
	char grade;
	
	//총점 계산 메서드
	int calTotal() {
		//메서드 내부에서는 멤버변수를 마음대로 접근할 수 있다.
		total =0;					//this.total = 0;을 의미함
		for(int i=0 ; i<3 ; i++) {
			total += score[i];		//this.total += this.score[i];
		}
		return total;				//return this.total;
	}
	
	//평균 계산 메서드
	double calAverage() {
		//메서드 내부에서는 다른 메서드를 호출할 수도 있다.
		if( total == 0 ) {
			calTotal();			//평균 전에 총점부터 구해라
		}
		
		average = total / 3.0;
		return average;
	}
	
	//학점 계사 메서드
	char calGrade() {
		if( average <= 0.0) {
			calAverage();		//학점 전에 평균부터 구해라
		}
		
		int tAverage = (int)(average / 10);
		switch(tAverage) {
		case 10:
		case 9: grade = 'A'; break;
		case 8: grade = 'B'; break;
		case 7: grade = 'C'; break;
		case 6: grade = 'D'; break;
		default: grade = 'F';
		}
		return grade;
	}

	void display() {
		System.out.printf("%s %d %d %d %d %6.2f %c%n",
						  name, score[0], score[1], score[2], total, average, grade);
	}
}
