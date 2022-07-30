package javaAssignments.week4.day1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HTML {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://html.com/tags/table/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		List<WebElement> rows = driver.findElements(By.xpath("(//table)[1]//tr"));
		int rowsize = rows.size();
		System.out.println("Table 1 - No. of rows: " +rowsize);
		 List<WebElement> columns = driver.findElements(By.xpath("(//table)[1]//th"));	
		 int columnsize = columns.size();
		 System.out.println("Table 1 - No.of columns: " +columnsize);
		 
		 List<WebElement> table2rows = driver.findElements(By.xpath("//table[@class='attributes-list']//tr"));
		 int tab2row = table2rows.size();
		 System.out.println("Table 2 - Count of rows: " +tab2row);
		
		 List<WebElement> table2columns = driver.findElements(By.xpath("//table[@class='attributes-list']//tr[1]/th"));
		 int tab2column = table2columns.size();
		 System.out.println("Table2 - Count of columns: " +tab2column);
		 
		 
		 
		 
	}

}
