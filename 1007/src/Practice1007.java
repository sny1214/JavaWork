import java.util.Scanner;

/*1. 주민번호를 입력받아 정상적인 주민번호인지 판별하시오(끝 검중숫자)

   871115-1428125
   ------ --------
          ||   ||--> 주민번호 검증을 위한 숫자 
          ||   |-->신고순번  
  출생년월일 ||---> 4자리는 출생신고 주민센터의 고유 식별번호        
          |---> 1 1900년대 출생 남자
                2   //    //  여자
                3 2000년대 출생 남자
                4 2000년대 출생 여자
                
    주민번호 검증루틴
    		 1111 1
	1234567890123 4
------------------------
    871115-142812 5
    234567 892345 
    
    1)234567892345차례로 곱하여 합계를 계산한다.
      16+21+4+5+6+35+8+36+4+24+4+10 ==> 173
    2) 11 나누어서 나머지를 구한다.
         173 % 11 ==> 8       0,1,2,3,4,5,6,7,8,9,10 
    3) 구한 값을 11에서 뺀다.  이값이 주민번호 끝숫자와 동일해야 한다.
        11 - 8 ==> 3
        ...
        11 - 0 ==> 11 ==> 1.
        11 - 1 ==> 10 ==> 0
 */
public class Practice1007 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("주민번호를 입력하시오 (예: 871115-1428125) >> ");
		String idNumber = scanner.nextLine();
		
		int totalSum = 0;
		int remainder;
		
		for(int i = 1; i <= 14 ; i ++) {
			 int k = idNumber.charAt(i-1) - '0';	//int 값으로 구하기 위해, char로 출력하면 코드 번호로 나와
	
			 int sum = 0 ;
			
			 
			 switch(i) {
				case 1 : case 10 : sum = k * 2 ; break;
				case 2 : case 11 : sum = k * 3 ; break;
				case 3 : case 12 : sum = k * 4 ; break;
				case 4 : case 13 : sum = k * 5 ; break;
				case 5 : sum = k * 6 ; break;
				case 6 : sum = k * 7 ; break;
				case 8 : sum = k * 8 ; break;
				case 9 : sum = k * 9 ; break;
			}
			
			 
			if (i !=7) {
				 System.out.println(i + "번째 숫자 : " + k);
				 System.out.println(i + " 번째 값에서의 합은 " + sum + "입니다");
			}

			
			totalSum += sum;
		}

		System.out.println("-----------------------------------");
		System.out.println("총 합계는 " + totalSum + "입니다.");
		
 
		remainder = totalSum % 11;
				
		System.out.println("11로 나눈 나머지는 " + remainder + "입니다" );
		System.out.println("11에서 뺀 값은 " + (11 - remainder) + "입니다" );
		System.out.println("-----------------------------------");
		
		
		if((11-remainder%10) == (idNumber.charAt(14-1) - '0')) {
			System.out.println("유효한 주민번호 입니다" );
		}else {
			System.out.println("잘못된 주민번호 입니다" );
		}
		
		scanner.close();


	}
}
