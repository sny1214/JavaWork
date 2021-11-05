package com.jica.awt.profile;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.Dialog;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.HeadlessException;
import java.awt.Label;
import java.awt.List;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class AWTProfileTest {

	public static void main(String[] args) {
		ProfileFrame frame = new ProfileFrame("신상명세 관리 프로그램 ver 0.1");

	}

}

class ProfileFrame extends Frame{
	private static final long serialVersionUID = 1L;

	//Fields
	//실제 신상명세를 가진 객체 
	ProfileManager manager = new ProfileManager("JICA");
	
	//UI 객체들
	Choice cCategory;
	List   lNames;

	TextField tfName;
    Checkbox  cbMale, cbFemale;
    CheckboxGroup cbgGender;
    TextField tfYear;
    TextField tfPhone;
    TextField tfEmail;
    TextArea  taMemo;
    
    TextField tfSearchName;
    Button    btnSearch;
    Button    btnAdd;
    Button    btnModify;
    Button    btnRemove;
    
	public ProfileFrame(String title) throws HeadlessException {
		super(title);
		
		//연승용 데이타 만들기- 현재예제는 인위적으로 연습용 데이타 5건을 만든다.
		//이후 file i/o를 학습하여 화일로부터 읽어서 데이타를 만들수도 있을것이다.
		makeSampleData();
		
		//메뉴 붙이기
		MenuBar mb = new MenuBar();
			Menu mFile = new Menu("File");
			Menu mEdit = new Menu("Edit");
				MenuItem miModify = new MenuItem("Edit Profile");
				mEdit.add(miModify);
			Menu mView = new Menu("View");
			Menu mHelp = new Menu("Help");
		
			mb.add(mFile);			
			mb.add(mEdit);
			mb.add(mView);
			mb.setHelpMenu(mHelp);	
			
		setMenuBar(mb);
		
/*		miModify.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				FileDialog fOpenDialog = new FileDialog(, "Edit Profile", FileDialog.LOAD);
//				
 * 				Button btnEdit;
 * 				Button btnCancel;
				
				TextField tfName;
    			Checkbox  cbMale, cbFemale;
    			CheckboxGroup cbgGender;
    			TextField tfYear;
    			TextField tfPhone;
    			TextField tfEmail;
    			TextArea  taMemo;
				
			add(tfName);
			add(cbMale);
			add(cbFemale);
			add(cbgGender);
			add(tfYear);
			add(tfEmail);
			add(taMemo);
		
		
//			fOpenDialog.setVisible(true);
//				
//				
//				
//				
//				
//				
//				
//				
//				
//			}
//			
//		});

	*/	
		
		
		//위치와 크기지정
		setBounds(300,200, 420,350);	
		
		//화면 구성 기능을 별도의 메서드작성
		makeGUI();
		
		//List에서 선택된 항목의 데이타가 오른쪽화면에 나타나게 한다.
		displayProfileData();
		
		//화면보이기
		setVisible(true);
		
		//이벤트 처리 코드
		//왼쪽 성명선택이 바뀌면 데이타 보여주기
		lNames.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent arg0) {
				displayProfileData();
			}
			
		});
		
		//신규등록을 클릭할때의 이벤트 처리
		btnAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//현재 버튼의 글자를 알아온다.
				String title = btnAdd.getLabel();
				if(title.equals("신규등록")) {
					 lNames.setEnabled(false);   // List - 사용못함
	                 btnAdd.setLabel("내용저장");  //신규등록 -->내용저장
	                 btnModify.setEnabled(false);//내용변경 -->사용못함
	                 btnRemove.setLabel("취     소");//삭    제  -->취소
	                 	                 
	                 // 2) 오른쪽화면의 모든 내용이 지워진다.
	                 clearProfileData();
	                 
	                 // 커서는 성명항목에 촛점이 주어진다.
	                 tfName.requestFocus();
				}else { //내용저장
					 // 오른쪽 화면의 내용을 읽어와서 Profile객체를 만든다.
					 String name = tfName.getText().trim();
					 int gender = cbMale.getState() ? 1 : 2;
					 String strYear = tfYear.getText();    //"1998"
					 int year = Integer.parseInt(strYear); //1998
					 String phone = tfPhone.getText().trim();
					 String email = tfEmail.getText().trim();
					 String memo = taMemo.getText().trim();
					 
					 Profile profile = new Profile(name,gender,year,phone,email,memo);
					
					 // manager에 Profile객체를 추가한다.
					 manager.add(profile);
					 
					 // 왼쪽 List에 성명을 추가하고 선택되게 한다.
					 lNames.add(name);
					 lNames.select(lNames.getItemCount()-1);
					 
					 // displayData()
					 
					 // 나머지 UI요소의 상태를 원상복구한다.
					 lNames.setEnabled(true);   // List - 사용가능
	                 btnAdd.setLabel("신규등록");  //내용저장 -->신규등록
	                 btnModify.setEnabled(true);//내용변경 -->사용가능
	                 btnRemove.setLabel("삭      제");//취   소 -->삭    제	
				}
			}
			
		});
		
		//삭제/취소버튼의 이벤트 핸들러 설정
		btnRemove.addActionListener(new RemoveButtonHandler());
		
