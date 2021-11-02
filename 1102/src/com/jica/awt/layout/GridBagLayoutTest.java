package com.jica.awt.layout;
import java.awt.*;
import java.util.*;
// GridLayout : 표형태로 구성요소를 차례대로 배치하여 관리
// new GridLayout(5,3)
//   0,0  0,1  0,2 <== 배열에서의 첨자로 생각하면(행,열)
//   1,0  1,1  1,2
//   2,0  2,1  2,2
//   3,0  3,1  3,2
//   4,0  4,1  4,2
//-----------------------
// GridBagLayout : 표형식을 셀들을 통합하여 관리
// new GridBagLayout()
// ----> x  |
//          |
//          V y
// 0,0  1,0  2,0 <== 위치지정 방식이 반대이다(열,행)
// 0,1  1,1  2,1
// 0,2  1,2  2,2
// 0,3  1,3  3,3
// 0,4  1,4  4,4
// 셀을 통합할때는 GridBagConstraints 객체를 이용하여 정보를 설정한다.
//
//-----------------------


//우선 GridLayout 생각한 상태에서 좌표 영역 생성, 이때 y->행, x->열
//합칠 폭과 높이가 1일 때 자기자신만 나타낸다.
//통합 셀을 c라 해서 add메서드로 c에 특정 객체 넣는다.
public class GridBagLayoutTest {

	public static void main(String[] args) {
		GridBagFrame frame = new GridBagFrame("GridBagLayout 테스트");
		frame.setSize(300,300);
		frame.setLocation(600,400);
		frame.setVisible(true);
	}

}

class GridBagFrame extends Frame{
	
	GridBagFrame(String title){
		super(title);
		
		// 배치관리자 -- 3행,3열
		// 배열 요소	0,0  0,1  0,2
		// (행, 열)	1,0	 1,1  1,2
		//  행 우선	2,0	 2,1  2,2
		GridBagLayout gridbagLayout = new GridBagLayout();
		setLayout(gridbagLayout);
		
		// 하나의 컴퍼넌트가 표시될 영역정보를 저장하는 객체
		GridBagConstraints c = new GridBagConstraints();
		//   0,0   1,0   2,0   	(열, 행) <- 열 우선
		//   0,1   1,1   2,1
		//   0,2   1,2   2,2
		// 기본값 설정
		c.weightx = 1.0;
		c.weighty = 1.0;
		c.fill = GridBagConstraints.BOTH;
		
		// 하나의 통합된 셀을 차지할 컴퍼넌트
		java.awt.List list = new java.awt.List();
		list.add("Basic");
		list.add("HTML");
		list.add("Java");
		list.add("JQuery");
		list.add("Servlet");
		list.add("JSP");
		list.add("Android");
		
		//   0,0   1,0   2,0   	(열, 행) <- 열 우선
		//   0,1   1,1   2,1
		//   0,2   1,2   2,2
		// 통합될 셀의 정보 설정
		c.gridx = 0; // x좌표
		c.gridy = 0; // y좌표
		c.gridwidth = 1;  // 통합될 x의 갯수(1 = 자기자신만), gridwidth 폭
		c.gridheight = 2; // 통합될 y의 갯수(2 = 2개의 cell을 통합하겠다)
		
		// Frame에 셀추가
		//add(list,c);				//통합된 c셀에 list 넣어라
		add(new Button("1"),c);		//통합된 c셀에 1 넣어라
		
		// 두번째 추가될 컴퍼넌트 
		Button btn5 = new Button("5");
		
		c.gridx = 1; // x
		c.gridy = 0; // y			==>0행,1열 위치
		c.gridwidth = 2;  // 통합될 x의 갯수
		c.gridheight = 1; // 통합될 y의 갯수
		
		add(btn5,c);
		
		// 세번째 추가될 컴퍼넌트
		Button btn6 = new Button("6");
		
		c.gridx = 1; // x
		c.gridy = 1; // y
		c.gridwidth = 1;  // 통합될 x의 갯수
		c.gridheight = 1; // 통합될 y의 갯수		
		
		add(btn6,c);
		
		// 네번째 추가될 컴퍼넌트
		Button btn7 = new Button("7");
		
		c.gridx = 2; // x
		c.gridy = 1; // y
		c.gridwidth = 1;  // 통합될 x의 갯수
		c.gridheight = 1; // 통합될 y의 갯수		
		
		add(btn7,c);	
		
		// 다섯번째 추가될 컴퍼넌트
		Button btn8 = new Button("8");
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 3;
		c.gridheight = 1;
		
		add(btn8, c);
	}
}