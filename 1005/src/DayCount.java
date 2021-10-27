import java.util.Scanner;

/*
 * 년월일을 입력받아 해당년도의 몇번째 날짜인가를 계산하여 출력하시오.
 * 단, 윤년일 때도 고려하시오.
 * 
 * 
 */
public class DayCount {

	public static void main(String[] args) {
		int dayCount = 0;
		int year, month, day;
		
		//년월일을 개별적으로 입력받자
		Scanner scanner = new Scanner(System.in); //변수 이름 꼭 scanner 아니여도 돼
		System.out.print("년도 입력 => ");
		year = scanner.nextInt(); //숫자값 입력
		System.out.print(" 월 입력 => ");
		month = scanner.nextInt();
		System.out.print(" 일 입력 => ");
		day = scanner.nextInt();
		
		System.out.printf("입력된 날짜 : %4d.%2d.%2d%n", year, month, day);

		//1. 전월까지의 일수 계산
		
//		for(int curMonth=1; curMonth <= month-1; curMonth++) {			//or --> ||
//			if( curMonth == 1 || curMonth == 3 || curMonth == 5 ||
//			    curMonth == 7 || curMonth == 8 || curMonth == 10 || curMonth == 12) {
//				dayCount += 31;
//			}else if( curMonth == 4 || curMonth == 6 || curMonth == 9 || curMonth == 11 || curMonth == 12) {
//				dayCount += 30;
//			}else {
//				dayCount += 28;		//평년을 기본값으로 적용		 
//		}
		
		for(int curMonth=1; curMonth <= month-1; curMonth++) {
			switch(curMonth) {
			case 1 : case 3 : case 5 : case 7 :
			case 8 : case 10 : 
			case 12 : dayCount += 31; break;
			
			case 4 : case 6 : case 9 : 
			case 11 : dayCount += 30; break;
			
			default : dayCount += 28;			
			}
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
