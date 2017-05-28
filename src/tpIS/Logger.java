package tpIS;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
// 
public class Logger {
	File file;
	
	public Logger() {
		try {
			Date fecha = new Date();
	        file = new File(fecha.toString()+ "log.txt");
		} finally {
        	//??
        }
		
	}
	
	public void Log(String message){
        BufferedWriter output = null;
        try {
            output = new BufferedWriter(new FileWriter(file));
            output.append(message);
        } catch ( IOException e ) {
            e.printStackTrace();
        } finally {
        	try {output.close();}
        	catch (IOException e) {e.printStackTrace();}
        }
	}
	
}