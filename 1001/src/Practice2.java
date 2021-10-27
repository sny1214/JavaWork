/*
 * 2. 중심수 구하기 - 1~m-1까지 합한 값 = m+1~..합한 값이 되는 수 ex) 1,2,3,4,5(까지합 15)/6/7,8(까지합 15) 이때 6이 중심수
 * 				 - 1~500까지 중심수 3개뿐, 그 3개를 구하라
 * 				 - 반복구조 내 반복구조
 */
public class Practice2 {

	public static void main(String[] args) {
//		
//		int number = 1;
//		int center;
//		int totalSum = 0;
//		
//		while(number)
//			totalSum = sum(number);
//			number ++;
//			totalSum == number;
//		}
//
	}
	
	
	static int sum(int a) {
		int number = 1;
		int sum = 0;
		
		while(number <= a) {
			sum += number;
			number ++;
		}
		
		return sum;
	}
	
}
