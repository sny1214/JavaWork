
public class LargeNumber2 {

	public static void main(String[] args) {
		int a = 7, b = 28, c = 3;
		int max;
		
		max = decideMax(a,b,c);
		System.out.println(max);
		System.out.println( decideMax(22, 96, 128) ); //return된 값 다음에 사용 안하면 변수(max) 없이 쓸 수 있다.
		// 근데 decideMax가 리턴값이 업었다면 이런식으로 쓸 수 없음
		
		a = 15;
		b = 97;
		c =3;
		max = decideMax2(a,b,c);
		System.out.println("max : " + max);
	}
	
	static int decideMax2(int a, int b, int c) {  //매개변수 변수와 같은 문자로 쓰여도 메소드 끝나면 매개변수 사라지므로 같은 이름써도 ok
		int max;
		if(a>=b) {
			max = a;
		}else {
			max = b;
		}
		// max 확정 후 나머지 하나와 비교 else없이 단순 if문으로 가능하게 조건 정할 수 있다.
		if(max < c) {
			max = c;
		}
		
		return max;
		
	}
	
	
	static int decideMax(int num1, int num2, int num3) { // 두 수 비교 후, 그 중 큰 값과 나머지 수 비교
	
		int result;
		if(num1 >= num2) {
			if(num1 >= num3) {
				result = num1;
			}else {
				result = num3;
			}
		}else {
			if(num2 >= num3) {
				result = num2;
			}else {
				result = num3;
			}
		}		
		return result;
	}	


}
