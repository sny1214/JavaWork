package com.jica.report;

import java.util.ArrayList;

/*
 * String str = new String("JICA 전주정보문화산업진흥원 JICA JEONJU");	
 * str에 저장된 문자열엣 'J' 문자의 위치를 모두 구하여 출력하시오.
 */
public class CharIndex {

	public static void main(String[] args) {
		String str = new String("JICA 전주정보문화산업진흥원 JICA JEONJU");
		
		ArrayList<Integer> arrPos;						//<Integer> : type parameter
		arrPos/*[]*/ = findCharPos(str, 'J');
		
		for(int i=0; i <arrPos.size()/*arrPos[i] != -1*/; i++) {
			System.out.println(arrPos.get(i)/*arrPos[i]*/ + "번째");
		}
	}
	
	static ArrayList<Integer>/*int[]*/ findCharPos(String str, char ch) {
		ArrayList<Integer> arrPos = new ArrayList<Integer>();
		//arrPos 0x100 ----> []
					//ArrayList 안쓸 때
					//arrPos[] = new int[10];
					//arrPos 0x100 ---------------------> [0,17,22,26,-1,0,0,0,0,0]			//-1 이후의 값은 무의미한 값, 더이상 없다는 뜻, 그 이전만 유의미한 값
		int i = 0;
					//int count = 0;
		while(i<str.length()) {						//for문은 규칙적인 반복문
			int pos = str.indexOf(ch, i);
			if (pos == -1) {
				break;
			}else {
				arrPos.add(pos);
					//System.out.println(pos + "번째");
					//arrPos[count++] = pos;
				i = pos + 1 ;			//index 0이면 1번째 글자 // pos + 1 --> 불규칙한 반복문 --> while문
			}
		}
					//arrPos[count] = -1;
		return arrPos;
	}
	
}
