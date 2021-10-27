package com.jica.chap03;

class OperatorEx12 { 
      public static void main(String[] args) { 
            char c1 = 'a';        // c1 97
            char c2 = c1;         // c1	97
            char c3 =' ';         // c3 32 공백 

            //문자형(char)과 정수값의 연산
            int i = c1 + 1;       // c1은 char(단일문자)형, int로 자동형 변환 후 + 1 = 98

            c3 = (char)(c1 + 1); //(c1 + 1) 정수int 연산 4byte ---> char 2byte로 저장하려면, 형변환 시켜야
            c2++; 				 // c2 98  --> 'b' 의미
            c2++; 				 // c2 99  --> 'c' 의미

            System.out.println("i=" + i); 
            System.out.println("c2=" + c2); 
            System.out.println("c3=" + c3); 
      } 
} 
