package com.jica.chap11;

public class MilliSecondTest {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		System.out.println("start : " + start);
		
		for(int i=0; i < 1000; i++) {
			System.out.println(i + " ");
		}
		long end = System.currentTimeMillis();
		System.out.println("end : " + end);
		System.out.println("0~999까지 출력하는 데 걸린 시간은 " + (end - start)
							+ " ms 입니다." );
		 

	}

}
