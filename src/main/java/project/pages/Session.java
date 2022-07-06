package project.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import project.driver.DriverSingleton;

public class Session {

	private WebDriver driver;
	
	public Session() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="#sidebar > div > div:nth-child(1) > ul:nth-child(2) > li:nth-child(5) > a")
	private WebElement menuFromSession;
	
	@FindBy(css="#content > div > div > div > div.panel-heading.ui-sortable-handle > div > a")
	private WebElement buttonRefresh;
	
	@FindBy(css="#data-table-session_filter > label > input")
	private WebElement searchInput;
	
	@FindBy(id="btnSearch")
	private WebElement btnSearch;
	
	@FindBy(css="#data-table-session > tbody > tr > td:nth-child(5)")
	private WebElement btnDelete;
	
	@FindBy(css="#data-table-session > tbody > tr > td:nth-child(5) > a")
	private WebElement btnDelete2;
	
	@FindBy(className ="dataTables_empty")
	private WebElement textDataNotFound;
	
	@FindBy(tagName ="tr")
	private List<WebElement> countDataTableSession;
	
	public int countData() {
		return countDataTableSession.size();
	}
	
	public void buttonRefresh() {
		menuFromSession.click();
		tunggu(2);
		buttonRefresh.click();
	}
	
	public void searchInput(String param) {
		tunggu(2);
		searchInput.clear();
		tunggu(1);
		searchInput.sendKeys(param);
		tunggu(1);
		btnSearch.click();
	}
	
	public String getText() {
		return textDataNotFound.getText();
	}
	
	
	public void clickBtnDelete() {
		try {
			btnDelete.click();
		} catch (Exception e) {
			btnDelete2.click();
		}
	}
	
	
	public static void tunggu(int detik) {
		try {
			Thread.sleep(1000*detik);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
