/*
 * 자료형과 변수의 선언 및 정의에 대하여 학습하는 예제
 */
public class CalculateSum {

	// 세 점수(75, 90, 92)가 주어졌을 때 총점과 평균을 계산하여 출력하는 프로그램
	public static void main(String[] args) {
		int score1, score2; //변수들은 ,이용해 여러 개를 동시에 선언 가능
		int score3 = 92;

		int total;
		double average;
		
		score1 = 75;
		score2 = 90;
		
		//총점 계산
		total = score1 + score2 + score3;
		
		//평균 계산
		
		//average = total / 3; //85.0
		//average에 값이 들어가긴 하나, total이 int로 선언되어 있고, 3도 정수이기 때문에 int/int = int로만 나와 => average값으로 int값만 들어가버려, 소수점 버려짐
		//실수 연산이 가능해야.. 즉 total이나 3 둘 중 하나를 실수로 바꿔주면 정수인 total이 실수로 바뀌면서 실수 연산 결과, 실수로 나온다.
		
		average = total / 3.0; //85.66666666666667

		//cast연산자로 일시적으로 자료형 바꿔주자. 정수인 total을 실수로! 
		//자료형 바꿀 대상 앞에 '(자료형)'을 붙임
		average = (double)total / 3; //85.66666666666667
		
		System.out.println("총점 : " + total);
		System.out.println("평균 : " + average);
		System.out.printf("평균 : %5.2f%n", average);

		//다른 메서드인 printf로 원하는 소수점까지만 표현할 수 있다.
		
		// "문자열 : %5.2f%n"
		// average를 출력하는 값을(85.666)반올림 해서 전체 자릿수를 소숫점 포함 5자리수로 얻어 소수점 이하 자리수 2자리까지만 출력해라
		// %8.2f고 쓰면 00085.666....를 반올림해서 00085.67인 격
		// %n은 줄을 바꾸라는 의미, 안쓰면 다음 출력값이 바로 옆에 출력되어버림 (println은 자동으로 줄바꿈)
		
		
	}

}
