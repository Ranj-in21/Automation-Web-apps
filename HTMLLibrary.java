package javaAssignments.week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HTMLLibrary {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://html.com/tags/table/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		List<WebElement> columns = driver.findElements(By.xpath("(//table)[1]//th"));	
		 int columnsize = columns.size();
		 
		List<String> lib = new ArrayList<String>();
		for (int i = 1; i < columnsize+1; i++) {
		String libfunc = driver.findElement(By.xpath("(//table)[1]/tbody/tr[1]/td["+i+"]")).getText();
		lib.add(libfunc);
		
		}
		System.out.println("Market Share:");
		System.out.println(lib);
		
		List<String> lib1 = new ArrayList<String>();
		for (int j = 1; j < columnsize+1; j++) {
			String libfunc1 = driver.findElement(By.xpath("(//table)[1]/tbody/tr[2]/td["+j+"]")).getText();
			lib1.add(libfunc1);
		}
		System.out.println("Absolute Usage:");
		System.out.println(lib1);
		

	}

}
