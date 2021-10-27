package com.jica.chap09;

class StringEx6 {
	public static void main(String[] args) {
		int iVal = 100;
		String strVal = String.valueOf(iVal);	// 100-->"100"
		
		double dVal = 200.0;
		String strVal2 = dVal + "";	// 200.0-->"200.0"

		double sum  = Integer.parseInt("+"+strVal)+Double.parseDouble(strVal2);
		double sum2 = Integer.valueOf(strVal) + Double.valueOf(strVal2);
        //            ---"100" --> 100 ------ 
		System.out.println(String.join("",strVal,"+",strVal2,"=")+sum);
		System.out.println(strVal+"+"+strVal2+"="+sum2);
	}
}
