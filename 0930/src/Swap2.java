
public class Swap2 {

	public static void main(String[] args) {
		int year = 2021; //swap()메서드 호출될 때도 메모리 있지만 swap()메서드에서는 사용 못해, main()에서 사용
		
		System.out.println("main()메서드 내부입니다.1 " + year); //출력 1번
		
		swap();		// 메서드 호출 //디버그하면 swap()위치에서 해당 내용 다 실행한 결과 나옴
		//메서드 호출을 해야 만든 것이 작동.. 만들기만 하고 호출 안하면 안나타나
		System.out.println("main()메서드 내부입니다.2 "+ year); //되돌아와서 출력 3번, 이때 swap()의 a, b, temp는 swap() 끝나면 사라진다 [지역변수]
		swap2();
		
	}
	
	// 두 변수의 내용을 교환하는 메서드 (임시변수 사용 안함)
	// swap()의 a,b, temp는 다 사라짐, 즉 swap2()의 a,b는 swap()와 다른 새로 만들어진 것
	static void swap2() {
		int a = 5, b = 20;
		
		System.out.println("swap2()교환 전 a=" + a + ", b="+b);
		a = a + b;
		b = a - b;
		a = a - b;
		System.out.println("swap2()교환 후 a=" + a + ", b="+b);
		
	}
	
	
	

	// 두 변수의 내용을 교환하는 메서드 (임시변수사용)
	static void swap() {
		System.out.println("임시변수를 사용한 변수 교환 "); // swap 호출되어 출력 2번
		//System.out.println(year); // swap()에선 main()의 year 쓸 수 없음, 자기 메서드 안에서 선언한 것은 자기 메서드 안에서만 쓸 수 있음
		int a = 5, b = 20;
		int temp;
		
		System.out.println("swap() 교환 전 a=" +a+ ", b=" +b);
		temp = a;
		a = b;
		b = temp;
		System.out.println("swap() 교환 후 a=" +a+ ", b=" +b);
		
	}
	
	
}
