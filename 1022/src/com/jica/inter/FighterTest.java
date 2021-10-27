package com.jica.inter;

class FighterTest {
	public static void main(String[] args) {
		//클래스와 인터페이스의 상속계층도
		
		//<<interface>>  <<interface>>
		//   Movable       Attackable
		//           다중상속           Object
		//         <<interface>>       상속  
		//          Fightable         Unit ---- 일반클래스
		//               구현        상속
		//                   Fighter ---------- 일반클래스     
		//                      |
		//                      |인스턴스화(new),객체생성
		//                      |
		//                      v
		//                      f
		
		Fighter f = new Fighter();

		if (f instanceof Unit)	{		
			System.out.println("f는 Unit클래스의 자손입니다.");
		}
		if (f instanceof Fightable) {	
			System.out.println("f는 Fightable인터페이스를 구현했습니다.");
		}
		if (f instanceof Movable) {		
			System.out.println("f는 Movable인터페이스를 구현했습니다.");
		}
		if (f instanceof Attackable) {	
			System.out.println("f는 Attackable인터페이스를 구현했습니다.");
		}
		if (f instanceof Object) {		
			System.out.println("f는 Object클래스의 자손입니다.");
		}
	}
}


interface Movable {	  //인터페이스
	void move(int x, int y);
}

interface Attackable {//인터페이스	
	void attack(Unit u);
}

class Unit {  //일반클래스
	int currentHP;	// 유닛의 체력
	int x;			// 유닛의 x좌표
	int y;			// 유닛의 y좌표
}

interface Fightable extends Movable, Attackable { //인터페이스 다중상속	
}

//일반클래스
class Fighter extends Unit implements Fightable { 
	public void move(int x, int y) { 
		// 구현부 작성
	}
	
	public void attack(Unit u) { 
		// 구현부 작성 
	}
}






