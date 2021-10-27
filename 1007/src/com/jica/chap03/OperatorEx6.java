package com.jica.chap03;

class OperatorEx6 { 
      public static void main(String[] args) {
    	  	//byte형, short형의 초기값 대입은 저장범위 내의 정수값을 저장할 수 있다.
    	  	//초기값을 줄 때에는 허락해서 error 아님
    	  
            byte a = 10; 			//부호가 없는 숫자 INT로 인식
            byte b = 20; 
          
            //byte형과 short형은 연산시 자동으로 int형으로 변환되어 연산을 수행한다.
            //또한 연산의 결과값도 int 형이다.
            //초기값 준다하더라도 연산의 결과를 넣어줄 때는 타입 맞춰줘야 해..
            
            //byte c = a + b; ---> error
            byte c = (byte) (a + b); 

            System.out.println(c); 
      } 
} 
