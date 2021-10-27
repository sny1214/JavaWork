class FactorialTest {
	public static void main(String args[]) {
		System.out.println(factorial(7)); // FactorialTest.factorial(4)
	}

	static long factorial(int n) {
		long result=0;

		if (n == 1) return 1;		

		return n * factorial(n-1); 
	}
}
