package project.pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import project.driver.DriverSingleton;

public class JadwalTrainingPages {

	private WebDriver driver;
	
	public JadwalTrainingPages() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="#sidebar > div > div:nth-child(1) > ul:nth-child(2) > li:nth-child(3) > a")
	private WebElement menuBucket;

	@FindBy(css="#sidebar > div > div:nth-child(1) > ul:nth-child(2) > li.has-sub.expand > ul > li:nth-child(3) > a")
	private WebElement menuJadwalTraining;
	
	@FindBy(css="#sidebar > div > div:nth-child(1) > ul:nth-child(2) > li.has-sub.active > ul > li:nth-child(3)")
	private WebElement menuJadwalTraining2;
	
	@FindBy(css="#content > div > div > div > div.panel-heading.ui-sortable-handle > div > a.btn.btn-xs.btn-icon.btn-circle.btn-default")
	private WebElement btnExpand;
	
	@FindBy(css="#content > div > div > div > div.panel-heading.ui-sortable-handle > div > a.btn.btn-xs.btn-icon.btn-circle.btn-success")
	private WebElement btnRefresh;
	
	@FindBy(css="#content > div > div > div > div.panel-heading.ui-sortable-handle > div > a.btn.btn-xs.btn-icon.btn-circle.btn-warning")
	private WebElement btnCollapse;
	
	@FindBy(id="Recruiter")
	private WebElement selectRecruiter;
	
	@FindBy(id="btn-filter")
	private WebElement btnFilterRecruiter;
	
	@FindBy(css="#data-table-rto_filter > label > input")
	private WebElement inputSearch;
	
	@FindBy(id="btnSearch")
	private WebElement btnSearch;
	
	@FindBy(css="#data-table-rto > tbody > tr:nth-child(1) > td:nth-child(1)")
	private WebElement btnPlus;
	
