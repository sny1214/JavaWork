package com.jica.chap03;

class OperatorEx2 {
	public static void main(String args[]) {
		int i=5, j=0;

		j = i++;
		//			i 5 6
		//			j 0 5
		System.out.println("j=i++; 실행 후, i=" + i +", j="+ j);

		i=5;        
		j=0;

		j = ++i;
		//		    i 5 6
		//			j 0 6
		System.out.println("j=++i; 실행 후, i=" + i +", j="+ j);
	}
}
