package com.jica.gui;

import java.awt.Frame;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FrameTest {

	public static void main(String[] args) {
		MyFrame frame = new MyFrame("처음 만드는 윈도우");

	}
}

//AWT를 이용한 gui프로그램 작성
class MyFrame extends Frame{
	Button button;
	public MyFrame(String title) throws HeadlessException {
		super(title);
		
		//윈도우의 위치 지정
		setBounds(300,300, 400, 400);
		
		//Button 객체 생성
		button = new Button("나를 클릭하세요.");
		
		//배치관리자를 설정
		setLayout(new FlowLayout());
		
		//버튼을 Frame에 추가
		add(button);
		
		//button클릭시의 이벤트 핸들러를 설정
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("버튼을 클릭했습니다.");
				
			}			
		});
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				System.exit(0);
			}			
		});
		
		//Frame을 보이게 하기
		setVisible(true);		
	}
	
}
