
public class Test {

	//1. Java는 객체지향 언어이므로 반드시 1개 이상의 클래스가 있어야 한다.
	//2. 클래스명은 파일명과 동일하고, 파일의 확장자는 .java이다.
	//   => Test.java
	//3. 클래스가 1개 파일에 여러 개일 때, public 클래스는 단 1개여야 한다.
	//4. 프로그램의 시작은 main() 메서드로부터 시작한다.
	//5. main() 메서드는 프로그램 시작 시 자동으로 JVM 으로 호출되어 실행된다.
	//6. main() 메서드의 인자정보는 프로그램 시작 시 전달되는 값을 저장한다.
	//   이러한 매개변수를 명령행 인자라고 부른다.
	//7. 명령행인자는 사용자가 실행하면서 전달한 값을 저장하게 된다.
	
	//					   |--명령행 인자--|    <----args변수 : string배열
	public static void main(String[] args) {	
		//args 0x10 ---> ""
		
		//run configulation 가서 arguments에서 100 85 입력시, 빈칸을 기준으로 문자열, 현재 문자열 2개
		//args 0x10 ---> [0x01, 0x02]		
		
		System.out.println("args : " + args);
		System.out.println("args.length : " + args.length);		// 0--->2로 바뀜
		//System.out.println(args[0]);	//error, 요소가 0개이므로 요소값을 접근할 수 없다.
		
		
		if (args.length != 3) {
			System.out.println("실행 시 명령행 인자로 성명과 숫자값 2개를 전달하시오");
			System.exit(0);
		}
		
		String name = args[0];					//홍길동
		int score1 = Integer.parseInt(args[1]);	//45
		int score2 = Integer.parseInt(args[2]); //60
		
		int sum = score1 + score2;
		double average = sum / 2.0;
		
		System.out.println(average);
		
		System.out.printf("%s %d %d %d %6.2f%n", name, score1, score2, sum, average);
	}

}
