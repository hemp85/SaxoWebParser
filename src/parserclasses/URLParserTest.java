package parserclasses;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileReader;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class URLParserTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCheckData() throws Exception {
		URLConnector urlc = new URLConnector();
		String html = urlc.connectURL("http://fxowebtools.saxobank.com/otc.html");
		Document doc = Jsoup.parse(html);
		Elements tables = doc.getElementsByClass("volTable");
		URLParser parser = new URLParser();
		parser.checkData(tables, "/home/hemp85/Dokumenty");
		
		File file = new File("/home/hemp85/Dokumenty/ATM VOLATILITIES");
		assertFalse(file.canRead());
		
	}

	

}
