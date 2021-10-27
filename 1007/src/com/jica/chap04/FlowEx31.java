package com.jica.chap04;

class FlowEx31 {
	public static void main(String[] args) {
		for(int i=0;i <= 10;i++) {
			if (i%3==0)
				continue;			//3의 배수는 출력되지 않음
			System.out.println(i);
		}
	}
}
