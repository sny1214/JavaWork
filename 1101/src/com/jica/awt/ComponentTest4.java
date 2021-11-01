package com.jica.awt;

import java.awt.Choice;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.HeadlessException;
import java.awt.List;
import java.awt.TextField;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//List, Choice의 사용법

public class ComponentTest4 {

	public static void main(String[] args) {
		ComponentFrame4 frame = new ComponentFrame4("List & Choice Component");
	}
}

class ComponentFrame4 extends Frame implements ItemListener {
	//UI객체 - 멤버변수
	List lCity;
	Choice chLanguage;		//Choice - 평상시엔 한줄만 보이다가 클릭하면 목록이 펼쳐지는 것
	TextField tfMessage;	//TextField - 한줄로 입력받거나 메세지를 출력
	
	
	public ComponentFrame4(String title) throws HeadlessException {
		super(title);
	
		setBounds(300,200,500,400);      // 크기와 위치지정
	    setBackground(Color.LIGHT_GRAY); // 배경색
	    
		//배치관리자를 FlowLayout으로 설정한다.
		setLayout(new FlowLayout());
			
		/*
		List의 여러가지 생성자
		List()	
		List​(int rows)	
		List​(int rows, boolean multipleMode) -> true일 때 여러 항목 선택 가능
		 */
		
		//목록(선택) 상자 - 단일 선택만 가능한 List
		//lCity = new List(5);		//갯수가 5개보다 더 많을 때 스크롤바 생겨
		lCity = new List(10);		//단일 항목만 선택 가능
		//lCity = new List(10, true);	//여러 항목 선택 가능
		
		//List객체에 보여줄 항목을 추가한다.
		lCity.add("Jeonju");
		lCity.add("Icsan");
		lCity.add("Gunsan");
		lCity.add("Gochang");
		lCity.add("Namwon");
		lCity.add("Jangsu");
		lCity.add("Kimje");
		lCity.add("Imsil");
		//Frame에 List 연결
		add(lCity);
		
		
		//최초 선택되어 보여질 항목을 지정한다.
		lCity.select(2);
		
		
		//선택 항목이 바R뀌 때 동작할 이벤트 핸들러 설정
		lCity.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				//현재 선택된 항목의 순서 얻기
				int pos = lCity.getSelectedIndex();
				//현재 선택된 항목명 얻기
				//String curItem = lCity.getSelectedItem();
				String curItem = lCity.getItem(pos);
				
				//현재 List의 선택정보를 tfMessage에 설정한다.
				tfMessage.setForeground(Color.RED);
				tfMessage.setText( (pos+1) + " 번째 항목 " + curItem + " 선택되었습니다.");
			}		
		});
		
		tfMessage = new TextField("여기에 메세지를 입력하거나 표시합니다.",40);
		tfMessage.setEditable(false);	//직접 입력하지 못하도록 설정
		tfMessage.setForeground(Color.RED);
		//Frame에 TextField 연결
		add(tfMessage);
		
		//Choice 평상시는 한줄로 항목을 표시하다가 클릭하면 여러 항목이 드롭다운 되어 표시되고
		//선택하면 다시 한줄로 항목을 표시하는 목록 선택 상자
		chLanguage = new Choice();
		//표시할 항목 추가.
		chLanguage.add("Java");
		chLanguage.add("C/C++");
		chLanguage.add("Web Programming");
		chLanguage.add("Android");
		chLanguage.add("Kotlin");
		//Frame에 Choice 연결
		add(chLanguage);	
		
		chLanguage.select(2);
		
		//Choice 항목 선택시 동작하는 이벤트 핸들러 처리
		chLanguage.addItemListener(this);	//this = ComponentFrame4 
											//ItemListener를 가져야 하므로 implements 한다.
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

	//Choice에서 항목 선택시의 이벤트 핸들러를 현재 클래스 즉, ComponentFrame4에서 구현하여 가지고 있다는
	//아래의 메서드를 재정의 한다.
	@Override
	public void itemStateChanged(ItemEvent e) {
		int pos = chLanguage.getSelectedIndex();
		String curItem = chLanguage.getSelectedItem();
		//String curItem = chLanguage.getItem(pos);
		
		tfMessage.setForeground(Color.BLUE);
		tfMessage.setText(curItem + " 항목이 선택되었습니다.");
	}
	
}