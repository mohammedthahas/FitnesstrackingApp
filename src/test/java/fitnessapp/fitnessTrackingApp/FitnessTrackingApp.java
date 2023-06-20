package fitnessapp.fitnessTrackingApp;



import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class FitnessTrackingApp {
	public static void main(String[]args) {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.strava.com/");
		driver.manage().window().maximize();
		
	    //Accepting cookies
		driver.findElement(By.xpath("//button[text()='I accept']")).click();
		driver.findElement(By.id("loh-signup-button")).click();
	
		//Login
		driver.findElement(By.xpath("//a[text()='Log in']")).click();
		driver.findElement(By.id("email")).sendKeys("mohammedthaha136@gmail.com");
		driver.findElement(By.id("password")).sendKeys("Password@123");
		driver.findElement(By.id("login-button")).click();
		
		//Mouse hover
		WebElement element=driver.findElement(By.cssSelector("li[data-log-category='training'] a[class='selection nav-link accessible-nav-link']"));
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//form[@id='global-search-bar']/parent::div/descendant::ul[2]/descendant::button[2]/following-sibling::ul/descendant::a[2]")).click();
		
		//finding my Activities
		driver.findElement(By.id("keywords")).sendKeys("Running");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[text()='Search']")).click();
		
		//DropDown for selecting Different types of sports
		WebElement dropdown = driver.findElement(By.id("activity_type"));
		Select select = new Select(dropdown);
		select.selectByVisibleText("Run");
		
		WebElement dropdown2 = driver.findElement(By.id("workout_type_run"));
		Select select2 = new Select(dropdown2);
		select2.selectByValue("2");
		
		//checking My goals
		WebElement goals = driver.findElement(By.xpath("//button[@id='dashboard-dropdown-arrow'][1]/parent::li/child::a[1]"));
		Actions action2 = new Actions(driver);
		action2.moveToElement(goals).build().perform();
		driver.findElement(By.cssSelector("a[href='/athlete/goals']")).click();
		
		//Scrolling down the page for checking hiking routes
		JavascriptExecutor scroll = (JavascriptExecutor)driver;
		scroll.executeScript("window.scrollBy(0,300)");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[text()='Routes']")).click();
		
		//selecting Austin for Hiking Route
		driver.findElement(By.xpath("//a[text()='Austin, TX']")).click();
		
		//logging out
		WebElement profile = driver.findElement(By.xpath("//a[@id='athlete-menu']/child::div/child::div/child::img"));
		Actions ac = new Actions(driver);
		ac.moveToElement(profile).build().perform();
		driver.findElement(By.xpath("//a[text()='Log Out']")).click();
		
		
		
		
		
		
	
		
		
	}


}
