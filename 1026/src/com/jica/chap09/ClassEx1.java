package com.jica.chap09;

class ClassEx1 {
	public static void main(String[] args) throws Exception {
		Card c  = new Card("HEART", 3);       // new연산자 사용
		Card c1 = Card.getInstance();
		
		//특정클래스의 클래스정보를 얻어내는 방법
		//방법1) 클래스명.class
		//방법2) 객체.getClass()
		
		Class clsInfo = Card.class;
		Card c2 = (Card)clsInfo.newInstance();
		
		//Card c2 = Card.class.newInstance();   // Class정보를 이용한 객체 생성

		//c  0x100---->["HEART",3]
		//c1 0x200---->["SPADE",1]
		
		//이미 만들어진 객체를 이용한 해당객체의 클래스정보을 얻어낼때 getClass()를 사용한다.
		Class clsInfo2 = c.getClass();
		Class clsInfo3 = Class.forName("com.jica.chap09.Card");
		System.out.println("c객체 : " + c);
		System.out.println("c1객체 : " + c1);		
		System.out.println("c2객체 : " + c2);
		
		System.out.println(clsInfo2.getName());
		System.out.println(clsInfo2.toGenericString());
		System.out.println(clsInfo2.toString());	
		//위의 메서드외의 다양한정보를 이용할 수 있는 메서드가 준비되어 있다.
		//이러한정보를 이용하는 프로그램을 리플렉션(Refrection)이라고 부른다.
	}
}
