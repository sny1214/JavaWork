import java.util.Arrays;

public class Practice {
	public static void main(String[] args) {
	final int MAX = 4;
	int target[] = new int [MAX];	
	target[0] = (int)(Math.random() * 10);		//첫번째 난수
	//						0  1  2  3
	//target 0x100 ----> [예)7, 0, 0, 0]
	
	int i=1;
	while ( i < MAX) {
		int num = (int)(Math.random() * 10);
		boolean duplicate = false;
		for(int j=0 ; j<=i-1 ; j++) {
			if( num == target[j] ) {	//중복됐다! -> break 빠져나와
				duplicate = true;
				break;
			}
		}
		if( !duplicate ) {				//중복되지 않았다면
			target[i] = num;
			i++;
		}
	}
	System.out.println("맞쳐야할 숫자 : " + Arrays.toString(target));


	}
}
