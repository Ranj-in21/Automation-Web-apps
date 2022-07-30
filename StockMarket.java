package javaAssignments.week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StockMarket {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.chittorgarh.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.id("navbtn_stockmarket")).click();
		driver.findElement(By.xpath("//a[text()='NSE Bulk Deals']")).click();
		
		List<WebElement> row = driver.findElements(By.xpath("(//table)[2]/tbody//tr"));
		int rowsize = row.size();
		System.out.println("No. of seecurity names: " +rowsize);
		
		List<String> names = new ArrayList<String>();
		for (int i = 1; i < rowsize; i++) {
			
		String security = driver.findElement(By.xpath("//table[@class='table table-bordered table-condensed table-striped']/tbody/tr["+i+"]/td[3]")).getText();
		names.add(security);

	}
		System.out.println("Security names List:");
		System.out.println(names);
		
		Set<String> check = new LinkedHashSet<String>(names);
		int setsize = check.size();
		//System.out.println(setsize);
		if(names.size()==setsize) {
			System.out.println("Duplicates are available in the list");
			
		}else {
			System.out.println("No Duplicates in the list");
		}
		
		
		
		
	}

}
