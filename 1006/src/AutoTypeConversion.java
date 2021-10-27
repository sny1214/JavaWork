
public class AutoTypeConversion {

	public static void main(String[] args) {
		int i = 'A';
		System.out.println("i : " + i);
		System.out.println("(char)i : " + (char)i);  //강제 형변환 - cast연산자
		System.out.printf("%d %c%n", i, i);	//%d 10진수 %c char값으로 출력이므로 코드로 출력됨
		
		long l = 123;
		double d = 3.14F;
		
		System.out.printf("%d%n", 0x123456789L );
		
		//int i2 = 0x123456789L;	//error - 0x123456789 int값의 표현 범위를 벗어남(21억 보다 값이 더 크다)
									//		  0x123456789L long형값을 int에 대입 못한다
		//float f = 3.14;				//error - double형 값을 float형에 저장할 수 없다.
		
		byte b = 127; //ok	        //정수 literal value는 기본형이 int로 인식되지만
									//표현 범위 이내의 값이면 허용된다.
		//byte b2 = 129;//error		//단, 표현 범위를 벗어나면 에러이다.
		byte b3 = ++b;           	//또한 계산의 결과값이 표현범위를 벗어나면 overflow된 값이 저장된다.
									//byte(-128~0~127)형과 short형에는 저장할 수 있다.
		
		System.out.printf(" s:%d%n", 0x1234);
		short s = 0x1234;			//short(-32768~0~32767) 표현범위 이내의 값이므로 ok
		//short s2 = 32768;//error
		System.out.printf(" s3:%d%n", 32768);	//int로 출력
		short s3 = (short)32768;	//강제로 형변환 시켜 강제 저장
		System.out.printf(" s3:%d%n", s3);		//short로 저장됐지만, overflow된 값
	}

}
