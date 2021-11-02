package com.jica.awt.event;


import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.HeadlessException;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class EventTest {

	public static void main(String[] args) {
		EventFrame frame = new EventFrame("이벤트처리코드 작성방법");

	}

}

class EventFrame extends Frame implements ActionListener{
	Button btn1,btn2,btn3;
	Button btn4,btn5,btn6;
	
	Label lMessage;
	
	public EventFrame(String title) throws HeadlessException {
		super(title);
		
		setBounds(400,300,500,400); //위치 및 크기
		
		//UI객체를 생성하여 화면 구성
		setLayout(new FlowLayout()); //배치 관리자 지정
		//Frame에 추가되는 모든 구성요소는 순서대로 좌에서 우로, 위에서 아래로 차례로 배치된다.
		
		btn1 = new Button("별도의 클래스");
		btn2 = new Button("익명의 클래스");
		btn3 = new Button("Frame에서 구현");
		
		Panel panel = new Panel();
		panel.setBackground(Color.GREEN);
		
		btn4 = new Button("확인");
		btn5 = new Button("취소");
		btn6 = new Button("재설정");
		panel.add(btn4);
		panel.add(btn5);
		panel.add(btn6);
		
		lMessage = new Label("버튼을 누르면 메세지가 나타납니다.");
		
		add(btn1);
		add(btn2);
		add(btn3);
		
		add(panel);
		
		add(lMessage);
		
		setVisible(true); //UI객체가 화면에 보이도록 설정	
		
		//이벤트 처리코드 설정
		//1.별도의 클래스
		btn1.addActionListener(new ButtonHandler());
		
		//2.익명의 클래스
		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				lMessage.setForeground(Color.RED);
				lMessage.setText("익명의 클래스를 이용한 이벤트 처리");	
			}			
		});
		
		//Frame에 이벤트 처리코드 작성
		btn3.addActionListener(this);
		//-------------------------------
		ButtonHandler2 handler2 = new ButtonHandler2();
		btn4.addActionListener(handler2);
		btn5.addActionListener(handler2);
		btn6.addActionListener(handler2);
		
		
		//Frame에서 우측상단의 x버튼 클릭시의 이벤트핸들러 설정
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				//Frame을 보이지 않도록 설정한다.
				setVisible(false);   
				System.exit(0);
			}			
		});
		
	}
	
	//1. 이벤트처리 클래스를 별도로 작성
	class ButtonHandler implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			lMessage.setForeground(Color.GREEN);
			lMessage.setText("이벤트 처리 코드를 별도의 클래스로 작성했습니다.");
		}	
	}

	//현재의 EventFrame클래스가 ActionListener를 implements했으므로
	//아래의 메서드가 반드시 필요
	@Override
	public void actionPerformed(ActionEvent e) {
		lMessage.setForeground(Color.BLUE);
		lMessage.setText("Frame에서 직접 이벤트핸들러 구현");		
	}
	
	//별도의 이벤트핸들러 클래스
	//여러버튼의 이벤트를 처리한다.
	class ButtonHandler2 implements ActionListener{
		int clickCount;	//클릭횟수
		
		@Override
		public void actionPerformed(ActionEvent e) {
			//인자로 전달된 ActionEvent객체 e에 이벤트 정보가 있다.
			clickCount++;
			lMessage.setForeground(Color.BLACK);
			lMessage.setText(clickCount + " 번째 버튼이 눌리워졌습니다.");
			
			//어느버튼(이벤트소스)이 클릭되었는지 판별해야한다(btn4,btn5,btn6)->.getSource로 판별
//			Button curButton = (Button)e.getSource();	
//			if(curButton == btn4) {
//				System.out.println("btn4가 눌리워졌습니다.");
//			}else if(curButton == btn5) {
//				System.out.println("btn5가 눌리워졌습니다.");
//			}else if(curButton == btn6) {
//				System.out.println("btn6가 눌리워졌습니다.");
//			}
//			
			
			String title = e.getActionCommand();
			if(title.equals("확인")) {
				System.out.println("btn4 clicked.");
			}else if(title.equals("취소")) {
				System.out.println("btn5 clicked.");
			}else if(title.equals("재설정")) {
				System.out.println("btn6 clicked.");
			}
			
			//눌리워진 버튼의 글자를 읽어와서 판별
			System.out.println(title);
		}
		
	}
	
}
