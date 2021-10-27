import java.util.Scanner;

/*
 * 년월일을 입력받아 해당년도의 몇번째 날짜인가를 계산하여 출력하시오.
 * 단, 윤년일 때도 고려하시오.
 * 
 * 
 */
public class DayCount2 {

	public static void main(String[] args) {
		int dayCount = 0;
		//년월일을 지정하자
		int year = 2016, month = 10, day = 5;
		
		System.out.printf("지정된 날짜 : %4d.%2d.%2d%n", year, month, day);

		//1. 전월까지의 일수 계산 - 배열 이용시 훨씬 단순해진다.
		//				0	1  2  3  4  5  6  7  8  9 10 11 12
		int months[] = {0, 31,28,31,30,31,30,31,31,30,31,30,31};
		for(int curMonth=1; curMonth <= month-1; curMonth++) {		
			dayCount += months[curMonth];
		}
		
		// 2. 윤년이고 월이 2월보다 크면 2월 29일을 적용하여 일수를 1 더한다.
		if(isLeap(year) && month >= 3) {					//isLeap(year) == true라 써도 되지만 참이다를 생략한 것. 안에 if문으로 3보다 크다는 조건 따로 줘도 돼
			dayCount++;
		}
		
		// 3. 일수를 더한다.
		dayCount += day;
		
		System.out.println("위의 날짜는 " + dayCount + " 번째 날짜 입니다.");
	}

	static boolean isLeap(int year) {
		//윤년 조건 : 4로 나누어떨어지고 100으로 나누어 떨어지지 않거나
		//400으로 나누어 떨어지면 윤년이다.
		int remain4 = year % 4;
		int remain100 = year % 100;
		int remain400 = year % 400;
		
		if( (remain4 == 0 && remain100 != 0) || remain400 == 0) {
			return true;		//윤년
		} else {
			return false;		//평년
		}		
	}
	
	
}
