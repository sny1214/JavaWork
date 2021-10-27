class FactorialTest2 {
	static long factorial(int n) {
		if(n<=0 || n>20) return -1;  // 매개변수의 유효성 검사, n 20 넘어가면 long형이 표현가능한 범위를 넘어감
		if(n<=1) 					 // 1일땐 재귀 호출 안함
			 return 1;				 // 2부터 재귀 호출
	    return n * factorial(n-1); 
	}

	public static void main(String args[]) {
		int  n = 21;
		long result = 0;

		for(int i = 1; i <= n; i++) {
			result = factorial(i);

			if(result==-1) {				//if(n<=0 || n>20) return -1; 에 의해 21이 오면 -1값이 와..
				System.out.printf("유효하지 않은 값입니다.(0<n<=20):%d%n", n);
				break;
			}

			System.out.printf("%2d!=%20d%n", i, result);
		}
	} // main�� ��
}
