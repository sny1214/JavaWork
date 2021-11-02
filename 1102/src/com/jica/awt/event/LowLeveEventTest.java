package com.jica.awt.event;
import java.awt.Frame;
import java.awt.HeadlessException;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class LowLeveEventTest {

	public static void main(String[] args) {
		MyFrame frame = new MyFrame("low level 이벤트 처리 예제");
		frame.setVisible(true);
	}

}

class MyFrame extends Frame{

	public MyFrame(String title) throws HeadlessException {
		super(title);
		
		setBounds(300,200,400,300);
		
		//키보드를 누를때의 이벤트 처리
		/*this.*/addKeyListener(new KeyAdapter() {
		//this = MyFrame
			
			@Override
			public void keyPressed(KeyEvent ke) {
				super.keyPressed(ke);
				System.out.println("KeyPressed 눌리워진 키 : " + ke.getKeyChar() + "," + ke.getKeyCode());
			}

			@Override
			public void keyTyped(KeyEvent e) {
				super.keyTyped(e);
				System.out.println("keyTyped  : " + e.getKeyChar() + "," + e.getKeyCode());
			}

			@Override
			public void keyReleased(KeyEvent e) {
				super.keyReleased(e);
				System.out.println("KeyReleased 떼어진 키 : " + e.getKeyChar() + "," + e.getKeyCode());
			}
			
		});
		
		//Mouse 기본이벤트
		this.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.out.println("마우스 클릭됨");
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				System.out.println("마우스가 Frame영역에 들어옴");;
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				System.out.println("마우스Frame영역을 빠져나감");
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				System.out.println("Mouse 눌리워짐");
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				System.out.println("Mouse 떼어짐");
				
			}
			
		});
		
		//마우스를 움직일때의 이벤트처리
		this.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				
				System.out.println("마우스 드래그: " + x + "," + y);
			}

			@Override
			public void mouseMoved(MouseEvent e) {
				int x = e.getX();
				int y = e.getY();
				
				System.out.println("마우스 움직임: " + x + "," + y);
			}
			
		});
	}
	
}