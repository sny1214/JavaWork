

public class CharsStringTest {

	//char[] 과 String 의 차이
	public static void main(String[] args) {
		char chs[] = {'J','I','C','A'};
		String names = "JICA";
		
		//chs      0x100 ---> JICA
		//names	   0x200 ---> JICA,...(추가적 기타데이터),메서드들
		
		//String의 데이터를 저장할 때는 내부적으로 char[] 배열의 저장구조를 사용한다
		//char[]도 객체로 취급되므로 참조값이 저장된다.
		//단, 저장된 요소의 갯수만 사용할 수 있다.
		System.out.println(chs.length);	//멤버변수, 자바언어에선 필드(field라 부름
		System.out.println();
		
		
		//String은 객체로 취급되고 다양한 메서드를 사용할 수 있다.
		System.out.println(names.length());	//메서드(method), (멤버변수x)
		System.out.println(names.charAt(2));
		System.out.println(names.substring(1,3)); //'IC' -> 1번째부터 3번째 직전까지	(3번째 포함 x)
		System.out.println(names.indexOf('C'));	  //2
		System.out.println(names.equals("JICB")); //false -> 문자열이 같은가			

		//이러한 특성으로 String 객체를 생성할 때 char[]을 사용할 수도 있다.
		//chs      0x100 ---> JICA
		//names	   0x200 ---> JICA,...(추가적 기타데이터),메서드들
		//name2    0x300 ---> JICA,...,메서드들
		
		String name2 = new String(chs);	//String 생성자 , 인자값으로 chs 배열 전달함
		System.out.println(names.equals(name2));	//true
		
	}
}
