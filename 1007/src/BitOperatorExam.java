//비트 논리합

public class BitOperatorExam {

	public static void main(String[] args) {
		int a = 5;
		int b = 2;
		int c = a & b;
		
		System.out.printf(" %d %s%n", a, toBinaryString(a));		
		System.out.printf(" %d %s%n", b, toBinaryString(b));
		System.out.printf(" %d %s%n", c, toBinaryString(c));
		
		int d = a | b;
		System.out.printf(" %d %s%n", d, toBinaryString(d));

		int e = ~a;
		System.out.printf("%d %s%n", e, toBinaryString(e));		// ~ : 1의 보수 : 0->1, 1->0으로 바뀐다. 부호까지 다 바뀜(0:양수, 1:음수)
		
		//shift 이동 -- 오른쪽으로 이동 : >>, 왼쪽으로 이동 : << , 이동 후 빈자리는 0으로 채워진다. >>2면 나누기 2*2, <<2 곱하기 2*2 효과
		int f = a >> 2;
		int g = a << 2;
		System.out.printf(" %d %s%n", f, toBinaryString(f));
		System.out.printf("%d %s%n", g, toBinaryString(g));
	}
	
	static String toBinaryString(int x) {
		String zero = "00000000000000000000000000000000";
		String tmp = zero + Integer.toBinaryString(x);

		return tmp.substring(tmp.length()-32);
	}

}
