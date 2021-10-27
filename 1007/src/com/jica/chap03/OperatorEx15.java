package com.jica.chap03;

class OperatorEx15 { 
      public static void main(String[] args) { 
            char lowerCase = 'a'; 	//97 'a' 의미
            char upperCase = (char)(lowerCase - 32); // (lowerCase - 32)= 65 int 이므로 char로 형변화시켜 'A'로 출력

            //영문자 대문자와 소문자의 차이는 32이다.
            System.out.println(upperCase); 
      } 
} 
