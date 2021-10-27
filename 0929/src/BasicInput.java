import java.util.Scanner; //입력 개체가 어디 클래스에 있는지 맨 위쪽에 어디에 있는지 알려줌, java.util에 있다..

public class BasicInput {

	public static void main(String[] args) {
		int age; //age는 int 정수형 변수이라고 선언
		
		//키보드로 나이를 입력받아 age 변수에 저장하자.

		//키보드로 입력받는 절차

		//1. 입력 개체 먼저 생성. 이 때 입력 개체가 어디 클래스에 있는지 맨 위쪽에 어디에 있는지 알려줘야, 이 문장만 입력시 오류가 뜨면서 생기는 창에서 위치 지정 가능
		Scanner scanner = new Scanner(System.in);
		
		//2. 키보드로 입력받아 저장 (초기값 안주고, 키보드로 입력한 값을 초기값으로 주고싶음, 실행 시 콘솔 창의 입력해야 하는 부분에서 커서가 멈춰있다)
		// 안내 문구를 작성해 입력 위치를 사용자에게 알려줄 수 있다.

		System.out.print("나이를 입력하세요 ==> ");
		// print 바로 출력, println 줄을 바꿔서 출력하라, 입력시 자동으로 다음 줄로 입력되도록 바뀜
		
		age = scanner.nextInt();
		// 이때 키보드로 입력한 것은 문자, nextInt()함수가 문자열을 숫자값으로 바꿔서 정수형 변수인 age로 들어가도록 함
		
		
		System.out.println("입력된 나이는 " + age + " 입니다.");

	}

}
