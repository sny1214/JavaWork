import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class MenuTest {
	public static void main(String args[]) {
		Frame f = new Frame("Frame with Menu");
		
		//Frame의 크기 설정
		f.setBounds(400,300,400, 300);

		//메뉴 구성하기
		MenuBar mb = new MenuBar();   //메뉴바
			
			//첫번째 Menu 구성하기
			Menu mFile = new Menu("File");

				//MenuItem
				MenuItem miNew = new MenuItem("New");
				MenuItem miOpen = new MenuItem("Open");
				Menu	mOthers = new Menu("Others");	    // MenuItem이 아니라 Menu임에 주의
				MenuItem miExit = new MenuItem("Exit");


				//New 버튼 누르면 실행할 이벤트 핸들러 설정시 아래와 같이 작성
//				miNew.addActionListener(new ActionListener(){
//
//					@Override
//					public void actionPerformed(ActionEvent e) {
//						// TODO Auto-generated method stub
//						
//					}
//					
//				});
					mFile.add(miNew);		// Menu에 MenuItem들을 추가한다.
					mFile.add(miOpen);
					mFile.add(mOthers);		// Menu에 Menu를 추가한다.
						mFile.addSeparator();	// 메뉴 분리선을 넣는다.
					mFile.add(miExit);
					
						//mFile.add(mOthers);
						MenuItem miPrint = new MenuItem("Print ...");
						MenuItem miPreview = new MenuItem("Print Preview");
						MenuItem miSetup = new MenuItem("Print Setup ...");
						mOthers.add(miPrint);
						mOthers.add(miPreview);
						mOthers.add(miSetup);

			//두번째 메뉴 구성하기
			Menu mEdit = new Menu("Edit");
				MenuItem miCopy = new MenuItem("Copy");
				MenuItem miPaste = new MenuItem("Paste");
				mEdit.add(miCopy);
				mEdit.add(miPaste);
			
			//세번째 메뉴 구성하기
			Menu mView = new Menu("View");
				CheckboxMenuItem miStatusbar = new CheckboxMenuItem("Statusbar");
				mView.add(miStatusbar);
			
			//네번째 메뉴 구성하기
			Menu mHelp = new Menu("Help");
		
		//MenuBar에 Menu를 추가한다.
		mb.add(mFile);			// MenuBar에 Menu를 추가한다.
		mb.add(mEdit);
		mb.add(mView);
		mb.setHelpMenu(mHelp);	// mHelp를 HelpMenu로 지정한다.

		// Frame에 MenuBar를 포함시킨다.
		f.setMenuBar(mb);	
		
		
		
		//팝업메뉴도 추가해보자 - 마우스 오른쪽 클릭 씨 뜨는 메뉴
		
		PopupMenu pMenu = new PopupMenu("신상명세 관리");
			MenuItem miAdd = new MenuItem("신상명세 추가");
			MenuItem miModify = new MenuItem("내용수정");
			MenuItem miRemove = new MenuItem("신상명세 삭제");
			pMenu.add(miAdd);
			pMenu.add(miModify);
			pMenu.add(miRemove);
			
			//팝업 메뉴의 메뉴항목(MenuItem) 선택시의 이벤트 핸들러 설정
			miModify.addActionListener(new ActionListener () {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
				}
				
			});
			
		f.add(pMenu);
		//마우스 오른쪽버튼 클릭시의 팝업메뉴가 나타나는 기능은 마우스 이벤트핸들러에서 설정이 필요
		f.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent me) {			//마우스이벤트 들어왔을 때
				// 마우스 오른쪽 버튼 클릭시 팝업메뉴 보여주기
				super.mouseClicked(me);
				
				if( me.getModifiers() == me.BUTTON3_MASK) {		//getModifiers들어온 정보가 BUTTON3_MASK = 오른쪽마우스버튼
					pMenu.show(f, me.getX(), me.getY());		//팝업메뉴 보여주라.
				}
			}
			
		});
		//--------------------------------------------
		//메뉴항목(MenuItem)을 클릭했을때 수행할 이벤트핸들러 지정
		miOpen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//FileDialog(Frame parent, String title, int mode)
				//                                       --------FileDialog.LOAD, SAVE
				FileDialog fOpenDialog = new FileDialog(f,"file Open", FileDialog.LOAD);	//파일을 열때 대화상자 창을 염
				fOpenDialog.setVisible(true);
				
				String fileName = fOpenDialog.getDirectory() + fOpenDialog.getFile();	//선택한 디렉토리위치와 선택한 파일명을 얻는다. (예 : C:\JKWork\JavaWork\1102\����.txt)
				System.out.println("select fileName :" + fileName);
				
				//실제 화일의 내용을 읽어오는 기능이 다음시간에 학습하는 java.io패키지의 다양한 클래스를 이용하면 가능하다.
				
			}
			
		});
		
		f.setVisible(true);

		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				super.windowClosing(arg0);
				f.setVisible(false);
				f.dispose();
				System.exit(0);
			}
			
		});
		
		f.setLayout(null);									
		Label lMessage = new Label("마우스 좌표");
		lMessage.setBounds(10,270,200,20);
		f.add(lMessage);
		
		f.addMouseMotionListener(new MouseAdapter() {				//마우스 움직일 때

			@Override
			public void mouseMoved(MouseEvent me) {
				super.mouseMoved(me);
				int x = me.getX();
				int y = me.getY();
				System.out.println("Mouse move(x,y) => "+ x + "," + y);
				lMessage.setText("마우스 좌표:("+x+","+y+")");
			}
			
		});
	}
}