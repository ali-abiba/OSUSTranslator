package translator;

import java.util.ArrayList;
import java.util.HashMap;

/*
 * Translate the untranslated list using the translated map
 * 
 * @author Ali Abiba
 */
public class TranslateFiles {
	/*
	 * Loops through untranslated list and matches each entry with a key on the translated map
	 * 
	 * @param key          The key used to translate
	 * @param untranslated The list needed to be translated
	 * @returns            A list of the translated values
	 */
	public ArrayList<String> translate(HashMap<String, String> key, ArrayList<String> untranslated){
		ArrayList<String> newList = new ArrayList<String>();
		
		for(String i : untranslated){
			if(key.containsKey(i)){
				newList.add(key.get(i));
			}else{
				newList.add("");
			}
		}
		
		return newList;
	}
}
