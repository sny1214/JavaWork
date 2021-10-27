
public class LoopTest {

	public static void main(String[] args) {
		// 1부터 10까지 합계 계산
		// 인위적인 무한 반복문
		
		int sum = 0;
		int number = 1;
		
		while(true) {
			sum += number;
			System.out.printf("%d, %d%n", number, sum);
			if(number >= 10) {
				break; // 가장 가까운 반복문을 강제 탈출 시킨다.
			}
			number++;
		}
		System.out.println("-----End-----");
		
		int sum2 = 0;
		int start = 1;
		for(;;) {					//while(true) = for(;;) 무한 반복문  ---> break로 강제 탈출
			sum2 += start;
			System.out.printf("%d, %d%n", start, sum2);
			if(start >= 10) {
				break;
			}
			start ++;
		}
		System.out.println("-----End2-----");
	}

}
