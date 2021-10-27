package com.jica.exam;

public class ScoreProcess3 {

	public static void main(String[] args) {
		//Student형 객체배열 선언 및 생성
		Student students[] = new Student[5];
		
		//students 0x100 ---> [null, null, null, null, null]
		
		for (int i=0 ; i<5 ; i++) {
			students[i] = new Student();
		}	
		//	
		//					   		 name  score[] total average grade
		//						|-->[null, [0,0,0],  0,    0.0,   ' ' ]
		//						|		|-->[null,[0,0,0],0,0.0,' ']					   
		//						|		|		|-->[null,[0,0,0],0,0.0,' ']
		//						|       |       |      |-->[null,[0,0,0],0,0.0,' ']
		//						|		|		|	   |	|-->[null,[0,0,0],0,0.0,' ']
		//students 0x100 ---> [0x100, 0x200, 0x300, 0x400, 0x500]

			
		students[0].name = "홍길동";
		students[0].score = new int[] {70, 80, 90};
		students[1].name = "장길산";
		students[1].score = new int[] {40, 50, 60};
		students[2].name = "이순신";
		students[2].score = new int[] {100, 95, 88};
		students[3].name = "강감찬";
		students[3].score = new int[] {88, 90, 92};
		students[4].name = "고주몽";
		students[4].score = new int[] {70, 80, 85};
		
			// name    ----> [홍길동,장길산,이순신,강감찬,고주몽]
			// score1  ----> [  70,  40, 100,  88,  70]
			// score2  ----> [  80,  50,  95,  90,  80]
			// score3  ----> [  90,  60,  88,  92,  85]
		
		//총점, 평균, 학점 계산하기
		for(int i=0; i<5; i++) {
			students[i].calTotal();
			students[i].calAverage();
			students[i].calGrade();
			
			students[i].display();
		}
			
		System.out.println("--------------------------------");
		
		//평균으로 정렬하기
		for(int i=0 ; i<4 ; i++) {
			for(int j=i+1 ; j<5 ; j++) {
				if(students[i].average < students[j].average) {
					Student tmp = students[i];
					students[i] = students[j];
					students[j] = tmp;
				}
			}
		}
		
		//최종 결과 출력
		for(Student student : students) {
			student.display();
		}

	}

}
