package com.jica.chap02;

class OverflowEx {
	public static void main(String[] args) {
		//short형의 표현범위   -32768~0~32767
		short sMin = -32768;
		short sMax = 32767;
		//           0 
		//        -1     1
		//       -2       2
		//      ...       ... 
		//       -32768 32767  
		
		//char형의 표현범위    0~65535
		char  cMin = 0;
		char  cMax = 65535;
		
		//          0 
        //   65535     1
		//   65534      2 
		//     ...      ...
		//   32769     32767
		//         32768 
		System.out.println("sMin  = " + sMin);
		System.out.println("overflow된값 sMin-1= " + (short)(sMin-1));
		System.out.println("sMax  = " + sMax);
		System.out.println("overflow된값 sMax+1= " + (short)(sMax+1));
		
		System.out.println("cMin  = " + (int)cMin);
		System.out.println("overflow된값 cMin-1= " + (int)--cMin);
		System.out.println("cMax  = " + (int)cMax);
		System.out.println("overflow된값 cMax+1= " + (int)++cMax);	
	}
}
