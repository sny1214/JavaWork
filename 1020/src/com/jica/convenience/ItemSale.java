package com.jica.convenience;

import java.util.Arrays;
//서비스 메서드 모아둔 클래스
//제품 판매와 관련된 모든 기능을 가진 클래스
public class ItemSale {
	public static final int MAX_ITEM_COUNT = 10;			//static이면서 public이면서 final ->객체 생성되기 전에 MAX_ITEM_COUNT 10개로 미리 생성되고 값 변경 불가
	Item items[];					//포함관계, 배열로 멤버변수 선언

	
	//10개 공간했는데 이미 아이템 객체 만들어진 객체 수
	int itemCount;
	
	
	//생성자
	public ItemSale() {			//생성자로 전달받는 인자 없다면
		//super();
		
		//Item 객체 배열 생성 (주의 : Item객체는 아직 생성되지 않았다. 배열만 생성됐을 뿐
		items = new Item[MAX_ITEM_COUNT];	//포함관계 ---> 객체 배열 생성
		//items 0x200	----> [null,null,null,null,....null]
		
		
		
		//배열에 실제 Item 객체 넣어야..
		//실무에선 파일로 만들어져 넣어져야 되는 데, 우리는 직접 Item 객체를 명시적으로 생성하여 저장
		//직접 Item 객체를 명시적으로 생성하여 저장
		
		items[0] = new Item("컵라면", 1200);
		items[1] = new Item("사이다", 850);
		items[2] = new Item("새우깡", 700);
		items[3] = new Item("아이스크림", 1500);
		items[4] = new Item("김밥", 1000);
		//10개 중에 5개는 명시적으로 생성
		itemCount = 5;
	
	}
	
	//실무에선 파일로 직접 입력받아 Item 객체를 생성해야 되는 데, 우리는 직접 Item 객체를 명시적으로 생성하여 저장
//	public ItemSale(String fileName) throws FileN..?{
//		FileReader fr = new FileReader(fileName);
//	}
//	
	
	
	
	//외부에서 item 만들어서 전달 시
	public Item add(Item item) {
		if(itemCount < MAX_ITEM_COUNT) {
			Item addItem = new Item(item.getTitle(), item.getPrice());		    //이름과 금액을 인자로 받아 addItem 객체 생성해줌 
			items[itemCount] = addItem;											//items 배열에 새로운 addItem 추가
			
			itemCount++;
			return addItem;
		}else {
			return null;
		}
		
	}

	//판매 수량 순 정렬하는 메서드(기본or개선 반복 정렬, 버블 정렬 기본or개선 중 선택해서 씀)
	public void sort() {
		//버블 정렬 개선형
		for(int i=0; i < itemCount -2 ; i++) {	//작성된 itemCount 취급 목록 중에서,, 0부터 시작이므로 -1 까지 해야 ++ 했을 때 마지막 까지 함
			boolean sw = true;		//아직 안끝났다
			for(int j = 0 ; j < itemCount-1; j++) {
				if(items[j].getQuantity() < items[j+1].getQuantity()) {
					Item tmp = items[j];
					items[j] = items[j+1];
					items[j+1] = tmp;
					sw = false;			//끝났다.
				}
			}
			if(sw) {		//sw=true 한번도 정렬 안한 거면 이미 첨부터 정렬되어 있었다는 의미 --> 그러므로 빠져나가자
				break;
			}
		}
	}
	
	
	
	//서비스 메서드
	
	public String sales(String title, int count) {			
		//제품을 검색한다
		Item result = find(title);
		
		//제품 검색 결과에 따라서 작업을 수행한다.
		String message = "";			//출력할 메세지 내용
		
		if ( result != null) {				//null 과 같지 않다 = 찾았다!
			if(	result.sale(count) > 0) {
				int money = count * result.getPrice();
				message = "총 금액은 " + money + " 입니다.\n";
				message += "정상적인 판매가 완료되었습니다.";
	
			}else {
				message = "수량오류 입니다.";
			}
		}else {								//못찾음
			message = title + " 제품은 취급 품목이 아닙니다.";
		}
		
		return message;
	}
	
	
	
	
	Item find(String title) {
		
		//순차 검색
		//취급 품목 갯수가 itemCount
		for(int i=0; i<itemCount; i++) {
			Item item = items[i];
			if( item.getTitle().equals(title)) {
				return item;
			}
		}
		return null;				//못찾으면 null값 출력
	}
		
		
//		int pos = -1 ; //찾은 위치  --> ㄷ위치를 찾으면 break 쓰기 위해!	
//		for(i = 0 ; i < itemCount ; i++) {
//			Item item = item[i];
////			if( item.getTitle() == title) {			//== 쓰면 참조값 비교함 --> 내용값 비교시엔 equals() 씀
////			}		
//			
//			if( item.getTitle().equals(item)) {
//				pos = i;
//				 break; 
//				
//				}		
//		}
//		return items[pos];;
//	}
//	


	
	
	

	@Override
	public String toString() {
		return "[ItemSale 제품갯수 : " + itemCount + "\n" +			//"\n"는 줄바꾸는 기호
			   Arrays.toString(items) + "]";						//items배열 요소에 또 toString 적용시켜 문자열로 쭉 출력, 정보 안 들어있는 건 null로 표현됨
	}
	

	
}
