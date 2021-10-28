package com.jica.chap11;

import java.util.*; 

class ArrayListEx2 { 
	public static void main(String[] args) { 
		final int LIMIT = 10;	// 글자의 갯수
		//                        10        20        30        40    
		String source = "0123456789abcdefghijABCDEFGHIJ!@#$%^&*()ZZZ"; 
		int length = source.length(); 

		List<String> list = new ArrayList<String>(length/LIMIT + 10); // 공간을 여유있게 확보
		//                        |-->["0123456789","abcdefghij","ABCDEFGHIJ","!@#$%^&*()","ZZZ",null,null,...] 
		// list 0x100--------->[0x200,...]
		
		for(int i=0; i < length; i += LIMIT) { 
			if(i+LIMIT < length ) 
				list.add(source.substring(i, i+LIMIT)); 
			else 
				list.add(source.substring(i)); 
		} 

		for(int i=0; i < list.size(); i++) { 
			System.out.println(list.get(i)); 
		} 
	} // main()
} 
