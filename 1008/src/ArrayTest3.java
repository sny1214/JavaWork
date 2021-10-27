import java.util.Arrays;

public class ArrayTest3 {

	public static void main(String[] args) {
		//배열 선언 및 생성 후 개별 초기화
		int score[] = new int[5];
		score[0] = 70;
		score[1] = 80;
		score[2] = 90;
		score[3] = 60;
		score[4] = 50;
		
		System.out.println(Arrays.toString(score));
		
		//간편 초기화 - 배열 선언과 동시에 초기값 지정
		int score2[] = {70, 80, 90, 60, 50};
		
		System.out.println(Arrays.toString(score2));
		
		//배열 선언 후 
		int score3[];
		score3 = new int[] {70, 80, 90, 60, 50};
				
		System.out.println(Arrays.toString(score3));
		
	}

}
