package com.jica.awt.layout;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class GridLayoutTest {
	public static void main(String args[]) {
		Frame f = new Frame("GridLayoutTest");
		f.setBounds(300,200,200,300);
		
		//배치관리자 설정-GridLayout
		//GridLayout gridLayout = new GridLayout(3,3);
		//f.setLayout(gridLayout); 
		
		f.setLayout(new GridLayout(3,3,10,20));// 3행 2열의 테이블을 만든다.
		/*생성자
		 *GridLayout()	
		 *GridLayout​(int rows, int cols)	
		 *GridLayout​(int rows, int cols, int hgap, int vgap)
		 * 								  수평간격,   수직간격
		 */
				
		//GridLayout gridLayout = (GridLayout)f.getLayout();
		//gridLayout.setVgap(50);
		
		
		//추가되는 순서대로 Button에 번호를 붙였다.
		//주의하기 : GridLayout에서는 좌표지정(열,행)식으로 표현되고 있다. (원래, (행,열))
		f.add(new Button("1,0"));
		f.add(new Button("0,0"));		    
		f.add(new Button("2,0"));
		f.add(new Button("0,1"));
		f.add(new Button("1,1"));
		f.add(new Button("2,1"));
		f.add(new Button("0,2"));
		f.add(new Button("1,2"));
		f.add(new Button("2,2"));

		
		//Frame에서 우측상단의 x버튼 클릭시의 이벤트핸들러 설정
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				//Frame을 보이지 않도록 설정한다.
				f.setVisible(false);   
				System.exit(0);
			}			
		});
		
		
		f.setVisible(true);
	}
}