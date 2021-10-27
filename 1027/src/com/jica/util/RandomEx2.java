package com.jica.util;

import java.util.*;

class RandomEx2 { 
	public static void main(String[] args) { 
		Random rand = new Random();
		int[] number = new int[100]; 
		int[] counter = new int[10]; 

		for (int i=0; i < number.length ; i++ ) { 
//			System.out.print(number[i] = (int)(Math.random() * 10)); 
//                  0<=x<10 ������ ���� x�� ��ȯ�Ѵ�.
			System.out.print(number[i] = rand.nextInt(10));	  
		} 
		System.out.println(); 
		
		//number  0x100-->[7,4,3,1,5,1,1,7,8,0,0,0,0,0,0,0.....0]
		//counter 0x200-->[0,8,0,1,1,1,0,2,1,0]
		for (int i=0; i < number.length ; i++ ) { 
			counter[number[i]]++; 
		} 

		for (int i=0; i < counter.length ; i++ ) { 
			System.out.println( i +"의 갯수 :"+ printGraph('#',counter[i]) + " " + counter[i]); 
		} 
	} 

	public static String printGraph(char ch, int value) { 
		char[] bar = new char[value]; 

		for(int i=0; i < bar.length; i++) { 
			bar[i] = ch; 
		} 
		return new String(bar); 
	} 
} 
