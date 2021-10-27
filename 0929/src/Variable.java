// 변수 선언 및 초기화 방법
public class Variable {

	public static void main(String[] args) {
		// 정수 값을 저장할 변수 score를 선언한 문장
		int score;
		
		// 정수값을 저장할 변수 score2를 선언하고 초기값을 지정한다.
		// 유효값이 저장되었으므로 이때 변수가 확보된다.
		int score2 = 88;
		int total;
		
		// 선언만 수행된 변수는 값을 읽어올 수 없다.
		// 즉, 선언된 변수에 유효한 값을 저장하지 않으면
		// 아직 메모리 공간에 변수가 생성되지 않으므로 사용할 수 없다.
		
		// 최초로 유효한 값이 지정되는 순간 실제 변수가 확보된다. (변수가 정의되었다)
		score = 75;
		
		// 두 점수를 합하여 총점을 계산한다.
		total = score + score2;
		
		// System.out.println(grade); ==> error
		// 선언되지 않은 변수는 사용할 수 없다.
		
		System.out.println("점수1 : " + score + "점");
		System.out.println("점수2 : " + score2 + "점");
		System.out.println("총점 : " + total + "점");
		System.out.println("평균 : " + total / 2 + "점");
		
		// 변수가 선언되었다 할지라도 유효한 값이 지정되기 전까지는 변수값을 읽어올 수 없다 = r-value로 사용될 수 없다.(기억장소 안 만들어져 -> 초기값 지정해줘야 기억장소 생성)
		// 여기선, score2 -> score -> total 순으로 기억장소 생성되었다.
		// 대입연산자(=) 왼쪽에 있는 건 l-value, 오른쪽에 있거나 그 외는 r-value.
		// 변수값을 읽어오는 표현을 r-value라고 한다.
		// 변수에 값을 저장하는 표현을 l-value라고 한다. l-value는 선언만 되면 사용할 수 있다.
		
	}

}
