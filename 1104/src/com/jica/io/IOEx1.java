package com.jica.io;

import java.io.*;
import java.util.Arrays;

class IOEx1 {
	public static void main(String[] args) {
		//1 byte에 표현될수 있는 값의 범위 : -128~0~127
		byte[] inSrc = {0,1,2,3,4,5,6,7,8,9};
		byte[] outSrc = null;

		ByteArrayInputStream  input  = null;
		ByteArrayOutputStream output = null;

		//input은 inSrc배열로부터 읽기 기능을 수행하는 입력스트림
		input  = new ByteArrayInputStream(inSrc);
		//output은 byte[]배열에 출력 기능을 수행하는 출력스트림
		output = new ByteArrayOutputStream();
		
		//                000000000000000100000010...00001001
		//inSrc  0x100--->[0,1,2,3,4,5,6,7,8,9] //원본배열
		//                 ^                    
		//input  0x200--->[| ,...]	
		//output 0x300--->[...,[0,1,2,....9]]
		//outSrc 0x400--->[0,1,2,3,4,5,6,7,8,9] //원본배열을 읽어서 동일한내용가지는 새로 만든 배열
        //data   -1;
		
		int data = 0;

		//더이상 읽을 데이타가 없으면 read()메서드는 -1을 리턴한다
		//while((data = input.read()) != -1) {
		//	output.write(data);	// void write(int b)
		//}
		
		data = input.read();
		while(data != -1) {
			output.write(data);	// void write(int b)			
			data = input.read();
		}

		//ByteArrayOutStream내부의 버퍼데이타를 꺼내오기
		outSrc = output.toByteArray(); // 스트림의 내용을 byte배열로 반환한다.

		System.out.println("Input Source  :" + Arrays.toString(inSrc));
		System.out.println("Output Source :" + Arrays.toString(outSrc));
	}
}
