package com.jica.thread.awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class BirdMove2 {
	public static void main(String[] args) {
		BirdFrame2 frame = new BirdFrame2("새가 이동하도록 해보세요- 쓰레드 사용");

	}
}

class BirdFrame2 extends Frame {
	Button btnStart,btnEnd;
	BirdCanvas birdCanvas;
	Thread birdThread;
	
	public BirdFrame2(String title) throws HeadlessException {
		super(title);

		setBounds(300,250,600,300); //크기와 위치를 한번에 지정

		
		//화면구성 - (내부구성요소 객체 생성-등록, 배치(Layout)
		setLayout(new BorderLayout());
		
		//버튼 패널 --------------------
		Panel panel = new Panel();
		
		btnStart = new Button(" 시 작 ");
		btnEnd = new Button("  끝   ");
		panel.add(btnStart);
		panel.add(btnEnd);
		
		add(panel,BorderLayout.SOUTH);
		//---------------------------
		
		birdCanvas = new BirdCanvas();
		add(birdCanvas, BorderLayout.CENTER);
		
		//내부구성요소에 대한 이벤트 처리코드
		btnStart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					birdCanvas.start();
					btnStart.setEnabled(false);
			}
		});
		
		btnEnd.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				birdCanvas.stop();
				btnStart.setEnabled(true);
				
			}			
		});
		
		//종료버튼 이벤트 처리
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				setVisible(false); //EventFrame.this.setVisible(false);
				dispose();         //윈도우를 사용하기위해 내부적으로 사용한 메모리자원 반납
				System.exit(0);    //프로그램종료
			}			
		});
		
		setVisible(true);
		//setResizable(false);
	}


	
	class BirdCanvas extends Canvas {
		private static final long serialVersionUID = 1L;

		//Bird클래스형 멤버변수
		Bird bird[];
		
		int width, height; //화면의 폭과 높이
		boolean isFirst;
		
		public BirdCanvas() {
			super();
		
			isFirst = true;
		}

		@Override
		public void paint(Graphics g) {	
			if( isFirst ) { //최초 호출시 폭과 높이를 구한다.
				width = getWidth(); 
				height = getHeight();
				isFirst = false;
			}
			g.setColor(Color.GRAY);
			g.fillRect(0, 0, width, height);
			
			if( bird != null) {
				for(int i=0; i<bird.length;i++) {
				  bird[i].paint(g);
				}
			}
		}
		
		public void start() {
			bird = new Bird[4];
			for(int i=0; i<bird.length;i++) {
				bird[i] = new Bird();
				bird[i].start();
			}
		}
		
		public void stop() {
			if(bird != null) {
				for(int i=0; i<bird.length;i++) {
					bird[i].isMove = false; //쓰레드 종료
					bird[i] = null;
				}
				bird = null;
			}
		}
		
		//여러마리의 새가 동시에 움직이도록 해보시오
		class Bird extends Thread{
			static final int RIGHT = 1;
			static final int LEFT = 2;
			static Image imgBird[] = new Image[4]; 
			static {
				//화일로 부터 이미지 객체 생성
				Toolkit tk = Toolkit.getDefaultToolkit();
				imgBird = new Image[4];
				//오른쪽으로 날라가는 이미지
				imgBird[0] = tk.getImage("bird1.png");
				imgBird[1] = tk.getImage("bird2.png");
				//왼쪽으로 날라가는 이미지
				imgBird[2] = tk.getImage("bird3.png");
				imgBird[3] = tk.getImage("bird4.png");
			}

			int x, y;      //새이미지의 좌표
			int index;     //현재 그려져야할 새 이미지 번호
			int direction; //새가 이동하는 방향
			boolean isMove;//쓰레드가 시작하면 true
			
			Bird(){
				direction = (int)(Math.random() * 2) == 0 ? RIGHT : LEFT;//0,1 중에..
				if( direction == RIGHT) {
					x = 0;
					index = 0;
				}else {
					x = width;
					index = 2;
				}
				y = (int)(Math.random() * height) + 1;
			}
			
			public void paint(Graphics g) {	
				g.drawImage(imgBird[index], x, y, null); //원본크기대로 그리기
			}
			
			@Override
			public void run() {
				isMove = true;
				while( isMove ) {
					if(direction == RIGHT) {
						x += 30;   //좌표값
						index = (index == 0) ? 1 : 0; //새이미지 번호
						if( x >= width) {
							direction = LEFT; //화면을 오른쪽으로 벗어났으므로 방향전환 
						}
					}else {
						x -= 30;
						index = (index == 2) ? 3 : 2;
						if( x < 0) {
							direction = RIGHT; //화면을 왼쪽으로 벗어났으므로 방향전환
						}
					}
					
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					BirdCanvas.this.repaint();  // 화면 다시 그리기 - 내부적으로 paint()메서드가 호출된다.
				}
			}
		}
			
	}
}
