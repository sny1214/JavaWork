package com.jica.address;

import java.util.Objects;

//1명의 신상정보를 표현하는 클래스
//성명, 나이, e-mail, 전화번호, 주소, 성별 및 특이사항
//커스텀클래스, 엔티티클래스, 자바빈즈라는 용어로 지칭한다.
public class Profile implements Comparable<Object>{
	public static final char MALE = 'M';
	public static final char FEMALE = 'F';
	
	//정보 보안을 위해 멤버변수 private 접근제어자, 대신 다른 패키지에서의 사용도 고려해서 getters/setters도 염두해 두어야 한다.
	//수업에선 걍 default로..하겠다/
	String name;
	int age;
	String email;
	String phone;
	String address;
	char gender;
	
	//생성자 -- 사용의 편리성을 고려해 만들어라!
	
	//인자없는 생성자 무조건 만들어라, source - generate Constructors from Superclass
	public Profile() {
		super();
		
	}
	//사용 편리성을 위해 특정 인자만 받는 생성자 생성, source - generate Constructors using fields <-- 자주 이용하자
	public Profile(String name) {
		super();
		this.name = name;
	}

	public Profile(String name, String phone) {
		super();
		this.name = name;
		this.phone = phone;
	}

	public Profile(String name, String email, String phone) {
		super();
		this.name = name;
		this.email = email;
		this.phone = phone;
	}

	//생성자 마지막 - 전체 인자 다 포함
	public Profile(String name, int age, String email, String phone, String address, char gender) {
		super();
		this.name = name;
		this.age = age;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.gender = gender;
	}
	
	//tostring 메서드 재정의 꼭 필요 - 확인하고 싶은 값만 선택 가능
	@Override
	public String toString() {
		return "Profile [name=" + name + ", age=" + age + ", email=" + email + ", phone=" + phone + ", address="
				+ address + ", gender=" + gender + "]\n";	//\n 출력하고 줄 바꿔라
	}
	
	

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	
	//두개의 Profile객체를 비교할 때 사용될 메서드 재정의
	
	//이름이 같으면 같은 객체라 할때.. name만 선택... --> 이름말고 더 인자 넣으면, 동일 객체 판단 여부를 여러 인자로 확인
	@Override
	public boolean equals(Object obj) {
		
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Profile other = (Profile) obj;
		
		//디버깅용
		System.out.println("Profile::equals(Object) 작동함...");	//여기서 other : profile에서 name만 꺼내서 비교
		return Objects.equals(name, other.name);	//여기서 (this.)name은 내가 검색하는 p의 name..
	}
	
	//Comparable interface를 구현하기 위해 필요하다. 재정의한 것.
	@Override
	public int compareTo(Object o) { //정렬기준은 프로그래머가 결정 - 이름순 비교
		// 객체자신(this)과 매개변수로 전달된 두 객체를 비교하여 결과을 리턴한다.
		// 양수를 리턴하면 교환하고 0,음수이면 교환하지 않는다.
		//디버깅용
		System.out.println("Profile::compareTo(Object) 작동함....");
		Profile other = (Profile)o;
		return name.compareTo(other.name);


	}
	
	public Profile set​(int index, Profile element) {
		
		return element;
	}
	
	
	
}
