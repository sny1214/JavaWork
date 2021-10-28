package com.jica.inner;

class InnerEx1 {  //외부 클래스
	  //인스턴스 내부 클래스  -- InnerEx1객체가 생성된후 연결시켜서 인스턴스내부클래스의 객체를 생성할 수 있다.
      class InstanceInner { 
            int iv = 100; 
           // static int cv = 100;            // (Java버전에 따라 다르다)에러! static변수를 선언할 수 없다. 
            final static int CONST = 100;   // final static은 상수이므로 허용. 
      } 

      //static 내부클래스 -- InnerEx1객체의 생성여부와 관계없이 static내부클래스 객체를 생성할 수 있다.
      static class StaticInner { // 
            int iv = 200; 
            static int cv = 200;       // static클래스는 static멤버를 허용. 
      } 

      void myMethod() { 
            class LocalInner { //지역 내부 클래스
                  int iv = 300; 
                  //static int cv = 300;          // (Java버전에 따라 다르다)에러! static변수를 선언할 수 없다. 
                  final static int CONST = 300; // final static은 허용
            }
            
            LocalInner li = new LocalInner();  //ok
      } 
      
      void myMethod2() {
    	   //지역내부클래스는 해당 클래스를 선언한 메서드 내부에서만 사용가능하다.
    	   //LocalInner li = new LocalInner();  //error
      }

      public static void main(String args[]) { 
            System.out.println(InstanceInner.CONST); 
            System.out.println(StaticInner.cv); 
      } 
} 
