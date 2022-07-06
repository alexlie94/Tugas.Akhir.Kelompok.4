package project.pages;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import project.driver.DriverSingleton;

public class Wawancara {

	private WebDriver driver;
	
	public Wawancara() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="#sidebar > div > div:nth-child(1) > ul:nth-child(2) > li:nth-child(3) > a")
	private WebElement menuBucket;
	
	@FindBy(css="#sidebar > div > div:nth-child(1) > ul:nth-child(2) > li.has-sub.expand > ul > li:nth-child(1) > a")
	private WebElement menuWawancara;
	
	@FindBy(css="#content > div > div > div > div.panel-heading.ui-sortable-handle > div > a.btn.btn-xs.btn-icon.btn-circle.btn-default")
	private WebElement btn_expand;
	
	@FindBy(css="#content > div > div > div > div.panel-heading.ui-sortable-handle > div > a.btn.btn-xs.btn-icon.btn-circle.btn-success")
	private WebElement btn_refresh;
	
	@FindBy(css="#content > div > div > div > div.panel-heading.ui-sortable-handle > div > a.btn.btn-xs.btn-icon.btn-circle.btn-warning")
	private WebElement btn_collapse;
	
	@FindBy(id="Recruiter")
	private WebElement selectRecruiter;
	
	@FindBy(id="btn-filter")
	private WebElement btnFilterRecruiter;
	
	@FindBy(css="#data-table-rto_filter > label > input")
	private WebElement inputSearch;
	
	@FindBy(id="btnSearch")
	private WebElement btnSearch;
	
	@FindBy(name="data-table-rto_length")
	private WebElement showData;
	
	@FindBy(css="#data-table-rto > tbody > tr:nth-child(1) > td:nth-child(1)")
	private WebElement btn_plus;
	
	@FindBy(css="#data-table-rto > tbody > tr.child > td > ul > li > span.dtr-data > a")
	private WebElement btn_detail;
	
	@FindBy(css="#content > div > div > div > form > div > div:nth-child(1) > div.col-md-6 > span > ul > li > div.image.text-center > img")
	private WebElement getImage;
	
	@FindBy(id="Division")
	private WebElement Division;
	
	@FindBy(id="Position_RTO")
	private WebElement Position_RTO;
	
	@FindBy(id="Recruiter_Source_ID")
	private WebElement Recruiter_Source_ID;
	
	@FindBy(id="Reference_Code")
	private WebElement Reference_Code;
	
	@FindBy(id="FaceBook")
	private WebElement FaceBook;
	
	@FindBy(id="Twitter")
	private WebElement Twitter;
	
	@FindBy(id="Instagram")
	private WebElement Instagram;
	
	@FindBy(xpath="//*[@id=\" \"]/tbody[1]/tr[1]/td[6]/div")
	private WebElement radio1;
	
	@FindBy(xpath="//*[@id=\" \"]/tbody[1]/tr[2]/td[5]/div")
	private WebElement radio2;
	
	@FindBy(xpath="//*[@id=\" \"]/tbody[1]/tr[3]/td[4]/div")
	private WebElement radio3;
	
	@FindBy(xpath="//*[@id=\" \"]/tbody[1]/tr[4]/td[5]/div")
	private WebElement radio4;
	
	@FindBy(xpath="//*[@id=\" \"]/tbody[1]/tr[5]/td[6]/div")
	private WebElement radio5;
	
	@FindBy(xpath="//*[@id=\" \"]/tbody[1]/tr[6]/td[5]/div")
	private WebElement radio6;
	
	@FindBy(xpath="//*[@id=\" \"]/tbody[1]/tr[7]/td[4]/div")
	private WebElement radio7;
	
	@FindBy(xpath="//*[@id=\" \"]/tbody[1]/tr[8]/td[5]/div")
	private WebElement radio8;
	
	@FindBy(xpath="//*[@id=\" \"]/tbody[1]/tr[9]/td[6]/div")
	private WebElement radio9;
	
	@FindBy(id="hasil")
	private WebElement selectHasilWawancara;
	
	@FindBy(css="#content > div > div > div > form > div > div.panel-footer.col-lg-12 > a")
	private WebElement btnBack;
	
	@FindBy(name="submit")
	private WebElement btnSubmit;
	
	@FindBy(css="#data-table-rto > tbody > tr > td")
	private WebElement textDataNotFound;
	
	@FindBy(tagName ="tr")
	private List<WebElement> countData;
	
	@FindBy(css="#data-table-rto > tbody > tr.odd.parent > td:nth-child(3)")
	private WebElement getEmailText;
	
	@FindBy(xpath="//*[@id=\"data-table-rto\"]/tbody/tr[1]/td[4]")
	private WebElement getDataListTable;
	
	@FindBy(css="#data-table-rto > tbody > tr:nth-child(1) > td:nth-child(4)")
	private WebElement getDataListTable2;
	
	@FindBy(id="Name")
	private WebElement nameDetail;
	
	private String text ="";
	
	
	public void buttonBack() {
		btnBack.click();
		tunggu(2);
		driver.navigate().back();
	}
	
	public String nameDetail() {
		return nameDetail.getAttribute("innerHTML");
	}
	
	public String getText() {
		return text;
	}


	public void setText(String text) {
		this.text = text;
	}
	
	public void inputFormEmptyData(HashMap<Integer, String> params) {
	select(Division).selectByVisibleText(params.get(1));
	select(Position_RTO).selectByVisibleText(params.get(2));
	select(Recruiter_Source_ID).selectByVisibleText(params.get(3));
	FaceBook.clear();
	FaceBook.sendKeys(params.get(4));
	Twitter.clear();
	Twitter.sendKeys(params.get(5));
	Instagram.clear();
	Instagram.sendKeys(params.get(6));
	select(selectHasilWawancara).selectByValue(params.get(7));
	}

	public void inputFormAllData(HashMap<Integer, String> params) {
	select(Division).selectByVisibleText(params.get(1));
	select(Position_RTO).selectByVisibleText(params.get(2));
	select(Recruiter_Source_ID).selectByVisibleText(params.get(3));
	FaceBook.clear();
	FaceBook.sendKeys(params.get(4));
	Twitter.clear();
	Twitter.sendKeys(params.get(5));
	Instagram.clear();
	Instagram.sendKeys(params.get(6));
	radio1.click();
	radio2.click();
	radio3.click();
	radio4.click();
	radio5.click();
	radio6.click();
	radio7.click();
	radio8.click();
	radio9.click();
	select(selectHasilWawancara).selectByValue(params.get(7));
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
	
	
	public void detail() {
		tunggu(2);
		btn_plus.click();
		tunggu(2);
		btn_detail.click();
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
	
	public void pickFilterData() {
		try {
			select(selectRecruiter).selectByValue("D8170116");
			tunggu(2);
			btnFilterRecruiter.click();
		} catch (Exception e) {
			select(selectRecruiter).selectByVisibleText("- All Recruiter -");
			tunggu(2);
			btnFilterRecruiter.click();
		}
	}
	
	public void accessFormWawancara() {
		menuBucket.click();
		tunggu(2);
		menuWawancara.click();
	}
	
	public void buttonSupportFormExpand() {
		tunggu(2);
		btn_expand.click();
		tunggu(2);
		btn_expand.click();
	}
	
	public void buttonSupportFormRefresh() {
		tunggu(2);
		btn_refresh.click();
	}
	
	public void buttonSupportFormCollapse() {
		tunggu(1);
		btn_collapse.click();
		tunggu(1);
		btn_collapse.click();
	}

	
	
	public WebElement getGetEmailText() {
		return getEmailText;
	}

	public void setGetEmailText(WebElement getEmailText) {
		this.getEmailText = getEmailText;
	}

	public List<WebElement> getCountData() {
		return countData;
	}

	public void setCountData(List<WebElement> countData) {
		this.countData = countData;
	}

	public WebElement getShowData() {
		return showData;
	}

	public void setShowData(WebElement showData) {
		this.showData = showData;
	}

	public WebElement getBtn_plus() {
		return btn_plus;
	}

	public void setBtn_plus(WebElement btn_plus) {
		this.btn_plus = btn_plus;
	}

	public WebElement getBtn_detail() {
		return btn_detail;
	}

	public void setBtn_detail(WebElement btn_detail) {
		this.btn_detail = btn_detail;
	}

	public WebElement getGetImage() {
		return getImage;
	}

	public void setGetImage(WebElement getImage) {
		this.getImage = getImage;
	}

	public WebElement getRadio1() {
		return radio1;
	}

	public void setRadio1(WebElement radio1) {
		this.radio1 = radio1;
	}

	public WebElement getRadio2() {
		return radio2;
	}

	public void setRadio2(WebElement radio2) {
		this.radio2 = radio2;
	}

	public WebElement getRadio3() {
		return radio3;
	}

	public void setRadio3(WebElement radio3) {
		this.radio3 = radio3;
	}

	public WebElement getRadio4() {
		return radio4;
	}

	public void setRadio4(WebElement radio4) {
		this.radio4 = radio4;
	}

	public WebElement getRadio5() {
		return radio5;
	}

	public void setRadio5(WebElement radio5) {
		this.radio5 = radio5;
	}

	public WebElement getRadio6() {
		return radio6;
	}

	public void setRadio6(WebElement radio6) {
		this.radio6 = radio6;
	}

	public WebElement getRadio7() {
		return radio7;
	}

	public void setRadio7(WebElement radio7) {
		this.radio7 = radio7;
	}

	public WebElement getRadio8() {
		return radio8;
	}

	public void setRadio8(WebElement radio8) {
		this.radio8 = radio8;
	}

	public WebElement getRadio9() {
		return radio9;
	}

	public void setRadio9(WebElement radio9) {
		this.radio9 = radio9;
	}

	public WebElement getSelectHasilWawancara() {
		return selectHasilWawancara;
	}

	public void setSelectHasilWawancara(WebElement selectHasilWawancara) {
		this.selectHasilWawancara = selectHasilWawancara;
	}

	public WebElement getBtnBack() {
		return btnBack;
	}

	public void setBtnBack(WebElement btnBack) {
		this.btnBack = btnBack;
	}

	public WebElement getBtnSubmit() {
		return btnSubmit;
	}

	public void setBtnSubmit(WebElement btnSubmit) {
		this.btnSubmit = btnSubmit;
	}

	public WebElement getTextDataNotFound() {
		return textDataNotFound;
	}

	public void setTextDataNotFound(WebElement textDataNotFound) {
		this.textDataNotFound = textDataNotFound;
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