/*		//내용수정버튼 클릭시의 이벤트 핸들러 설정
		btnModify.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//현재 버튼의 글자를 알아온다.
				String title = btnModify.getLabel();
				if(title.equals("내용수정")) {
					 lNames.setEnabled(false);   // List - 사용못함
	                 btnAdd.setLabel("내용저장");  //신규등록 -->내용저장
	                 btnModify.setEnabled(false);//내용변경 -->사용못함
	                 btnRemove.setLabel("취     소");//삭    제  -->취소
	                 // 커서는 성명항목에 촛점이 주어진다.
	                 tfName.requestFocus();
				}else { //내용저장
					 // 오른쪽 화면의 내용을 읽어와서 Profile객체를 만든다.
					 String name = tfName.getText().trim();
					 int gender = cbMale.getState() ? 1 : 2;
					 String strYear = tfYear.getText();    //"1998"
					 int year = Integer.parseInt(strYear); //1998
					 String phone = tfPhone.getText().trim();
					 String email = tfEmail.getText().trim();
					 String memo = taMemo.getText().trim();
				}
				
				Profile profile = new Profile(name,gender,year,phone,email,memo);
					
				 // manager에 Profile객체를 추가한다.
				 manager.add(profile);
				 
				 // 왼쪽 List에 성명을 추가하고 선택되게 한다.
				 lNames.add(name);
				 lNames.select(lNames.getItemCount()-1);
				 
				 // displayData()
				 
				 // 나머지 UI요소의 상태를 원상복구한다.
				 lNames.setEnabled(true);   // List - 사용가능
                btnAdd.setLabel("신규등록");  //내용저장 -->신규등록
                btnModify.setEnabled(true);//내용변경 -->사용가능
                btnRemove.setLabel("삭      제");//취   소 -->삭    제
			}
		});
*/		
		//검색버튼 클릭시의 이벤트 핸들러 설정
		btnSearch.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//1. 검색 이름을 가져오기
				String sName = tfSearchName.getText().trim();
				
				//2. manager에서 동일이름을 가진 첫데이타 위치를 찾는다.				
				int pos = manager.getIndex(sName);
				
				//3. 찾은 순번을 lNames에서 선택한다.
				if(pos != -1) { //찾았다.
					lNames.select(pos);
					displayProfileData();
				}
				
			}
			
		});
		
		//Frame의 x버튼, 즉 윈도우의 종료버튼 클릭시 프로그램 종료
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				setVisible(false);
				System.exit(0);
			}	
		});
		
	}
	
	class RemoveButtonHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			String title = e.getActionCommand();
			if( title.equals("취     소")) {
				//UI요소를 원래대로 복구 시킨다.
				lNames.setEnabled(true);   // List - 사용가능
                btnAdd.setLabel("신규등록");  //내용저장 -->신규등록
                btnModify.setEnabled(true);//내용변경 -->사용가능
                btnRemove.setLabel("삭      제");//취   소 -->삭    제

                //오른쪽화면의 내용을 현재 lName에서 선택한 사람의 데이타로 복구시킨다.
                displayProfileData();

			}else if( title.equals("삭      제")) {
				System.out.println("삭제버튼이 클릭되었다.");
				//무조건 현재선택된 데이타를 삭제하자.(오후-대화상자로 확인하는 작업)
				//사용자에 정말로 데이타를 삭제할 것인지 확인하자
				ConfirmDialog confirmDialog = new ConfirmDialog(ProfileFrame.this,"삭제확인 대화창", true);
				confirmDialog.setVisible(true);
				
				//이후의 코드는 대화상자가 모달대화상자로 만들어지면 
				//위의 confirmDialog가 종료된 이후에 동작한다.
				
				//그러나 모달리스대화상자로 만들어지면 즉시 동작된다.
				System.out.println("대화상자가 종료하면 현재의 메세지가 보입니다.");
				if(!confirmDialog.confirm) {
					return;   // 대화상자에서 아니오를 선택했으므로 아무일도 하지않고 돌아간다.
				}
				
				//1. manager에서 현재 데이타 삭제
				int curIndex = lNames.getSelectedIndex();
				manager.remove(curIndex);
				
				//2. lName에 항목을 재구성
				lNames.removeAll(); //기존항목을 모두 지운다.
				
				String names[] = manager.getNames();
				for(int i=0; i<names.length; i++) {
					lNames.add(names[i]);
				}
				
				//3. 무조건 첫번째 데이타가 선태되게 한다.
				if( lNames.getItemCount() > 0) {
					lNames.select(0);
					//4. 오른쪽 내용을 보여준다.
					displayProfileData();
				}else { //항목이 하나도 없으므로 오른쪽도 비어상태로 보여져야 한다.
	                clearProfileData();
				}
			}
		}
		
	}
	
	void makeSampleData() {
		/*
		 * 여기에 profile.dat 내용을 읽어서 manage에 Profile객체를 추가하는 코드로 
		 * 변경시키고 아래의 코드를 지운다.
		 */
		Profile profile1 = new Profile("홍길동",1,1994,"010-1111-1111","hgd@daum.net",null);
		manager.add(profile1);
		
		Profile profile2 = new Profile("장길산",2,1998,"010-2222-2222","jgs@naver.com",null);
		manager.add(profile2);
		
		Profile profile3 = new Profile("이순신",1,1997,"010-3333-3333","lss@gmail.net",null);
		manager.add(profile3);	
		
		Profile profile4 = new Profile("고주몽",2,1994,"010-4444-4444","gjm@naver.com",null);
		manager.add(profile4);		
		
		Profile profile5 = new Profile("강감찬",1,1995,"010-5555-5555","ggchan@daum.net","JICA 수강생");
		manager.add(profile5);	
		
		Profile profile6 = new Profile("홍길동2",1,1994,"010-1111-1111","hgd@daum.net",null);
		manager.add(profile6);
		
		Profile profile7 = new Profile("장길산2",2,1998,"010-2222-2222","jgs@naver.com",null);
		manager.add(profile7);
		
		Profile profile8 = new Profile("이순신2",1,1997,"010-3333-3333","lss@gmail.net",null);
		manager.add(profile8);	
		
		Profile profile9 = new Profile("고주몽2",2,1994,"010-4444-4444","gjm@naver.com",null);
		manager.add(profile9);		
		
		Profile profile10 = new Profile("강감찬2",1,1995,"010-5555-5555","ggchan@daum.net","JICA 수강생");
		manager.add(profile10);	
		
		Profile profile11 = new Profile("홍길동3",1,1994,"010-1111-1111","hgd@daum.net",null);
		manager.add(profile11);
		
		Profile profile12 = new Profile("장길산3",2,1998,"010-2222-2222","jgs@naver.com",null);
		manager.add(profile2);
		
		Profile profile13 = new Profile("이순신3",1,1997,"010-3333-3333","lss@gmail.net",null);
		manager.add(profile13);	
		
		Profile profile14 = new Profile("고주몽3",2,1994,"010-4444-4444","gjm@naver.com",null);
		manager.add(profile14);		
		
		Profile profile15 = new Profile("강감찬3",1,1995,"010-5555-5555","ggchan@daum.net","JICA 수강생");
		manager.add(profile15);	
	}
	
	void makeGUI() {
		//배치관리자 설정
		setLayout(null);
		
		//신상명세 카테고리
		cCategory = new Choice();
		cCategory.add("전 체");
		cCategory.add("초등학교");    // 1
		cCategory.add("중고등학교");   // 2
		cCategory.add("직장동료");    //  3
		cCategory.add("JICA 수강");  //  4
		cCategory.setBounds(30,50,80,20);
		//사용자가 이용하지 못하도록 한다. - 마우스 클릭을 해도 반응없음
		cCategory.setEnabled(false);
		
		add(cCategory);
		
		//성명들
		lNames = new List(10); //10명을 이름을 목록으로 보여준다.
		String names[] = manager.getNames();
		for(int i=0; i<names.length; i++) {
			lNames.add(names[i]);
		}
		lNames.setBounds(30, 80, 80, 200);
		
		add(lNames);
		
		lNames.select(0);  //List의 항목중 첫번째 항목이 선택되게 한다.
		
		
		//오른쪽 화면 구성 - 신상명세 내용이 보여지거나 입력
		Label lName = new Label("성      명");
		lName.setBounds(120, 60, 50, 20);
		add(lName);
		
		tfName = new TextField(10);
		tfName.setBounds(170, 60, 100, 20);
		add(tfName);
		
		//성     별
		Label lGender = new Label("성     별");
		lGender.setBounds(120, 90, 50, 20);
		add(lGender);
		
		cbgGender = new CheckboxGroup();
		cbMale = new Checkbox("남자",cbgGender,false);
		cbFemale = new Checkbox("여자",cbgGender,true);
		cbMale.setBounds(170, 90, 40, 20);
		cbFemale.setBounds(220, 90, 40, 20);
		add(cbMale);
		add(cbFemale);
		
		//출생년도     1994
        //전화번호     010-7242-9424
		//email   argus10@hammail.net
		Label lYear = new Label("출생년도");
		lYear.setBounds(120,120,50,20);
		add(lYear);
		
		tfYear = new TextField(6);
		tfYear.setBounds(170,120,50,20);
		add(tfYear);
		
		Label lPhone = new Label("전화번호");
		lPhone.setBounds(120,150,50,20);
		add(lPhone);
		
		tfPhone = new TextField(17);
		tfPhone.setBounds(170,150,100,20);
		add(tfPhone);
		
		Label lEmail = new Label("E-mail");
		lEmail.setBounds(120,180,50,20);
		add(lEmail);
		
		tfEmail = new TextField(25);
		tfEmail.setBounds(170,180,150,20);
		add(tfEmail);
		
        //특이사항     메모내용     TextArea
		Label lMemo = new Label("특이사항");
		lMemo.setBounds(120,210,50,20);
		add(lMemo);
		
		taMemo = new TextArea("메모내용을 입력하세요.",4,50);
		taMemo.setBounds(170,210,230,60);
		add(taMemo);
			
		//하단화면구성 -- 다양한 버튼들
	    /*
	    TextField 검색     신규등록     내용변경    삭    제  Button   
	     */
		tfSearchName = new TextField(10);
		tfSearchName.setBounds(30,300,80,20);
		add(tfSearchName);
		
		btnSearch = new Button("이름검색");
		btnSearch.setBounds(120,300,60,20);
		add(btnSearch);
		
		btnAdd = new Button("신규등록");
		btnAdd.setBounds(190,300,60,20);
		add(btnAdd);
		
		btnModify = new Button("내용수정");
		btnModify.setBounds(260,300,60,20);
		add(btnModify);
		
		btnRemove = new Button("삭      제");
		btnRemove.setBounds(330,300,60,20);
		add(btnRemove);
		
		setResizable(false);
	}
	
	public void clearProfileData() {
   	    tfName.setText("");
        tfYear.setText("");
        tfPhone.setText("");
        tfEmail.setText("");
        taMemo.setText("");
	}
	
	void displayProfileData() {
		//List에서 선택된 항목 알아내기
		int curIndex = lNames.getSelectedIndex();
		//String curName = lNames.getSelectedItem();
		Profile profile = manager.getProfile(curIndex);
		if( profile != null) {
			tfName.setText(profile.name);
			if( profile.gender == 1) {
				cbMale.setState(true);
			}else {
				cbFemale.setState(true);
			}
			tfYear.setText(profile.year+"");
			tfPhone.setText(profile.phone);
			tfEmail.setText(profile.email);
			if( profile.memo == null) {
				taMemo.setText("");
			}else {
				taMemo.setText(profile.memo);
			}
		}
	}
	
	class ConfirmDialog extends Dialog implements ActionListener{
		Button btnYes, btnNo;
		boolean confirm ;
		
		public ConfirmDialog(Frame owner, String title, boolean modal) {
			//파라메터값의 의미
			//owner : 부모Window
			//title : 대화상자 title
			//modal : true-모달 대화상자, false-모달리스 대화상자
			super(owner, title, modal);
			
			//대화상자의 위치와 크기를 지정
			setBounds(400,250,280,150);
			
			//배치관리자 설정
			setLayout(null);
			
			Label lMessage = new Label("현재 선택된 신상명세를 삭제하시겠습니까?");
			lMessage.setBounds(30, 50, 230, 20);
			add(lMessage);
			
			btnYes = new Button("   예     ");
			btnNo  = new Button(" 아니오   ");
			btnYes.setBounds(30,80,60,20);
			btnNo.setBounds(100,80,60,20);
			add(btnYes);
			add(btnNo);
			
			//이벤트 핸들러 설정
			btnYes.addActionListener(this);
			btnNo.addActionListener(this);
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			Button curButton = (Button)e.getSource();
			
			if(curButton == btnYes) {
				confirm = true;  //삭제 해야함
			}else { //btnNo
				confirm = false; //삭제 안함
			}
			
			setVisible(false); //대화상자를 보이지 않게 한다.
		}
		
	}
	
}