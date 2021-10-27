package com.jica.chap08;

class NewExceptionTest {
	public static void main(String args[]) {
		try {
			startInstall();		// 인스톨 준비.
			copyFiles();			// 실제 파일 복사
		} catch (SpaceException e)	{
			System.out.println("에러 메세지 : " + e.getMessage());
			e.printStackTrace();
			System.out.println("공간을 확보하고 다시 설치해 주세요.");
		} catch (MemoryException me)	{
			System.out.println("에러 메세지 : " + me.getMessage());
			me.printStackTrace();
			System.gc();		//  Garbage Collection기능 - 현재 참조되지 않는 동적영역의 메모리를
								//JVM에 요청한다.
			System.out.println("다시 설치를 시도하세요.");
		} finally {
			deleteTempFiles();	// 임시 파일 삭제.
		} // try�� ��
	} // main�� ��

   static void startInstall() throws SpaceException, MemoryException { 
		if(!enoughSpace()) 		// 설치 공간 검사, =하드 디스크 용량 검사
			throw new SpaceException("설치 공간이 부족합니다..");
		if (!enoughMemory())		// 메모리 공간 검사
			throw new MemoryException("메모리가 부족합니다..");
   } // startInstall�޼����� ��

   static void copyFiles() { /* 실제 파일을 복사하면서 임시파일을 만들면서 작업한다. */ }
   static void deleteTempFiles() { /* �ӽ����ϵ��� �����ϴ� �ڵ带 ���´�.*/}
   
   static boolean enoughSpace()   {
	   // 하드디스크 용량이 충분하면 true 부족하면 false 를 출력한다.
		return false;
   }
   static boolean enoughMemory() {
		// 메모리 용량이 충분하면 true 부족하면 false 를 출력한다.
		return true;
   }
} // ExceptionTestŬ������ ��

class SpaceException extends Exception {	//스페이스 공간 부족할 때 발생 exception
	SpaceException(String msg) {
	   super(msg);	
   }
} 

class MemoryException extends Exception {	//메모리 부족시 발생 exception
	MemoryException(String msg) {
	   super(msg);	
   }
}
