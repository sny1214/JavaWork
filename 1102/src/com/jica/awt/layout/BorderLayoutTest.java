package com.jica.awt.layout;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.HeadlessException;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class BorderLayoutTest {

	public static void main(String[] args) {
		//BorderFrame2 frame = new BorderFrame2("BorderLayout test2");
		BorderFrame frame = new BorderFrame("BorderLayout 연습1");

	}

}

class BorderFrame2 extends Frame{
	private static final long serialVersionUID = 1L;

	TextArea taMessage;
	TextField tfInput;
	
	public BorderFrame2(String title) throws HeadlessException {
		super(title);
		setBounds(300,200,250,300);      // 크기와 위치지정
	    setBackground(Color.LIGHT_GRAY); // 배경색
	    //setResizable(false);             // 테두리에서 폭과 높이를 변경할 수 없도록 설정
	    
		//배치관리자를 BorderLayout으로 설정한다.
	    //내부구성요소를 추가하면서 동,서,남,북,중앙의 위치를 지정해야 한다. 
		setLayout(new BorderLayout());
		add(new Label("Input chatting message"), BorderLayout.NORTH);
		taMessage = new TextArea(10,40);
		add(taMessage, BorderLayout.CENTER);
		
		Panel panel = new Panel();
		panel.add(new Label(" Message "));
		tfInput = new TextField(30);
		panel.add(tfInput);
		
		add(panel, BorderLayout.SOUTH);
				
		
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
		
		//Frame을 보이도록 설정
		setVisible(true);
	}
	
}

class BorderFrame extends Frame{
	private static final long serialVersionUID = 1L;

	Button btn1, btn2, btn3, btn4, btn5;
	
	public BorderFrame(String title) throws HeadlessException {
		super(title);
		setBounds(300,200,250,300);      // 크기와 위치지정
	    setBackground(Color.LIGHT_GRAY); // 배경색
	    setResizable(true);             // 테두리에서 폭과 높이를 변경할 수 없도록 설정
	    
		//배치관리자를 BorderLayout으로 설정한다.
	    //내부구성요소를 추가하면서 동,서,남,북,중앙의 위치를 지정해야 한다.
		setLayout(new BorderLayout());
		btn1 = new Button("동쪽");
		btn2 = new Button("중앙");
		btn3 = new Button("서쪽");
		btn4 = new Button("남쪽");
		btn5 = new Button("북쪽");
		
		
		//add(btn1);		//추가하면서 위치를 지정하지 않으면 자동으로 중앙(center)이 적용되고
							//남은 영역 전체를 차지한다.
		add(btn1, BorderLayout.EAST);		//add(btn1, "East"); 같은 코드
		add(btn2, BorderLayout.CENTER);		//add(btn2, "Center");
			//중앙으로 지정된 컴퍼넌트는 나머지 영역지역이 없는 공간으로  확장된다. 
		add(btn3, BorderLayout.WEST);		//add(btn3, "West");
		add(btn4, BorderLayout.SOUTH);		//add(btn4, "South");
		add(btn5, BorderLayout.NORTH);		//add(btn5, "North");
		
		
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
		
		//Frame을 보이도록 설정
		setVisible(true);
	}
}