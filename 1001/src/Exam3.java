//1~100까지의 자연수 중 3의 배수와 5의 배수를 제외한 홀수의 합을 계산하시오
 
public class Exam3 {

	public static void main(String[] args) {
		int sum = 0;

		
		for(int number = 1; number <= 100; number += 2) {
			int remain3 = number % 3;
			int remain5 = number % 5;
			
			if(remain3 != 0 && remain5 != 0) {
				sum += number ;
				//디버깅 목적의 중간출력
				//System.out.println(number);
			}
		}
		System.out.println("최종 합계 : "+ sum);
	}

}
