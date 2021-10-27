public class doWhileTest {

	public static void main(String[] args) {
	    //1부터 10까지 합계계산
	    int sum = 0;
	    int number = 0;
	    
	    do{       
	      number++;             //number  0 1 2 3 4  5   6  7  8  9  10              
	      sum += number;        //sum     0 1 3 6 10 15 21 28 36 45  55 
	    }while(number < 10);
	    
	    System.out.println("합계: " + sum);  
	}

}
