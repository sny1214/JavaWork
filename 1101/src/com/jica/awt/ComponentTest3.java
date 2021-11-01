package com.jica.awt;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
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

public class ComponentTest3 {

	public static void main(String[] args) {
		ComponentFrame3 frame = new ComponentFrame3("UI Component test");

	}

}

class ComponentFrame3 extends Frame implements ItemListener{
	//UI객체- 취미
	CheckboxGroup cgHobby;
	
	Checkbox cbBook;
	Checkbox cbMovie;
	Checkbox cbMusic;
	
	Button btnInfo;
	
	TextArea taInfo;
	
	public ComponentFrame3(String title) throws HeadlessException  {
		super(title);
		
		setBounds(300,200,500,400);      // 크기와 위치지정
	    setBackground(Color.LIGHT_GRAY); // 배경색
	    
		//배치관리자를 FlowLayout으로 설정한다.
		setLayout(new FlowLayout());
		
		//UI객체를 생성하여 Frame에 연결(추가)한다.
		add(new Label("Select hobby-only one"));
		cgHobby = new CheckboxGroup();
		//아래의 3개의 Checkbox는 같은 group으로 묶어서 배타적 선택(1개만 선택됨)으로  동작한다.
		cbBook = new Checkbox(" Book ",false,cgHobby);
		cbMovie = new Checkbox(" Movie ", true,cgHobby); 
		cbMusic = new Checkbox(" Music ",false,cgHobby);
		
		add(cbBook);
		add(cbMovie);
		add(cbMusic);

		//각 checkbox선택시(선택/해제)의 이벤트핸들러 설정
		cbBook.addItemListener(this);
		cbMovie.addItemListener(this);
		cbMusic.addItemListener(this);
				
		btnInfo = new Button(" display ");
		add(btnInfo);
		//버튼 클릭시의 이벤트 핸들러 설정
		btnInfo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Checkbox의 선택상태를 읽어와서 TextArea에 보여주자
				String message = "";
				if( cbBook.getState() ) {
					message += "Book Selected";
				}
				
				if( cbMovie.getState()) {
					message += ", Movie selected";
				}
				
				if( cbMusic.getState()) {
					message += ", Music selected";
				}
				
				//TextArea에 글자를 추가한다.
				taInfo.append(message +"\n\n");
				
			}			
		});
		
		taInfo = new TextArea(5,50); // 5줄로 1줄에 약 50글자를 보여주거나 입력받을수 있다.
		taInfo.setEditable(false);   // 입력용으로는 사용할 수 없도록 설정
		add(taInfo);
		
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

	//ComponentFrame3에서 ItemListener를 implements했으므로 재정의(override)해야하는 메서드
	@Override
	public void itemStateChanged(ItemEvent e) {
		//현재의 Checkbox는 배타적 선택 즉, Radio Button성격 이므로 단 1개만 선택된다.
		//그러므로 CheckboxGroup 객체에서 선택된 Checkbox를 확인할 수 있다.
		Checkbox cb = cgHobby.getSelectedCheckbox();
		
		taInfo.append(cb.getLabel()+" 항목이 선택되었습니다.\n");
	}
	
}