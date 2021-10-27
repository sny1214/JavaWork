/* 가급적 메서드 만들어서 풀이해볼 것!
 * 
 * 실습문제
 * 1. 세 숫자가 주어졌을 때, 중간 수를 구하여 출력하시오. (7, 25, 3)
 * 2. 5!(5*4*3*2*1 = 120)를 구하여 출력하시오.
 * 3. 1(/1!) - 2/3! + 3/5! - 4/7! +5/9! ... - 10/19! (분모는 홀수로 증가, 분자는 숫자는 순서대로 커지지만, 홀수는 부호 +, 짝수는 부호-)
 *   : 실수로 처리,float(7자리까지 가능) 말고 double
 * 4. 피보나치 수열값 50개 출력하기 int정수 표현 범위를 넘어간다, 그러므로 long형으로 표현
 *    1 1(까지는 정해진 값) 2 3 5 8 13 ... (이전 수 2개를 더한 값)
 *    
 * 2, 3, 4 반복문...
 */
//		int a = 7, b = 25, c = 3;
//		int middle;
//		
//		middle = decideMid(a,b,c);
//		System.out.println(middle);
//	
//	
//
//		//2
//		int num1 = 5;
//		float factorial2;
//
//		
//		factorial2 = facResult(num1);
//		
//		
//		System.out.println("2번은 "+ factorial2);
//		System.out.println("----------------");


public class Practice931 {

	public static void main(String[] args) {

//	
		//3
		long number = 1;		 //항 번호, 분자
		long denominator;    //분모 (!된 값)
		int factNumber = 1;  //fact 되기 전 값
		double fraction;     //분수
		double sum=0;
	
		while(number <= 10) {	
		
			denominator = factorial(factNumber);
			System.out.println(denominator);
			
			factNumber += 2;
			
			
			fraction = (number/(double)denominator);
			
			sum = sum + fraction;

			System.out.printf("%d, %-20.15f, %-20.15f%n", number, fraction, sum);
			
			
			number = number * -1;
			if(number > 0) {
				number++;
			}else {
				number--;
			}
			//이게 훨 복잡, number 따로 부호 나타내는 변수 따로 설정해주자
			//★ number 변수에 부호를 포함시키면 안되는 이유(number = number * -1 쓰면 안되는 이유) -2로 들어가면 number++에 의해 -1로 되므로 원했던 다음결과값(+3)이 안나옴)  		
		}
			

		System.out.println("답은" + sum);		
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

	

	



//	static int decideMid(int num1, int num2, int num3) {
//		int max;
//		int mid=0;
////		
////		if(num1 >= num2) {
////			if(num2 >= num3) {
////				print num2;
////			}else {
////			num3 >= num1;
////			max = num1;
////		}else {
////			max = num2;
////		}
////		
//		if(max >= num3) {
//			mid = num3;
//		}
//				
//		return 0;
//		
//		
//	}
		

	
	
