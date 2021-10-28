package com.jica.profile;

class Profile {

	String name;
	String sex;
	String age;
	String number;
	String email;
	String address;
	String character;
	
	//				name, sex, age, number, email, address, character
	//Profile ---> [null,null,null,   null,	 null,	  null,		null] 
	
	
	Profile(){
		super();
	}
	
	Profile(String name) {
		this.name = name;
	}
	
	Profile(Profile profile) {
		this.name = profile.name;
		this.age = profile.age;
		this.email = profile.email;
		this.number = profile.number;
		this.address = profile.address;
		this.sex = profile.sex;
		this.character = profile.character;
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getCharacter() {
		return character;
	}

	public void setCharacter(String character) {
		this.character = character;
	}
	
	
	
	
	
	
	
	@Override
	public String toString() {
		return "Profile [name=" + name + ", age=" + age + ", email=" + email + ", number=" + number + ", address="
				+ address + ", sex=" + sex + ", character=" + character + "]";
	}
	
}



//if(sex == "남" || "남자") {
//	this.sex = "남자";
//}else {
//	this.sex = "여자";
//}
