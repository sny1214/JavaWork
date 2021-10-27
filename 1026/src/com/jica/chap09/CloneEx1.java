package com.jica.chap09;



class CloneEx1 {
	public static void main(String[] args){
		Point original = new Point(3, 5);		
		Point copy = (Point)original.clone(); // ����(clone)�ؼ� ���ο� ��ü�� ����
		
		//                   x y
		//original 0x100--->[3,5]
		//copy     0x200--->[3,5]
		
		System.out.println(original);
		System.out.println(copy);
	}
}
