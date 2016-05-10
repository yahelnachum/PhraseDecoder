import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		Clock c = new Clock();
    	File f = new File("test.txt");
    	FileInputStream in;
		try {
			in = new FileInputStream(f);
	        System.out.println(f.length());
	        byte[] bFile = new byte[(int) f.length()];
	        in.read(bFile);
	        /*for(int i = 0; i < f.length(); i++){
	        	System.out.print(bFile[i]);
	        }*/
	        int range = 1000000;
	        for(int i = 0; i < f.length(); i+=range){
		        MultithreadingDemo obj = new MultithreadingDemo(i, (int)f.length(), bFile, c);  
		        Thread tobj = new Thread(obj);  
		        tobj.start(); 
	        }
	        in.close();
	        
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}
	
	static class MultithreadingDemo implements Runnable{
		int start;
		int range;
		byte[] array;
		Clock c;
		public MultithreadingDemo(int start, int range, byte[] array, Clock c){
			this.start = start;
			this.range = range;
			this.array = array;
			this.c = c;
		}
		public void run(){  
			System.out.println("My thread is in running state.");
			String s = "";
			for(int i = start; i < start+range; i++){
				s += Integer.toBinaryString(array[i]);
				if(i % 10000 == 0) System.out.println(i);
			}
			long time = c.split();
	        System.out.println("Time: " + time);
		}   
	}  
}
