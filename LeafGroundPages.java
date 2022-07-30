package javaAssignments.week4.day1;

import java.time.Duration;
import java.util.ArrayList;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundPages {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://www.leafground.com/pages/table.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		List<WebElement> row = driver.findElements(By.xpath("//table//tr"));
		int rowsize = row.size();
		System.out.println("Count of number of rows: " +rowsize);
		
		List<WebElement> column = driver.findElements(By.xpath("//table//tr[1]/th"));
		int columnsize = column.size();
		System.out.println("Count of number of columns: " +columnsize);
		System.out.println("Progress value of Learn to interact with Elements:");
		
		for (int i = 3; i <=4; i++) 
			for (int j = 1; j < columnsize; j++) {
				String value = driver.findElement(By.xpath("//table//tr["+i+"]/td["+j+"]")).getText();
				System.out.println(value);
		}
			
			System.out.println("Progress value:");
			List<String> data = new ArrayList<String>();
				for (int k = 2; k <=rowsize; k++) {
					for (int l = 2; l < columnsize; l++) {
				String value1 = driver.findElement(By.xpath("//table//tr["+k+"]/td["+l+"]")).getText();
				data.add(value1);
				System.out.println(value1);
				
			
			}
			
		}
				
		Set<String> newdata = new TreeSet<String>(data);
		System.out.println("After sort: " +newdata);
		for (String output : newdata) {
			if(output.contentEquals("20%")) {
				
			driver.findElement(By.xpath("(//input[@name='vital'])[5]")).click();			
				
			}
			
		}
		
		
			
			
	
		
		
		
		
		
		
		
	}

}
