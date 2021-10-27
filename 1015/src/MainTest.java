class MainTest {
	//main()메서드는 프로그램 시작점이다.
	//인위적으로 호출할 수도 있지만 우리는 호출하지 않는다
	public static void main(String args[]) {
		main(null);			//이미 메인 메서드 호출했는데 또 한 것(재귀호출), 그리고 string에 null전달
		//StackOverflowError 나올 것이다.
	}
}
