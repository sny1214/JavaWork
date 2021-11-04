package com.jica.io;

import java.io.*;
import java.util.Arrays;

class IOEx3 {
	public static void main(String[] args) {
		byte[] inSrc = {0,1,2,3,4,5,6,7,8,9};
		byte[] outSrc = null;

		byte[] temp = new byte[4];	// 이전 예제와 배열의 크기가 다르다.

		ByteArrayInputStream input = null;
		ByteArrayOutputStream output = null;

		input  = new ByteArrayInputStream(inSrc);
		output = new ByteArrayOutputStream();

		System.out.println("Input Source  :" + Arrays.toString(inSrc));

		//inSrc  0x100--->[0,1,2,3,4,5,6,7,8,9] //원본배열
		//                                    ^                    
		//input  0x200--->[| ,...]
		//output 0x300--->[...,[0,1,2,3,4,5,6,7,8,9,6,7]]
		//outSrc 0x500--->[0,1,2,3,4,5,6,7,8,9,6,7] //원본배열을 읽어서 동일한내용가지는 새로 만든 배열
        //temp   0x400--->[8,9,6,7]
		//len      2
		
		int len = 0;  //읽은 byte수
		try {     //    10  6  2 0
			while(input.available() > 0) {
				//byte배열이 꽉차거나 읽을 byte가 없을때까지 읽기
				//int read(byte[])
				len = input.read(temp);  //4,4,2
				System.out.println("읽은 byte수 : " + len);
				output.write(temp); 
				outSrc = output.toByteArray();
				printArrays(temp, outSrc);
			}
		} catch(IOException e) {}
	} // main의 끝

	static void printArrays(byte[] temp, byte[] outSrc) {
		System.out.println("temp          :" +Arrays.toString(temp));
		System.out.println("Output Source :" +Arrays.toString(outSrc));	
	}
}
