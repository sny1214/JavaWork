package com.jica.awt.layout;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.HeadlessException;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FlowLayoutTest {

	public static void main(String[] args) {
		FlowFrame frame = new FlowFrame("FlowLayout test");

	}

}


class FlowFrame extends Frame{
	private static final long serialVersionUID = 1L;

	//성명과 성별,나이 및 전화번호를 입력받는 화면구성을 하자
	TextField tfName;
	CheckboxGroup cgGender;
	Checkbox cbMale;
	Checkbox cbFemale;
	TextField tfAge;
	TextField tfPhone;
	
	Button btnAppend, btnModify, btnRemove;
	public FlowFrame(String title) throws HeadlessException {
		super(title);
		setBounds(300,200,250,300);      // 크기와 위치지정
	    setBackground(Color.LIGHT_GRAY); // 배경색
	    setResizable(false);             // 테두리에서 폭과 높이를 변경할 수 없도록 설정
	    
		//배치관리자를 FlowLayout으로 설정한다.
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		Panel panelName = new Panel();		
		panelName.add(new Label(" Name " ));
		tfName = new TextField(10);
		panelName.add(tfName);
		add(panelName);
		
		
		//화면 크기를 조절할 때마다 크기에 따라 cgGender, cbMale, cbFemale이 떨어져서 표시되는 경우 있다.
		//cgGender, cbMale, cbFemale 이 화면 구성할 때 항상 함께 묶어서 움직이도록
		//panel을 만들어 panel에 cgGender, cbMale, cbFemale 추가
		
		Panel genderPanel = new Panel();
		genderPanel.add(new Label(" Gender "));
		cgGender = new CheckboxGroup();
		cbMale = new Checkbox("Male",false,cgGender);
		cbFemale = new Checkbox("Female", true, cgGender);
		genderPanel.add(cbMale);
		genderPanel.add(cbFemale);
		//Frame에 Panel을 추가
		add(genderPanel);
		
		Panel agePanel = new Panel();
		agePanel.add(new Label(" Age "));
		tfAge = new TextField(4);
		agePanel.add(tfAge);
		add(agePanel);
		
		Panel mobilePanel = new Panel();
		mobilePanel.add(new Label(" Mobile "));
		tfPhone = new TextField(13);
		mobilePanel.add(tfPhone);
		add(mobilePanel);
		
		Panel buttonPanel = new Panel();
		btnAppend = new Button(" Add ");
		btnModify = new Button(" Modify ");
		btnRemove = new Button(" Remove ");
		buttonPanel.add(btnAppend);
		buttonPanel.add(btnModify);
		buttonPanel.add(btnRemove);
		add(buttonPanel);
		
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
