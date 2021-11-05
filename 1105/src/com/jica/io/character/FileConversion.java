package com.jica.io.character;

import java.io.*;

class FileConversion {
	public static void main(String args[]) {
		try {
			FileReader fr = new FileReader("test.txt");
			FileWriter fw= new FileWriter("test.out");

			int data = 0;
			while((data = fr.read()) != -1) {
			      if(data != '\t' && data != '\n' && data != ' ' && data != '\r')
					fw.write(data);
			}

			fr.close();
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();		
		}
	} // main
}
