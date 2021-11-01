package com.jica.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

//현재 프레임 직접 이용하는 방법을 사용했음
//Frame객체를 직접 생성.
class FrameTest {
	public static void main(String args[]) {
		//독자적인 윈도우를 구성 및 단독 실행을 위해 Frame객체를 생성
		Frame f = new Frame("Login");	// Frame객체를 직접 생성.
		
		//현재 컴퓨터 모니터의 해상도 (1280,768)
		f.setSize(600, 300);			// Frame의 크기를 지정한다.(픽셀단위 지정)
		f.setLocation(300,100);         // Frame의 초기 위치 지정 (모니터 화면 내 frame 뜨는 위치)
		
		//Frame의 배경색을 다르게 지정해 보자 - 작업영역 구성을 위해, 지정 안해주면 그냥 흰화면 나와서 작업영역과 타이틀바 구분 안됨
		f.setBackground(Color.GRAY);
	
		//버튼(Button)을 보여주도록 하자
		Button button = new Button(" Yes ");
		
		//Frame은 에 버튼을 연결(추가)시켜야 한다.
		//-> add()사용,frame은 borderLayout 기본적으로 적용시킴(동서남북 위치 지정하지 않으면 정중앙으로, 화면영역 전체가 버튼..)
		//1. 추가하는 구성요소를 차례로 배치하도록 배치 관리자(LayoutManager)를 변경(setLayout)한다.
		f.setLayout(new FlowLayout()); //<-layout 바꿔줌,flowlayout:순차적 구성요소 배치
		//2. 구성요소를 연결(추가)한다.
		f.add(button);
		
		//이벤트 처리
		//버튼 클릭시(이벤트) 수행할 기능을 작성해보자 - 버튼의 Event Hanlder 작성
		class MyButtonHandler implements ActionListener{	//ActionLister 인터페이스므로 객체 만들기 위해 implement해서 객체 만들어
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("버튼이 클릭되었습니다.");	
			}		
		}
		
		MyButtonHandler handler = new MyButtonHandler();
		
		button.addActionListener(handler);
		
		//frame꺼니까.. frame.(여기선 frame 객체가 f)
		//Windows계열의 UI객체(Frame,Dialog)는 x버튼 클릭 시 동작할 기능을 작성해주어야 함
		//다른 건 기능 다 만들어져 있는데 윈도우 끄는 버튼 기능은 안되어 있음 --> 닫는 메서드 재정의 해줘야
		//우측 상단의 x버튼 클릭시 윈도우 소멸되도록 설정해보자 -- 익명의 내부클래스를 이용한 코딩
		
		//Windowlistner로 사용하지 않는 이유? Windowlistner 인터페이스에 추상메서드 여러개 있음
		//windowclosing 재정의 해주기 위해선 나머지 추상메서드들도 재정의 해줘야함..
		//WindowAdapter클래스 대신 이용
		
		f.addWindowListener(new WindowAdapter() {	
			@Override
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				f.setVisible(false); // Frame을 보이지 않게 한다.
				System.exit(0);      // 프로그램을 종료한다.
			}			
		});
		
		//현재 Frame이 화면에 보이도록 설정한다. 
		f.setVisible(true);			    
	}
}
