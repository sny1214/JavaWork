/*
 * 1~100까지 숫자에서 홀수의 합을 계산하시오
 */
public class Exam1 {

	public static void main(String[] args) {
		int sum1, sum2;
		
		calculate1();		//리턴값이 있는 메소드는 변수 저장없이 호출도 가능, 변수에 저장 가능, 리턴값 받아 출력도 가능
		// 리턴값 있는 메소드가 사용이 훨씬 편리해, 그러므로 리턴값 있는 메소드 작성을 권장
		
		sum1 = calculate1();
		System.out.println("sum1 = " + sum1);
		System.out.println(calculate1());
		
		//리턴값이 없는 메서드는 단독으로만!!!! 사용할 수 있다.
		calculate2();			

		//calcule2()를 다른 변수에 저장한게 아니라 호출함
		//sum2 = calculate2();  --> error 리턴값 없는 메서드를 다른 변수에 저장 시 오류 뜸
		//System.out.println(calculate2());  ---> error, 리턴값 받아 출력한다는 의미이므로 오류 뜸, 리턴값이 없으므로
		
	}

	static void calculate2() {			//리턴값이 없는 메소드(void), 메소드 내에서 출력해줘야 한다.
		int sum = 0;
		int number = 1;
		int remain;
		
		while(number <= 100) {
			remain = number % 2;
			if( remain == 1) {
				sum += number;          //sum = sum + number;
			}
			number ++;					//number = number + 1;
		}
		
		System.out.println("합계는 " + sum + "입니다.");
	}
	
	
	
	// 홀수를 만들면서 홀수 합계를 계산하는 메서드, 리턴값 받는 메소드
	
	static int calculate1() {
		int sum = 0;
		int oddNumber = 1;
		
		while (oddNumber < 100) {
			sum += oddNumber ;    // sum = sum + oddNumber;
			oddNumber += 2;		  // oddNumber = oddNumber + 2;
		}
		
		return sum;
	}
	
}
