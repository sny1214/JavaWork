import java.util.Scanner;
	//java.util패키지의 Scanner클래스를 사용하겠다는 의미

/*
 * 성명과 세 점수를 입력받아 총점과 평균을 계산하고
 * 학점도 결정하여 출력하시오.
 * 
 * 참고) java.lang 패키지의 모든 클래스는 마음대로 자유롭게 사용할 수 있다.
 * 		그러나 다른 패키지에 속해 있는 클래스는 반드시 import 시켜야 사용할 수 있다.
 */
public class ScoreProcess {

	public static void main(String[] args) {
		String name;
		int score1, score2, score3;
		int total;
		double average;
		char grade;
		
		//키보드로 성명과 세점수를 입력받자
		//입력전용객체 선언 및 생성
		Scanner scanner = new Scanner(System.in);
		
		// 성명과 세점수를 개별적으로 입력받자.
		// 한줄로 한꺼번에 입력받는 기능은 차후에 학습
		
		System.out.print("성명 입력=> ");
		name = scanner.nextLine();		//문자열을 입력  "홍길동" -->name에 저장

		
		System.out.print("점수1 => ");
		score1 = scanner.nextInt();		//정수값 입력		"75" -> 문자열로 내부적으로 입력되므로 숫자(75)로 바꿔 score1에 저장했음 알 수 있음
	
		
		System.out.print("점수2 => ");
		score2 = scanner.nextInt();		//				"80" ->	80

		
		System.out.print("점수3 => ");
		score3 = scanner.nextInt();		//				"92" -> 92	

		//입력된 값 확인
//		System.out.println(name);		//name 출력
//		System.out.println(score1);	
//		System.out.println(score2);
//		System.out.println(score3);
		
		System.out.printf("%s,%d,%d,%d%n", name, score1, score2, score3);
		
		//총점 및 평균 계산
		total = score1 + score2 + score3;
		average = total / 3.0;	//average = (double)total / 3;
		
		//학점 계산
		//grade = calculateGrade(average); //입력값은 double, 리턴값은 char
		grade = calculateGrade2(average);
		
		//계산 결과 출력
		System.out.printf("총점:%d, 평균:%6.2f, 학점:%c%n", total, average, grade);
		
	}
	static char calculateGrade2(double average) {
		//switch문으로 학점을 구하여 리턴														   (int)
		int tAverage = (int)(average * 0.1); //(average * 0.1)값을 정수형으로 , 85.4 --> 8.54 ------> 8)
		char result; //기억장소 설정
		
		switch(tAverage) {
			case 10 : // 의도적으로 수행할 문장과 break를 생략하여 or 효과를 적용한다
			case 9 : result = 'A' ; break;
			case 8 : result = 'B' ; break;
			case 7 : result = 'C' ; break;
			case 6 : result = 'D' ; break;
			//위의 문장에 일치하는 값이 없을 때 수행
			default : result = 'F' ;
		}
		return result;
	}

	static char calculateGrade(double average) {
		//else if문으로 학점을 구하여 리턴
		char result;
		if(average >= 90.0) {
			result = 'A';
		}else if(average >= 80.0) {
			result = 'B';
		}else if(average >= 70.0) {
			result = 'C';
		}else if(average >= 60.0) {
			result = 'D';
		}else { //위의 모든 조건이 거짓인 경우
			result = 'F';
		}
		
		return result;
		//return ' ';	//공백 문자 코드값 32 - space , 1byte 안에 들어있는 게 ascii문자, 2byte면 유니코드
	}
}
