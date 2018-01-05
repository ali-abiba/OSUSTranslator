package translator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class StartTranslator {

	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		String path;
		HashMap<String, String> transMap = new HashMap<String,String>();
		ArrayList<String> untransList = new ArrayList<String>();
		ArrayList<String> newList = new ArrayList<String>();
		
		GetFiles getFiles = new GetFiles();
		TranslateFiles translate = new TranslateFiles();
		WriteData writeData = new WriteData();
		
		
		
		int colOne, colTwo;
		
		System.out.println("Enter the absolute path of the translated file");
		path = console.nextLine();
		
		System.out.println("Enter the first (untranslated) column");
		colOne = console.nextInt();
		
		System.out.println("Enter the second (translated) column");
		colTwo = console.nextInt();
		
		transMap = getFiles.getTranslated(colOne, colTwo,path);
		console.nextLine();
		System.out.println("Enter the absolute path of the untranslated file");
		path = console.nextLine();
		
		System.out.println("Enter the column to be translated");
		colOne = console.nextInt();
		
		untransList = getFiles.getUntranslated(colOne, path);
		
		newList = translate.translate(transMap, untransList);
		
		writeData.writeNewList(path, newList);
		
	}

}
