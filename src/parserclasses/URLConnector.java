package parserclasses;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;



public class URLConnector {
	
	

		public String connectURL(String url) throws IOException{
			
			URL saxo = new URL(url);
	        BufferedReader in = new BufferedReader(new InputStreamReader(saxo.openStream()));

	        StringBuilder strb = new StringBuilder("");
	        String inputLine;
	        
	        while ((inputLine = in.readLine()) != null){
	        	strb.append(inputLine+"\n");
	        }
	        in.close();
	        return strb.toString();
			
		}
		
		public Elements getWebElements (String html) throws IOException{
			Document doc = Jsoup.parse(html);
	        return doc.getElementsByClass("volTable");
			
		}
}
