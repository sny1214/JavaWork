/* 실습문제
 * 1. 1+3+5+...+99 합계
 * 2. 1+(1+2)+(1+2+3)+...+(1+2+...+9+10) 합계
 * 3. 1부터 100까지 홀수 중에서 3의 배수와 5의 배수를 제외한 홀수의 합계
 */
public class Practice0929 {

	public static void main(String[] args) {
		
		
		//실습문제 1번 1+3+5+...+99 합계
		
		int sum1 = 0;
		
		for(int odd1 = 1; odd1 < 100; odd1 += 2) {
			sum1 += odd1 ;
//			System.out.println("홀수 " + odd + ", 지금까지 합 " + sum1 ); //중간확인용
		}
		
		System.out.println("1번 답 " + sum1);

		
		
		//실습문제 2번 1+(1+2)+(1+2+3)+...+(1+2+...+9+10) 합계
		
		int total2 = 0;
		int sum2 = 0;
		int num2 = 1;
		
		
		while(num2 <= 10) {
			sum2 += num2;		
			total2 += sum2;			
//			System.out.print("숫자 " + num + "까지 더해진 합인 " + sum2+ "까지 더한 총 합 : " + total); //중간확인용

			num2 ++ ;
		}
		
		System.out.println("2번 답 " + total2);
		

	
		
		//실습문제 3번 1부터 100까지 홀수 중에서 3의 배수와 5의 배수를 제외한 홀수의 합계
		
		int total3 = 0;
		
		for(int odd3 = 1; odd3 <= 100 ; odd3 += 2) {
			if(odd3 % 3 != 0 && odd3 % 5 != 0) {
				total3 += odd3;
			}
//			System.out.println("홀수 " + odd3 + "까지 더한 합은 " + total3 + "입니다"); //중간확인용
		}
		
		System.out.println("3번 답 " + total3);

		
		//실습문제 2번 다른 풀이
		
		int total4 = 0;
		int sum4 = 0;
		
		for (int num4 = 1; num4 <= 10 ; num4 ++) {
			System.out.println("숫자 " + num4);
			sum4 += num4;
				
   			System.out.println("까지 합 " + sum4);
   			    
   			total4 += sum4;
		}
		
		System.out.println("2번 답 " + total4);
		
		
		// 괄호 빼고 쓰면 1+1+2+1+2+3+.. ---> 1이 10개, 2가 9개,...
		// 1 * (11-1) + 2 * (11-2) + 3* (11-3)
		//int number = 1, count = 10 이라면 term = number *count, number++, count --로 할 수도..
		
	}
	
}


