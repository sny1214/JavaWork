package com.jica.chap09;

class EqualsEx1 {
	public static void main(String[] args) {
		Value v1 = new Value(10);
		Value v2 = new Value(10);		

		//				    value
		//v1	0x100 ---> [ 10 ]
		//v2	0x200 ---> [ 10 ]
		
		if (v1.equals(v2)) {		//Value 클래스에서 equals()를 재정의하지 않았으므로 참조값(위치정보)를 등가비교한다.
			System.out.println("v1과 v2는 같다.");
		} else {
			System.out.println("v1과 v2는 다르다.");		
		}

		v2 = v1;

		//				    value
		//v1	0x100 ---> [ 10 ]
		//v2	0x100 ---^ 
		
		if (v1.equals(v2)) {
			System.out.println("v1과 v2는 같다.");
		} else {
			System.out.println("v1과 v2는 다르다.");		
		}
	} // main
} 

class Value {
	int value;

	Value(int value) {
		this.value = value;
	}
}
