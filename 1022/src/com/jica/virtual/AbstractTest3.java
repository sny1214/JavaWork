package com.jica.virtual;

public class AbstractTest3 {

	public static void main(String[] args) {
		// Unit객체 배열
		Unit units[] = new Unit[5];
		
		units[0] = new Tank(10,10);
		units[1] = new Marine(100,100);
		units[2] = new DropShip(40,50);
		units[3] = new Marine(100,110);
		units[4] = new Marine(100,120);
		
		for(int i=0; i<5; i++) {
			Unit unit = units[i];
			
			unit.move(300, 300);
			
			if( unit instanceof Marine) {
				((Marine)unit).stimPack();
			}else if(unit instanceof Tank) {
				((Tank)unit).changeMode();	
			}else if(unit instanceof DropShip) {
				Marine m = new Marine(1,1);
				((DropShip)unit).load(m);
			}
			System.out.println();
		}

	}

}
