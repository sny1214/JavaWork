package com.jica.io;

import java.io.*;
import java.util.Arrays;

class DataOutputStreamEx2 {
	public static void main(String args[]) {
		FileOutputStream fos = null;
		DataOutputStream dos2 = null;
		ByteArrayOutputStream bos = null;
		DataOutputStream      dos = null;

		byte[] result = null;

		try {
			//byte[]로 출력시킨것과 동일한 내용을 file에 출력시키자.
			fos = new FileOutputStream("sample2.dat");
			dos2 = new DataOutputStream(fos);
			dos2.writeInt(10);
			dos2.writeFloat(20.0f);
			dos2.writeBoolean(true);
			
			//byte[]로 출력
			bos = new ByteArrayOutputStream();
			dos = new DataOutputStream(bos);
			
			dos.writeInt(10);
			dos.writeFloat(20.0f);
			dos.writeBoolean(true);
			
            //                       10 20.0 true
			//bos    0x100---->[...,[|||||||||]]
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
				if(result[i] < 0) {             //int값을 byte배열로 변환하여 저장했을때
					                            //1byte의 값은 -128~0~127까지의 범위로 값이 저장될수 있다.
					                            //이때 1byte값이 음수이면 양수로 변환하여 16진수로 나타내자
					hex[i] = String.format("%02x", result[i]+256);
				} else {
					hex[i] = String.format("%02x", result[i]);
				}
			}

			System.out.println("10진수형태로 byte[]값 확인  :" + Arrays.toString(result)); //음수도 나타난다.
			System.out.println("16진수형태로 byte[]값 확인  :" + Arrays.toString(hex));

			dos.close();
			dos2.close();
		} catch (IOException e) {
			e.printStackTrace();		
		}
	} // main
}
