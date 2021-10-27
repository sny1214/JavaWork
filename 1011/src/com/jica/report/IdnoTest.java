package com.jica.report;

import java.util.Scanner;

public class IdnoTest {

	public static void main(String[] args) {
		String idno;
		
		//주민번호 입력
		Scanner scanner = new Scanner(System.in);
		System.out.print("주민번호 입력 ==> "); //"980512-1257236"
		idno = scanner.nextLine();
		System.out.println("입력한 주민번호 ==> |" + idno + "|");
		//if( idno == "" || idno.length() < 14 ) {
		//	System.out.println("-(하이픈) 포함 14자리를 정확히 입력하세요.");
		//	System.exit(0); //프로그램 강제 종료
		//}
		
		if( idno == "" || idno.length() < 3 ) {
			System.out.println("-(하이픈) 없이 13자리를 정확히 입력하세요.");
			System.exit(0); //프로그램 강제 종료
		}
		
		//주민번호 검증 메서드 호출
		//boolean result = idnoCheck(idno);
		
		boolean result = idnoCheck2(idno);
		
		String resultMessage;
		resultMessage = result ? " 정상 " : " 오류 ";
		System.out.println("입력하신 " + idno + " 는 " + resultMessage + " 입니다.");
		
	}
	
	static boolean idnoCheck2(String idno) {
		// 0123456789012   //위치값               i
		//"9805121257236"  
		//"1111111111118"
		
		int baseNumber[]= {2,3,4,5,6,7,8,9,2,3,4,5};
		int sum = 0;
		for(int i=0; i<idno.length()-1; i++) {
			sum += (idno.charAt(i) - 48) * baseNumber[i];
		}
		
		//2. 나머지 계산
		int remain = sum % 11;
		
		//3. 최종 계산 결과값 
		int result;
		if(remain >= 2 && remain <= 11) {
			result = 11 - remain;	
		}else if( remain == 0) {
			result = 1;
		}else {
		    result = 0;
		}
		
		//디버깅용 출력
		System.out.println("검증숫자는 " + result + " 이어야 합니다.");
		
		//4. 판별
		return (idno.charAt(12) - 48) == result ? true : false;

	}

	static boolean idnoCheck(String idno) {
		// 01234567890123   //위치값               i
		//"980512-1257236"  
		//"111111-1111118"
		// 234567 892345    //차례로 곱할 정해진 숫자  baseNumber
		
		// 1. 숫자를 차례로 곱하여 합계 계산
		int sum = 0;
		int baseNumber = 2;
		for(int i=0; i<=12; i++ ) {
			if( i == 6 ) continue;   //아무것도 안하고 지나간다
			//if( i == 6 ) {
			//	continue;
			//}                              //와 같다
			
			
			
			//char chatAt(int)를 사용하여 한문자 추출
			//int iNumber = idno.charAt(i) - 48; //'9'  ---> 9
			
			//String substring​(int beginIndex, int endIndex)
			String strNo = idno.substring(i, i+1); //"9" 문자열에서 한글자씩 읽어와
			int iNumber = Integer.parseInt(strNo); //"9" ---> 9  (단일)문자를 숫자로 바꿔
			sum += iNumber * baseNumber;

			if( ++baseNumber >= 10) {			//basenumber 23456789 반복
				baseNumber = 2;
			}			
		}

		//2. 나머지 계산
		int remain = sum % 11;
		
		//3. 최종 계산 결과값 
		int result;
		if(remain >= 2 && remain <= 11) {
			result = 11 - remain;	
		}else if( remain == 0) {
			result = 1;
		}else {
		    result = 0;
		}
		
		//디버깅용 출력
		System.out.println("검증숫자는 " + result + " 이어야 합니다.");
		
		//4. 판별
		if( result == (idno.charAt(13) - 48)) {
			return true;
		}else {
			return false;
		}
	}
}
