package com.jica.chap09;

import java.util.StringJoiner;

class StringEx5 {
	public static void main(String[] args) throws Exception {
		String str = "가";

		//엔코딩(encoding)

		byte[] bArr  = str.getBytes("UTF-8");  //UTF-8  - 한글1문자 3byte  byte[]만들기
		byte[] bArr2 = str.getBytes("CP949");  //유니코드 - 한글1문자 2byte

		System.out.println("UTF-8:" + joinByteArr(bArr));
		System.out.println("CP949:" + joinByteArr(bArr2));

		//디코딩(decoding)
		//String​(byte[] bytes, String charsetName)
		System.out.println("UTF-8:" + new String(bArr,  "UTF-8"));
		System.out.println("CP949:" + new String(bArr2, "CP949"));
	}

	static String joinByteArr(byte[] bArr) {
		 StringJoiner sj = new StringJoiner(":", "[", "]");

		for(byte b : bArr)
			sj.add(String.format("%02X",b));

		return sj.toString();
	}
}
