package com.jica.chap09;

import java.util.*;

class RandomEx1 {
	public static void main(String args[]) {
		//생성자 Random()				---내부적으로 현재 시각을 기준으로 난수를 발생
		//					    	   항상 다른 값으로 난수값이 만들어진다.
		// 	   Random(int seed)	   ---주어진 seed값을 기준으로 난수를 발생
		//                            항상 동일순서로 난수값이 만들어진다.
		
		//Random rand  = new Random(1);
		//Random rand2 = new Random(1);
		
		
		Random rand  = new Random();


		System.out.println("= rand =");
		for(int i=0; i < 5; i++)
			System.out.println(i + ":" + rand.nextInt());

		Random rand2 = new Random();
		
		System.out.println();
		System.out.println("= rand2 =");
		for(int i=0; i < 5; i++)
			System.out.println(i + ":" + rand2.nextInt());
	}
}
