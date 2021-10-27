/*
 * 기준 날짜(1998.7.12)와 오늘 날짜(2021.10.6) 사이의 일수를 계산하시오.
 * 
 * 메서드를 활용하는 방법을 익히자
 * 메서드는 다음의 목적으로 사용된다.
 * 	  1) 기능 분류
 * 	  2) 코드 재사용(여러번 호출하여 사용)
 * 
 */
public class DayCount3 {

	public static void main(String[] args) {
		int dayCount = 0;
		int bYear =1998, bMonth = 7, bDay =12;	//기준날짜
		int tYear =2021, tMonth =10, tDay = 6;		//현재날짜
		
		
		//1. 기준년도의 일수 계산
		//1.1 월+1 부터 12월까지 일수 계산
		for(int cMonth = bMonth +1 ; cMonth <= 12 ; cMonth ++) {
		
			//월의 일수에 따라 31, 30, 28을 더해준다. - 메서드(lastDay) 이용 //코딩 소문자로 시작시, 변수거나 메서드.. 이때 뒤에 괄호 있으면 메서드(괄호 안이 리턴값)
			dayCount += lastDay(cMonth);
		}
		
		//1.2 일수 더하기
		dayCount += lastDay(bMonth) - bDay + 1;
		
		//1.3 기준년도가 윤년이고 월이 1월이거나 2월이면
		if( isLeap(bYear) && bMonth <= 2) {
			dayCount ++;
		}
		
		
		//2. 중간년도의 일수 계산
		for(int cYear = bYear +1; cYear < tYear ; cYear ++) {
			if(isLeap(cYear)) {
				dayCount += 366;
			}else {
				dayCount += 365;
			}
		}

		
		//3. 오늘날짜 년도의 일수 계산
		//3.1 전월까지의 일수 계산
		for(int cMonth =1; cMonth < tMonth ; cMonth ++) {
			dayCount += lastDay(cMonth);
		}
		
		//3.2 일수 더하기
		dayCount += tDay;
		
		//3.3 오늘 날짜의 연도가 윤년이고 월이 2월보다 크면 2월 29일을 적용하여 일수를 1 더한다.
		if( isLeap(tYear) && tMonth >= 3) {
			dayCount ++;
		}
		
		
		
		//4. 계산된 일수 출력
		System.out.printf("두날짜 (%4d.%2d.%2d~%4d.%2d.%2d) 사이의 일수는 %d입니다%n",
							bYear, bMonth, bDay, tYear, tMonth, tDay, dayCount);
		
		//계산결과가 다름. 무엇이 잘못되었을까 고쳐보자
		//정확한 값은 8448
		//코딩 결과는 8335
	}

	
	
// 메서드	
	
	//월의 일수에 따라 31, 30, 28을 더해주는 메서드 + 윤년까지 고려하자!
	static int lastDay(int month) {
		
		// 윤년을 고려하지 않은 평년의 월의 일수
		int lastDay = 0;	//변수명도 동일하게 준 상태
		
		//배열 이용하면 훨씬 편해짐
		//	int months[] = {0, 31,28,31,30,31,30,31,31,30,31,30,31};
		//	for(int curMonth=1; curMonth <= month-1; curMonth++) {		
		//	dayCount += months[curMonth];
		//	}
		
		
		//switch 이용
		switch(month) {
			case 1:  case 3: case 5: case 7: case 8: case 10: 
			case 12: lastDay = 31; break;
			
			case 4:  case 6: case 9:
			case 11: lastDay = 30; break;
			
			default : lastDay = 28; break; 				//default = case2
		
		}
		
		//윤년도 같이 고려해서 계산, ★년도 변수도 같이 불러와야 해
		
		
		return lastDay;
	}
	
	
	
	
	// 윤년 계산 메서드 - 조건 : 4로 나누어떨어지고 100으로 나누어 떨어지지 않거나 400으로 나누어 떨어지면 윤년이다.
	static boolean isLeap(int year) { 
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
