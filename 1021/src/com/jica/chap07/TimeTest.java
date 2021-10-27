package com.jica.chap07;

public class TimeTest { 
      public static void main(String[] args) 
      { 
            Time t = new Time(12, 35, 30); 
            System.out.println(t); 
//          t.hour = 13;
            t.setHour(t.getHour()+1);   // hour는 private 멤버변수이므로
                                        // getter/setter를 사용하여 값이 이용한다.
            
            System.out.println(t);      // System.out.println(t.toString());
      } 
}

