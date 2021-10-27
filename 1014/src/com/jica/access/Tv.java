package com.jica.access;	//클래스가 속해 있는 패키지
//클래스 만들기
//접근제어자를 아무것도 사용하지 않았으므로
//클래스 및 모든 멤버변수와 메서드는 default 접근제어를 갖는다.
//default 접근제어는 같은 패키지(package)에는 외부나 내부에서
//자유롭게 접근할 수 있다.
//패키지가 다르면 외부에서는 접근할 수 없다.
//외부에서 접근 = 객체를 만들고 객체 이용해 접근하는 것..

public class Tv { 
     // Tv의 멤버변수(field)-- 상태 
     String color;           	// 색상 
     private boolean power;         	// 전원상태(on/off) 
     private int channel;           	// 채널 

     // Tv의 메서드 --- 기능,행위
     public void power()   { //Tv를 켜거나 끄는 기능
    	 power = !power; 
     }  
     
     public void channelUp()   {   //Tv의 채널을 증가
    	 ++channel; // ++this.channel;
     }
     
     public void channelDown() {   //Tv의 채널을 감조

    	 
    	 System.out.println("channelDown()내부에서의 this값 : " + this);
    	 --channel;  //channel = channel - 1;
     }   
     
     public void changeChannel(int channel) {
    	 this.channel = channel;		//멤버변수와 매개변수 이름이 똑같을 때, 구분을 위해 맴버변수에 this 사용, 멤버변수를 참조한 this에 매개변수인 channel 전달해라
     }

     //현재 Tv객체의 상태값을 그대로 출력해주는 기능
     public void display() {
//    	 System.out.println("--현재 상태------------");
    	 System.out.printf("Tv의 현재 상태 : %s %s %d%n", color, power?"on":"off", channel);
     }


}