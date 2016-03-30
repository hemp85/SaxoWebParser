package parserclasses;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

import org.junit.Test;

public class ExecutorClassTest {

	@Test
	public void test() throws IOException {
		
		
//		Properties props = new Properties();
//		FileInputStream isr = new FileInputStream(System.getProperty("user.dir")+"/config.properties");
//		props.load(isr);
//		File database = new File(props.getProperty("path"));
//		database.mkdir();
		System.out.println(System.getProperty("user.home"));
		
	}

}
