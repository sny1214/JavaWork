/*
 *  1+3+5+7+9+... 합계가 1000을 초과할 때의 마지막 더해진 숫자 구하기
 *  
 *  반복제어변수의 증감이 고정적일 때 즉, 규칙적일 때 for문 사용
 *  반복제어변수의 증감이 유동적일 때 즉, 불규칙적일 때는 while문으로 코딩하기를 적극 권장합니다.
 */
public class Over1000 {

	public static void main(String[] args) {
		
		int result = calculateFor(20);
		System.out.printf("홀수합계에서 %d을(를) 초과한 마지막 더해진 수는 %d입니다.%n", 20, result);
		
		result = calculateFor(1000);
		System.out.printf("홀수합계에서 %d을(를) 초과한 마지막 더해진 수는 %d입니다.%n", 1000, result);

	}
	
	
	static int calculateFor(int baseNumber) {
		int sum= 0;
		int number = -1;
		
		//조금 어색하지만 문법적으로 타당하다.
		//반복제어변수 초기화 그리고 반복제어변수 증감을 생략했다.(세미콜론(;)은 생략 불가) 		//초기화 내용 안써도 돼, 미리 위에 적어줘도 돼
		for(; sum <= baseNumber ;) { //반복제어변수증감 내용 안쓰고 실행 내용에 적어도 돼 //sum += number;을 증감 내용에 적으면 sum 값이 다르게 나와
			number += 2;
			sum += number;
			//디버깅용 중간 출력
			System.out.printf("%d, %d%n", number, sum);

		}
		
		return number;
	}
	
	//불규칙적인 반복이므로 while문이 좀더 타당하다고 할 수 있다.
	static int calculateSum(int baseNumber) {
		int sum = 0;
		int number = -1;
		
		while(sum <= baseNumber) {
			number += 2;
			sum += number;
			//디버깅용 중간 출력
			System.out.printf("%d, %d%n", number, sum);
		}
		
		return number;
		
	}
}
