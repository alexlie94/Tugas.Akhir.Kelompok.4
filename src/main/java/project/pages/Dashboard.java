package project.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import project.driver.DriverSingleton;

public class Dashboard {

	private WebDriver driver;
	
	public Dashboard() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="#content > div:nth-child(3) > div:nth-child(1) > div > div.stats-link > a")
	private WebElement linkDirectWawancara;
	
	@FindBy(css="#content > div:nth-child(3) > div:nth-child(2) > div > div.stats-link > a")
	private WebElement linkDirectVerifikasi;
	
	@FindBy(css="#content > div:nth-child(3) > div:nth-child(3) > div > div.stats-link > a")
	private WebElement linkDirectJadwalTraining;
	
	@FindBy(css="#content > div:nth-child(3) > div:nth-child(4) > div > div.stats-link > a")
	private WebElement linkDirectCoding;
	

	public void linkDirectWawancara() {
		linkDirectWawancara.click();
	}
	
	public void linkDirectVerifikasi() {
		linkDirectVerifikasi.click();
	}
	
	public void linkDirectJadwalTraining() {
		linkDirectJadwalTraining.click();
	}
	
	public void linkDirectCoding() {
		linkDirectCoding.click();
	}

	
}
