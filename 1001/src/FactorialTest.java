/*
 *  1- 2.3! + 3/5! + 4/7! + ... + 10/19!
 *  
 *  정수형과 실수형의 값의 표현범위를 확인해 봅시다.
 */
public class FactorialTest {

	public static void main(String[] args) {
		long result;    //값이 int가 표현가능한 값 범위를 넘어선다.
		
		result = factorial(5);
		System.out.println("5! = " + result);
		System.out.println("-----------------------------");
		
		for(int number=1; number <= 20 ; number++) {
			result = factorial(number);
			System.out.println(number + "! = " + result);

		}
		System.out.println("-----------------------------");
	}
	
	
	static long factorial(int number) {				//메서드 명과 변수명 똑같을 수 있음
		int factNumber; //1부터 number까지
		long factorial = 1; //factorial값
		
		for(factNumber = 1; factNumber<=number; factNumber++) {
			factorial *= factNumber;
		}
		
		return factorial;
	}
}
