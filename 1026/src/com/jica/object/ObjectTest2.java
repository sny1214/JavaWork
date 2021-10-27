package com.jica.object;

public class ObjectTest2 {

	public static void main(String[] args) {
		Item item = new Item("새우깡",1000);
		Item item2 = new Item("콜라", 800);
		
		//item  0x100--->["새우깡", 1000]
		//item2 0x200--->["콜라",   800]
		//item3 null
		
		System.out.println("item : " + item); //item.toString()
		System.out.println("item2 : " + item2);//item2.toString()
		System.out.println("------------------------------");
		
		 //error -- Object클래스의 clone()은 protected이다
		//                 |-->|새|우|깡|  
		//item  0x100--->[0x10, 1000]
		//item3 0x300--->[0x10, 1000]		
		//item2 0x200--->["콜라",   800]

		Item item3 = null;
		try {
			item3 = (Item) item.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		} 
		System.out.println("item의 복제본 item3 : " + item3);
		
		//메모리에서 item객체가 소멸될때 수행할 기능이 있다면 finalize()메서드를 재정의하여 		
		//작동시킬수 있다.
		
		//item2 0x200--->["콜라",   800]
		//item2 null     ["콜라",   800]	
		
		item2 = null;  //의미 : item2는 더이상 동적영역(Heap)영역인 인스턴스-객체 를 가리키지 않으므로
		               //      동적영역의 인스턴스 쓸모가 없어진다. 이때의 인스턴스를 가비지라고 부른다.
		               //      아직까지는 메모리 공간을 차지하고 있지만 쓸수는 없다.
		               //JVM에의 가비지컬렉터가 주기적을 동작하여 메모리공간을 정리한다.
		               //이때가 실제 인스턴스가 소멸되는 시점이다. 
		//인위적으로 JVM에게 가비지컬렉터를 당장 작동시키라고 요청할 수 있다.
		System.gc();
		
	}

}
