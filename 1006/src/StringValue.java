
public class StringValue {

	public static void main(String[] args) {
		char ch = 'J';	//코드값 74 //j가 직접 들어가 있음
		System.out.printf("%c %d%n", ch, (int)ch);

		String name = "Java Programming";		//name 무조건 4바이트, 위치정보(id) 저장되어 있는 것 = 객체로 저장되어 있다.
		System.out.printf("%s%n", name);
		
		//ch, name의 메모리의 상태정보는 전혀 다르다.
		//ch는 2byte에 'J'값 즉, 코드 74가 저장되어 있다.
		//name는 4byte에 위치정보(심볼테이블의 식별자-정수)가 저장되어 있다.
		//(심볼테이블에서 주소값(id-정수)--> 메모리의 실제주소값으로 연결시켜--> 해당 메모리에 있는 값 출력)
		
		String str1 = "JICA(전주정보문화산업진흥원)";
		String str2 = ""; 		//ok - 빈 문자열(empty string)
		String str3 = null;		//ok - null : 참조명에만 저장되는 예약어, 즉 참조변수(배열, 객체)에만 저장할 수 있다.
								//참조변수 : 위치정보를 저장하는 변수, null은 위치정보는 아직 결정되지 않았다는 의미

		System.out.println(str1.length());	// ok ,17개 문자수임을 알수 있다.
		System.out.println(str2.length());  // ok, 0개
		System.out.println(str3);			// ok
		//System.out.println(str3.length());	//error --> 접근시, run-time error(NullPointerException) 뜸
		//null 값을 직접 출력할 수는 있으나, 접근해 어떠한 기능(메서드) 하라하면 쓸 수 없음
		//null은 참조형에만 쓸 수 있음
		
		
		char ch2 = ' ';	//ok, 공백문자, 코드 32 저장된다
		//char ch3 = '';  // error  -> 사용할 수 없는 표현 (빈문자 불가)
		//---------------------------------------------------------------------------
		
		//모든 기본자료형 값은 문자열(String)과 덧셈연산자(+)와 결합되면
		//연결된 문자열로 변환된다.
		
		String str4 = "Ja" + "va";	//ok "Java"로 저장됨
		String str5 = "Java" + 5;   //ok "Java5" 5가 문자열로 바껴 연결된다
		String str6 = 7 + "Java";	//ok "7Java" 7이 문자열로 바껴 연결된다
		String str7 = 7 + 7 + "Java";	// ok "14Java" 앞부터 덧셈으로 연산 후 문자열로 바껴 연결됨
		String str8 = "Java" + 7 +7;    // ok "Java77" 앞부터 문자열로 연결된 후 연산은 불
		System.out.printf("%s %s %s %s %s%n", str4, str5, str6, str7, str8);
		
    }

}
