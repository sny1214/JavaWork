
public class BrenchTest {

	public static void main(String[] args) {
		for(int i = 1; i<=10 ; i++) {
			System.out.println(i);
			if(i >= 5) {
				break;
			}
			System.out.println("할일");
		}
		System.out.println("-----end-----");
		
		for(int i = 1; i<=10 ; i++) {
			System.out.println(i);
			if(i >= 5) {
				continue;
			}
			System.out.println("할일");
		}
		
	}

}
