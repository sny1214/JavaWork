/*
 * 500까지의 자연수에서 중심수를 구하여 출력하시오
 * 1 2 3 4 5 6 7 8
 * ----------|----
 *   이전수 합 | 다음수 합
 * 			 v
 * 		   중심수
 * 
 * 이전 수의 합과 다음수들의 합이 같은 숫자가 중심이다.
 * 
 * 상수 변수 : 변수인데 초기값 지정 후에는 그값이 프로그램 끝까지 동일한 값을 유지하는 변수
 * 			 즉, 값을 변경할 수 없는 변수를 말한다.
 * 			 JAVA언어에서는 final 변수로 선언한다.
 * 			 일반 변수와 구분하기 위해 대문자로 작성하기를 권장한다.
 * 			 두 단어 이상을 사용할 때는 _를 사용한다.
 */
public class NumericCenter {

	public static void main(String[] args) {
		final int UPPER_NUMBER = 500;	//sum합이 int로 표현가능한 범위 넘어가면 자료형 바꿔야 해
		int upperNumber = 500;		//final변수 아님, 일반 변수, 대문자로 써도 되긴 하지만 관례적으로 소문자, 두 단어 이상이면 단어 구분은 대문자
		
		for(int number=2; number <= UPPER_NUMBER ; number++) {	//for문 내에서만 사용, 지역변수 : number, prevNumber, prevSum, nextNumber, nextSum
			//UPPER_NUMBER = 700  ----> final 변수이므로 값 변경할 수 없다.
			
			//이전수의 합 계산
//			int prevSum = 0;
//			for(int prevNumber = 1; prevNumber<number ; prevNumber++) {
//				prevSum += prevNumber;
//			}
			
			//메서드로 계산
			int prevSum = calculateSum(number - 1);	//메서드 괄호안의 값부터 계산한 것을 다시 인자로 메서드로 실행
			
			//이전 수의 합 계산
			//이전수의 합이 다음수의 합보다 큰 동안 반복 -->불규칙하므로 while반복문 사용
			int nextNumber = number +1;
			int nextSum = nextNumber;
			while(prevSum > nextSum) {
//				nextNumber++;
//				nextSum += nextNumber;
				nextSum += ++nextNumber; 	//++nextNumber-->nextNumber ++가 먼저 온 조건 임을 나타내
			}
			
			//중심수 판별하여 출력
			if(prevSum == nextSum) {
				System.out.printf("%d == %d 중심수 : %d%n", prevSum, nextSum, number);
			}
		}	//전체 for반복문 끝

	}
	
	
	
//메서드
	// 이전 수의 합 구하는 메서드
	static int calculateSum(int lastNumber) {
		int sum = 0;
		for(int number = 1; number <= lastNumber ; number ++) {
			sum += number;
		}
		return sum;
	}
	
	
}
