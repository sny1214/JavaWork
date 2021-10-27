package com.jica.chap05;

class ArrayEx10 {
	public static void main(String[] args) {
		
		//개선된 버블정렬
		
		//인접한 두 값을 비교한다.
		//중간의 정렬이 완료되면 탈출한다.
		
		int[] numArr = new int[10];

		System.out.println("원본배열 생성후 출력 ----");
		//numArr 0x100 ----> [0,0,0,0,0,0,0,0,0,0]
		for (int i=0; i < numArr.length ; i++ ) {
			System.out.print(numArr[i] = (int)(Math.random() * 10));	// 0 ~ 9까지 숫자
			// 0 ~ 9 까지 범위의 난수를 발생시켜 i번째 요소값으로 저장하고 저장된 값을 즉시 출력한다.
		}
		System.out.println();

		
		//버블정렬 수행한다.
		for (int i=0; i < numArr.length-1 ; i++ ) {
			boolean changed = false;	// 내용값을 교환하지 않았다고 가정하고 시작

			for (int j=0; j < numArr.length-1-i ;j++) {
				if(numArr[j] > numArr[j+1]) { // 인접한 두값 즉, j번째와 j+1번째 비교
					int temp = numArr[j];
					numArr[j] = numArr[j+1];
					numArr[j+1] = temp;
					changed = true;	// 값을 교환했으므로 정렬이 완료되지 않았음을 의미
				}
			} // end for j

			if (!changed) break;	// true값을 유지하고 있다면 = 한번도 교환하지 않았다면 반복 탈출 break

			//중간결과 출력
			System.out.print(i + " 번째 반복 후  ===> ");
			for(int k=0; k<numArr.length;k++)
				System.out.print(numArr[k]);
			System.out.println();
		} // end for i
	} // main�� ��
}
