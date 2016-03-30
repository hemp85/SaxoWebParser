package parserclasses;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import org.jsoup.select.Elements;

public class ExecutorClass {
	
	private final static Logger LOGGER = Logger.getLogger(ExecutorClass.class.getName());
	private static FileHandler fh;
	private static String url = "http://fxowebtools.saxobank.com/otc.html";
	private static String logpath;
	
	
	public static void main(String[] args) {
		
		try{
			//checks or creates log in working directory
			String workingDir = System.getProperty("user.dir");
			logpath = workingDir+"/saxo.log";
			File loger = new File(logpath);
			loger.createNewFile();
			
			//creates logger
			fh = new FileHandler(logpath, true);
			fh.setFormatter(new SimpleFormatter());
			fh.setLevel(Level.WARNING);
			LOGGER.addHandler(fh);
			
			
			
			//checks or creates folder in path to store files
			Properties props = new Properties();
			FileInputStream isr = new FileInputStream(workingDir+"/config.properties");
			props.load(isr);
			File database = new File(props.getProperty("path"));
			database.mkdirs();
			String path = props.getProperty("path");
			
			
			
			//checks or save data
			URLConnector urlc = new URLConnector();
			String html = urlc.connectURL(url);
			Elements elems = urlc.getWebElements(html);
			URLParser parser = new URLParser();
			parser.checkData(elems,path);
		
		} catch (Exception e){
			LOGGER.log(Level.WARNING,"an exception was thrown", e);
			
		}
	}

}