package com.jica.io;

import java.io.*;
import java.util.Arrays;	

class IOEx4 {
	public static void main(String[] args) {
		byte[] inSrc = {0,1,2,3,4,5,6,7,8,9};
		byte[] outSrc = null;

		byte[] temp = new byte[4];

		ByteArrayInputStream  input  = null;
		ByteArrayOutputStream output = null;

		input  = new ByteArrayInputStream(inSrc);
		output = new ByteArrayOutputStream();
		//inSrc  0x100--->[0,1,2,3,4,5,6,7,8,9] //원본배열
		//                                    ^                    
		//input  0x200--->[| ,...]
		//output 0x300--->[...,[0,1,2,3,4,5,6,7,8,9]]
		//outSrc 0x500--->[0,1,2,3,4,5,6,7,8,9]     //원본배열을 읽어서 동일한내용가지는 새로 만든 배열
        //temp   0x400--->[8,9,6,7]
		//len    2
		try {
			//           10, 6, 2, 0
			while(input.available() > 0) {
				//4,4,2
				int len = input.read(temp); // 읽어 온 데이터의 개수를 반환한다.
				output.write(temp, 0, len); // 읽어 온 만큼만 write한다.
			}
		} catch(IOException e) {}

		outSrc = output.toByteArray();

		System.out.println("Input Source  :" + Arrays.toString(inSrc));
		System.out.println("temp          :" + Arrays.toString(temp));
		System.out.println("Output Source :" + Arrays.toString(outSrc));
	}
}
