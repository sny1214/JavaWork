package com.jica.chap06;
//클래스 만들기
class Tv { 
     // Tv의 멤버변수(field)-- 상태 
     String color;           	// 색상 
     boolean power;         	// 전원상태(on/off) 
     int channel;           	// 채널 

     // Tv의 메서드 --- 기능,행위
     void power()   { //Tv를 켜거나 끄는 기능
    	 power = !power; 
     }  
     
     void channelUp()   {   //Tv의 채널을 증가
    	 ++channel; // ++this.channel;
     }
     
     void channelDown() {   //Tv의 채널을 감조
    	 //메서드 내부에서 멤버변수를 자유롭게 사용할수 있는 이유
    	 //메서드가 호출될때 객체의 참조값이 전달되어
    	 //메서드 내부에서만 사용할수 있는 this에 저장되기 때문이다.
         //또한 선언되지 않은 변수를 사용하면 this를 적용한다.
    	 
    	 System.out.println("channelDown()내부에서의 this값 : " + this);
    	 --channel;  //channel = channel - 1;
    	 //위의 코드는 아래의 코드와 동일하다.
    	 //--this.channel; //this.channel = this.channel - 1;
    	 
     }   

     //현재 Tv객체의 상태값을 그대로 출력해주는 기능
     void display() {
//    	 System.out.println("--현재 상태------------");
    	 System.out.printf("%s %s %d%n", color, power?"on":"off", channel);
     }


}