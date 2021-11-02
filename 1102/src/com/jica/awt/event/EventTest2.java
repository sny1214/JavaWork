package com.jica.awt.event;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class EventTest2 {

	public static void main(String[] args) {
		Frame frame = new Frame("이벤트 처리 방법");
		frame.setBounds(300,200,400,300);
		frame.setVisible(true);
		
		//익명의 클래스를 사용하여 x버튼클릭시 종료하게 설정
		//WindowListener 인터페이스이므로
		//내가 원하는 windowClosing 외의 다른 추상 메서드도 다 구현해야 함
		//---> XXXAdapter를 대신 사용
		
//		frame.addWindowListener(new WindowListener() {
//			
//			@Override
//			public void windowOpened(WindowEvent e) {
//				System.out.println(" windowOpened()... ");
//			}
//
//			@Override	//원하는 메서드
//			public void windowClosing(WindowEvent e) {
//				System.out.println(" windowClosing()... ");
//				frame.setVisible(false);	//윈도우 안보이게 하고
//				System.exit(0);				//윈도우 창 닫아라
//			}
//
//			@Override
//			public void windowClosed(WindowEvent e) {
//				System.out.println(" windowClosed()... ");
//				
//			}
//
//			@Override
//			public void windowIconified(WindowEvent e) {
//				System.out.println(" windowEvent()... ");
//			}
//
//			@Override
//			public void windowDeiconified(WindowEvent e) {
//				System.out.println(" windowDeiconified()... ");
//			}
//
//			@Override
//			public void windowActivated(WindowEvent e) {
//				System.out.println(" windowActivated()... ");			
//			}
//
//			@Override
//			public void windowDeactivated(WindowEvent e) {
//				System.out.println(" windowDeactivated()... ");			
//			}
//		});
				
		
		
		
		//관심있는 이벤트 처리 메서드는 x버튼 클릭시 동작하는 메서드이다.
		//그러므로 이미 모든 메서드를 구현해서 가지고 있는 xxxAdapter를 상속받아
		//관심있는 메서드만 재정의 하면 코딩이 편리하다.
		
		frame.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				frame.setVisible(false);
				System.exit(0);
			}
			
		});
	}

}
