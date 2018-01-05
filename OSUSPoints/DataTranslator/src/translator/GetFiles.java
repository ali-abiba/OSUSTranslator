package translator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

/*
 * Gets files and puts them into their respective formats
 * 
 * @author Ali Abiba
 */
public class GetFiles {
	/*
	 * Grabs file provided and parses each line into an array. 
	 * Adds designated columns of array to the map.
	 * 
	 * @param firstColumn  the column of the original name
	 * @param secondColumn the column of the translated name
	 * @param path         the path of the translated csv
	 * @return             the map of translated values
	 */
	public HashMap<String,String> getTranslated(int firstColumn, int secondColumn, String path){
		HashMap<String, String> translatedMap = new HashMap<String,String>();
		String line;
		
		try {
			BufferedReader transList = new BufferedReader(new FileReader(path));
			int totalColumns = (transList.readLine()).split(",").length;
			while(transList.ready() && (line = transList.readLine()) != null){
				String[] columns = line.split(",");
				translatedMap.put(columns[firstColumn-1], columns[secondColumn-1]);
			}
			
			System.out.println("Grabbed file successfully");
			transList.close();	
		}catch (IOException e){
			System.out.println(e.getMessage());
		}
		
		return translatedMap;
	}
	/*
	 * Grabs file provided and parses each line into an array. 
	 * Adds designated columns of array to the map.
	 * 
	 * @param firstColumn  the column of the original name
	 * @param path         the path of the translated csv
	 * @return             the map of translated values
	 */
	public ArrayList<String> getUntranslated(int firstColumn, String path){
		ArrayList<String> untranslatedList = new ArrayList<String>();
		String line;
		
		try{
			BufferedReader untransList = new BufferedReader(new FileReader(path));
			int totalColumns = (untransList.readLine()).split(",").length;
			while(untransList.ready() && (line = untransList.readLine()) != null){
				ArrayList<String> columns = new ArrayList<String>();
				
				for(String i : line.split(",")){
					columns.add(i);
				}
				
				if(columns.size() == totalColumns){
					untranslatedList.add(columns.get(firstColumn-1));
				}else if (columns.size() != totalColumns){
					untranslatedList.add("");
				}
			}
			System.out.println("Grabbed file successfully");
			untransList.close();
		}catch (IOException e){
			System.out.println(e.getMessage());
		}
		
		return untranslatedList;
	}
}
