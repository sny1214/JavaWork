package com.jica.chap06;

class Test{
      
   int add(int...a){
           //-------> 가변인자로 a로 전달되는 인자의 갯수는 1개부터~여러개 전달할수 있다는 의미이다.
           //         내부적으로 가변인자는 배열이다.
       int result = 0;
       for(int i = 0; i<a.length; i++){
       	   result += a[i];
       }             
       return result;       
   } 
   
   public static void main(String args[]) {
	   /*
	   System.out.println(add(10));
	   System.out.println(add(10,20));
	   System.out.println(add(10,20,30));
	   System.out.println(add(10,20,30,40));
	   System.out.println(add(new int[]{70,45,80,95,88}));
	   System.out.println();
	   
	   System.out.println(Test.add(10));
	   System.out.println(Test.add(10,20));
	   System.out.println(Test.add(10,20,30));
	   System.out.println(Test.add(10,20,30,40));
	   System.out.println(Test.add(new int[]{70,45,80,95,88}));
	   */
	   
	   Test obj = new Test();
	   System.out.println(obj.add(10));
	   System.out.println(obj.add(10,20));
	   System.out.println(obj.add(10,20,30));
	   System.out.println(obj.add(10,20,30,40));
	   int arr[] = new int[]{70,45,80,95,88};
	   System.out.println(obj.add(arr));
   }
}