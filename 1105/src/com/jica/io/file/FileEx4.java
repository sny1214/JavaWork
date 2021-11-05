package com.jica.io.file;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

class FileEx4 {
	public static void main(String[] args){
		String currDir = System.getProperty("user.dir");
		//"C:\\JKWork\\JavaWork\\1105"
		File dir = new File(currDir);

		File[] files = dir.listFiles();

		for(int i=0; i < files.length; i++) {
			//1개 1개의 File객체의 상세정보를 추출
			File f = files[i];
			String name = f.getName();
			SimpleDateFormat df =new SimpleDateFormat("yyyy-MM-dd HH:mma");
			String attribute = "";
			String size = "";

			if(files[i].isDirectory()) {
				attribute = "DIR";
			} else {
				size = f.length() + "";
				attribute  = f.canRead()  ? "R" : " ";	
				attribute += f.canWrite() ? "W" : " ";
				attribute += f.isHidden() ? "H" : " ";	
			}

			System.out.printf("%s %3s %6s %s%n", df.format(new Date(f.lastModified())), attribute, size, name );
		}
	}
} // end of class
