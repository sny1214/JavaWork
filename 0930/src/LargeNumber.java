/*
 * 두 수를 전달 받아 큰 수를 리턴하는 메서드 작성 연습
 */
public class LargeNumber {

	public static void main(String[] args) {
		int number1 = 34, number2 = 141;
		int large;
		
		if(number1 >= number2) {
			large = number1;
		}else {
			large = number2;
		}
		
		System.out.println("큰 수는 "+large + "입니다.");
		
		System.out.printf("큰 수 : %d%n", large);
		//%d(정수int 값을 10진수로 출력해달라), %n(출력 후 줄 바꿔달라)
		System.out.printf("큰 수 : %5d%n", large);
		//%5d(출력자리를 5자리 확보해 그 공간 내 정수int 값을 10진수로 출력해달라)
		
		//실수는 %6.2f으로 표현
		// https://eehoeskrap.tistory.com/260
		
		System.out.println("--------------------------------");
		
		int max;
		max = decideLarge(number1, number2);
		System.out.printf("%d, %d중에서 큰 수는 %d입니다", number1, number2, max);
		
		
	}
		// 두 정수를 전달 받아 큰 수를 리턴하는 메서드
	    //			  				34       141
		static int decideLarge(int num1, int num2) { //main이 static이므로 static 붙인다 
			int large;
			if(num1 >= num2) {
				large = num1;
			}else {
				large = num2;
			}
			return large;
			
		}
	
}
