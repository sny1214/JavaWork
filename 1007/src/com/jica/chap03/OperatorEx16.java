package com.jica.chap03;

class OperatorEx16 { 
	public static void main(String[] args) { 
		float pi = 3.141592f; 
		
		//					  3141.592f
		//				3141
		//								   3.141
		float shortPi = (int)(pi * 1000) / 1000f; 

		System.out.println(shortPi); 
	} 
} 
