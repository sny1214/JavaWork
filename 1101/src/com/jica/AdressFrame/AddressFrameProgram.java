package com.jica.AdressFrame;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.HeadlessException;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AddressFrameProgram {

	public static void main(String[] args) {
		AddressFrame frame = new AddressFrame("Address Frame Program");

	}
}

class AddressFrame extends Frame {
	private static final long serialVersionUID = 1L;
	
	Choice chGroup;
	List profileList;
	TextField tfName, tfAge, tfEmail;
	CheckboxGroup cgGender;
	Checkbox cbMale, cbFemale;
	TextArea taMemo;
	Button btnAppend, btnModify, btnRemove;
	
	public AddressFrame(String title) throws HeadlessException {
		super(title);
		setBounds(300,100,600,500);      // 위치, 크기지정
	    setBackground(Color.LIGHT_GRAY); // 배경색
	    setResizable(false);             // 테두리에서 폭과 높이를 변경할 수 없도록 설정
	    
	    //배치관리자
	    setLayout(new BorderLayout());
	
//groupPanel
		Panel groupPanel = new Panel();
		groupPanel.setLayout(new BorderLayout());
		//group패널 - chGroup, profileList
		chGroup = new Choice();
		chGroup.add("Family");
		chGroup.add("Friends");
		chGroup.add("Colleague");
		chGroup.add("acquaintance");
		groupPanel.add(chGroup, BorderLayout.NORTH);	//패널 내에서도 정렬을 위해 BorderLayout 선택, 패널은 기본으로 FlowLayout으로 되어 있다.
		chGroup.select(1);
	
		profileList = new List(10);			//리스트 10개짜리 크기
		profileList.add("Honggildong");
		profileList.add("Leesunsin");
		profileList.add("Janggilsan");
		profileList.add("Ganggamchan");
		profileList.add("Gojumong");
		groupPanel.add(profileList, BorderLayout.CENTER);
		profileList.select(0);
		
		add(groupPanel, BorderLayout.WEST);
		
//		//선택 항목이 바뀔 때 동작할 이벤트 핸들러 설정
//		profileList.addItemListener(new ItemListener() {
//			@Override
//			public void itemStateChanged(ItemEvent e) {
//				//현재 선택된 항목의 순서 얻기
//				int pos = profileList.getSelectedIndex();
//				//현재 선택된 항목명 얻기
//				//String curItem = profileList.getSelectedItem();
//				String curItem = profileList.getItem(pos);
//				
//				//현재 List의 선택정보를 tfName에 입력한다.
//				tfName.setText(curItem);
//			}		
//		});
//		
		
		
//profilePanel
		Panel profilePanel = new Panel();
		//profile패널 - tfName, tfAge, cgGender, cbMale, cbFemale, tfEmail, taMemo
		profilePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
	//성명 패널 - tfName
		Panel namePanel = new Panel();
		namePanel.add(new Label(" Name "));
		tfName = new TextField(20);		//이름 30개글자 들어가게
		//tfName.add();
		namePanel.add(tfName);
		profilePanel.add(namePanel);
		
	//나이 패널 - tfAge
		Panel agePanel = new Panel();
		agePanel.add(new Label(" Age "));
		tfAge = new TextField(10);	//나이 10개숫자 들어가게
		//tfAge.add();
		agePanel.add(tfAge);
		profilePanel.add(agePanel);
		
	//성별 패널 - cgGender, cbMale, cbFemale
		Panel genderPanel = new Panel();
		genderPanel.add(new Label(" Gender "));
		cgGender = new CheckboxGroup();
		cbMale = new Checkbox("Male", false, cgGender);
		cbFemale = new Checkbox("Female", true, cgGender);
		//프로필에 따른 성별 자동 체크 추가하기/../
		genderPanel.add(cbMale);
		genderPanel.add(cbFemale);
		profilePanel.add(genderPanel);
		
	//이메일 패널 - tfEmail
		Panel emailPanel = new Panel();
		emailPanel.add(new Label(" Email "));
		tfEmail = new TextField(50);
		//tfEmail.add();
		emailPanel.add(tfEmail);
		profilePanel.add(emailPanel);
		
	//메모 패널 - taMemo
		Panel memoPanel = new Panel();
		memoPanel.add(new Label(" Memo "));
		taMemo = new TextArea(5,50); // 5줄로 1줄에 약 50글자를 보여주거나 입력받을수 있다.
		taMemo.setEditable(false);
		memoPanel.add(taMemo);
		profilePanel.add(memoPanel);

	//패널 추가
		add(profilePanel, BorderLayout.CENTER);	
	
//buttonPanel
		Panel buttonPanel = new Panel();
		//button패널 - btnAppend, btnModify, btnRemove
		btnAppend = new Button(" Add ");
		btnModify = new Button(" Modify ");
		btnRemove = new Button(" Remove ");
		buttonPanel.add(btnAppend);
		buttonPanel.add(btnModify);
		buttonPanel.add(btnRemove);

		add(buttonPanel, BorderLayout.SOUTH);
		
		
		
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