//	@FindBy(css="#data-table-rto > tbody > tr.even > td:nth-child(10) > a")
//	private WebElement btnDetailSingle;
	
	@FindBy(css="#data-table-rto > tbody > tr.child > td > ul > li > span.dtr-data > a")
	private WebElement btnDetail;
	
	@FindBy(id="Employee_Type")
	private WebElement Employee_Type;
	
	@FindBy(id="Departement")
	private WebElement Departement;
	
	@FindBy(id="Division")
	private WebElement Division;
	
	@FindBy(id="Branch")//MEDAN
	private WebElement Branch;
	
	@FindBy(id="Position")//DSR
	private WebElement Position;
	
	@FindBy(id="Channel")//Community
	private WebElement Channel;
	
	@FindBy(id="Group_Type")//Exhibition
	private WebElement Group_Type;
	
	@FindBy(id="Level")//Executive
	private WebElement Level;
	
	@FindBy(id="Product")//EDC
	private WebElement Product;
	
	@FindBy(id="Sales_Mode")//Tele Sales
	private WebElement Sales_Mode;
	
	@FindBy(name="Training_Date")
	private WebElement input_date;
	
	@FindBy(name="submit")
	private WebElement btn_submit;
	
	@FindBy(xpath="//*[@id=\"data-table-rto\"]/tbody/tr/td")
	private WebElement getTextNotFound;
	
	@FindBy(tagName ="tr")
	private List<WebElement> countDataTableReportTraining;
	
	@FindBy(id ="Name")
	private WebElement getDetailText;
	
	@FindBy(xpath="//*[@id=\"data-table-rto\"]/tbody/tr[1]/td[4]")
	private WebElement getDataListTable;
	
	@FindBy(css="#data-table-rto > tbody > tr:nth-child(1) > td:nth-child(4)")
	private WebElement getDataListTable2;
	
	@FindBy(css ="#content > div > div.col-lg-8.ui-sortable > div > div.panel-heading.ui-sortable-handle > div > a")
	private WebElement btnCollapseDetail;
	
	@FindBy(css ="#content > div > div.col-lg-4.ui-sortable > div > div.panel-heading.ui-sortable-handle > div > a")
	private WebElement btnCollapseDetail2;
	
	private String textIdDetail="";
	
	public void btnCollapseDetail() {
		btnCollapseDetail.click();
		tunggu(2);
		btnCollapseDetail2.click();
		tunggu(2);
		btnCollapseDetail.click();
	}
	
	public String getTextIdDetail() {
		return textIdDetail;
	}

	public void setTextIdDetail(String textIdDetail) {
		this.textIdDetail = textIdDetail;
	}
	
	public void inputNotAllData() {
		tunggu(1);
		select(Employee_Type).selectByValue("MAGANG");
		tunggu(1);
		select(Departement).selectByValue("Finance");
		tunggu(1);
		select(Division).selectByValue("Operational");
		tunggu(1);
		select(Branch).selectByValue("");
		tunggu(1);
		select(Position).selectByValue("DSR");
		tunggu(1);
		select(Channel).selectByValue("Community");
		tunggu(1);
		select(Group_Type).selectByValue("Exhibition");
		tunggu(1);
		select(Level).selectByValue("Executive");
		tunggu(1);
		select(Product).selectByValue("EDC");
		tunggu(1);
		select(Sales_Mode).selectByValue("Tele Sales");
		tunggu(2);
		buttonSubmitClick();
	}

	public String getDataListTable() {
		
		String text ="";
		try {
			text = getDataListTable.getAttribute("innerHTML");
		} catch (Exception e) {
			text = getDataListTable2.getText();
		}
		
		return text;
	}
	
	public String getDetailText() {
		return getDetailText.getAttribute("value");
	}
	
	public void buttonSubmitClick() {
		btn_submit.click();
	}
	
	public int countData() {
		return countDataTableReportTraining.size();
	}
	
	public String getTextNotFound() {
		return getTextNotFound.getAttribute("innerHTML");
	}
	
	public void accessFormJadwalTraining() {
		try {
			menuJadwalTraining.click();
		} catch (Exception e) {
			menuJadwalTraining2.click();
		}
		
	}
	
	public void buttonSupportFormExpand() {
		tunggu(1);
		btnExpand.click();
		tunggu(2);
		btnExpand.click();
	}
	
	public void buttonSupportFormRefresh() {
		tunggu(2);
		btnRefresh.click();
	}
	
	public void buttonSupportFormCollapse() {
		tunggu(1);
		btnCollapse.click();
		tunggu(1);
		btnCollapse.click();
	}
	
	public void pickFilterData() {
		try {
			select(selectRecruiter).selectByValue("D6170495");
			btnFilterRecruiter.click();
		} catch (Exception e) {
			select(selectRecruiter).selectByVisibleText("- All Recruiter -");
			btnFilterRecruiter.click();
		}
	}
	
	public void searchInput(String param) {
		tunggu(3);
		inputSearch.clear();
		tunggu(2);
		inputSearch.sendKeys(param);
		tunggu(1);
//		btnSearch.click();
		inputSearch.sendKeys(Keys.ENTER);
	}
	
	public void buttonPlus() {
		btnPlus.click();
		tunggu(2);
		btnDetail.click();
	}

	public void inputFormJadwalTraining(WebElement param1,String param2) {
		select(param1).selectByValue(param2);		
	}
	
	public void inputDate(String param) {
		input_date.clear();
		input_date.sendKeys(param);
		tunggu(2);
		input_date.sendKeys(Keys.ENTER);
	}
	
	
	private Select select(WebElement param) {
		Select val = new Select(param);
		return val;
	}
	
	
	public WebElement getEmployee_Type() {
		return Employee_Type;
	}

	public void setEmployee_Type(WebElement employee_Type) {
		Employee_Type = employee_Type;
	}

	public WebElement getDepartement() {
		return Departement;
	}

	public void setDepartement(WebElement departement) {
		Departement = departement;
	}

	public WebElement getDivision() {
		return Division;
	}

	public void setDivision(WebElement division) {
		Division = division;
	}

	public WebElement getBranch() {
		return Branch;
	}

	public void setBranch(WebElement branch) {
		Branch = branch;
	}

	public WebElement getPosition() {
		return Position;
	}

	public void setPosition(WebElement position) {
		Position = position;
	}

	public WebElement getChannel() {
		return Channel;
	}

	public void setChannel(WebElement channel) {
		Channel = channel;
	}

	public WebElement getGroup_Type() {
		return Group_Type;
	}

	public void setGroup_Type(WebElement group_Type) {
		Group_Type = group_Type;
	}

	public WebElement getLevel() {
		return Level;
	}

	public void setLevel(WebElement level) {
		Level = level;
	}

	public WebElement getProduct() {
		return Product;
	}

	public void setProduct(WebElement product) {
		Product = product;
	}

	public WebElement getSales_Mode() {
		return Sales_Mode;
	}

	public void setSales_Mode(WebElement sales_Mode) {
		Sales_Mode = sales_Mode;
	}

	private static void tunggu(int detik) {
		try {
			Thread.sleep(1000*detik);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
