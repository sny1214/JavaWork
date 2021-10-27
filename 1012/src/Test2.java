
public class Test2 {

	public static void main(String[] args) {
		// 일반적인 배열
		// 배열은 같은 자료형의 변수를 여러개 모아놓은 것이다.
		//int score[] = {70,90,85};
		int score[] = new int[] {70,90,85};
		System.out.println(score.length); //3
		//score 0x100 ---> [70,90,85]
		
		//특수하게 요소의 갯수가 1개이거나 0개인 배열도 만들 수 있다.
		//int arr[] = { 86 };	//배열
		int arr[] = new int[] {86};
		int value = 86;		//일반변수
		
		// arr     0x200 ---> [86]
		// value   86
		
		System.out.println("value : " + value);
		System.out.println(arr);	//가공된 위치정보
		System.out.println(arr.length); //1
		System.out.println("arr[0] : " + arr[0]);
		
		// 요소의 갯수가 0개짜리인 배열
		int arr2[] = {};
		//int arr2[] = new int[0]; //arr2[] = {}
		System.out.println(arr2);
		System.out.println(arr2.length); // 0
		//System.out.println(arr2[0]);  //error
	}

}
