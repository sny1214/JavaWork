package com.jica.util;

import java.util.Arrays;
import java.util.Comparator;

public class ArraysTest {

	public static void main(String[] args) {
		int arr[] = { 10, 92, 48, 26, 5 };
	    System.out.println(Arrays.toString(arr));

	    //배열 요소를 정렬하자
	    //다양한 정렬방법을 사용하여 직접 코딩할수 있다
	    //sort()는 기본적으로 오름차순 정렬을 한다.
	    Arrays.sort(arr);
	    System.out.println(Arrays.toString(arr));
	    
	    //내림차순 정렬이 필요하다면?
	    
		Integer arrObj[] = {10, 92, 48, 26, 5 };
		//{10, 92, 48, 26, 5 } 안의 요소는 int로 썼지만
	    // Integer.valueOf(10)으로 쓴 것과 같다, autoboxing 기능
		
		//내부클래스중 익명의 클래스를 사용한 코딩
	    Comparator<Integer> com = new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				//디버깅용 출력(실행되는 과정 추적)
				System.out.println(o1.intValue()+","+o2.intValue());
				
				//오름차순
				//return o1.intValue() - o2.intValue();
				
				//내림차순
				return o2.intValue() - o1.intValue();
			}
	    		
	    };
	    
	    Arrays.sort(arrObj, com);
	    System.out.println(Arrays.toString(arrObj));
	    
	}

}
