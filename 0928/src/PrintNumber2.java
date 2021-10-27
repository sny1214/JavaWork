
public class PrintNumber2 {

	public static void main(String[] args) {
		// 변수를 이용하여 1부터 10까지 값을 증가시키면서 출력한다.
		
		//1. 변수 선언 및 초기화
		int number = 1;
		
		//2. number값이 10보다 작거나 같은 동안 반복한다 ( while(조건) {실행시킬 내용} )
		while(number <= 10) {
			System.out.println(number);
			number = number + 1;
		}
		
		System.out.println("number값이 10보다 크면 반복을 종료하고 끝난다.");
		
	}

}
