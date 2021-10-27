/*기준년월일(생일:1998.04.03)과
오늘날짜(2021.10.5)사이의 일수를 계산해 보시오 ==> 살아온 일수

태어난 년도
   1998년 5월~12월까지 일수더하기 단, 월이 1월,2월의 날짜이면 윤년이므로 2월의 일수에 1을 더한다. 
중간년도 1999,2000,2001, ... 2019,2020
   평년이면 365일, 윤년이면 366일
금년(2021년의 살아온일수) ==> DayCount.java  
*/
public class DdayCount {

	public static void main(String[] args) {
		int dayCount = 0;
		int birthYear = 1998, birthMonth = 4, birthDay = 3;
		int curYear = 2021, curMonth = 10, curDay = 5;
		
		// 풀이1 태어난 년도의 생일 이후~ 12/31까지 일수 + 이후 년도 일수 + 금년 기준 일 까지의 일수
		// 풀이2 태어난 년도의 1월 1일 기준으로 금년 날짜 까지 일수 - 생일까지 일수............. v

		
		//1. 생일 년도의 생일날 이후 해당 월 이후 그 해 남은 일수- 배열 이용
		//				0	1  2  3  4  5  6  7  8  9 10 11 12
		int months[] = {0, 31,28,31,30,31,30,31,31,30,31,30,31};
		int countDay;
		int countMonth = 0;
		
		for(int month = birthMonth ; month <= 12 ; month ++) {
			countMonth += months[month];
		}
		
		countDay = countMonth - birthDay + 1 ;
		
		if(isLeap(birthYear) && birthMonth < 3) {
			countDay ++;
		}

		
		
		// 2. 사이년도 일수 합
		int midDay = 0 ;
		
		for(int midYear = birthYear + 1 ; midYear < curYear ; midYear ++) {
			
			if(isLeap(midYear)) {
				midDay += 366;
			}else {
				midDay += 365;
			}			
		}

		//3. 금년 날짜까지의 일수
		int curCount = 0;
		
		for(int monthNumber = 1; monthNumber <= curMonth-1; monthNumber++) {		
			curCount += months[curMonth];
		}
		
		if(isLeap(curYear) && curMonth >= 3) {
			curCount ++;
		}
		
		curCount += curDay;
		
		
		
		//4. 총합
		dayCount = countDay + midDay + curCount;
		
		System.out.printf("살아온 일수 : %4d%n", dayCount);
		
		
		
	}	
	
	static boolean isLeap(int year) {
		//윤년 조건 : 4로 나누어떨어지고 100으로 나누어 떨어지지 않거나
		//400으로 나누어 떨어지면 윤년이다.
		int remain4 = year % 4;
		int remain100 = year % 100;
		int remain400 = year % 400;
		
		if( (remain4 == 0 && remain100 != 0) || remain400 == 0) {				//&& and, || or
			return true;		//윤년
		} else {
			return false;		//평년
		}		
	}
	
	
}
