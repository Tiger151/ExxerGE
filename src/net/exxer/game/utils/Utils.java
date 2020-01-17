package net.exxer.game.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Utils {
public int widthTest;
public static String loadFileAsString(String path){
	StringBuilder builder = new StringBuilder();
		try{
			BufferedReader br = new BufferedReader(new FileReader(path));
			String line;
			while((line = br.readLine()) != null){
				builder.append(line);
			}
			br.close();
		}catch(IOException e){
			e.printStackTrace();
		}
		return builder.toString();
	}

public static int parseInt(String num){
	try{
		return Integer.parseInt(num);
	}catch(NumberFormatException e){
		System.out.println("UTILS LINE: 27");//might be \n on each file line
		//e.printStackTrace();
		System.out.println(e.getMessage());
		return 0;//return 0 tile aka grass test if \n is in code above method somewhere
	}
	
}

}