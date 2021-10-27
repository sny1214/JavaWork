package com.jica.virtual;

public abstract class Player {
	abstract void play(int pos);
	abstract void stop();
}



//일반클래스이므로 객체 생성 가능
class AudioPlayer extends Player{

	@Override
	void play(int pos) {
	}

	@Override
	void stop() {
	}	
}
