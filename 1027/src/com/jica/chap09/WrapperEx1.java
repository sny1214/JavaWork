package com.jica.chap09;

class WrapperEx1 {
	public static void main(String[] args) {
		//기본형		Wrapper클래스
		//------------------------
		//int		Integer
		//100 	--> 객체
		//Integer i  = new Integer(100);	-->Depreciated
		//Integer i2 = new Integer(100);	-->Depreciated

		Integer i = Integer.valueOf(100);
		Integer i2 = Integer.valueOf(100);
		
		//i  0x100 ----> [100]
		//i2 0x200 --^	 [100]
		
		//Wrapper 클래스로 만들어진 객체는 모두 동일한 참조값을 가진다.
		//Wrapper 클래스로 만들어진 객체는 값이 동일하다면 다 동일 참조값
		System.out.println("i==i2 ? "+(i==i2));					//true
		System.out.println("i.equals(i2) ? "+i.equals(i2));		//true
		System.out.println("i.compareTo(i2)="+i.compareTo(i2));	//앞의 값이 크면 양수, 같으면 0 뒤의 값이 크면 음
		System.out.println("i.toString()="+i.toString());	

		System.out.println("MAX_VALUE="+Integer.MAX_VALUE);
		System.out.println("MIN_VALUE="+Integer.MIN_VALUE);
		System.out.println("SIZE=" +Integer.SIZE+" bits");
		System.out.println("BYTES="+Integer.BYTES+" bytes");
		System.out.println("TYPE=" +Integer.TYPE);
	}
}
