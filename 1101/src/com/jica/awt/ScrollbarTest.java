package com.jica.awt;

import java.awt.*;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

class ScrollbarTest {
	static Canvas canvas;
	public static void main(String args[]) {
		//Frame에서 직접 생성
		Frame f = new Frame("Scrollbar");
		//Frame의 크기(폭,높이) 지정 - 위치는 지정하지 않았으므로 (0,0)이다.
		//f.setSize(300, 200);
		//Frame의 위치와 크기(x, y, 폭, 높이) 지정
		f.setBounds(300, 200, 500, 400);
		//배치과닐자를 사용하지 않도록 설정 - UI객체를 생성하고 위치와 크기를 지정해야 한다
		f.setLayout(null);

		//수평 스크롤바(좌/우)
		//Scrollbar​(int orientation,	<-방향(HORIZONTAL - 수평, VERTICAL - 수직)
		//				  int value,	<-Thumb의 초기 위치값
		//				int visible,	<-Thumb의 폭인데, 0~100의 10정도를 폭으로 하겠다 (비율)
		//				int minimum, 	<-Thumb의 최소위치값을 0이라 하겠다
		//				int maximum)	<-Thumb의 최대위치값을 100이라 하겠다
		Scrollbar hor = new Scrollbar(Scrollbar.HORIZONTAL, 0, 1, 0, 255);
		hor.setSize(400, 15);		//스크롤바 길이, 두께
		hor.setLocation(60, 30);	
		
		//수직 스크롤바(위/아래) -> 사용 하지 말자
//		Scrollbar ver = new Scrollbar(Scrollbar.VERTICAL, 50, 20, 0, 100);
//		ver.setSize(15, 100);
//		ver.setLocation(30, 30);

		//scrollbar를 움직일 때마다 작동하는 이벤트 핸들러 설정
		hor.addAdjustmentListener(new AdjustmentListener() {

			@Override
			public void adjustmentValueChanged(AdjustmentEvent e) {
				int value = hor.getValue();
				System.out.println("현재 Thumb의 값 : " + value);	//Thumb 폭이 5 이고, 총 255이므로 value가 250까지만 가능
				canvas.setBackground(new Color(0,0,value));//내부클래스에서 외부 클래스 이용
				//new Color(R,G,B)
				//스크롤바 움직일 때마다 바뀌는 value에 맞게 canvas 객체의 배경색이 달라져..
			}
			
		});
		
		//Frame에 scrollbar 추가
		f.add(hor);
		//f.add(ver);
		
		//Canvas UI객체는 사용자가 직접 선, 도형, 이미지, 글ㅈ자 등을 그리기 위해서 사용한다.
		//현재 예제에서는 직접 그리는 기능은 사용하지 않았다. Thumb 이용한 배경색만 바꾸는 효과만 이용
		canvas = new Canvas();
		canvas.setBounds(50, 70, 400, 300);
		canvas.setBackground(Color.BLUE);
		
		f.add(canvas);

		
		//Frame이 보이도록 설정
		f.setVisible(true);
	}
}