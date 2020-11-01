package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileStreams {

	public void readAndWriteFile(String src, String des) throws Throwable {
		FileReader fr= null;
		FileWriter fw=null;
		
		try {
			
			 fr= new FileReader(src);
			 fw=new FileWriter(des);
			
			int c=fr.read();
			
			while(c!=-1) {
				fw.write("Hi this is java");
				break;
			}
			
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if(fr!=null) {
				fr.close();
			}
			if(fw!=null) {
				fw.close();
			}
		}
	}
	public void readInputStream(String src, String des) throws Throwable {
		FileInputStream fr= null;
		FileOutputStream fw=null;
		
		try {
			
			 fr= new FileInputStream(src);
			 fw=new FileOutputStream(des);
			
			int c;
			
			while((c=fr.read())!=-1) {
				fw.write(c);
				break;
			}
			
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
			if(fr!=null) {
				fr.close();
			}
			if(fw!=null) {
				fw.close();
			}
		}
	}
	public static void main(String ar[]) throws Throwable {
		FileStreams fs=new FileStreams();
		fs.readAndWriteFile("C:\\Users\\vinay\\eclipse-workspace\\SeleniumTraining\\TestData\\input.txt","C:\\Users\\vinay\\eclipse-workspace\\SeleniumTraining\\TestData\\input1.txt");
		fs.readInputStream("C:\\Users\\vinay\\eclipse-workspace\\SeleniumTraining\\TestData\\inputtest.txt","C:\\Users\\vinay\\eclipse-workspace\\SeleniumTraining\\TestData\\inputtest1.txt");
	}
}
