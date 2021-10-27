// 반복제어문 while은 반복제어변수의 증감이 일정하지 않다 => 불규칙적인 반복, 한눈에 판단 불가, 해 봐야 안다

// 반복제어변수초기화;
// while(반복조건){
//		수행할 문장;
//		반복제어변수증감;
// }

public class NumberSum {

	// 1부터 10까지 합계를 계산하시오
	// 1 + 2 + 3 + ... + 9 + 10     숫자(number) ->증가하는 변수
	// 1   3   6   10... 45  55     합계(sum)->저장하는 변수
	
	// 변수들 각각 초기값 줄 것, 변수들 값이 변하는 코드작성할 것
	
	
	public static void main(String[] args) {
		int sum = 0;         //합계   0 1 3 6 ...36 45 55
			//int sum만 쓰고 sum = sum + number 작성 시, error=>sum이 선언만 됐을 뿐 정의되지 않은 상태
		
		//반복제어변수 초기화
		int number = 1;     //숫자    1 2 3 4 ... 9 10 이후는 반복문 조건 안맞
		
		//반복조건
		while(number <= 10) { //number가 반복을 제어하는 변수
			sum = sum + number;
			System.out.println(number + ", " + "지금까지 합 " + sum); //중간 결과 출력"
			
			//반복제어변수 증감
			number = number + 1;
			//number = number + 2이면 홀수 10개 합 구할 수 있다
			// 짝수 10개 합하려면 number 초기값을 2로 주면 돼
		}
		
		System.out.println("While문을 이용한 합계 : " + sum); //최종 결과

	}

}
