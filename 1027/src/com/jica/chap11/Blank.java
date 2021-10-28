package com.jica.chap11;

import java.util.Scanner;

public class Blank {

	public static void main(String[] args) {
		System.out.println("정보를 입력하세요 --> ");
//		Scanner scanner = new Scanner(System.in);
//		String inputProfile = scanner.nextLine();
//		String arr[]  = inputProfile.split(",");
		String animals = "dog,cat,bear";
		String[] arr   = animals.split(",");
		
		
		System.out.println(String.join("-", arr));
		System.out.println(arr[0]);
		
	}

}
