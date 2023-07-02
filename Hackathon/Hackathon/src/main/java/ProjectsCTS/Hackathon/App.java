package ProjectsCTS.Hackathon;

import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.io.FileInputStream;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

class App{
	
	public static WebDriver driver;
	public static Properties prop;
	@BeforeClass
	public void InvokeChrome()
	{
		//Instantiating Properties file
		prop=new Properties();
        try {
        FileInputStream ip= new FileInputStream("C:\\Users\\AKSHITH\\eclipse-workspace\\new workspace\\Hackathon\\config.properties");
        //Loading properties file
        prop.load(ip);
        }
        catch(Exception e)
        {
        	System.out.println("Error setting up Properties file");
        }
        
        try {
        //Instantiating Chrome Driver
		System.setProperty("webdriver.chrome.driver",prop.getProperty("driver"));
        driver =new ChromeDriver();
        }
        catch(Exception e)
        {
        	System.out.println("Error setting up Chrome Browser");
        }
		
	}
	@Test(priority=0)
	public void navigate() 
	{
		try {
		//Navigating to Amazon Website
		driver.get(prop.getProperty("URL"));
        //Waiting until the page is loaded
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	    //Maximizing the page after it is loaded
		driver.manage().window().maximize();
		}
		catch(Exception e)
		{
			System.out.println("Error navigating to Amazon Website");
		}
	}
	
	@Test(priority=1)
	public void SearchWatches()
	{
		try {
		//Locating the search box and entering Watches
		driver.findElement(By.id(prop.getProperty("searchbox"))).sendKeys(prop.getProperty("searchdata") ,Keys.ENTER);
	    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		}
		catch(Exception e)
		{
			System.out.println("Error Navigating to Search box in Amazon");
		}
	}
	
	@Test(priority=2)
	public void Analogue()
	{
		try {
		//waiting until Analogue is clickable and Selecting Display type as Analogue
		WebElement e1=driver.findElement(By.xpath(prop.getProperty("Analogue")));
		WebDriverWait w1=new WebDriverWait(driver,Duration.ofSeconds(30));
	    w1.until(ExpectedConditions.elementToBeClickable(e1));
	    e1.click();
	    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		}
		catch(Exception e)
		{
			System.out.println("Error selecting Analogue");
		}
	}
	
	@Test(priority=3)
	public void Leather()
	{
		try {
		//Waiting until Band name Leather is clickable and the clicking Leather
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		WebElement e2=driver.findElement(By.xpath(prop.getProperty("Leather")));
		WebDriverWait w2=new WebDriverWait(driver,Duration.ofSeconds(60));
	    w2.until(ExpectedConditions.elementToBeClickable(e2));
	    e2.click();
	    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		}
		catch(Exception e)
		{
			System.out.println("Error selecting Leather");
		}
	}
	
	@Test(priority=4)
	public void Titan()
	{
		try {
		//Waiting until brand name titan is clickable and clicking it
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		WebElement e3=driver.findElement(By.xpath(prop.getProperty("Titan")));
		WebDriverWait w3=new WebDriverWait(driver,Duration.ofSeconds(60));
	    w3.until(ExpectedConditions.elementToBeClickable(e3));
	    e3.click();
	    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		}
		catch(Exception e)
		{
			System.out.println("Error selecting Titan ");
		}
	}
	
	
	@Test(priority=5)
	public void discount()
	{
		try {
		//Waiting until discount 25% is clickable and then clicking it
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		WebElement e4=driver.findElement(By.xpath(prop.getProperty("discount")));
		WebDriverWait w4=new WebDriverWait(driver,Duration.ofSeconds(60));
	    w4.until(ExpectedConditions.elementToBeClickable(e4));
	    e4.click();
	    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		}
		catch(Exception e)
		{
			System.out.println("Error applying discount");
		}
		
	}
	
	@Test(priority=6)
	public void Retrieve5()
	{
		try {
		//Retrieving the 5th watch from the page
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(40));
		WebDriverWait w5=new WebDriverWait(driver,Duration.ofSeconds(60));
	    w5.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath(prop.getProperty("element5")))));
	    
		List<WebElement>l=driver.findElements(By.xpath(prop.getProperty("element5")));
		String p=(l.get(4).getText());
		String[] a=p.split("\n");
		System.out.println("Brand of 5th watch: "+a[0]);
		System.out.println("Model Name of 5th watch: "+a[1]);
		System.out.println("Number of reviews for 5th watch: "+a[2]);
		System.out.println(a[3]);
		System.out.println("MRP Price: "+a[4]);
		System.out.println("Orginal Price: "+a[5]);
		System.out.println("Estimated Delievery: "+a[6]);
		System.out.println(a[7]);
		}
		catch(Exception e)
		{
			System.out.println("Error retriving 5th watch data");
		}

	}
	
	@AfterClass
	public void close() throws Exception
	{
		//Closing the browser
		try {
		driver.close();
		}
		catch(Exception e)
		{
			System.out.println("Error closing the browser");
		}
	}

}