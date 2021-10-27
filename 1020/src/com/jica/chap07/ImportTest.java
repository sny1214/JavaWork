package com.jica.chap07;

import java.text.SimpleDateFormat;
import java.util.Date;

class ImportTest {

	public static void main(String[] args) {
		//날짜와 시간정보를 표현하기 위해 Date 클래스 혹은 Calendar 클래스를 사용한다.
		 Date today = new Date();
		 //오늘날짜 및 시간 정보가 저장된 객체가 생성된다.
		 
		 //today 0x100 --->[년,월,일,시,분,초 정보]
		 //Date 클래스에 어떤 멤버변수가 어떻게 들어가 있는지 모름 <- 설명서에 private으로 공개x

		 //아래와 같이 개별 값 구할 순 있음
		 System.out.println(today.getYear()+1900);	//getYear는 설명서에서 depricated라고 적혀져 있음
		 											//쓸 순 있으나 나중엔 못쓸수도 있다는 의미
		 											//1900더해야 맞는 년도
		 System.out.println(today.getMonth()+ 1);	//0~11값이므로 +1 해야 맞는 월
		 System.out.println(today.getDate());
		 System.out.println(today.getHours());
		 System.out.println(today.getMinutes());
		 System.out.println(today.getSeconds());
		 
		 
		 //년월일과 시분초 값을 문자열로 손쉽게 작성하는 방법 --> 설명서에 패턴문자 설명 있음
		 
		 SimpleDateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd");	//하나의 문자열로 형식정보 얻고 있음
		 SimpleDateFormat timeformat = new SimpleDateFormat("hh:mm:ss a");

		 //java.text.SimpleDateFormat의 상위인 java.text.DateFormatformat 메서드
		 //객체의 값을 참조해서 로직 수행해 정보 가져다 줌
		 System.out.println("오늘 날짜는 " + dateformat.format(today));
		 System.out.println("현재 시간은 " + timeformat.format(today));
	}
}
