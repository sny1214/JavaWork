import java.awt.Button;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.HeadlessException;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogTest {

	public static void main(String[] args) {
		MyFrame frame = new MyFrame("대화상자 연습");

	}

}

class MyFrame extends Frame implements ActionListener{
	Button btnModal;
	Button btnModeless;
	
	public MyFrame(String title) throws HeadlessException {
		super(title);
		
		setBounds(200,100,500,400);
		
		setLayout(new FlowLayout());
		
		btnModal = new Button(" 모달 대화상자 ");
		btnModeless = new Button(" 모달리스 대화상자 ");
		
		add(btnModal);
		add(btnModeless);
		
		btnModal.addActionListener(this);
		btnModeless.addActionListener(this);
		
		setVisible(true);  // Frame이 보이도록 설정
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Button cur = (Button)e.getSource();

		if(cur == btnModal) {
			MyModalDialog  dialog = new MyModalDialog(this, "모달 대화상자", true);
			dialog.setVisible(true); 
			// 모달 대화상자가 나타난다. 다음라인의 이후 코드는 대화상자가 종료하면
			// 그때 실행된다.
			System.out.println("modal dialog end!!!");
			System.out.println("inputName : " + dialog.inputName);
		}else if(cur == btnModeless) {
			MyModalDialog  dialog2 = new MyModalDialog(this, "모달리스 대화상자", false);
			dialog2.setVisible(true); 
			// 모달리스 대화상자가 나타난다. 다음라인의 이후 코드는 즉시 실행된다.
			
			System.out.println("modeless dialog end!!!");
			System.out.println("inputName : " + dialog2.inputName);
		}
	}
	
	class MyModalDialog extends Dialog{
		TextField tfName;
		Button btnQuit;
		
		String inputName;
		public MyModalDialog(Frame owner, String title, boolean modal) {
			//Frame owner : 부모윈도우
			//String title : 제목
			//boolean modal : 대화상자 종류(true:Modal, false:Modeless)
			super(owner, title, modal);
			
			//나머지 내용은 Frame에서 위치와 크기 설정및 화면구성 그리고 이벤트 설정을 동일하게 한다.
			setBounds(300,200,200,150);
			
			setLayout(new FlowLayout());
			add(new Label(" 성 명 입 력 "));
			tfName = new TextField(10);
			add(tfName);
			btnQuit = new Button(" 대화상자 종료 ");
			add(btnQuit);
			
			btnQuit.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					inputName = tfName.getText();
					
					setVisible(false);//현재 대화상자를 보이지 않게 한다.					
				}
				
			});
		}
		
	}
}