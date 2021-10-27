package com.jica.chap06;

class Document {
	static int count = 0;
	String name;     // 문서명(Document name)

	Document() {     // 문서생성시 문서명을 지정하지 않았을때
		this("제목없음" + ++count);
	}

	Document(String name) {
		this.name = name;
		System.out.println("문서 " + this.name + " 가 생성되었습니다.");
	}
}

class DocumentTest {
	public static void main(String args[]) {
		Document d1 = new Document();
		Document d2 = new Document("자바.txt");
		Document d3 = new Document();
		Document d4 = new Document("코틀린.txt");
		Document d5 = new Document();
		
		//Document::count    3
		//              name
		//d1 0x100----->["제목없음1"]
		//d2 0x200----->["자바.txt"]
		//d3 0x300----->["제목없음2"] 
		//d4 0x400----->["코틀린.txt"]
		//d5 0x500-----> ["제목없음3"]   
	}
}
