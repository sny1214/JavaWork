package com.jica.chap11;

import java.util.*; 

class Bingo { 
      public static void main(String[] args) { 
            Set<String> set = new HashSet<String>(); 			//HashSet에는 전부 문자열 추가 -> 타입 파라미터 <String>
//          Set set = new LinkedHashSet(); 
            int[][] board = new int[5][5]; 

            //i : 무의미한 i -->while문 써보자
//            for(int i=0; set.size() < 25; i++) { 
//                  set.add((int)(Math.random()*50)+1+""); 
//            } 
            
            while(set.size() < 25) { 
            	set.add((int)(Math.random()*50)+1+""); 	//1~50의 난수, 중복 없이 들어가 있을 것이다.
            }
            
            
            Iterator<String> it = set.iterator(); 		//set 정렬
            //it 0x10----------------------v
            //						|--> ["7","43","12","9","1","4","25","19",...] 중복없이 25개
            //set 예시 0x100 ---> [0x100,...] set 내부 저장 공간 있음
            //board	  0x200 ---> [[  7, 43, 12,  9,  1],
            //					  [  4, 25, 19,  0,  0],
            //					  [  0,  0,  0,  0,  0],
            //					  [  0,  0,  0,  0,  0],
            //					  [  0,  0,  0,  0,  0]]
                        
            //set의 배열(요소 25개) 을 2차원으로 표현
            for(int i=0; i < board.length; i++) { 
                  for(int j=0; j < board[i].length; j++) { 
                        board[i][j] = Integer.parseInt(/*(String)*/it.next());			//it 파라미터 이미 string 위에서 지정해줌
                        System.out.print((board[i][j] < 10 ? "  " : " ") + board[i][j]); //2차원 배열에 들어가는 숫자가 한자리수라면 보기 좋게 두칸 띄고 숫자 작성, 1자리수 아님 한칸만 띔
                  } 
                  System.out.println(); 
            } 
      } // main
} 
