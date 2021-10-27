import java.util.Arrays;

public class ArrayTest4 {
   public static void main(String[] args) {
	   int number = 86;
	   int score[] = { 70, 90, 80, 50, 60 };
	   
	   print(number);
	   printArray(score);
	   
	   System.out.println(Arrays.toString(score));
	   System.out.println(myToString(score));
   }
   
   static void print(int n){
      System.out.println(n);
   }
   
   static String myToString(int arr[]){
	      String result = "배열크기 : " + arr.length + " 요소값들 [";

	      for(int i=0; i<arr.length; i++){
	      	if( i != arr.length-1){
	      	   result += arr[i] + ",";
	      	}else{
	      	   result += arr[i];
	      	}
	      }
	      result += "]";
	      
	      return result;
	   } 
   
   
   static void printArray(int arr[]){
      System.out.println("배열크기 : " + arr.length);
      String result = "[";
      for(int i=0; i<arr.length; i++){
      	if( i != arr.length-1){
      	   result += arr[i] + ",";
      	}else{
      	   result += arr[i];
      	}
      }
      result += "]";
      System.out.println("배열요소값들: " + result);	   
   } 

}
