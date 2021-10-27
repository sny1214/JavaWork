
public class StringTest2 {

	public static void main(String[] args) {
		String city = "Jeonju";
		String city2 = "Jeonju";
		String city3 = new String("Jeonju");
		
		String city4 = "Namwon";
		String city5 = "Iksan";
		
		//city  0x10 -----> Jeonju
		//city2 0x10 ------^
		//city3 0x20 -----> Jeonju :똑같은 값을 가졌지만 위치정보 다르다.
		
		//city4 0x30 -----> Namwon
		//city5 0x40 -----> Iksan
		
		
		//문자열 비교에서 등가비교(==) 연산자는 위치정보를 비교한다.
		System.out.println(city == city2); 	//true
		System.out.println(city == city3);  //false
		System.out.println(city3 == city4); //false
		
		System.out.println("문자열의 내용값을 비교할 때는 equals()를 사용한다.");
		System.out.println(city.equals(city2)); 	//true
		System.out.println(city.equals(city3));  	//true --> 값이 동일
		System.out.println(city3.equals(city4));    //false
		System.out.println("---------------------------------------------------");
		
		//문자열의 대소비교에서 연산자(>,>=,<,<=)는 위치정보 자체를 비교하므로 아무 의미가 없다. -> 사용하지 않는다.
		//그러므로 문자열의 대소비교에는 compareTo()를 사용한다.
		System.out.println(city.compareTo(city2)); //같다, 0 출력
		System.out.println(city.compareTo(city3)); //같다, 0 출력
		System.out.println(city.compareTo(city4)); //city보다 city4의 문자열 (코드)값이 더 큼, 음수 출력
		System.out.println(city.compareTo(city5)); //city가 city5보다 문자열 (코드)값이 더 큼, 양수 출력
		
	}

}
