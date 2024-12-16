package BaseDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Basepage {
public static  WebDriver driver;
	
	//public static final String pathQA="./Config.properties";
  
	String environment=System.getProperty("environment");
	
	private static final String DEFAULT_PATH = "./config.properties";
    private static final String DEV_PATH = "./configDEV.properties";
    private static final String PROD_PATH = "./configPROD.properties";



    public void ConfigReader() {
        // Default to a system property or fallback to default
        this.environment = System.getProperty("environment", "DEFAULT").toUpperCase();
    }

    public String getData(String key) throws IOException {
        String filePath = getFilePathForEnvironment(environment);

        try (FileInputStream fileInputStream = new FileInputStream(filePath)) {
            Properties properties = new Properties();
            properties.load(fileInputStream);
            return properties.getProperty(key);
        }
    }

    private String getFilePathForEnvironment(String environment) {
        switch (environment) {
            case "PROD":
                return PROD_PATH;
            case "DEV":
                return DEV_PATH;
            default:
                return DEFAULT_PATH;
        }
    }
	

	
		/*public  String getData(String key) throws Exception {
			if(environment.equalsIgnoreCase("PROD")) {
				String pathPROD="./configPROD.properties";
				File f= new File(pathPROD);
				FileInputStream fi=new FileInputStream(f);
				Properties p=new Properties();
				p.load(fi);
				return p.getProperty(key);
			}else if(environment.equalsIgnoreCase("DEV")) {
				String pathDEV="./configDEV.properties";
				File f= new File(pathDEV);
				FileInputStream fi=new FileInputStream(f);
				Properties p=new Properties();
				p.load(fi);
				return p.getProperty(key); 
				
			}
			else {
				String path="./config.properties";
				File f= new File(path);
				FileInputStream fi=new FileInputStream(f);
				Properties p=new Properties();
				p.load(fi);
				return p.getProperty(key); 
				
			}
				
			
			
		}
		*/
		
		public void browserlaunch(String url) throws Exception {
			
			
			
			String browser=System.getProperty("browserProperty");
			
			if (browser.equalsIgnoreCase("chrome")) {
				
			
			if (driver ==null) {
				driver=new ChromeDriver();
				driver.get(url);
				driver.manage().window().maximize();
				
				//To setup chromedriver options can use below Snippet
				//ChromeOptions options = new ChromeOptions();
//				//options.addArguments("--headless");
//				WebDriverManager.chromedriver().setup();
//				//driver.get(url);
//				//threadLocalDriver.set(new ChromeDriver(options));
//				threadLocalDriver.set(new ChromeDriver());
			}
			}
			else if (browser.equalsIgnoreCase("Firefox")) {
				
				
				if (driver ==null) {
					driver=new FirefoxDriver();
					driver.get(url);
					driver.manage().window().maximize();
					
					//To setup chromedriver options can use below Snippet
					//ChromeOptions options = new ChromeOptions();
//					//options.addArguments("--headless");
//					WebDriverManager.chromedriver().setup();
//					//driver.get(url);
//					//threadLocalDriver.set(new ChromeDriver(options));
//					threadLocalDriver.set(new ChromeDriver());
				}
				
				}
			
			else{
				if (driver ==null) {
					driver=new EdgeDriver();
					driver.get(url);
					driver.manage().window().maximize();
				
			}
			
			}
		
		
			
		
	
		}
}
