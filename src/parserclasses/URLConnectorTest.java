package parserclasses;

import static org.junit.Assert.*;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.NodeList;

public class URLConnectorTest {

	URLConnector urlc;
	String url = "http://fxowebtools.saxobank.com/otc.html";
	String html;
	
	
	@Before
	public void setUp() throws Exception {
		
		urlc = new URLConnector();
		html = urlc.connectURL(url);
		
		
	}

	@After
	public void tearDown() throws Exception {
		urlc = null;
		html = null;
	}

	@Test
	public void testConnectURL() throws IOException {
		assertEquals("<html", html.substring(0, 5));
	}
	
	@Test
	public void testgetWebElements() throws Exception{
		Document doc = Jsoup.parse(html);
		Elements tables = doc.getElementsByClass("volTable");
		assertEquals("<table", tables.toString().substring(0, 6));
	}
	

}
