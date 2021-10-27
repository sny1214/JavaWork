package com.jica.chap04;

class FlowEx14 {	
	public static void main(String[] args) { 
		for(int i=1; i<= 10; i++) {
			System.out.println(i);
		}
		System.out.println("----------------------------------------");
		
		
		for(int i=1,j=10;i<=10;i++,j--)
			System.out.printf("%d \t %d%n", i, j);	// \t : tab키를 누른 효과
	}
}
