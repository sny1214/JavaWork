package com.jica.awt.layout;
import java.awt.*;
import java.awt.event.*;

class CardLayoutTest {
	public static void main(String args[]) {
		final Frame f = new Frame("CardLayoutTest");
		
		//배치관리자 설정 - CardLayout
		final CardLayout cardLayout = new CardLayout(10, 10);
		f.setLayout(cardLayout);
		
		Panel card1= new Panel();				//첫번째 화면
		card1.setBackground(Color.lightGray);
		card1.add(new Label("Card 1"));
		card1.add(new TextField(20));
		
		Panel card2= new Panel();				//두번째 화면
		card2.add(new Label("Card 2"));
		card2.setBackground(Color.orange);
		
		Panel card3= new Panel();				//세번째 화면
		card3.add(new Label("Card 3"));
		card3.setBackground(Color.cyan);

		f.add(card1, "1");		// Frame에 card1을 "1"이라고 이름 붙여 추가한다.
		f.add(card2, "2");
		f.add(card3, "3");

		//마우스와 관련된 이벤트 핸들러
		class Handler extends MouseAdapter {
			public void mouseClicked(MouseEvent e) {
				// 마우스 오른쪽 버튼을 눌렀을때 (클릭 이벤트)
				if(e.getModifiers() == e.BUTTON3_MASK)	{	//왼쪽 마우스 클릭을 했다면
					cardLayout.previous(f);  //  CardLayout의 이전 Panel을 보여준다.
				} else {
					cardLayout.next(f);	  //  CardLayout의 다음 Panel을 보여준다.
				}
			}
		} // class Handler

		Handler handler = new Handler();
		card1.addMouseListener(handler);
		card2.addMouseListener(handler);
		card3.addMouseListener(handler);

		f.setSize(200, 200);
		f.setLocation(200, 200);
		f.setVisible(true);

		cardLayout.show(f,"1");	// Frame에 추가된 Component중 이름이 "1"인 것을 보여준다.
	}
}