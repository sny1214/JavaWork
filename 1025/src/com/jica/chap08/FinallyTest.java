package com.jica.chap08;

class FinallyTest {
	public static void main(String args[]) {
		try {
			startInstall();		// 설치 준비
			copyFiles();		// 파일을 복사한다 
			deleteTempFiles();	// 인스톨하면서 임시로 작성했던 파일을 제거한다.
		} catch (Exception e) {
			e.printStackTrace();
		    deleteTempFiles();   // 인스톨하면서 임시로 작성했던 파일을 제거한다.
		} 
	} 

   static void startInstall() { 
        /* 설치에 필요한 준비동작을 한다.*/ 
   }
   static void copyFiles() { /* 파일을 복사한다. */ }
   static void deleteTempFiles() { /*임시파일들을 삭제하는 코드를 적는다.*/ }
}
