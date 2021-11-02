package com.jica.awt.profile;

public class Profile {
	String name;
	int gender;   //1:남자, 2:여자
	int year;
	String phone;
	String email;
	String memo;
	
	public Profile() {
		super();
	}

	public Profile(String name) {
		super();
		this.name = name;
	}

	public Profile(String name, String phone) {
		super();
		this.name = name;
		this.phone = phone;
	}

	public Profile(String name, int gender, int year, String phone, String email, String memo) {
		super();

		this.name = name;
		this.gender = gender;
		this.year = year;
		this.phone = phone;
		this.email = email;
		this.memo = memo;
	}
	
	//setters/getters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}
	
		
	@Override
	public String toString() {
		return "[" + name + "," + gender + "," + year + ","
				+ phone + "," + email + "," + memo + "]\n";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

    //기준은 본인이 설정(성명과 카테고리코드가 같으면 같은 데이타로 취급)
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Profile other = (Profile) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
