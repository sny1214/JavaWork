
public class Swap {

	public static void main(String[] args) {
		// 임시 변수를 사용하여 두 변수 교환
		int a = 5, b = 20;
		int temp;
		
		System.out.println("교환 전 a=" + a + ", b=" + b);
		
		temp = a;
		a = b;
		b = temp;
		
		System.out.println("교환 후 a=" + a + ", b=" + b);
		System.out.println("--------------------------");
		
		
		// 두 변수만을 사용하여 교환
		a = 5;		//a 5
		b = 20;		//b 20
		
		System.out.println("교환 전 a=" + a + ", b=" + b);
		
		a = a + b ;  // a 25
		b = a - b ;  // b 5
		a = a - b ;  // a 20

		System.out.println("교환 후 a=" + a + ", b=" + b);
		System.out.println("--------------------------");
		
	}

}
