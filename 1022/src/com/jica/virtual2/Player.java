package com.jica.virtual2;

public abstract class Player {
	boolean pause;
	int currentPos;
	
	Player(){
		pause = false;
		currentPos = 0;
	}
	
	abstract void play(int pos);
	abstract void stop();
	
	void play() {
		play(currentPos); //ok -- 하위클래스에서 재정의된 play(int)가 호출된다.
	}
	
	void pause() {
		if( pause ) {
			pause = false;
			play(currentPos);
		}else {
			pause = true;
			stop();   //ok -- 하위클래스에서 재정의된 stop()메서드 호출
		}
	}
}

class CDPlayer extends Player{
	int currentTrack;
	
	void nextTrack() {
		currentTrack++;
	}
	
	void preTrack() {
		currentTrack--;
	}

	@Override
	void play(int pos) {
		// CDPlayer특성에 맞는 코드 작성
	}

	@Override
	void stop() {
		// CDPlayer특성에 맞는 코드 작성
	}
}