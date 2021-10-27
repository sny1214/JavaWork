package com.jica.exception;

import java.util.Scanner;

public class ExceptionTest {

	public static void main(String[] args) {
		int result, result2;
		int number1, number2;
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("나눌 정수 숫자를 입력하시오 ==> ");
		number1 = scanner.nextInt();
		
		result = 5/number1;
		System.out.println("결과값 : "+ result); 	//2
		
		System.out.print("나눌 정수 숫자를 입력하시오 ==> ");
		number2 = scanner.nextInt();
		
		//result2 = 5/0;			//0으로 나눌 수 없다. 이 코드 수행하다가 ArithmeticException(숫자 0으로 나눌 때 나타나는 exception)
		result2 = 5/number2;		//number2에 0을 넣으면 사용자 실수 -> 예외 발생 가능성 있는 코드, 프로그램 비정상적 종료
		System.out.println("결과값 : "+ result2);
		
		String name = "JICA"; 				
		System.out.println("문자열 길이 : " + name.length());
	
		//runtimeException : 프로그래머 실수일 가능성이 높다.
		
		//String name = null; 				//null 객체에 넣는 값으로, 아직 유효한 값을 가지고 있지 않다는 의미
		//System.out.println(name.length());  //java.lang.NullPointerException <-runtimeException 상속받은 것
	
		
		int arr[] = { 7, 4, 2, 3, 5 };
		for(int i=0; i <= 5 ; i++) {		//배열 첨자 범위 벗어났을 때
			System.out.println(arr[i]);		//i=5가 됐을 때 출력될 값이 없으므로 ArrayIndexOutOfBoundsException <- runtimeException 상속받은 것
		}
	}

}
