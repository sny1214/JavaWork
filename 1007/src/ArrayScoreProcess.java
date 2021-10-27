import java.util.Scanner;

/*
 *  5명의 점수를 입력받아
 *  평균을 구하여 출력하고
 *  개별점수와 평균과의 차이를 출력하시오
 */
public class ArrayScoreProcess {

	public static void main(String[] args) {
		double average, difference;
		//int score[];				//배열 선언
		//score = new int[5]; 		//배열 생성
		
		int score[] = new int[5];	//배열 선언 및 생성
		//						     0  1  2  3  4
		// score 0x100 ----------->[ 0, 0, 0, 0, 0 ]
		
		//배열명은 참조변수이다.
		//score에는 주소 즉, 위치정보가 저장되어 있다.
		System.out.println(score);		// 배열명 출력 명령시, 내부적으로 가공된 값(프로그램 코드에서 참조값)을 출력
		
		//배열 요소 값 ==> 배열명[첨자]
		//					   |----> 정수 Literal value
		//						      정수 변수 (예: k)
		//							  정수 값을 결과로 가지는 계산식
		//					   첨자의 값은 0 ~ n-1 까지 사용한다. (여기선 n = 5)
		
		
		
		System.out.println(score[0]);			// 0번째 배열요소값
		System.out.println(score[3]);			// 3번째	배열요소값
		int k = 1;
		System.out.println(score[k]);   		// 1번째 배열요소값 k=1이므로 score[1] 출력
		System.out.println(score[++k]);			// 2번째 배열요소값 k+1=2
		System.out.println(score[k*3-2]);		// 4번째 배열요소값 k*3-2 =4 
		
		System.out.println("--------------------------------------");
		
		int total = 0;
		
		//입력전용객체 선언 및 생성
		Scanner scanner = new Scanner(System.in);
		for(int i = 0; i < 5 ; i++) {
			System.out.print((i+1) + " 번째 점수입력 ==> "); 
			score[i] = scanner.nextInt();
		}
		//							  0   1   2   3   4
		// score 0x100 ----------->[ 85, 73, 80, 93, 65 ]
		System.out.println("입력된 점수값 확인 및 총점 계산");
		for(int j=0; j<5 ; j++) {
			total += score[j];
			System.out.print(score[j] + " ");
		}
		
		System.out.println();
		
		//평균계산
		average = total / 5.0;
		
		System.out.printf("평균 : %6.2f%n" , average);
		
		//점수와 평균과의 차이를 출력한다.
		System.out.println("점수 평균과의 차이");
		System.out.println("----------------");
		for(int j = 0 ; j < 5; j++ ) {
			difference = score[j]- average;
			System.out.printf("%d %6.2f%n", score[j], difference);
		}
	}

}
