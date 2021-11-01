package com.jica.awt;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.HeadlessException;
import java.awt.Label;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ComponentTest {

	public static void main(String[] args) {
		ComponentFrame frame = new ComponentFrame("UI Component test");

	}

}

class ComponentFrame extends Frame{
	private static final long serialVersionUID = 1L;

	public ComponentFrame(String title) throws HeadlessException {
		super(title);
		
		this.setBounds(300,200,500,300); //크기 및 위치 지정(x, y, width, height)
		this.setBackground(Color.LIGHT_GRAY);
		
		//배치 관리자를 사용하지 않는다고 설정
		setLayout(null);				
		//<- 개별기능 컴포넌트 생성할 때마다 위치 각각 직접 지정 가능(But 권장 안함)
		//프로그램 실행하는 컴퓨터 해상도가 가지각색이므로 보여지는 화면구성이 일정하지 않음
		//가급적 배치관리자 사용하기를 권장
		
		
		//Label - 글자를 보여주는 UI객체
		Label laID = new Label(" ID : ");
		laID.setBounds(20,50,30,10);			//작업영역 내 Label(UI객체)의 크기 및 위치 지정
		laID.setBackground(Color.WHITE);		//배경색 흰색(글씨는 검정글씨..)
		Label laPassword = new Label(" PASSWORD : ");
		laPassword.setBounds(20,70,100,10);		//작업영역 내 Label(UI객체)의 크기 및 위치 지정
		laPassword.setBackground(Color.WHITE);
		
		//Frame에 Label객체를 연결하자
		add(laID);
		add(laPassword);
		
		
		//Button
		Button bt1,bt2, bt3;
		bt1 = new Button(" Yes ");
		bt1.setBounds(20, 90, 70, 20);
		bt2 = new Button(" Cancel ");
		bt2.setBounds(100, 90, 70, 20);
		bt3 = new Button(" Confirm ");
		bt3.setBounds(180, 90, 70, 20);
		
		//Frame에 Button객체를 연결하자
		add(bt1);
		add(bt2);
		add(bt3);
		
		
		//Frame을 보이도록 설정
		setVisible(true);
		
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
	}

}