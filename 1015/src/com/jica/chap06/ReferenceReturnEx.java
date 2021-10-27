package com.jica.chap06;

class ReferenceReturnEx {
	public static void main(String[] args) 
	{
		Data d = new Data();
		d.x = 10;

		Data d2 = copy(d); 
		System.out.println("d.x ="+d.x);
		System.out.println("d2.x="+d2.x);
	}
//			 x                            x
//	  0x100	[10]<-----------|	   0x200 [10]			<> : 메서드끝나면 사라짐
//			 | 				|             |
//			 |				|			  |
//copy()	 |			<d 0x100>		<tmp 0x200>
//main() d 0x100		d2 ?--------------|
	
	static Data copy(Data d) {
		Data tmp = new Data();
		tmp.x = d.x;

		return tmp;
	}
}
