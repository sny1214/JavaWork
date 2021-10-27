class PowerTest { 
	public static void main(String[] args) { 
		int x = 2; 
		int n = 5; 
		long result = 0; 

		for(int i=1; i<=n; i++) { 
			result += power(x, i); 	//2의 1승
								   	//2의 2승
								   	//2의 3승
									//2의 4승
									//2의 5승
		} 
									// 다 합한 값이 result
		System.out.println(result); 
		System.out.println(power(2,10));
	} 

	static long power(int x, int n) { 
		if(n==1) return x; 

		return x * power(x, n-1);	//2의 1승, 2의 2승, 2의 3승...
	} 
}
