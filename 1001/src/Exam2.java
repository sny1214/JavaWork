/*
 * 1 + (1+2) + (1+2+3) + ... + (1+2+...+9+10)
 * 
 * 반복문에 대한 이해
 * 
 */
public class Exam2 {

	public static void main(String[] args) {
		int sum1,sum2,sum3,sum4;
		
		sum1 = calculateSum1();  //중첩된 while문
		System.out.println("sum1 = " + sum1);
		
		sum2 = calculateSum2();  //중첩된 for문
		System.out.println("sum2 = " + sum2);
		
		sum3 = calculateSum3();  
		System.out.println("sum3 = " + sum3);
		
		sum4 = calculateSum4();
		System.out.println("sum4 = " + sum4);
	}
	
	static int calculateSum4() {
		int sum = 0;
		//int subSum = 0;
		for(int number=1,subSum=0; number<=10; number++) {
			subSum += number;
			sum += subSum;
		}
		return sum;
	}
	
	static int calculateSum3() {
		int sum = 0;
		int subSum = 0;
		int number = 1;
		
		while(number <= 10) {
			subSum = subSum + number;
			sum += subSum;
			number++;
		}
		return sum;
	}
	
	static int calculateSum2() {
		int sum = 0;
		
		for(int number=1; number <= 10; number++) {
			int subSum = 0;
			for(int subNumber=1; subNumber <= number; subNumber++) {
				subSum += subNumber;
			}
			
			sum += subSum;
			
			//중간결과출력
			//System.out.printf("%d,%d,%d%n",number,subSum,sum);
		}
		
		return sum;
	}
	
	
	static int calculateSum1() {
		//중첩된 반복구조 - while
		int sum = 0;    //최종합계
		int number = 1; //항(1~10)
		
		//1항부터 10항까지 반복
		while(number <= 10) {
			int subSum = 0;
			int subNumber = 1;
			//1부터 number까지 반복
			while(subNumber <= number) {
				subSum += subNumber; //항의값 계산
				subNumber++;
			}
			
			//전체합계 계산
			sum += subSum;
			
			//중간결과를 출력해서 정확히 계산되는지 확인해 보자
			//System.out.printf("%d,%d,%d%n",number, subSum, sum);
			
			number++;
		}
		
		return sum;
	}

}
