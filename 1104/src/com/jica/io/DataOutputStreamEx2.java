package com.jica.io;

import java.io.*;
import java.util.Arrays;

class DataOutputStreamEx2 {
	public static void main(String args[]) {
		ByteArrayOutputStream bos = null;
		DataOutputStream      dos = null;

		byte[] result = null;

		try {
			bos = new ByteArrayOutputStream();
			dos = new DataOutputStream(bos);
			dos.writeInt(10);
			dos.writeFloat(20.0f);
			dos.writeBoolean(true);

			//bos    0x100---->[...,[||||||||||]]
			//                  | 
			//dos    0x200---->[|,..]
			//result 0x300---->[||||||||||]
			//                  ---- ---- -	
			//                   10  20.0f true
			//                       10000001101000000000000000000000
			result = bos.toByteArray();

			String[] hex = new String[result.length];
			//hex 0x400--->[null,null,null,....]
			
			for(int i=0;i<result.length; i++) {
				if(result[i] < 0) { 
					hex[i] = String.format("%02x", result[i]+256);
				} else {
					hex[i] = String.format("%02x", result[i]);
				}
			}

			System.out.println("10진수  :" + Arrays.toString(result));
			System.out.println("16진수  :" + Arrays.toString(hex));

			dos.close();
		} catch (IOException e) {
			e.printStackTrace();		
		}
	} // main
}
