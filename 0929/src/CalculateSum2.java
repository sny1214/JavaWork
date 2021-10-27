
public class CalculateSum2 {

	public static void main(String[] args) {
		int score1 = 50, score2 = 86, score3 = 90;
		int total;
		double average;
		
		//총점계산
		total = score1 + score2 + score3;
		//평균계산
		average = total / 3.0;
		
		System.out.println("총점: " + total + " 평균 : " + average);
		
		//평균이 90점 이상이면 매우 우수("Excellent")를 출력하시오
		
		if(average >= 90.0) {
			System.out.println("Excellent!!!");
		}
		System.out.println("END");

		//if 조건이 참일 때 실행할 내용이 한 문장 뿐이라면 그 내용의 대괄호{}는 생략 가능 
		if(average >= 90.0) 
			System.out.println("Excellent!!!");
			System.out.println("매우 뛰어난 성적입니다"); //이건 if문 참이든 거짓이든 항상 출력되는 문장임
		
		if(average == 90.0) 
			System.out.println("Excellent!!!");
			System.out.println("매우 뛰어난 성적입니다");	
		
		System.out.println("END");

	//양자택일문
		System.out.println("총점: " + total + " 평균 : " + average);
		//평균이 90점 이상이면 매우 우수("Excellent")를 출력하시오
		if(average >= 90.0) {
			System.out.println("Excellent!!!");
			System.out.println("매우 뛰어난 성적입니다"); //이건 if문 참이든 거짓이든 항상 출력되는 문장임
		}
		
		//평균이 70점 이상이면 "합격", 미만이면 "불합격"을 출력하시오.
		if(average >= 70.0) {
			System.out.println("합격 입니다.");
		}else {
			System.out.println("불합격");	
		}
		
		System.out.println("END");
	}

}
