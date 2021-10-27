package com.jica.inheritance2;

public class ScoreTest2 {

	public static void main(String[] args) {
		Score  p = new Score("홍길동",70,80,90);
		p.calTotal();
		p.calAverage();
		p.display();
		System.out.println();
		System.out.println(p);
		System.out.println();
		
		//           name     score      total  average
		//p 0x100--->["홍길동", [70,80,90], 240   , 80.0]
		
		Score2 c = new Score2("홍길동",60,60,50);
		//중요: 하위클래스로 객체를 생성하면 
		//     하위클래스의 인스턴스및 상위클래스의 인스턴스도 생성된다.
		//           Score2             Score          
		//           grade name     score     total  average
		//c 0x200--->['F', "장길산", [40,50,60], 150   , 50.0]
		
		//사용시 하위클래스의 멤버뿐만아니라 상위클래스의 멤버도 모두 사용가능하다.
		c.name = "장길산";
		c.score[0] = 40;
		c.score[1] = 50;
		c.score[2] = 60;
		c.calTotal();
		c.calAverage();
		
		c.calGrade();
		System.out.println("학점은 " + c.grade + " 입니다.");
		
		c.display();
		System.out.println(c);
				
	}
}
