import java.util.Random;

public class RandomTest {

	public static void main(String[] args) {
		double value;
		int value2;
		for(int i = 0 ; i <10; i++) {
			value = Math.random();
			//value2 = (int)(value * 100);    		//0~99
			value2 = (int)(value * 100) + 1;		//1~100
			//value2 = (int)(value * 1000) + 1;		//1~1000
			System.out.printf("%18.16f, %3d%n", value, value2);
		}
		System.out.println("--------------------------------");
		
		//난수 발생 전용 객체 생성
		Random rand = new Random();
		//Random rand = new Random(100); 항상 똑같은 난수 발생
		for(int i = 0 ; i<5 ; i++) {
			System.out.print(rand.nextInt() + " ");		//nextInt()
//			System.out.print(rand.nextInt(100) + " ");	//nextInt(int)
//			System.out.print(rand.nextBoolean() + " ");	//nextBoolean()
//			System.out.print(rand.nextDouble() + " ");	//nextDouble()
		}
				
		

	}

}
