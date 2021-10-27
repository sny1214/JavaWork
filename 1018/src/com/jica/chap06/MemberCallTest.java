package com.jica.chap06;

public class MemberCallTest {

	public static void main(String[] args) {
		//객체없이 클래스 멤버변수 접근 - ok
		System.out.println(MemberCall.cv);
		//객체없이 클래스 메서드 호출 - ok
		MemberCall.staticMethod1();
		System.out.println();
		
		//객체 생성
		MemberCall mc = new MemberCall();
		System.out.println(mc.iv);
		System.out.println(MemberCall.cv);
		mc.instanceMethod1();
		MemberCall.staticMethod1();
		System.out.println();
		
		//객체를 생성하자 마자 곧장 메서드를 호출하는 표현
		new MemberCall().instanceMethod1();
		//int result = new MemberCall().instanceMethod1();       //ok
		//System.out.println(new MemberCall().instanceMethod1());//ok
	}
	// MemberCall::cv  20      <---정적영역(static영역)   
	// MemberCall::cv2 10 
	//
	//                iv  iv2  <---동적영역(heap) 
	//                10   20         
	//              0x10 위치정보를 참고하여 저장한 변수가 없으므로
	//                   더이상 접근하거나 사용할 수 없다.(JVM에서는 쓸모없는 공간)
    //        iv   iv2    iv   iv2
	//        10   20     10   20 
	//     |->0x100      0x200
	//     |
	// mc 0x100           
}
