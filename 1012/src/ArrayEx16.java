class ArrayEx16 {
	public static void main(String []args) {
		//String[] args
		//String args[]
		//String []args
		//args 말고 다른 이름으로 바꿔도 된다. 
		System.out.println("count of Arguments:"+args.length);
		//args 0x10 ---> ""
		
		
		for(int i=0;i< args.length;i++) {		//0<0 --> false 이므로 아무것도 안함
			System.out.println("args[" + i + "] = \""+ args[i] + "\"");
		}
	}
}
