package com.jica.string;

import java.util.Arrays;

public class StringTest {

	public static void main(String[] args) {
		// 문자열객체는 문자열자체를 변경할 수 없다
		String str1 = new String();  //빈문자열 객체--거의 사용하지 않는다.
		String str2 = "";            //빈문자열 객체
		
		System.out.println(str1 == str2);
		System.out.println(str1.equals(str2));
		
		// 많이 사용하는 생성자
		String str = new String("JICA 전주정보문화산업진흥원");
		char chs[] = {'J','e','o','n','j','u'};
		String str4 = new String(chs);
		
		//                     0 1 2 3 4 5  6 7 8  9 0 1  2 3 4 5
		//                |-->|J|I|C|A| |전|주|정|보|문|화|산|업|진|흥|원|   
		//str 0x300---->[0x30,...]
		//                    실제문자자체는 byte[]배열로 저장된다. 
		
		System.out.println(str);          //str.toString()
		System.out.println(str.length()); //문자의갯수 16
		System.out.println(str.isEmpty()); //빈문자열인가? false
		
		//부분 문자나 문자열 추출
		System.out.println(str.charAt(7)); // '정'
		System.out.println(str.substring(5));  //5번째부터 끝까지의 문자열     "전주정보문화산업진흥원"
		System.out.println(str.substring(5,9));//5번째부터 9번째이전까지 문자열 "전주정보"
		
		String title = "Jeonju";
		System.out.println(title.compareTo("Jeonju")); //0
		System.out.println(title.compareTo("Jeonjo")); //양수
		System.out.println(title.compareTo("Korea"));  //음수 
		
		System.out.println(title + " 전주");
		String title2 = title.concat(" 전주"); //문자열 합치기
		System.out.println(title2);
		
		str = new String("JICA 전주정보문화산업진흥원 JICA JEONJU");		
		
		//                     0 1 2 3 4 5  6 7 8  9 0 1  2 3 4 5  6 7 
		//                |-->|J|I|C|A| |전|주|정|보|문|화|산|업|진|흥|원| |J|I|C|A| |J|E|O|N|J|U|   
		//str 0x300---->[0x30,...]
		System.out.println(str.contains("C"));      //true
		System.out.println(str.contains("산업진흥원"));//true
		System.out.println(str.contains("진주"));    //false
		
		//몇번째 위치에 있는가?
		System.out.println(str.indexOf("정보"));    //7
		System.out.println(str.indexOf("정보",9));  //-1
		System.out.println(str.indexOf('J'));      //0
		System.out.println(str.indexOf('J',1));    //18
		
		System.out.printf("%s는 %d년도에 만들어졌다.%n", "JICA", 2002);
		String message = String.format("%s는 %d년도에 만들어졌다.", "JICA", 2002);
		System.out.println(message);
		
		String city = "jeonju";
		byte arr[] = city.getBytes();
		//                 |--->|j|e|o|n|j|u|
		//city 0x400 --->[0x60,...]
		//arr 0x500---->[74, 101, 111, 110, 106, 117]
		//                 |--->|k|e|o|n|k|u|
		//city2 0x600 --->[0x60,...]
		System.out.println(Arrays.toString(arr));
		
		String city2 = city.replace('j', 'k');
		System.out.println(city2);
		
		String city3 = "  GunSan Insan ";
		System.out.println(city3 + " " + city3.length());
		
		String city4 = city3.trim();  //앞뒤의 공백문자를 제거
		System.out.println(city4 + " " + city4.length());
		
		//기본자료형을 문자열 객체로 만들기-- static String valueOf(기본자료형)
		
		String strNumber = 7 + "";            //"7"
		String strNumbe2 = String.valueOf(7); //"7"
	}

}
