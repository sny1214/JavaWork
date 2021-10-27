
public class Fibonacci {

	public static void main(String[] args) {
		//printFibonacci();

		printFibonacci2();
		
	}
	static void printFibonacci2() {
		long fibonacci; //표현해야할 값이 21억 넘어가므로 int 아닌 long
		long pPrev = 1;
		long prev = 1;
		int count = 0;
		
		System.out.printf("%-4d:%d%n" , ++count , pPrev); //4자리(4)를 확보하되 숫자를 앞쪽에 정렬(-)
		System.out.printf("%-4d:%d%n" , ++count, prev);

		// 반복제어변수 count의 증감이 1씩 항상 같다.(규칙적이다)
		// for문으로 표현하기를 권장한다.
		for(count = 3; count <= 50; count ++) {
			fibonacci = pPrev + prev;
			System.out.printf("%-4d:%d%n" , count , fibonacci);
			pPrev = prev;
			prev = fibonacci;
		}
	}
	
	
	
	//출력하는 메서드, 리턴값 필요없음
	static void printFibonacci() {
		long fibonacci; //표현해야할 값이 21억 넘어가므로 int 아닌 long
		long pPrev = 1;
		long prev = 1;
		int count = 0;
		
		//첫 두 수열값을 출력
		System.out.printf("%-4d:%d%n" , ++count , pPrev); //4자리(4)를 확보하되 숫자를 앞쪽에 정렬(-)
		System.out.printf("%-4d:%d%n" , ++count, prev);

		count = 3;
		while(count <= 50) {
			fibonacci = pPrev + prev;
			System.out.printf("%-4d:%d%n" , count , fibonacci);
			pPrev = prev;
			prev = fibonacci;
			
			count ++;
		}
	}
}
