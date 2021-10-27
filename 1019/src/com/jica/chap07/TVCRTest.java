package com.jica.chap07;

class Tv {
	boolean power; 	 
	int channel;	 

	void power()       { 	power = !power; }
	void channelUp()   { 	++channel; }
	void channelDown() {	--channel; }
}

class VCR {
	boolean power; 
    int counter = 0;
	
    void power() { 	power = !power; }
	void play()  { System.out.println("VCR의 play() 동작함"); }
	void stop()  { /* �������*/ }
	void rew()   { /* �������*/ }
	void ff()    { /* �������*/ }
}

/*  다중상속은 지원되지 않음
class TVCR extends Tv, VCR{
	...
}
*/

class TVCR extends Tv {  //상속과
	VCR vcr = new VCR(); //포함을 동시에 사용
	
	int counter = vcr.counter;

	void play() {
		vcr.play();
	}

	void stop() {
		vcr.stop();
   }

	void rew() {
		vcr.rew();
   }

	void ff() {
		vcr.ff();	
   }
}

public class TVCRTest{
	public static void main(String args[]) {
		TVCR tvcr = new TVCR();
		tvcr.power();      //Tv클래스의 멤버 사용
		tvcr.channelUp();
		
		tvcr.play();       //VCR클래스의 멤버를 사용한 효과 
	}
}
