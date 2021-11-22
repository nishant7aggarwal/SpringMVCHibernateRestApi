package test;
import java.io.FileInputStream; 

public class FileStream {
	public static void main(String[] args) {
		      
		           try{      
						/*
						 * FileOutputStream fout=new
						 * FileOutputStream("C:\\Users\\nisha\\Documents\\testout.txt"); fout.write(65);
						 * fout.close(); System.out.println("success...");
						 */
		             
		             
		             
		             FileInputStream fin=new FileInputStream("C:\\Users\\nisha\\Documents\\testout.txt");      
		            
		             int i=fin.read();  
		             int j=fin.read();  
		             System.out.print((char)i); 
		             System.out.print((char)j); 
		     
		             fin.close();      
		             
		            }catch(Exception e){System.out.println(e);}      
		      }      
		} 
	


