package devops.ilp1;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import org.openqa.selenium.firefox.FirefoxOptions;
import devops.ilp1.*;;

import devops.ilp1.IntegrationTest;

import static org.junit.Assert.assertTrue;

import org.junit.*;
import static org.junit.Assert.*;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.junit.experimental.categories.Category;


@Category(IntegrationTest.class)
public class MedicineFunctionalTest {

	static WebDriver driver;

	@BeforeClass
	public static void setup() {
	//driver = new ChromeDriver();
		// new FirefoxDriver();
		FirefoxBinary firefoxBinary = new FirefoxBinary();
        firefoxBinary.addCommandLineOptions("--headless");
        System.setProperty("webdriver.gecko.driver", "/usr/bin/geckodriver");
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setBinary(firefoxBinary);        
        driver=new FirefoxDriver(firefoxOptions);
	}
	

	@AfterClass
	public static void cleanUp() {
		driver.quit();
	}

	@Test
	public void addMedicineSuccess() {
        driver.get("http://localhost:8080/MedicalStoreProject/home.jsp");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebElement medId = driver.findElement(By.name("medId"));
        WebElement medName = driver.findElement(By.name("medName"));
        WebElement medComposition = driver.findElement(By.name("medComposition"));
        WebElement medExpDate = driver.findElement(By.name("medExpDate"));
        WebElement medPrice = driver.findElement(By.name("medPrice"));
        WebElement button = driver.findElement(By.name("addMedicineButton"));
        
        medId.sendKeys("110");
        medName.sendKeys("Glucomate");
        medComposition.sendKeys("Glimepiride");
        medExpDate.sendKeys("2020-12-10");
        medPrice.sendKeys("110");
        button.click();
        
        assertTrue(driver.getPageSource().contains("Success"));
	}
	
	@Test
	public void viewAllMedicines() {
        driver.get("http://localhost:8080/MedicalStoreProject/home.jsp?id='medicinesList'");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebElement button = driver.findElement(By.name("getMedicinesButton"));
        button.click();
        assertTrue(driver.getPageSource().contains("id")); 
       	}
	
	@Test
	public void getMedicine() {
        driver.get("http://localhost:8080/MedicalStoreProject/home.jsp?id='viewMedicineById'");
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        WebElement medId = driver.findElement(By.name("getMedId"));
        WebElement button = driver.findElement(By.name("getMedicineButton"));
        medId.sendKeys("103");
        button.click();
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        assertTrue(driver.getPageSource().contains("id")); 
       	}
	
	@Test
	public void deleteMedicine() {
        driver.get("http://localhost:8080/MedicalStoreProject/home.jsp?id='deleteMedicineById'");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        WebElement medId = driver.findElement(By.name("deleteMedId"));
        WebElement button = driver.findElement(By.name("deleteMedicineButton"));
        medId.sendKeys("110");
        button.click();
        assertTrue(driver.getPageSource().contains("Success")); 
       	}

}
