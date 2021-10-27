package com.jica.chap09;

class Person {
	long id;	//주민번호 => String"9511201428125"
				//			 long  9511201428125L
	
	@Override
	public boolean equals(Object obj) {
		if(obj!=null && obj instanceof Person) {	
			return id ==((Person)obj).id;
		} else {
			return false;
		}
	}

	Person(long id) {
		this.id = id;
	}
}

class EqualsEx2 {
	public static void main(String[] args) {
		Person p1 = new Person(8011081111222L);
		Person p2 = new Person(8011081111222L);
		//				id
		//p1 0x100 [8011081111222L];
		//p2 0x200 [8011081111222L];
		
		if(p1==p2)	 //참조값 비교
			System.out.println("p1과 p2의 주소(참조값)은 같다.");
		else
			System.out.println("p1과 p2의 주소(참조값)은 다르다.");

		if(p1.equals(p2))	//내용값 비교 - 재정의한 메서드
			System.out.println("p1과 p2의 내용값은 같다.");
		else
			System.out.println("p1과 p2의 내용값은 다르다.");
	
		System.out.println(p1.hashCode());
		System.out.println(p2.hashCode());
	}
}
