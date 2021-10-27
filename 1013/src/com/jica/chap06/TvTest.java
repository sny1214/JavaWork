package com.jica.chap06;


//              |1)클래스정보(TvTest,Tv)      |<--코드영역 
//              |2)메서드별로 실행코드가 적재(load)|
//              |  main()-------            |
//              |  power()------            |
//              |  channelUp()------------- |
//              |  ------ channelDown()---- |
//              |  ------------------------ |
//              ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
//              |Literal Value 및 전역변수 생성|
//              |                   (정적영역)|
//              |~~~~~~~~~~~~~~~~~~~~~~~~~~~|
//              | [null,false,6]    (동적영역)|
//              | 0x100      [null,false,-1]|<<== 데이타영역
//              |            0x200          |
//              |                           |
//              |                           |
//              |                           |
// channelDown()| this 0x200                |
// main()       | t 0x100  t2 0x200 (스택영역)|
public class TvTest { 
      public static void main(String args[]) { 
            Tv t;                  // Tv형 참조변수 t 선언
            t = new Tv();          // Tv 클래스를 이용하여 객체를 생성한후
                                   // 객체의 위치정보를 참조변수 t에 저장한다.
                                   // 이러한 참조변수 t를 객체명이라고 부른다.   
            
            //t객체에 저장된 위치정보를 출력해 보자
            System.out.println("t : " + t);
            
            Tv t2 = new Tv();
            System.out.println("t2 : " + t2);
            
            //객체의 사용
            //객체명.멤버변수
            //객체명.멤서드()
            t.channel = 7;         // Tv객체의 channel멤버변수값에 7을 저장 
            t.channelDown();       // Tv객체의 channelDown()메서드를 호출한다.
                                   // 중요) 내부적으로 t의 참조값이 channelDown()메서드로 전달된다.
            
            t2.channelDown();
            
            System.out.println("t객체의 채널 " + t.channel );
            System.out.println("t2객체의 채널 " + t2.channel);
      } 
} 
