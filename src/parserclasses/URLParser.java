package parserclasses;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.jsoup.select.Elements;

public class URLParser {
		
	public void checkData(Elements elems, String path) throws IOException{
		//checks and formats date
		SimpleDateFormat std = new SimpleDateFormat("dd-MM-yyyy");
		Date date = new Date();
		String stringdate = std.format(date);
		//prepare files names
		String[] vols = {stringdate+"\nATM VOLATILITIES.xml",stringdate+ "\n25-DELTA RISK REVERSAL.xml"};
		File[] files = new File[2];
		Boolean exist = false;
		String stringElems = null;
		String[]tabs = null;
		
		
		for(int i =0; i <files.length;i++){
			if(vols[i].contains("VOLATILITIES")){
				files[i] = new File(path+"/ATM VOLATILITIES");	
				files[i].mkdirs();
				files[i] = new File(path+"/ATM VOLATILITIES/"+vols[i]);
				exist = files[i].createNewFile(); // returns true when creates file
				continue;
			}
			files[i] = new File(path+"/25-DELTA RISK REVERSAL");	
			files[i].mkdirs();
			files[i] = new File(path+"/25-DELTA RISK REVERSAL/"+vols[i]);
			exist = files[i].createNewFile(); // returns true when creates file
        }
				
		switch(exist.toString()){
		
			case "false": System.out.println("System.exit(0)");
						  System.exit(0);
			break;
			
			case "true" : 
				stringElems = elems.toString();
				tabs = stringElems.split("</table>");//clean and preapare data to save
				StringBuilder str = new StringBuilder(tabs[0]+"</table>");
				tabs[0] = str.toString();
			break;
		}
		//writing data in file
		for(int i=0;i<tabs.length;i++){
			FileWriter fw = new FileWriter(files[i]);
			fw.write(tabs[i]);
			fw.close();
		}
	}

}
