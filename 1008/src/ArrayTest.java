import java.util.Arrays;
import java.util.Scanner;

public class ArrayTest {

	public static void main(String[] args) {
		//int score[];	//배열 선언 : 메모리는 확보되지 않고 앞으로 score라는 식별자는 int값 여러개를 저장한 
						// 			공간의 위치 정보를 저장하여 사용하겠다라는 선언일 뿐, 아직 값 안 가짐 
		
		//int []score;
		int[] score;
		//선언 시에는 표현 3가지 다 가능
		
		
		//값 할당할 땐 항상 이런 표현
		score = new int[5]; //배열 생성(배열정의) : 동적 영역에 int값을 저장할 공간 5개
							// 0 으로 초기화 시킨 후 그 시작위치를 score에 저장한다.
		
		
		//						   0  1  2  3  4
		//score 0x100 ---------> [ 0, 0, 0, 0, 0 ]
		//						0x100
	
		//배열명 score는 위치정보를 가진다. 이값을 출력시켜 확인해 보자
		//(내부적으로 가공된 형태의 값이 출력된다==> [@16진수문자열 형태)
		System.out.println("배열명 score ==> " + score);
		
		//배열의 크기가 결정되었다. 배열 크기 ==> 배열명.length
		System.out.println("배열의 크기 score.length ==> " + score.length);
		
		//배열 크기나타내는 score.length 는 값을 읽어올수만 있고, 값을 변경시킬 수 없다.
		System.out.println("배열 생성 직후의 배열요소값들--------------");
		for(int i = 0; i <5 ; i ++) {
			System.out.print(score[i] + " ");
		}
		System.out.println();
		
		//배열요소 - 단일변수와 동일한 기능을 수행
		//배열요소 => 배열명[정수값]
		//					|--->정수 literal value, 저어수형 변수, 정수값을 결과로 가지는 계산식
		//				          0  ~  크기 -1
		//						   0  1  2  3  4
		//score 0x100 ---------> [80,90,85,70,입력값]
		//						0x100
		score[0] = 80;
		score[1] = score[0] + 10;
		int index = 2;
		score[index] = 85;
		score[(index * 10) % 3 + 1] = 70;
		Scanner scanner = new Scanner(System.in);
		System.out.print("점수를 입력하시오 ==> ");
		score[score.length -1] = scanner.nextInt();
		
		
		System.out.println("현재의 배열요소값들--------------");
//		for(int i = 0; i <5 ; i ++) {
//			System.out.print(score[i] + " ");
//		}

		//향상된 for문을 사용해 보자-> 객체를 대상으로만
		// for(변수타입 변수이름 : 배열이름) {실행코드}
		int sum = 0;
		for( int temp : score) {
			sum += temp;
			System.out.print(temp + " ");
		}	//요소값 없으면 알아서 탈출
		
		System.out.println();
		System.out.println("점수의 합계 : " + sum);
		
		//배열의 모든 요소값을 문자열로 만들어 주는 간편한 메서드
		//Arrays.toString(배열명) : java.util 안에 Arrays 라는 클래스 - 배열과 관련된 유용한 메서들. static 메서드(객체 생성 필요없음)
		//						== "[__,__,__,__,__]" 배열의 모든 요소들을 하나의 문자열로 출력해줌
		
		System.out.println(Arrays.toString(score));
		
	//배열요소의 첨자범위(int정수값)를 벗어나 보자
		//score[3.5] = 95; --> 컴파일에러(코드창에러), 첨자에 실수값이 왔으므로
		
		//score[-1] = 95;  //--> 실행에러(콘솔창에러,컴파일은 됨), 첨자범위를 음수로 씀
		
		//score[5] = 95;    //--> 실행에러(콘솔창에러,컴파일은 됨), 첨자범위 넘어감
		
		
		//배열의 사용이 끝났으므로 null을 저장하여 더이상 배열요소를 사용하지 못하게 하자
		score = null;
		

		System.out.println(Arrays.toString(score));
		System.out.println(score);
		
		//배열명이 null을 가지면 더이상 유효한 메모리를 가리키지 않으므로
		//배열요소를 사용할 수 없다. - 실행시, NullPointerException 에러 발생
		score[2] = 100 ;
		System.out.println(score[2]);
		
	}

}
