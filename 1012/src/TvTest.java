
public class TvTest {

	public static void main(String[] args) {
		//객체 생성
		//클래스명 참조변수명 = new 클래스명();
		
		Tv tv1 = new Tv();
		
		//tv1 생성하는 순간 메서드말고 멤버변수만 메모리 공간 할당됨(멤버변수-원하는 특성만 묶어놓음)
		//				 color  channel  power
		//tv1 0x100 ---> [null,    0   , false]	//논리값의 디폴트는 false 이므로

		//멤버변수 접근
		tv1.color = "흰색";  //tv1의 color 특성에 "흰색" 넣어라
		tv1.channel = 7;
		 
		//메서드 접근
		tv1.power(); //현재 tv1의 power : false --> power메서드에서 !power로 바꾼 후, power에 넣어줘
		
		//객체 사용
		System.out.printf("색상 : %s 채널 : %d 전원상태 : %b%n",
							tv1.color, tv1.channel, tv1.power);
		tv1 = null;
		//				 color  channel  power
		//tv1 0x100 -x-> [null,    0   , false], 메모리에는 존재하나 접근 불가, 쓸수 없어 --> JVM이 나중에 쓸모 없는 걸 알고 정리해버려(garbage collecting기능)
		
	}

}


//Tv의 설계도에 해당하는 Tv클래스 정의
class Tv{
	//Tv의 상태적 특성 - 멤버변수, 필드(field)
	String color;
	int channel;
	boolean power;
	
	//Tv의 행위 - 메서드
	boolean power() {
		int sum = 0;	//x, sum : 지역변수
		// power를 부정을 만들어서 넣어라
		power = !power; //중요 : 메서드 내부에서는 멤버변수를
						//		자유롭게 접근할 수 있다.
						// power : Tv 객체가 존재하는 한 자유롭게 접근 가능하다.
	
		return power;
	}

	void channelUP() {
		++channel;
	}

	void channelDown() {
		--channel;
	}
}
