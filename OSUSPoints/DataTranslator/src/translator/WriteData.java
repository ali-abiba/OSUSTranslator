package translator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class WriteData {
	
	public void writeNewList(String path, ArrayList<String> newList){
		String output = "";
		String lineSeperator = System.getProperty("line.separator");
		
		int endOfName = path.indexOf(".csv");
		
		String newFile = path;
		newFile = new StringBuffer(newFile).insert(endOfName, "_New").toString();
				
		try{
			
			BufferedReader read = new BufferedReader(new FileReader(path));
			BufferedWriter write = new BufferedWriter(new FileWriter(newFile));
			
			
			String line;
			int i = 0;
			output = read.readLine() + ", Translated Name";
			for(line = read.readLine(); line != null; line = read.readLine(), i++){
				output += line.replace(lineSeperator, "," + newList.get(i) + lineSeperator);
			}
			read.close();
			
			write.write(output);
			write.flush();
			write.close();
			
		}catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
}
