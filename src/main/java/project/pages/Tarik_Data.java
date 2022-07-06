package project.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import project.driver.DriverSingleton;

public class Tarik_Data {

	private WebDriver driver;
	
	public Tarik_Data() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="#sidebar > div > div:nth-child(1) > ul:nth-child(2) > li:nth-child(4) > a")
	private WebElement menu_reportRto;
	
	@FindBy(css="#sidebar > div > div:nth-child(1) > ul:nth-child(2) > li.has-sub.expand > ul > li:nth-child(3) > a")
	private WebElement menu_reportTarikData;
	
	@FindBy(css="#content > form > div > div > div > div.panel-heading.ui-sortable-handle > div > a")
	private WebElement btnCollapse;
	
	@FindBy(id="cbo_kategoriundefined")
	private WebElement select_kategori;
	
	@FindBy(name="tanggal")
	private WebElement input_date;
	
	@FindBy(name="submit")
	private WebElement btn_submit;
	
	@FindBy(css="#content > form > div > div > div > div.panel-footer.col-lg-12 > span > a")
	private WebElement btn_generate;
	
	@FindBy(xpath="//*[@id=\"content\"]/form/div/div/div/div[2]/div[2]/div[2]/div/span")
	private WebElement textKategoriError;
	
	@FindBy(xpath="//*[@id=\"datepicker-autoClose\"]/span[2]")
	private WebElement textTanggalError;
	
	public String textKategoriError() {
		return textKategoriError.getAttribute("innerHTML");
	}
	
	public String textTanggalError() {
		return textTanggalError.getAttribute("innerHTML");
	}
	
	public void buttonCollapse() {
		menu_reportRto.click();
		tunggu(2);
		menu_reportTarikData.click();
		tunggu(2);
		btnCollapse.click();
		tunggu(1);
		btnCollapse.click();
	}
	
	public void inputFilterData(String kategori,String tgl) {
		select_kategori.sendKeys(kategori);
		tunggu(1);
		select_kategori.sendKeys(Keys.ENTER);
		tunggu(1);
		input_date.sendKeys(tgl);
		tunggu(1);
		btn_submit.click();
	}
	
	public void clickButtonGenerate() {
		driver.switchTo().alert().accept();
		tunggu(2);
		btn_generate.click();
	}
	
	public String buttonGenerate() {
		return btn_generate.getText();
	}

	public static void tunggu(int detik) {
		try {
			Thread.sleep(1000*detik);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
