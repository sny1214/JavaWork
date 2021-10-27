package com.jica.chap05;

class ArrayEx13 {
	public static void main(String[] args) {
		//16진수 값을 이진수 형태로 변환하여 출력하고 싶다.
		
		//아래의 char배열 hex의 내용값은 16진수를 의미한다. 16진수 C,A,F,E
		char[] hex = { 'C', 'A', 'F', 'E'};	//        char 기본자료형, String 참조형
											// 저장값       코드값     실제저장위치정보
		//String형 객체 : char형 배열의 데이터, 기타데이터,..., 메서드 까지 함께 모여있음
		// char.length --> 4개라고 바로 나오지만, char은 길이 구하는 것만 쓸수 있어
		// str.length() ---> 실제데이터의 갯수만 구해라, length()메서드 --> 4
		// str에는 객체이므로 다양한 메서드 사용 가능
		// str.charAt(1) ==> 'A'
		// str.다양한메서드() 사용가능, char은 불가
		// str.substring(1,3) --> 'AF'
		// str.indexOf('E') --> 3
		
		//아래의 String배열 binary는 각 요소값으로 이진수 형태의 문자열을 가진다(0x0, 0x1, 0x2...)
		String[] binary = {   "0000", "0001", "0010", "0011"
						    , "0100", "0101", "0110", "0111"
						    , "1000", "1001", "1010", "1011"
						    , "1100", "1101", "1110", "1111" };
							//16개 (0x0,0x1,0x2,0x3,0x4,0x5,0x6,0x7,0x8,0x9,
							//      0xA,0xB,0xC,0xD,0xE,0xF)

		String result=""; //빈문자열을 의미, null은 아님
		
		for (int i=0; i < hex.length ; i++ ) {	//hex.length = 4 --> i 0~3
			
			if(hex[i] >='0' && hex[i] <='9') {	//0~9 사이값이면
				result +=binary[hex[i]-'0'];	   // 문자 '8'-'0' => 56 - 48 (char 코드값)
												   // hex[i]-'0' : 문자값을 숫자값으로 바꾸는 코드
			
			} else {	// A~F이면
				result +=binary[hex[i]-'A'+10]; // 'C'(67)-'A'(65) +10 ===> 2 +10 = 12 ==> 16진수 중 12 의미
												// hex[i]-'A'+10 : 문자를 16진수로 변환시킨 효과
			}
		}

		//result += ~ : result에 문자열 누적...
		// result     1100 1010 1111 1110 
		//			    C    A    F   E
		
		// 아래의 코드는 문자열을 만든다.
		System.out.println("hex:"+ new String(hex)); // String(char[] value)
		// 문자열을 16진수로 나타낸 값을 출력한
		System.out.println("binary:"+result);
	}
}
