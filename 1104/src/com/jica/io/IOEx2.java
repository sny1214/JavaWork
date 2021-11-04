package com.jica.io;

import java.io.*;
import java.util.Arrays;

class IOEx2 {
	public static void main(String[] args) {
		byte[] inSrc = {0,1,2,3,4,5,6,7,8,9};
		byte[] outSrc = null;

		byte[] temp = new byte[10];

		ByteArrayInputStream  input  = null;
		ByteArrayOutputStream output = null;

		input  = new ByteArrayInputStream(inSrc);
		output = new ByteArrayOutputStream();
		
		//inSrc  0x100--->[0,1,2,3,4,5,6,7,8,9] //원본배열
		//                 ^                    
		//input  0x200--->[| ,...]
		//output 0x300--->[...,[5,6,7,8,9]]
		//outSrc 0x500--->[5,6,7,8,9]           //원본배열을 읽어서 동일한내용가지는 새로 만든 배열
        //temp   0x400--->[0,1,2,3,4,5,6,7,8,9]
		
		//input을 이용하여 1byte씩 읽을때   int read()
		//input을 이용하여 배열크기만큼 읽을때  int	read(byte[] b, int off, int len)
		int len = input.read(temp,0,temp.length); // 읽어 온 데이터를 배열 temp에 담는다.
		
		//void	write(byte[] b, int off, int len)
		// temp[5]부터 5개의 데이터를 write한다.
		output.write(temp,5, 5);	    

		outSrc = output.toByteArray();

		System.out.println("Input Source  :" + Arrays.toString(inSrc));
		System.out.println("temp          :" + Arrays.toString(temp));
		System.out.println("Output Source :" + Arrays.toString(outSrc));

	}
}
