package com.jica.awt;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.HeadlessException;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//Frame클래스를 직접 객체로 생성하지 않고 상속받아서 사용하자
public class FrameTest2 {

	public static void main(String[] args) {
		MyFrame frame = new MyFrame("Second Frame");
		frame.setVisible(true);

	}

}

//Frame클래스를 직접 객체로 생성하지 않고 상속받아서 사용하자
//크고 복잡한 기능을 코딩할 때 상속받아 사용하는 것이 여러모로 편리하다
class MyFrame extends Frame{
	private static final long serialVersionUID = 1L;  //내부적인 버전관리
	//UI 멤버변수로 해주는 게 좋다. --> 이후에 사용할 것, lName은 나중에 변경하거나 하지 않을 것이므로 추가안했음
	Button button;
	TextField tfName;	
	
	
	
	public MyFrame(String title) throws HeadlessException {
		super(title);
		
		//크기 및 위치 지정
//		super.setSize(600,300);
//		super.setLocation(300, 100);
		
		//크기 및 위치 지정->위 2줄을 1줄로!
		super.setBounds(300, 100, 600, 300);	//super.없애도 돼
		
		//Frame의 배경색을 다르게
		//super.setBackground(Color.YELLOW);
		super.setBackground(new Color(0x78,0xf3,0xff));	//fafaaa 
		//(Alpha, R, G,B) Alpha(투명도) 정수(0~255)를 16진수로 나타낼 수도 있다.

		
		//Frame의 기본 배치관리자는 BorderLayout 이므로, 내부 구성요소를 순차적으로
		//추가(연결)한 순서대로 순차적으로 배치하기 위해 배치관리자를 FlowLayout으로 설정하자.
		super.setLayout(new FlowLayout());
		
		//Button객체 생성 - 이후의 다양한 곳에서 이용하기 위해 UI객체를 멤버변수로 선언해 놓았다.
		button = new Button(" Confirm ");
		//TextField객체 생성 - 생성자 중에서 10짜리 글자 입력가능한 것 만듬
		tfName = new TextField(10);
		//현재 객체만 만들고, 연결안됐으므로 연결해줘야해
		
		//모든 개별기능 Component(Button, TextField,...)는 Container(MyFrame)에 연결되어야 한다.
//		super.add(button);
//		super.add(tfName);
		
		//FlowLayout 으로 설정했으므로 추가한 순서대로 나타난다.(위와 순서 반대)
		Label lName = new Label(" Name ");	//lable: 화면에 글자 보여주기만 해
		lName.setForeground(Color.BLUE);	//글자색 지정
		
		super.add(lName);
		super.add(tfName);					//한줄에 글자 입력하는 것
		super.add(button);
	
		//버튼 클릭시의 이벤트 핸들러를 설정하자.
		button.addActionListener(new ActionListener(){ //ActionListner이용해보자
			@Override
			public void actionPerformed(ActionEvent e) {
				//TextField에 입력된 값을 읽어와서 Console에 보여주자
				String inputText = tfName.getText();
				System.out.println("입력된 내용 : "+ inputText);
				tfName.setText("");	//글자 지워진 효과
			}
		});
		
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
		//super.setVisible(true);	//위에 객체 생성 후, 작성해줬으므로 주석처리해줌
		
	}
	
	
}