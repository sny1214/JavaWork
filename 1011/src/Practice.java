import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/*
<간단한 야구 게임>

a가 0 ~ 9 숫자
b가 그 숫자 자리도 맞추고 수도 맞추면 strike, 숫자는 맞췄지만 자리가 틀리면 ball
4 strike가 되면 끝
몇번만에 맞추는 가

1. int target[] = {난수 4개} <--- 0 ~ 9까지 숫자, ★중복 안됨
2. 사용자가 키보드로 0 ~ 9까지 숫자 4개 입력
3. 비교
4. 맞출 때까지 사용자가 입력할 때까지 or "end"(포기) 입력할 때까지 반복

1차원 배열
 */
public class Practice {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.print(" 0 ~ 9 사이 숫자 4개를 중복없이 입력하시오 => ");
		String inputNumber = scanner.nextLine();
		
		char[] chArr = inputNumber.toCharArray();
		System.out.println(chArr);
		
		int[] numArr = new int[4];
		
		for(int i = 0 ; i < chArr.length; i++) {
			numArr[i] = chArr[i]-'0';
		}
		
		if(inputNumber == "" || inputNumber.length() != 4) {
			
			System.out.println("잘못된 숫자입니다. 숫자 4개를 입력하세요");
			System.exit(0);
		}
		
		int arr[] = new int[4];
		boolean sw;
		int strikeSum = 0;
		int ballSum = 0;
		
		for(int i=0 ; i < 4 ; i++) {
			arr[i] = (int)(Math.random() * 10);
		//중복안되게 하는 내용
			System.out.print(arr[i]);
			//sw = true;
		}	
		
		for(int j=0 ; j < arr.length ; j++) {
			sw = false;
			for(int i=0 ; i < 4 ; i++) {
				if (numArr[i] == arr[j]) {
					if(i == j) {
						strikeSum++;
						System.out.println();
						System.out.println(strikeSum + "strike");
					}else {
						ballSum++;
						System.out.println();
						System.out.println(ballSum + "ball");
					}	
				}//else continue;
//				if (sw != true) break;
			}
		}	
			
		
		
	}
}
