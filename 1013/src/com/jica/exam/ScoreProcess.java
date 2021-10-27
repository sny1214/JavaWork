package com.jica.exam;

import java.util.Scanner;
import java.util.StringTokenizer;

//5명의 성명과 세 점수를 입력받아
//개별성적(초엄,평균,등급)을 출력하고
//성적순으로 데이터를 정렬하여 출력하시오.

//클래스를 사용하지 않고 메서드 중심으로 코딩 -- 절차적(구조적) 프로그래밍
public class ScoreProcess {

	public static void main(String[] args) {
		final int MAX = 5; //5건 처리하겠다.
		//5명의 성적처리에 필요한 배열
		String name[] = new String[MAX];
		int score1[] = new int[MAX];
		int score2[] = new int[MAX];
		int score3[]= new int[MAX];
		int total[] = new int[MAX];
		double average[] = new double[MAX];
		char grade[] = new char[MAX];
		
		//5명의 성적을 입력받는다.
		inputProcess(name, score1, score2, score3);
		
		for(int i=0 ; i<5 ; i++) {
			System.out.printf("%s %d %d %d%n", name[i], score1[i], score2[i], score3[i]);
		}
		
		//각 학생의 총점과 평균과 학점을 계산한다.
		for(int i=0 ; i<5 ; i++) {
			total[i] = calTotal(score1[i],score2[i],score3[i]);
			average[i] = calAverage(total[i]);
			grade[i] = calGrade(average[i]);
		}
		//성적순으로 모든 데이터를 정렬해야 한다.
		for(int i=0 ; i<4 ; i++) {
			for(int j=i+1; j<5 ; j++) {
				if(average[i] < average[j]) {
					//성명, 세점수, 총점, 평균, 학점 다 교환해야 함.
					String tTmp = name[i];
					name[i] = name[j];
					name[j] = tTmp;
					
					int tmp = score1[i];
					score1[i] = score1[j];
					score1[j] = tmp;
					
					tmp = score2[i];
					score2[i] = score2[j];
					score2[j] = tmp;
					
					tmp = score3[i];
					score3[i] = score3[j];
					score3[j] = tmp;
					
					tmp = total[i];
					total[i] = total[j];
					total[j] = tmp;
					
					double dTmp = average[i];
					average[i] = average[j];
					average[j] = dTmp;
					
					char cTmp = grade[i];
					grade[i] = grade[j];
					grade[j] = cTmp;
				}
			}
		}
		
		
		for(int i=0 ; i<5 ; i++) {
			System.out.printf("%s %d %d %d %d %6.2f %c%n",
							   name[i], score1[i], score2[i], score3[i],
							   total[i], average[i], grade[i]);
		}
		
	}
	// name    0x100 ----> [null,null,null,null,null] //기억장소 1개 4byte x 5
	// score1  0x200 ----> [   0,   0,   0,   0,   0]
	// score2  0x300 ----> [   0,   0,   0,   0,   0]
	// score3  0x400 ----> [   0,   0,   0,   0,   0]
	// total   0x500 ----> [   0,   0,   0,   0,   0]
	// average 0x600 ----> [ 0.0, 0.0, 0.0, 0.0, 0.0] //기억장소 1개 8byte x 5
	// grade   0x700 ----> [ ' ', ' ', ' ', ' ', ' ']
	
	// name    0x100 ----> [홍길동,장길산,이순신,강감찬,고주몽]
	// score1  0x200 ----> [  70,  40, 100,  88,  70]
	// score2  0x300 ----> [  80,  50,  95,  90,  80]
	// score3  0x400 ----> [  90,  60,  88,  92,  85]
	// total   0x500 ----> [   0,   0,   0,   0,   0]
	// average 0x600 ----> [ 0.0, 0.0, 0.0, 0.0, 0.0] //기억장소 1개 8byte x 5
	// grade   0x700 ----> [ ' ', ' ', ' ', ' ', ' ']
	
	
	
	static void inputProcess(String name[], int score1[], int score2[], int score3[]) {
			//입력 전용객체 선언 및 생성
			Scanner scanner = new Scanner(System.in);
			
			String line = "";
			for(int i = 0 ; i < 5 ; i++ ) {
				System.out.print("성명 및 3 점수를 입력하세요 ==> ");
				line = scanner.nextLine(); //"홍길동 70 80 90" 쓰고 엔터
				StringTokenizer st = new StringTokenizer(line);
				name[i] = st.nextToken(); //"홍길동"
				score1[i] = Integer.parseInt(st.nextToken()); // 문자 "70"이 나오므로 숫자70으로 바꿔준다.
				score2[i] = Integer.parseInt(st.nextToken()); // 문자 "80"이 나오므로 숫자80으로 바꿔준다.
				score3[i] = Integer.parseInt(st.nextToken()); // 문자 "90"이 나오므로 숫자90으로 바꿔준다.
			}
	}
	
	static int calTotal(int s1, int s2, int s3) {
		return s1 + s2 + s3;
	}
	static double calAverage(int total) {
		return total / 3.0 ;
	}
	static char calGrade(double average) {
		char grade = 'F'; 	
		if(average >= 90.0) {
			grade = 'A';
		}else if(average >= 80.0) {
			grade = 'B';
		}else if(average >= 70.0) {
			grade = 'C';
		}else if(average >= 60.0) {
			grade = 'D';
		}else {
			grade = 'F';
		}
		return grade;
	}
	
}
