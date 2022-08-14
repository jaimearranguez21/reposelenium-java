package formedixExam;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class medicalhistory {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\fdcar\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://ryze-staging.formedix.com/sign-in");
		
		//userCredentials
		String username = "testteamtechtest";
		String password = "T3st3rT3ch";
		
		
		System.out.println(driver.getCurrentUrl());
		
		//LoginPage
		driver.findElement(By.id("username")).sendKeys(username);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("btnSubmit")).click();
		
		//hoverMainMenu
		WebElement repoMenu = driver.findElement(By.xpath("//li[@id='menuMdb']"));
		Actions action = new Actions(driver);
		action.moveToElement(repoMenu).perform();
		driver.findElement(By.id("menuMdbStudies")).click();
		
		//Studies
		WebElement dropdown = driver.findElement(By.id("fdxMdbContainerListItem0MenuToggle"));
		action.moveToElement(dropdown).click().perform();
		driver.findElement(By.id("fdxMdbContainerListItem0View")).click();
		driver.findElement(By.id("ViewAssetGroupdataAcquisition")).click();
		driver.findElement(By.id("FORMTypeView")).click();
		driver.findElement(By.xpath("//span[text()='Medical History']")).click();
		
		
		
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@id='switchEditMode']")).click();
		driver.findElement(By.id("editPropsAddEntrydescription")).click();
		Thread.sleep(3000);
		
		String desc = "Sample Description!";
		driver.findElement(By.id("assetLocaleEditTextTextareadescription")).sendKeys(desc);
		driver.findElement(By.id("saveAsset")).click();
		Thread.sleep(5000);
		
		//Logout
		WebElement logout = driver.findElement(By.id("menuUser"));
		action.moveToElement(logout).click().perform();
		driver.findElement(By.id("menuUserLogout")).click();

		
				
		
		System.out.println(driver.getTitle());
		System.out.println(username + "--> username");
		System.out.println(password + "--> password");
		
		
		driver.close();
	}

}
