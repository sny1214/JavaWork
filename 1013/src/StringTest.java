import java.util.Scanner;

public class StringTest {

	public static void main(String[] args) {

		//아래의 코드에서 10, 3.141592, "JICA", 85, 70, "pass", "fail" 등을
		//Literal value라고 한다.
		//즉, 프로그램 소스에 직접 값이 표현된 것을 말한다.
		//Literal value는 값이 동일하면 한개만 메모리에 확보된다.
		//또한 메모리의 위치는 우리는 알 수 없고 내부적으로 관리된다.
		
		System.out.println(10);
		System.out.println(3.141592);
		System.out.println("JICA");

		int score = 85;
		if( score >= 70 ) {
			System.out.println("pass");
		}else {
			System.out.println("fail");
		}
		
		String str = "JICA";
		String str0 = "JICA";
		String str1 = "JICA";
		//위의 str, str0, str1은 동일한 위치정보를 가진다. -> id 똑같다. 메모리 주소 같다 <정적영역>
		
		//new에 의해 생성됐거나 직접 입력했을 때는 값은 같더라도 항상 다른 위치에 저장된다 -> id = 주소값 다르다. <동적영역>
		
		String str2 = new String("JICA");
		String str21 = new String("JICA");
		String str22 = new String("JICA");
		//위의 str2, str21, str22는 동일한 값을 가졌지만
		//new에 의해 동적으로 할당되었으므로 각기 다른 위치에 저장된다.
		
		String str3;
		String str4;
		//키보드로 입력받기위한 입력전용 객체 선언 및 생성
		Scanner scanner = new Scanner(System.in);
		System.out.print("문자열1 입력 ==> ");
		str3 = scanner.nextLine();	//사용자가 키보드로 JICA입력
		System.out.print("문자열2 입력 ==> ");
		str4 = scanner.nextLine();	//사용자가 키보드로 JICA입력
		
		//키보드로 입력된 문자열도 각기 다른 위치에 확보된다.
		System.out.println("------------------------");
		
		System.out.println("JICA");
		System.out.println(str);
		System.out.println(str2);
		System.out.println(str3);
		
		
	}

}
