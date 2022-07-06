package project.pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import project.driver.DriverSingleton;

public class Training {

	private WebDriver driver;
	
	public Training() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="#sidebar > div > div:nth-child(1) > ul:nth-child(2) > li:nth-child(4) > a")
	private WebElement menu_reportRto;
	
	@FindBy(css="#sidebar > div > div:nth-child(1) > ul:nth-child(2) > li.has-sub.expand > ul > li:nth-child(2) > a")
	private WebElement link_menu_formTraining;
	
	@FindBy(css="#content > div > div.panel-heading > div > a")
	private WebElement btnCollapse;
	
	@FindBy(id="cbo_tahun")
	private WebElement select_year;
	
	@FindBy(id="cbo_bulan")
	private WebElement select_month;
	
	@FindBy(name="btn_go")
	private WebElement btn_go;
	
	@FindBy(css="#data-table-default_filter > label > input")
	private WebElement inputSearch;
	
	@FindBy(css="#data-table-default > tbody > tr:nth-child(1) > td.sorting_1")
	private WebElement btn_plus;
	
	@FindBy(css="#data-table-default > tbody > tr.child > td > ul > li > span.dtr-data > a")
	private WebElement btn_detail;
	
	@FindBy(xpath ="//*[@id=\"data-table-default\"]/tbody/tr/td")
	private WebElement textDataNotFound;
	
	@FindBy(css ="#data-table-default > tbody > tr > td:nth-child(2)")
	private WebElement getTextNameDataTableTrainer;
	
	@FindBy(id="Name")
	private WebElement getTextDetailNameDataTableTrainer;
	
	@FindBy(tagName ="tr")
	private List<WebElement> countDataTableReportTraining;
	
	public int countData() {
		return countDataTableReportTraining.size();
	}
	
	public String getTextDetailNameDataTableTrainer() {
		return getTextDetailNameDataTableTrainer.getText();
	}
	
	public String getTextNameDataTableTrainer() {
		return getTextNameDataTableTrainer.getText();
	}
	
	public String getTextNotFound() {
		return textDataNotFound.getAttribute("innerHTML");
	}
	
	public void searchData(String param) {
		inputSearch.clear();
		tunggu(2);
		inputSearch.sendKeys(param);
		tunggu(1);
		inputSearch.sendKeys(Keys.ENTER);
	}
	
	public void filterData(String year,String month) {
		select(select_year).selectByValue(year);
		select(select_month).selectByValue(month);
		tunggu(2);
		btn_go.click();
	}
	
	public void buttonCollapse() {
		menu_reportRto.click();
		tunggu(2);
		link_menu_formTraining.click();
		tunggu(2);
		btnCollapse.click();
		tunggu(2);
		btnCollapse.click();
	}
	
	public void clickDetail() {
		btn_plus.click();
		tunggu(2);
		btn_detail.click();
	}
	

	private Select select(WebElement params) {
		Select val = new Select(params);
		return val;
	}
	
	public static void tunggu(int detik) {
		try {
			Thread.sleep(1000*detik);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
