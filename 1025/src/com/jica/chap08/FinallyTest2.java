package com.jica.chap08;

class FinallyTest2 {
	public static void main(String args[]) {
		try {
			startInstall();		// 인스톨 준비
			copyFiles();		// 파일 복사
		} catch (Exception e)	{
			e.printStackTrace();
			
		} finally {				//finally 블럭 - 예외 발생하든 말든 꼭 수행
			deleteTempFiles();	// 인스톨하면서 임시로 작성했던 파일을 제거한다.
		}
		
	}	

   static void startInstall() {
        /* 설치에 필요한 준비동작을 한다. */ 
   }
   static void copyFiles() { /* 실제 파일을 복사한다. */ }
   static void deleteTempFiles() { 
	   System.out.println("임시파일 삭제");
	   /* 임시파일들을 삭제하는 코드를 적는다. */}
}
