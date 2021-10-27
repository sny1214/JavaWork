package com.jica.tv;

//클래스 만들기
public class Tv { 
     // Tv의 멤버변수(field)-- 상태 
     private String color;                   	// 색상 
     private boolean power;         	// 전원상태(on/off) 
     private int channel;           	// 채널 

     //생성자가 1개도 없으면 디폴트 생성자가 동작합니다.

     //인자가 없는 사용자가 만드는 기본생성자-반드시 작성하기를 권장
     Tv(){ 
    	 System.out.println("인자가 없는 사용자가 만든 기본 생성자");
     }
     
     Tv(String color){
    	 System.out.println("인자가 1개인 Tv 생성자");
    	 this.color = color;
    	 // 생성자 내부에서 다른 메서드 호출
    	 method();
     }
     
     //인자가 3개인 생성자
     Tv(String color, boolean power, int channel){
    	//매개변수명과 멤버변수명이 동일할때 멤버변수를 명시적으로 지정하기위해 this를 사용 
    	System.out.println("인자가 3개인 Tv 생성자");
    	this.color = color;
    	this.power = power;
    	this.channel = channel;
     }

     
     // Tv의 메서드 --- 기능,행위
     public void power()   { //Tv를 켜거나 끄는 기능
    	 power = !power; 
     }  
     
     public void channelUp()   {   //Tv의 채널을 증가
    	 ++channel; // ++this.channel;
     }
     
     public void channelDown() {   //Tv의 채널을 감조
     	 --channel;  //channel = channel - 1;
     } 
     
     public void changeChannel(int channel) {
    	 this.channel = channel;
     }
     
     //현재 Tv객체의 상태값을 그대로 출력해주는 기능
     public void display() {
    	 System.out.printf("Tv의 현재상태 : %s %s %d%n", color, power?"on":"off", channel );
     }
     
     void method() {
    	 System.out.println("연습용 메서드 입니다.");
     }
}