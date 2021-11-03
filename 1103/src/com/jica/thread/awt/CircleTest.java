package com.jica.thread.awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CircleTest {

	public static void main(String[] args) {
		CircleFrame frame = new CircleFrame("원을 움직입니다.");

	}

}

//java.awt.Canvas 클래스는 해당영역에 직접 선,도형,이미지,글자 등을 드로잉 할 수 있다.,
//Component를 상속받은 모든 UI클래스는 paint(Graphic g) 메서드를 가지고 있어서
//자신의 모습을 화면에 나타낼 때 작동하여 자신을 그리도록 되어있다.
//주로 Canvas 클래스를 상속받는 하위 클래스를 만들어서 paint()메서드를 재정의하면
//자신을 그려야할 필요성 있을 때 자동으로 호출된다.(1번)

class CircleFrame extends Frame{
	
	CircleCanvas cc;	//Canvas클래스를 상속받아 원을 그리는 클래스의 멤버객체
	
	TextField tfMessage;
	Button btnStart, btnEnd;
	Thread thread;
	
	public CircleFrame(String title) throws HeadlessException {
		super(title);
		
		//위치와 크기 설정
		setBounds(300,200,400,300);
		
		//배치관리자 설정
		setLayout(new BorderLayout());
		
		cc = new CircleCanvas();
		add(cc, BorderLayout.CENTER);
		
		Panel panel = new Panel();
		//패널 만들어 3개 객체 패널에 추가
		tfMessage = new TextField(30);
		panel.add(tfMessage);
		
		btnStart = new Button("시작");
		panel.add(btnStart);
		
		btnEnd = new Button(" 끝 ");
		panel.add(btnEnd);
		
		add(panel, BorderLayout.SOUTH);
		//시작 버튼 누를 때 이벤트 처리
		btnStart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 원을 움직이는 쓰레드 객체를 생성하여 start시킨다.
				thread = new Thread(cc); 	//cc : circleCanvas객체 (Runnable implements함)
				thread.start();
				
			}			
		});
		
		btnEnd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//쓰레드 소멸 -- run()메서드 종료				
				cc.running = false;
			}			
		});
		
		//x버튼 클릭 시 종료
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				setVisible(false);
				System.exit(0);
			}
			
		});
		//Frame을 보기게 한다.
		setVisible(true);	
	}
	
	class CircleCanvas extends Canvas implements Runnable{
		int width;
		int height;
		boolean isFirst = true;
		
		//원의 중심점 좌표
		int x = 0;
		int y = 30;
		
		//쓰레드 기능이 시작/끝날때 사용
		boolean running;
		
		@Override
		public void paint(Graphics g/*그림그리는 데 필요한 도구,기능 다가지고 있음*/) {
			super.paint(g);	//paint 그림을 실제 그리는 기능
		
			if( isFirst ) { //최초 호출시 1번만 실행된다.<- cc = new CircleCanvas(); 할 때
				//cicleCanvas의 폭과 높이 구한다.
				width = getWidth();
				height = getHeight();
				isFirst = false;
			}
				
			//그림 그리는 메서드들
			//색상 지정
			g.setColor(Color.RED);
			//원그리기
			g.drawOval(x, y, 50, 50);	//사각형 내에 내접하는 원을 그리는 것(x,y,폭,높이)
			
		}

		@Override
		public void run() {
			// x좌표값을 변경시켜서 paint()호출되게 하면
			running = true;
			while(running) {	//running이 거짓이 될때(쓰레드 기능 끝남)까지 반복
				x += 10;		//원의 중심의 x좌표 이동시킴
				
				if( x > (width-50)) {	//원이 끝까지 가면 멈추라
					x = 0;
				}
				
				try {
					Thread.sleep(100);			//0.3초만에
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				//paint()메서드 직접 호출하지 못하고 간접호출한다.
				repaint(); //현재 화면을 지우고 paint()메서드를 호출한다.
			}
		}
		
	}
	
}
