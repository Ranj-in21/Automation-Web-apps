package week4.day1;

import java.time.Duration;
import java.util.ArrayList;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ERail {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://erail.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		WebElement from = driver.findElement(By.id("txtStationFrom"));
		from.clear();
		from.sendKeys("MAS", Keys.TAB);
		WebElement to = driver.findElement(By.id("txtStationTo"));
		to.clear();
		to.sendKeys("MDU", Keys.TAB);
		driver.findElement(By.id("chkSelectDateOnly")).click();
		List<WebElement> trainrows = driver.findElements(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr"));
		int rowsize = trainrows.size();
		System.out.println("No. of rows: " +rowsize);
		List<String> trainlist = new ArrayList<String>();
		for (int i = 1; i < rowsize; i++) {
			 String trainnames = driver.findElement(By.xpath("//table[@class='DataTable TrainList TrainListHeader']//tr["+i+"]/td[2]")).getText();
			 trainlist.add(trainnames);
		 }
		 
		 System.out.println("List of trains available: ");
		 System.out.println(trainlist);
		 
		 Set<String>checkduplicate = new TreeSet<String>(trainlist);		 
		 int setsize = checkduplicate.size();
		 System.out.println(setsize);
		 
		 if(trainlist.size()==checkduplicate.size()) {
			 System.out.println("Duplicate");
		 }
		 else {
			 System.out.println("No Dplicate");
		 }
		
		
		
		
	}

}
