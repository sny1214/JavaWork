package com.jica.thread.awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
//쓰레드 우선순위 다르게 해서 만들 수도 있다.
public class RunningTest {

	public static void main(String[] args) {
		RunningFrame frame = new RunningFrame("쓰레드 사용 예제");

	}

}

class RunningFrame extends Frame{
	private static final long serialVersionUID = 1L;

	MyCanvas canvas;
	Button btnStart;
	Button btnStop;
	
	Thread thread;
	
	public RunningFrame(String title) throws HeadlessException {
		super(title);
		
		setBounds(400,200,400,300);// 위치와 크기지정
		
		//배치관리자 지정
		setLayout(new BorderLayout());
		
		canvas = new MyCanvas();
		canvas.setBackground(Color.GRAY);
		add(canvas, BorderLayout.CENTER);
		
		Panel panel = new Panel();
		btnStart = new Button(" 시 작 ");
		btnStop = new Button( " 중 지 ");
		panel.add(btnStart);
		panel.add(btnStop);
		
		add(panel, BorderLayout.SOUTH);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				setVisible(false);
				System.exit(0);
			}			
		});
		
		//시작버튼 클리시 쓰레드가 작동시작하도록 하자
		btnStart.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// 쓰레드 객체를 생성한다.
				if(thread == null || !canvas.isRun) {
					thread = new Thread(canvas);
					thread.start();
				}
			}
			
		});
		
		btnStop.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(thread != null && canvas.isRun) {
					canvas.isRun = false;
					canvas.w1 = 50;
					canvas.w2 = 50;
					
					thread = null;
				}
				
			}
			
		});
		
		setVisible(true);
	}
	
	//내부 클래스 -- 자신내부영역에 사용자가 직접 드로잉기능가진 클래스
	class MyCanvas extends Canvas implements Runnable{
		//MyCanvas의 폭을 구하자
		int cWidth = 0;
		
        //색칠하기 관련 멤버변수
		int x1 = 30, y1 = 70, w1 = 50;
        int x2 = 30, y2 = 150, w2 = 50;
        
        //쓰레드 관련 멤버변수
        boolean isRun = false;
        
		@Override
		public void paint(Graphics g) {	
			cWidth = getWidth()-50; //현재 MyCanvas의 폭이 구해진다.
			//System.out.println("캔버스의 폭 : " + cWidth);
			
			g.setColor(Color.BLACK);
			g.drawString("색칠하기- ", 30, 50);
			
			g.setColor(Color.RED);
			g.fillRect(x1,y1, w1,50);
			
			g.setColor(Color.BLUE);
			g.fillRect(x2, y2, w2, 50);
		}

		@Override
		public void run() {
			int step1 = 0;
			int step2 = 0;
			
			isRun = true;
			while(isRun) {
				
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
				//한번에 색이 넓혀지는 간격
				step1 = (int)(Math.random() * 20) + 1;
				step2 = (int)(Math.random() * 17) + 1;
				
				w1 += step1;
				w2 += step2;
				
				//위의 paint()메서드는 직접 호출하면 안된다.
				//repaint()메서드를 이용하여 간접 호출한다.
				repaint();
				
				if( w1 >= cWidth || w2 >= cWidth) {
					isRun = false;
				}
			}
			
		}
		
	}
	
	
	
}