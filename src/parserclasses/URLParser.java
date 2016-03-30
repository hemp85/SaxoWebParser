package parserclasses;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.jsoup.select.Elements;

public class URLParser {
		
	public void checkData(Elements elems, String path) throws IOException{
		
		SimpleDateFormat std = new SimpleDateFormat("dd-MM-yyyy");
		Date date = new Date();
		String stringdate = std.format(date);
		
		String[] vols = {stringdate+"\nATM VOLATILITIES.xml",stringdate+ "\n25-DELTA RISK REVERSAL.xml"};
		File[] files = new File[2];
		Boolean exist = false;
		String stringElems = null;
		String[]tabs = null;
		
		
		for(int i =0; i <files.length;i++){
		files[i] = new File(path+"/"+vols[i]);	
        exist = files[i].createNewFile();
        }
				
		switch(exist.toString()){
		
			case "false": System.out.println("System.exit(0)");
						  System.exit(0);
			break;
			
			case "true" : 
				stringElems = elems.toString();
				tabs = stringElems.split("</table>");
				StringBuilder str = new StringBuilder(tabs[0]+"</table>");
				tabs[0] = str.toString();
			break;
		}
		
		for(int i=0;i<tabs.length;i++){
			FileWriter fw = new FileWriter(files[i]);
			fw.write(tabs[i]);
			fw.close();
		}
	}

}
