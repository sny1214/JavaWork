
public class StringSort {

	public static void main(String[] args) {
//		String names[] = new String[5];
		

		//names	0x100 ---->			   0x50   0x60  0x70   0x80   0x90
 		//							[  null,  null, null,  null,  null  ]
		//							  "홍길동""강감찬""장길산""이순신""고주몽"
		
//		names[0] = "홍길동";
//		names[1] = "강감찬";
//		names[2] = "장길산";
//		names[3] = "이순신";
//		names[4] = "고주몽";

		//names	위와 같이만들어짐
		String names[] = { "홍길동", "강감찬", "장길산", "이순신", "고주몽" };	// String 배열
																		// String도 클래스 라이브러리를 자바에서 제공해주는 클래스다
		
		for(int i = 0 ; i < names.length ; i++) {
			System.out.println(names[i]);
		}
		System.out.println("------------------");
		
		//오름차순으로 성명을 정렬시키자 --> compareTo() 메서드 이용해 값 비교 후, 음수 = 앞이 더 나중 문자열 --> 교환하라
		for(int i= 0 ; i < 4 ; i++) {
			for(int j = i+1; j < 5 ; j++) {
				if( names[i].compareTo(names[j]) > 0 ) {
					String tmp = names[i];
					names[i] = names[j];
					names[j] = tmp;
				}
			}
		}
		
		//names	0x100 ---->			    0x70    0x90   0x80    0x70   0x50
		//							  ["강감찬","고주몽","이순신","장길산","홍길동"]
		//문자열의 위치정보 순서만 바뀜 -> 정렬
		
		
		for(String name : names) {
			System.out.println(name);
		}
	}

}
