//이클립스에서는 'sysout' 이라고 입력하고 'ctrl+space'를 누르면 System.out.println()이 자동 입력된다.

public class First {

	public static void main(String[] args) {
	//기본 데이터타입 = 원시 데이터타입(primitive data type)
		//문자값
			// 0개 이상의 문자로 이루어진 값들을 문자열-String이라고 한다(character가 여러개 모인 것)
			// 산술적인 계산엔 참여하지만, 의미를 부여한 단어
			// 이를 표현할 때는 반드시 큰따옴표("")사용
		System.out.println("-----문자열 출력-----");
		System.out.println("전주정보문화산업진흥원");
		System.out.println("JICA");
		System.out.println("A");
		System.out.println("강");
		System.out.println("2");
		System.out.println("");
		
			// 반드시 한 글자로만! 이루어진 문자를 단일문자-Character라고 부른다.
			// 이를 표현할때는 작은따옴표('')사용 "A","강","2"는 'A','강','2'도 ok. ""는불가!!
		System.out.println("-----단수문자 출력-----");
		System.out.println('A');
		//System.out.println('AB');
		System.out.println('강');
		//System.out.println('강백호');
		System.out.println('2');
		//System.out.println(''); //에러

		//숫자값
		System.out.println("-----숫자값(정수, 실수) 출력-----");
		System.out.println(75);
		System.out.println(83);
		System.out.println(185.54);
		
		//논리값
		System.out.println("-----논리값(true,false) 출력-----");
		System.out.println(true);     //참
		// System.out.println("true");이면 문자열, 논리값 아님
		System.out.println(false);    //거짓
		
		//예시
		System.out.println("5a7");
	}

}
