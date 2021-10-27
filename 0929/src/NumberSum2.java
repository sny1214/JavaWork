//반복문 for문(제일 많이 사용) -> while문 -> do while반복문 순으로 많이 사용

//for 반복문 - 한줄로 쭉 써서 내용 한눈에 판단 가능 ==> 일반적으로 반복제어변수의 증감이 일정할 때(규칙적인 반복)

//for(반복제어변수초기화;반복조건;반복제어변수증감){
//    수행할 문장;
//	  }

public class NumberSum2 {

	// 1부터 10까지 합계를 계산하시오
	// 1 + 2 + 3 + ... + 9 + 10     숫자(number) ->증가하는 변수
	// 1   3   6   10... 45  55     합계(sum)->저장하는 변수
	//number가 반복을 제어하는 변수
	
	public static void main(String[] args) {
		int sum = 0;
			
		for(int number = 1;number <= 10;number = number + 1) { 
			sum = sum + number;
			System.out.println(number + ", " + "지금까지 합 " + sum); //중간 결과 출력"
		}
		

		
		System.out.println("for문을 이용한 합계 : " + sum); //최종 결과

	}

}

// do while반복
// do {
//		수행할 문장;
// } while(반복조건);