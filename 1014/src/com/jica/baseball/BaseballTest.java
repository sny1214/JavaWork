package com.jica.baseball;

import java.util.Scanner;

public class BaseballTest {

	public static void main(String[] args) {
		//4개 숫자 입력
		Scanner scanner = new Scanner(System.in);
		System.out.print(" 0 ~ 9 사이 숫자 4개를 중복없이 입력하시오 => ");
		
		String inputNumber = scanner.nextLine();
		char[] chArr = inputNumber.toCharArray();
		System.out.println(chArr);
		
		int numArr[] = new int [4];
		for(int i = 0 ; i < chArr.length; i++) {
			
			numArr[i] = chArr[i]-'0';
		}
		
	if(inputNumber == "" || inputNumber.length() != 4) {
			
			System.out.println("잘못된 숫자입니다. 숫자 4개를 입력하세요");
			System.exit(0);
		}
		
		random();
	}		
	static void random() {
		//0~9까지 랜덤 값 4개 뽑기
		int arr[] = new int[4];
				
		for (int i=0; i < arr.length ; i++) {
			arr[i] = (int)(Math.random() * 10);
				
			//중복값 검사
			for(int j=0 ; j < i ; j++) {
				if(arr[i] == arr[j]) {
					i--;
					break;
				}
			}
		}
		printArray(arr);
	}
		
		
		

	//배열 출력
	 static void printArray(int arr[]){
		  String result = "[";
		  for(int i=0; i<arr.length; i++){
		     	if( i != arr.length-1){
		      	   result += arr[i] + ",";
		      	}else{
		      	   result += arr[i];
		      	}
		      }
		      result += "]";
		      System.out.println("배열요소값들: " + result);

	    	}
	}
