package com.jica.address;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//만든 Profile 클래스 연습하는 클래스...
public class ProfileTest {

	public static void main(String[] args) {
		//프로필 객체 생성해보자 - 원하는 인자만 입력해서 객체 생성 가능 (생성자를 사용편리성 위해 만들어 놓았으므로)
		Profile profile = new Profile("홍길동", "010-1111-1111");
		profile.email = "hgd@daum.net";
		profile.age = 26;
		profile.gender = Profile.MALE;		//--> M 로 들어가
		profile.address = "전북 전주시 완산구 노송동 125번지";
		//System.out.println(profile);
			

		//String name, int age, String email, String phone, String address, char gender
		Profile profile2 = new Profile("이순신", 42, "lss@naver.com", "010-2222-2222", "충무 앞바다",'M');
		//System.out.println(profile2);
		
		
		Profile profile3 = new Profile("장길산", 31, "jgs@gmail.com", "010-3333-3333", "강원도 산골짜기",'F');
		Profile profile4 = new Profile("고주몽", 38, "gjm@daum.net", "010-4444-4444", "만주 요서지방",'F');
		Profile profile5 = new Profile("강감찬", 29, "kkc@naver.com", "010-5555-5555", "함경도",'M');
			
		
		
		
		//여러  건의 Profile 객체를 관리(추가/수정/삭제/검색/정렬,...) 하고 싶다면 ArrayList 이용
		ArrayList<Profile> profiles = new ArrayList<Profile>();
		//								  |--------> profile ["홍길동", "010-1111-1111","hgd@daum.net",26,"전북 전주시 완산구 노송동 125번지",'M']
		//								  |		|--> profile2["이순신", 42, "lss@naver.com", "010-2222-2222", "충무 앞바다", 'M']
		//								  |	    |
		//							|-->[0x10,0x20,null,...] 10개 -> 데이터 공간 더 필요하면 알아서 더 확보.. 배열이지만 공간 자유롭게 확보
		// profiles 0x100 -----> [0x200, ....]
	
		profiles.add(profile);
		profiles.add(profile2);
		//profiles.add(profile2);			//똑같은 게 추가 될 수 있다. ArrayList중복 허용됨
		profiles.add(profile3);
		profiles.add(profile4);
		profiles.add(profile5);
		
		
		//System.out.println("개별객체 profile");
		//System.out.println("---------------------------------------------------");
		
		//1건의 profile 데이터를 총 모아둔 ArrayList
		System.out.println(profiles);
		//System.out.println(profiles.toString());		//위와 같은 말, profile의 toString도 작동한다.
		
		
		
		//검색
		
		
		
		//                            |-->["홍길동", 26, "hgd@daum.net", "010-1111-1111", "전북 전주시 완산구 노송동 125번지", 'M' ]
		//                            |    |-->["이순신", 42, "lss@naver.com", "010-2222-2222","충무 앞바다", 'M']
		//                            |    |    |-->["장길산", 31, "jgs@gmail.com", "010-3333-3333","강원도 산골짜기", 'F']
		//                            |    |    |    |-->["고주몽", 38, "gjm@daum.net", "010-4444-4444","만주 요서지방", 'F]
		//                            |    |    |    |    |-->["강감찬", 29, "ggc@naver.com", "010-5555-5555","함경도", 'M']    
		//                      |-->[0x10,0x20,0x30,0x40,0x50....]
		//profiles 0x100----->[0x200,....]
		//
		//p  0x80------------------>["고주몽",0,null,null,null,' ']
		
		
		
		//직접 코딩으로 "고주몽"의 신상명세의 포함여부와 위치를 검색한다면 향상된 for문 (하나 : array(list))
		/*				contains, indexOf에 다 포함되어 있으므로 굳이 사용x
		int i = 0;
		for(Profile p : profiles) {
			
//			if(p.name.equals("을지문덕")) {
//				System.out.println("을지문덕 데이터가 있습니다.");			//을지문덕 데이터 없으니까 출력 하나도 안됨
//				break;
//			}
			if(p.name.equals("고주몽")) {
				System.out.println("고주몽 데이터가 " + i + " 번째에 있습니다.");
				break;
			}
			i++;
		}
		*/
		
		//contains(), indexOf()	사용하여 검색해보자
		//내부에서 equals() 작동시킴 -> Object의 equals 작동시키는 것(참조값을 비교) 이므로
		
//		boolean found = profiles.contains("고주몽");				//데이터 있음에도 불구하고 무조건 false 나와, 내가 인자로 넣은 "고주몽"
//		System.out.println("고주몽 데이터 존재여부 : " + found);  		
		
		
		
		//Object의 equals 작동시키는 것(참조값을 비교) 이므로
		//false 나와, 고주몽 profile의 참조값 0x20과 p의 0x60을 비교해버리므로
		//비교하는 메서드 재정의 만들어줘야! ---> Object의 equals 메서드를 재정의해주는 이유이다!!!
		
		Profile p = new Profile("고주몽");						
		boolean found = profiles.contains(p);					
		System.out.println("고주몽 데이터 존재여부 : " + found);		
			
		
		int pos = profiles.indexOf(p);				//indexOf : 객체를 찾아라, pos : 몇번째 인지 알고 싶어 준 변수
		if(pos == -1) {								//디버깅용 출력열이 출력되는 것을 보면, indexOf도 equals 작동함을 알 수 있음
			System.out.println("고주몽 데이터는 존재하지 않습니다");
		}else {
			Profile result = profiles.get(pos);		//profiles의 몇번째 데이터
			System.out.println("고주몽의 위치는 " + pos + "번째 이고 아래는 자세한 신상명세 입니다.");
			System.out.println(result);
		}
		
		
		
		
		//삭제
		
		//순서 알고 있는 3번째인 "고주몽" 데이터를 삭제 하고 싶다. --> remove 이용
//		Profile rProfile = profiles.remove(pos);			//pos 현재 3 --> 이 객체의 참조값은 rProfile이 가짐
//		if(rProfile != null) {
//			System.out.println("삭제된 데이터 : " + rProfile);
//		}
//		System.out.println(profiles);						//profiles에 고주몽 데이터 존재x, 뒤의 데이터는 앞으로 당겨짐
//		
		
		//검색하여 삭제하기
		boolean removed = profiles.remove(p);		//검색한 p객체 삭제하시오, Profile 객체로 검색하여 삭제(equals 또 작동) -> 결과만 알려주는 코드작성함
		System.out.println(p.name + " 객체의 삭제 결과 : " + removed);
		System.out.println(profiles);		

		
		
		//정렬
	
		//성명 순으로 차례로 보여주기
		//방법1) 직접 정렬시킨다(선택정렬, 버블정렬)
		//방법2) Collections의 sort()메서드 사용
		//public static <T extends Comparable<? super T> void sort(List<T> list)
		Collections.sort(profiles);
		System.out.println("정렬후--------------------");
		System.out.println(profiles);
		
		//내부클래스
		class AgeComparator implements Comparator<Profile>{
			@Override
			public int compare(Profile o1, Profile o2) {
			
				//디버깅용
				System.out.println("Agecomparator::compare(Object,Object)...작동함");
				//양수가 리턴되면 교환, 0이나 음수는 교환하지 않음
				return o2.age - o1.age;  
			}		
		}
		
		//나이 순서대로 정렬시켜 보여주기
		AgeComparator comparator = new AgeComparator();
		
		Collections.sort(profiles, comparator);
		System.out.println("나이순 정렬후 ----------");
		System.out.println(profiles);

		
		
		//이메일 순서대로 정렬시켜 보여주기
		//익명의 클래스를 이용하면 좀더 간결하게 코딩할 수 있다.
		Collections.sort(profiles, new Comparator<Profile>() {
			@Override
			public int compare(Profile o1, Profile o2) {
			
				//디버깅용
				System.out.println("Comparator::compare(Object,Object)...작동함");
				//양수가 리턴되면 교환, 0이나 음수는 교환하지 않음
				return o1.email.compareTo(o2.email) ;  
			}
		});
		System.out.println("이메일 순서(오름차순) 정렬후 ----------");
		System.out.println(profiles);
	}
}
