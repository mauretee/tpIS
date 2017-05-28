package tpIS;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

public class Logger {

	public Logger(){
		try{
		    PrintWriter writer = new PrintWriter("log.txt", "UTF-8");		    
		    writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void Log(String message){
		
		try {
			Writer output = new BufferedWriter(new FileWriter("log.txt", true));
			output.append(message+"\n");
			//output.write(message);			
			output.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
				
	}
	
}

