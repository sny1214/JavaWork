
public class PrintTest {

	public static void main(String[] args) {
		String title = "전주정보문화산업진흥원(JICA)";
		char ch = 'A';
		int score = 85;
		double average = 92.35;
		boolean flag = true;
		
		System.out.print(title);
		System.out.print(ch);
		System.out.print(score);
		System.out.print(average);
		System.out.print(flag);
		System.out.println(); 			//줄바꿈
		System.out.println(); 
		
		System.out.println(title);
		System.out.println(ch);
		System.out.println(score);
		System.out.println(average);
		System.out.println(flag);
		System.out.println(); 
		
		System.out.println("형식을 갖춘 출력 -- printf() 메서드를 사용"); 
		
		//정수값(byte, short, int, long) 출력
		System.out.printf("%d %o %x%n", score, score, score); //문자열값"81 125 55"//%d : 10진수, %o : 8진수(일이오 라고 읽어야), %x : 16진수
		System.out.println(Integer.toBinaryString(score)); //문자열값"1010101"
		//Integer(Wrapper래퍼 클래스)의 toBinaryString메서드 : 2진수로 만들어 문자열로 출력
		
		//값 자체 즉, Literal value를 8진수나 16진수로 표현할 수 있다.
		int a = 85;				//10진수 85
		int b = 0125;			//8진수 125
		int c = 0x55;			//16진수 55
		int d = 0b1010101;		//2진수 1010101  // 0 : 10진수로 바꿔라..
		
		System.out.printf("%d %d %d %d%n", a, b, c, d);
		//동일한 정수값이어도 자료형을 Literal value에 지정할 수 있다(long)  		//short, byte로 인식하는 방법은 없음
		int iValue = 100;		// 4byte int값 : int를 기본으로!!
		long lValue = 100L ; 	// 8byte long값 : 뒤에 L 붙임

		
		//논리값(boolean) 출력
		System.out.printf("%b%n",  flag); // %b --> true, false

		//실수값(double, float) 출력
		System.out.printf("|%f| |%10.2f| |%-10.2f|%n", average, average, average);
		// %f : 실수값, %4d : 소숫점 없이 전체자리수 4, %5.2f : 소숫점 포함 전체 자리수 5, 소수점 이하 자리수 2
		// 형식변환기호와 함께 - 기호 사용시 맞춤기준 --> 좌측 기준 (기본적으로 우측 기준)
		// 형식변환기호 외의 문자들은 그대로 출력된다.
		// %t tap(4칸 건너뜀)
		
		//소수점이 있는 실수 상수 표현은 기본으로 double형 Literal value로 평가된다.
		double dValue = 3.1415;			// 8byte double형
		//float fValue = 3.1415;		// error 발생(이유 : float 4byte<double 8byte 이므로)
		float fValue = 3.1415F;			// 4byte  float형 (F를 붙여 float로 바꿔줌)
		
		System.out.printf("%8.4f %8.4f%n", dValue, fValue);
		
		//표준에러출력은 모든 사용법이 동일하나 화면에 출력되는 색상이 다르다.(빨강색)
		System.out.println("표준 출력 입니다.");
		System.err.println("표준 에러출력 입니다.");			//순서상으로 에러가 먼저 나오고 검정이 나중에 출력될 수도 있다. - 별도의 쓰레드를 작동시키므로.....
	}

}
