import java.util.Arrays;

public class ArrayTest6 {

	public static void main(String[] args) {
		int a[] = {56,78,50,95,42,88,100,82};
		int b[];
		
		b = a; //얕은 복사
		System.out.println("a : " + a);
		System.out.println("b : " + b);
	
		a[2] = 99;
		System.out.println(b[2]);// 99
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.toString(b));
		System.out.println("---------------------------------------");
		
		//깊은 복사
		int c[];
		c = new int[a.length]; //새로운 메모리를 할당하여 c배열 생성
		for(int i=0 ; i < a.length ; i++) {
			c[i] = a[i];
		}
		
		System.out.println("c : " + c);
		System.out.println(Arrays.toString(c));
		
		//깊은 복사, System.arraycopy() 이용
		int d[];
		d = new int[a.length];
		System.arraycopy(a,0,d,0,a.length);
		
		System.out.println("d : " + d);
		System.out.println(Arrays.toString(d));

	}

}
