package com.jica.chap09;

class  StringBufferEx2 {
	public static void main(String[] args) {
		StringBuffer sb  = new StringBuffer("01");
		StringBuffer sb2 = sb.append(23);
		//                    |-->|0|1|2|3|4|5|6|7|8|9|.|0||||
		//sb  0x100--------->[0x10,...]
		//sb2 0x100---------^
		//sb3 0x100---------^
		sb.append('4').append(56);  //메서드 체이닝
		
		StringBuffer sb3 = sb.append(78);			
		sb3.append(9.0);

		System.out.println("sb ="+sb);
		System.out.println("sb2="+sb2);
		System.out.println("sb3="+sb3);

		//                    |-->|0|1|2|a|b|c|E|N|D|||||||||||
		//sb  0x100--------->[0x10,...]
		System.out.println("sb ="+sb.deleteCharAt(10));
		System.out.println("sb ="+sb.delete(3,6));
		System.out.println("sb ="+sb.insert(3,"abc"));
		System.out.println("sb ="+sb.replace(6, sb.length(), "END"));

		// length()는 실제저장된 문자의 갯수
		// capacity()는 문자를 저장하기 위해 내부에 확보된 메모리 공간의 크기
		System.out.println("capacity="+sb.capacity());
		System.out.println("length="+sb.length());
	}
}

class Some{
	//...
	
	Some method() {
	   //....
	   return this;	
	}
}
