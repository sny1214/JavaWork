
public class RecursiveTest {

	public static void main(String[] args) {
		 printNumber(10);
			System.out.println("-------------------------------------");
		 printNumberR(10);
	}
	
	//재귀호출은 메서드 안에서 동일한 메서드를 호출하는 것을 말한다.
	//특별한 경우에는 직관적인 개념을 그대로 코드로 옮긴다는 장점이 있지만
	//메모리 사용과 처리속도에서 단점을 가진다.
	
	static void printNumberR(int n) {
		if(n==0) {
			return;						//언제 종료할 것인가를 반드시 지정해야 한다.
		}	
		System.out.println(n);
		printNumberR(--n);				//재귀호출
		//--n : n-1 먼저하고 수행, n-- : n먼저 수행하고, 나중에 -1 --> 오류뜸
	}
	static void printNumber(int n) {
		for(; n>=1 ; n--) {
			System.out.println(n);
		}
	}
}
