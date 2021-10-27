package com.jica.chap03;

class OperatorEx18 {
	public static void main(String args[]) { 
		double pi = 3.141592; 
		double shortPi = Math.round(pi * 1000) / 1000.0;
						//Math클래스.round메서드() <-- 객체 호출 없이 쓸 수 있는 static 메서드
						//반올림 하는 메서드
						//           3141.592
						//Math.round(float) --> 결과값 long형 ---> 3142
						// 3142 (long형)       / 1000.0 (float형)
		                // 				    3.142 (float형)
		System.out.println(shortPi);
	}
}
