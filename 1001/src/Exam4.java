/*
 * 1항	2항	  3항    4항   
 *  +1/1!- 2.3! + 3/5! - 4/7! + ... + 10/19!
 *  
 *  정수형과 실수형의 값의 표현범위를 확인해 봅시다.
 */
public class Exam4 {

	public static void main(String[] args) {
		double sum = 0;		//전체합계(분수합계)
		int number = 1;		//항
		int sign = -1;		//부호
		int numerator;		//분자
		long denominator;	//분모 (홀수 factorial)
		int factNumber = 1;
		double fraction;		//항의 값 즉, 분수값
		
		for(number = 1; number <= 10 ; number++) {
			// 1. 부호 결정
			sign = sign * -1;	 //부호결정
			numerator = number;  //분자
			denominator = factorial(factNumber);	//분모계산 (factorial을 계산하는 메서드 호출)
			//왼쪽 기억저장소는 오른쪽 기억저장소보단 커야돼, 오른쪽이 long형 8byte --> denominator도 8byte
			factNumber += 2; 	//다음 홀수! 설정
			
			//분수값 결정
			fraction = sign * (numerator / (double)denominator);	//둘 중에 하나만 바꾸면 다 float로 바껴 원래 int나 long이였으니,
			
			//분수합계 누적
			sum = sum + fraction;   //정수+실수 = 실수여야 해, 정수불가 //sum도 float
			
			//중간결과출력
			System.out.printf("%d, %-20.15f, %-20.15f%n", number, fraction, sum);
			
		}	
		System.out.println("최종 분수합계는 " + sum + "입니다.");
	}
	
	
	//factorial을 계산하는 메서드
	static long factorial(int number) {				//메서드 명과 변수명 똑같을 수 있음
		int factNumber; //1부터 number까지
		long factorial = 1; //factorial값
		
		for(factNumber = 1; factNumber<=number; factNumber++) {
			factorial *= factNumber;
		}
		
		return factorial;
	}
}
