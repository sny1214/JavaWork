package com.jica.io.character;

import java.io.*;

class StringReaderWriterEx {
	public static void main(String[] args) {
		String inputData = "ABCD";  //원본문자열

		StringReader input  = new StringReader(inputData);
		StringWriter output = new StringWriter();
		//                "ABCD"
		//input  0x100--->[|,...]
		//output 0x200--->[..,[ABCD]]
		int data = 0;

		try {
			while((data = input.read()) != -1) {
				output.write(data);	// void write(int b)
			}
		} catch(IOException e) {}

		System.out.println("Input Data  :" + inputData);
		System.out.println("Output Data :" + output.toString());
//		System.out.println("Output Data :" + output.getBuffer().toString());
	}
}
