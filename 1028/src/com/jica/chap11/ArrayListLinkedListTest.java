package com.jica.chap11;

import java.util.*; 

//ArrayList는 내부 데이터 저장구조로 배열을 사용한다.
//			  데이터 읽기/쓰기 속도(access)가 빠르다
//			  중간에 데이터를 추가/삭제할 때 속도가 느리다(데이터 이동이 많다)
//LinkedList는 내부데이터 저장구조로 Link를 사용하고 있다.
//			  링크를 이용한 데이터 접근으로 속도가 느리다.
//			  중간에 데이터를 추가/삭제할 때 속도가 빠르다(데이터 이동없이 링크만 조절한다)

public class ArrayListLinkedListTest { 
      public static void main(String args[]) { 
        
    	  	ArrayList<String> al = new ArrayList<String>(2000000);
            LinkedList<String> ll = new LinkedList<String>(); 

            System.out.println("= 순차적인 데이터 추가 ="); 
            System.out.println("ArrayList :"+add1(al)); 
            System.out.println("LinkedList :"+add1(ll)); 
            System.out.println(); 
            System.out.println("= 중간에 데이터 추가 ="); 
            System.out.println("ArrayList :"+add2(al)); 
            System.out.println("LinkedList :"+add2(ll)); 
            System.out.println(); 
            System.out.println("= 중간에서 데이터 삭제 ="); 
            System.out.println("ArrayList :"+remove2(al)); 
            System.out.println("LinkedList :"+remove2(ll)); 
            System.out.println(); 
            System.out.println("= 순차적으로 데이터 삭제 ="); 
            System.out.println("ArrayList :"+remove1(al)); 
            System.out.println("LinkedList :"+remove1(ll)); 
      } 

      public static long add1(List<String> list) { 
    	  	//현재 작업 시작 시간을 저장 -시작시간
            long start = System.currentTimeMillis(); 
            
            for(int i=0; i<1000000;i++) list.add(i+""); 	//문자열로 만들어 ArrayList에 추가
            
            //현재 작업 시작 시간을 저장 -끝시간
            long end = System.currentTimeMillis(); 
            return end - start; 
      } 

      public static long add2(List list) { 
            long start = System.currentTimeMillis(); 
            for(int i=0; i<10000;i++) list.add(500, "X"); 
            long end = System.currentTimeMillis(); 
            return end - start; 
      } 

      public static long remove1(List list) { 
            long start = System.currentTimeMillis(); 
            for(int i=list.size()-1; i >= 0;i--) list.remove(i); 
            long end = System.currentTimeMillis(); 
            return end - start; 
      } 

      public static long remove2(List list) { 
            long start = System.currentTimeMillis(); 
            for(int i=0; i<10000;i++) list.remove(i); 
            long end = System.currentTimeMillis(); 
            return end - start; 
      } 
} 
