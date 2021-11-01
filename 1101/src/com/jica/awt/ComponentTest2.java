package com.jica.awt;

import java.awt.Button;
import java.awt.Checkbox;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.HeadlessException;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ComponentTest2 {

	public static void main(String[] args) {
		ComponentFrame2 frame = new ComponentFrame2("UI Component test");

	}

}

class ComponentFrame2 extends Frame{

	//UI객체 - 취미

	
	Checkbox cbBook;	//다중선택 가능한 게 Checkbox
	Checkbox cbMovie;
	Checkbox cbMusic;
	
	Button btInfo;
	
	TextArea taInfo;			//여러 줄에 거쳐 정보 표현
	
	public ComponentFrame2(String title) throws HeadlessException {
		super(title);
		
		setBounds(300,200,500,400);			//크기와 위치지정
		setBackground(Color.LIGHT_GRAY);	//배경색
		
		//배치관리자를 FlowLayout 으로 설정한다.
		setLayout(new FlowLayout());
		
		//UI객체를 생성하여 Frame에 연결(추가)한다.
		add(new Label(" Select hobby "));
		cbBook = new Checkbox(" Book ");
		cbMovie = new Checkbox(" Movie ", true);	//최초 선택(Check)되어 있는 상태로 보여준다.
		cbMusic = new Checkbox(" Music ");
		
		add(cbBook);
		add(cbMovie);
		add(cbMusic);
		
		//선택항목이 변경되었을 때 작동할 이벤트 핸들러 클래스
		class CheckboxHandler implements ItemListener {
			@Override
			public void itemStateChanged(ItemEvent e) {
				//이벤트 핸들러 메서드로 전달된 객체에 이벤트 정보가 있다.
				//현재 선택되거나 해제된 Checkbox객체
				Checkbox cbCurrent = (Checkbox)e.getSource();
				Boolean checked = cbCurrent.getState();
				
				String message = "";
				if (cbCurrent == cbBook) {
					message = (checked) ? "Book Checked!" : "Book NOT Checked!";
				}else if( cbCurrent == cbMovie ) {
					message = (checked) ? "Movie Checked!" : "Movie NOT Checked!";
				}else if(cbCurrent == cbMusic ) {
					message = (checked) ? "Music Checked!" : "Music NOT Checked!";
				}
				taInfo.append(message + "\n");
			}
		}
		
		CheckboxHandler cbHandler = new CheckboxHandler();
		//각 체크박스 선택시(선택/해제)의 이벤트 핸들러 설정
		cbBook.addItemListener(cbHandler);
		cbMovie.addItemListener(cbHandler);
		cbMusic.addItemListener(cbHandler);
		
		
//		//각 체크박스 선택시(선택/해제)의 이벤트 핸들러 설정 -> 중복되므로 내부 메서드로 만들어보자 ^
//		cbBook.addItemListener(new ItemListener() {
//
//			@Override
//			public void itemStateChanged(ItemEvent e) {
//				//이벤트 핸들러 메서드로 전달된 객체에 이벤트 정보가 있다.
//				boolean checked = cbBook.getState();
//				String message = (checked) ? "Book Checked!" : "Book NOT Checked!";
//				taInfo.append(message + "\n");
//			}
//		});
//		
//		cbMovie.addItemListener(new ItemListener() {
//
//			@Override
//			public void itemStateChanged(ItemEvent e) {
//				//이벤트 핸들러 메서드로 전달된 객체에 이벤트 정보가 있다.
//				boolean checked = cbMovie.getState();
//				String message = (checked) ? "Movie Checked!" : "Movie NOT Checked!";
//				taInfo.append(message + "\n");
//			}
//		});
//		
//		cbMusic.addItemListener(new ItemListener() {
//
//			@Override
//			public void itemStateChanged(ItemEvent e) {
//				//이벤트 핸들러 메서드로 전달된 객체에 이벤트 정보가 있다.
//				boolean checked = cbMusic.getState();
//				String message = (checked) ? "Music Checked!" : "Music NOT Checked!";
//				taInfo.append(message + "\n");
//			}
//		});
//		
		
		
		btInfo = new Button(" Display ");
		add(btInfo);
		
		//버튼 클릭시의 이벤트 핸들러 설정
		btInfo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Checkbox의 선택상태를 읽어와서 TextArea에 보여주자,
				String message = "";		
				if( cbBook.getState() ) {	//book 체크박스 선택시
					message += "Book Selected";
				}
				
				if( cbMovie.getState() ) {	//movie 체크박스 선택시
					message += ", Movie Selected";
				}
				
				if( cbMusic.getState() ) {	//music 체크박스 선택시
					message += ", Music Selected";
				}
				//TextArea에 글자를 추가한다.
				taInfo.append(message+"\n\n");	//글자 추가 후 빈줄 2줄 추가
			}
			
		});
		
		taInfo = new TextArea(5,50);	//5줄로 1줄에 약 50글자를 보여주거나 입력받을 수 있다.
		taInfo.setEditable(false); 		//입력용으로는 사용할 수 없도록 설정
		add(taInfo);
		
		//Frame에서 우측 상단의  x버튼 클릭시의 이벤트핸들러 설정
		this.addWindowListener(new WindowAdapter() {
	
		@Override
		public void windowClosing(WindowEvent e) {
			super.windowClosing(e);
			//frame을 보이지 않도록 설정한다.(WindowEvent에 setVisible메서드 있는지 확인 -> no, 상위의 MyName에 그 메서드 있는지 확인 -> Name에 있음을 확인, 사용)
			setVisible(false);//명시적으로 외부 클래스 객체 지정할 때는 MyFrame.this.setVisible(false);
			System.exit(0);	//프로그램 닫아라
		}
	});
					
		//Frame을 보이게 설정한다.
		super.setVisible(true);
				
	}

	
}