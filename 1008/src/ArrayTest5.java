import java.util.Arrays;

public class ArrayTest5 {

	public static void main(String[] args) {
		int a = 10, b = 20;
		
		//두변수의 내용값을 교환하는 메서드 호출
		System.out.printf("a:%d, b:%d%n",a,b);	
		swap(a, b);		
		System.out.printf("a:%d, b:%d%n",a,b);

		//배열의 요소값을 교환하는 메서드(0번째와 1번째)
		int data[] = {10,20,30,40,50};
	
		System.out.println("data배열 배열요소값들 :" + Arrays.toString(data));
		
		System.out.printf("data[0]:%d, data[1]:%d%n",data[0],data[1]);		
		swap(data);
		System.out.printf("data[0]:%d, data[1]:%d%n",data[0],data[1]);		

		swap(data, 2, 4);
		System.out.println("data배열 배열요소값들 :" + Arrays.toString(data));
	}

	//
	// swap()   x 20  y 10 temp 10 --> 메서드가 끝나면 메모리에서 소멸된다.
	// main()   a 10  b 20
	

	static void swap(int x, int y) {
		int temp;
		temp = x;
		x = y;
		y = temp;
	}
	//         
	//        |20 | 10|
	//        ^0x100
	//        | ^----------| 
	//        |-----|      |
	// swap()       | arr 0x100 temp 10
	// main() data 0x100
	
	static void swap(int arr[]) {
		int temp;
		temp = arr[0];
		arr[0] = arr[1];
		arr[1] = temp;
	}
	
	static void swap(int arr[], int i, int j) {
		int temp;
		temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
