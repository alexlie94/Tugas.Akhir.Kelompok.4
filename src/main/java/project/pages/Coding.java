package project.pages;

import java.util.HashMap;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import project.driver.DriverSingleton;

public class Coding {

	private WebDriver driver;
	
	public Coding() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="#sidebar > div > div:nth-child(1) > ul:nth-child(2) > li:nth-child(3) > a")
	private WebElement menuBucket;
	
	@FindBy(css="#sidebar > div > div:nth-child(1) > ul:nth-child(2) > li.has-sub.active > ul > li:nth-child(4)")
	private WebElement menuCoding;
	
	@FindBy(css="#sidebar > div > div:nth-child(1) > ul:nth-child(2) > li.has-sub.active > ul > li:nth-child(4) > a")
	private WebElement menuCoding2;
	
	@FindBy(css="#content > div > div > div > div.panel-heading.ui-sortable-handle > div > a.btn.btn-xs.btn-icon.btn-circle.btn-default")
	private WebElement btn_expand;
	
	@FindBy(css="#content > div > div > div > div.panel-heading.ui-sortable-handle > div > a.btn.btn-xs.btn-icon.btn-circle.btn-success")
	private WebElement btn_refresh;
	
	@FindBy(css="#content > div > div > div > div.panel-heading.ui-sortable-handle > div > a.btn.btn-xs.btn-icon.btn-circle.btn-warning")
	private WebElement btn_collapse;
	
	@FindBy(id="Branch")
	private WebElement selectBranch;
	
	@FindBy(id="btn-filter")
	private WebElement btnFilterBranch;
	
	@FindBy(css="#data-table-hrd_filter > label > input")
	private WebElement inputSearch;
	
	@FindBy(id="btnSearch")
	private WebElement btnSearch;
	
	@FindBy(css="#data-table-hrd > tbody > tr > td:nth-child(1)")
	private WebElement btn_plus;
	
	@FindBy(css="#data-table-hrd > tbody > tr.child > td > ul > li > span.dtr-data")
	private WebElement btn_detail;
	
	@FindBy(css="#accordion > div:nth-child(1)")
	private WebElement btn_card_data;
	
	@FindBy(css="#accordion > div:nth-child(2)")
	private WebElement btn_card_dokumen;
	
	@FindBy(css="#accordion > div:nth-child(3)")
	private WebElement btn_card_approval;
	
	@FindBy(css="#accordion > div:nth-child(4)")
	private WebElement btn_card_verifikasi;
	
	@FindBy(id="btnEdit")
	private WebElement btn_edit;
	
	@FindBy(css="#applicant_form > div > div:nth-child(1) > div:nth-child(1) > div.panel-heading.ui-sortable-handle > div > a.btn.btn-xs.btn-icon.btn-circle.btn-default")
	private WebElement btn_expand_dataPersonal;
	
	@FindBy(css="#applicant_form > div > div:nth-child(1) > div:nth-child(1) > div.panel-heading.ui-sortable-handle > div > a.btn.btn-xs.btn-icon.btn-circle.btn-success")
	private WebElement btn_refresh_dataPersonal;
	
	@FindBy(css="#applicant_form > div > div:nth-child(1) > div:nth-child(1) > div.panel-heading.ui-sortable-handle > div > a.btn.btn-xs.btn-icon.btn-circle.btn-warning")
	private WebElement btn_collapse_dataPersonal;
	
	@FindBy(css="#applicant_form > div > div:nth-child(1) > div:nth-child(2) > div.panel-heading.ui-sortable-handle > div > a.btn.btn-xs.btn-icon.btn-circle.btn-default")
	private WebElement btn_expand_dataPendidikan;
	
	@FindBy(css="#applicant_form > div > div:nth-child(1) > div:nth-child(2) > div.panel-heading.ui-sortable-handle > div > a.btn.btn-xs.btn-icon.btn-circle.btn-success")
	private WebElement btn_refresh_dataPendidikan;
	
	@FindBy(css="#applicant_form > div > div:nth-child(1) > div:nth-child(2) > div.panel-heading.ui-sortable-handle > div > a.btn.btn-xs.btn-icon.btn-circle.btn-warning")
	private WebElement btn_collapse_dataPendidikan;
	
	@FindBy(css="#applicant_form > div > div:nth-child(1) > div:nth-child(3) > div.panel-heading.ui-sortable-handle > div > a.btn.btn-xs.btn-icon.btn-circle.btn-default")
	private WebElement btn_expand_dataPayrol;
	
	@FindBy(css="#applicant_form > div > div:nth-child(1) > div:nth-child(3) > div.panel-heading.ui-sortable-handle > div > a.btn.btn-xs.btn-icon.btn-circle.btn-success")
	private WebElement btn_refresh_dataPayrol;
	
	@FindBy(css="#applicant_form > div > div:nth-child(1) > div:nth-child(3) > div.panel-heading.ui-sortable-handle > div > a.btn.btn-xs.btn-icon.btn-circle.btn-warning")
	private WebElement btn_collapse_dataPayrol;
	
	@FindBy(css="#applicant_form > div > div:nth-child(2) > div:nth-child(1) > div.panel-heading.ui-sortable-handle > div > a.btn.btn-xs.btn-icon.btn-circle.btn-default")
	private WebElement btn_expand_dataSaudaraTerdekat;
	
	@FindBy(css="#applicant_form > div > div:nth-child(2) > div:nth-child(1) > div.panel-heading.ui-sortable-handle > div > a.btn.btn-xs.btn-icon.btn-circle.btn-success")
	private WebElement btn_refresh_dataSaudaraTerdekat;
	
	@FindBy(css="#applicant_form > div > div:nth-child(2) > div:nth-child(1) > div.panel-heading.ui-sortable-handle > div > a.btn.btn-xs.btn-icon.btn-circle.btn-warning")
	private WebElement btn_collapse_dataSaudaraTerdekat;
	
	@FindBy(css="#applicant_form > div > div:nth-child(2) > div:nth-child(2) > div.panel-heading.ui-sortable-handle > div > a.btn.btn-xs.btn-icon.btn-circle.btn-default")
	private WebElement btn_expand_dataStruktur;
	
	@FindBy(css="#applicant_form > div > div:nth-child(2) > div:nth-child(2) > div.panel-heading.ui-sortable-handle > div > a.btn.btn-xs.btn-icon.btn-circle.btn-success")
	private WebElement btn_refresh_dataStruktur;
	
	@FindBy(css="#applicant_form > div > div:nth-child(2) > div:nth-child(2) > div.panel-heading.ui-sortable-handle > div > a.btn.btn-xs.btn-icon.btn-circle.btn-warning")
	private WebElement btn_collapse_dataStruktur;
	
	@FindBy(css="#applicant_form > div > div:nth-child(2) > div:nth-child(3) > div.panel-heading.ui-sortable-handle > div > a.btn.btn-xs.btn-icon.btn-circle.btn-default")
	private WebElement btn_expand_dataRecruiter;
	
	@FindBy(css="#applicant_form > div > div:nth-child(2) > div:nth-child(3) > div.panel-heading.ui-sortable-handle > div > a.btn.btn-xs.btn-icon.btn-circle.btn-success")
	private WebElement btn_refresh_dataRecruiter;
	
	@FindBy(css="#applicant_form > div > div:nth-child(2) > div:nth-child(3) > div.panel-heading.ui-sortable-handle > div > a.btn.btn-xs.btn-icon.btn-circle.btn-warning")
	private WebElement btn_collapse_dataRecruiter;
	
	@FindBy(id="btnUpdate")
	private WebElement btn_simpan;
	
	@FindBy(id="btnCancelUpdate")
	private WebElement btn_cancel;
	
	@FindBy(id="select2-Branch-container")//D8130112-SANTI WIDYAWATIK
	private WebElement clikFilterBranch;
	
	@FindBy(css="body > span > span > span.select2-search.select2-search--dropdown > input")//D8130112-SANTI WIDYAWATIK
	private WebElement inputFilterBranch;
	
	@FindBy(xpath="//*[@id=\"data-table-hrd\"]/tbody/tr[1]/td[3]")
	private WebElement getDataListTable;
	
//	@FindBy(css="#data-table-hrd > tbody > tr:nth-child(1) > td:nth-child(3)")
//	private WebElement getDataListTable2;
	
	//Form Input
	@FindBy(id="Name")
	private WebElement Name;
	
	@FindBy(id="Place_Of_Birth")//medan
	private WebElement Place_Of_Birth;
	
	@FindBy(id="Date_Of_Birth")//27
	private WebElement Date_Of_Birth;
	
	@FindBy(id="Month_Of_Birth")//01
	private WebElement Month_Of_Birth;
	
	@FindBy(id="Year_Of_Birth")//2000
	private WebElement Year_Of_Birth;
	
	@FindBy(id="ID_Type")//SIM
	private WebElement ID_Type;
	
	@FindBy(id="ID_Number")
	private WebElement ID_Number;
	
	@FindBy(id="Gender")//Perempuan
	private WebElement Gender;
	
	@FindBy(id="Religion")//Protestan
	private WebElement Religion;
	
	@FindBy(id="Marital_Status")//Single
	private WebElement Marital_Status;
	
	@FindBy(id="Total_Of_Child")
	private WebElement Total_Of_Child;
	
	@FindBy(id="Address_By_ID")
	private WebElement Address_By_ID;
	
	@FindBy(id="Address_ID_RT")
	private WebElement Address_ID_RT;
	
	@FindBy(id="Address_ID_RW")
	private WebElement Address_ID_RW;
	
	@FindBy(id="Address_ID_Province")//DKI Jakarta
	private WebElement Address_ID_Province;
	
	@FindBy(id="Address_ID_City")//Jakarta Pusat
	private WebElement Address_ID_City;
	
	@FindBy(id="Address_ID_District")//Gambir
	private WebElement Address_ID_District;
	
	@FindBy(id="Address_ID_Village")//Gambir
	private WebElement Address_ID_Village;
	
	@FindBy(id="Address_By_Residence")
	private WebElement Address_By_Residence;
	
	@FindBy(id="Address_Residence_RT")
	private WebElement Address_Residence_RT;
	
	@FindBy(id="Address_Residence_RW")
	private WebElement Address_Residence_RW;
	
	@FindBy(id="Address_Residence_Province")//Banten
	private WebElement Address_Residence_Province;
	
	@FindBy(id="Address_Residence_City")// Tangerang Selatan
	private WebElement Address_Residence_City;
	
	@FindBy(id="Address_Residence_District")//Serpong
	private WebElement Address_Residence_District;
	
	@FindBy(id="Address_Residence_Village")//Buaran
	private WebElement Address_Residence_Village;
	
	@FindBy(id="Home_Phone_Number_Code")//Serpong
	private WebElement Home_Phone_Number_Code;
	
	@FindBy(id="Home_Phone_Number")//Buaran
	private WebElement Home_Phone_Number;
	
	@FindBy(id="Mobile_Phone_Number")//Buaran
	private WebElement Mobile_Phone_Number;
	
	@FindBy(id="Email")//Serpong
	private WebElement Email;
	
	@FindBy(id="Mother_Maid")//Buaran
	private WebElement Mother_Maid;
	
	
	//Data Pendidikan
	
	@FindBy(id="Education")//Buaran
	private WebElement Education;
	
	@FindBy(id="School_Name")//Buaran
	private WebElement School_Name;
	
	@FindBy(id="Majoring")//Serpong
	private WebElement Majoring;
	
	@FindBy(id="IPK_Value")//Buaran
	private WebElement IPK_Value;
	
	//Data Payroll
	
	@FindBy(id="Bank_Name")//Buaran
	private WebElement Bank_Name;
	
	@FindBy(id="Bank_Branch")//Buaran
	private WebElement Bank_Branch;
	
	@FindBy(id="Bank_Account")//Serpong
	private WebElement Bank_Account;
	
	@FindBy(id="NPWP_Number")//Buaran
	private WebElement NPWP_Number;
	
	@FindBy(id="NPWP_Address")//Buaran
	private WebElement NPWP_Address;
	
	//Saudara Tidak Serumah
	
	@FindBy(id="Econ_Name")
	private WebElement Econ_Name;
	
	@FindBy(id="Econ_Relationship")
	private WebElement Econ_Relationship;
	
	@FindBy(id="Econ_Phone_Number")
	private WebElement Econ_Phone_Number;
	
	@FindBy(id="Econ_Address")
	private WebElement Econ_Address;
	
	@FindBy(id="Econ_Address_RT")
	private WebElement Econ_Address_RT;
	
	@FindBy(id="Econ_Address_RW")
	private WebElement Econ_Address_RW;
	
	@FindBy(id="Econ_Address_Province")
	private WebElement Econ_Address_Province;
	
	@FindBy(id="Econ_Address_City")
	private WebElement Econ_Address_City;
	
	@FindBy(id="Econ_Address_District")
	private WebElement Econ_Address_District;
	
	@FindBy(id="Econ_Address_Village")
	private WebElement Econ_Address_Village;
	
	//Struktur
	@FindBy(id="Division")//Operational
	private WebElement Division;
	
	@FindBy(id="Departement")//Project
	private WebElement Departement;
	
	@FindBy(id="Branch")//MEDAN
	private WebElement Branch;
	
	@FindBy(id="Position")//DSR
	private WebElement Position;
	
	@FindBy(id="Employee_Type")//MAGANG
	private WebElement Employee_Type;
	
	@FindBy(id="Product")//EDC
	private WebElement Product;
	
	@FindBy(id="Channel")//EDC
	private WebElement Channel;
	
	@FindBy(id="Group_Type")//Retail
	private WebElement Group_Type;
	
	@FindBy(id="Level")//Premier
	private WebElement Level;
	
	@FindBy(id="Sales_Mode")//Direct Sales
	private WebElement Sales_Mode;
	
	@FindBy(id="SM_Code")//NULL22052500-ARIE27
	private WebElement SM_Code;
	
	@FindBy(id="BSH_Code")//D8130112-SANTI WIDYAWATIK
	private WebElement BSH_Code;
	
	@FindBy(css="#form_submit > div:nth-child(6) > div > table > tbody > tr:nth-child(1) > td > input[type=checkbox]")//D8130112-SANTI WIDYAWATIK
	private WebElement ceklis1;
	
	@FindBy(css="#form_submit > div:nth-child(6) > div > table > tbody > tr:nth-child(2) > td > input[type=checkbox]")//D8130112-SANTI WIDYAWATIK
	private WebElement ceklis2;
	
	@FindBy(css="#form_submit > div:nth-child(6) > div > table > tbody > tr:nth-child(3) > td > input[type=checkbox]")//D8130112-SANTI WIDYAWATIK
	private WebElement ceklis3;
	
	@FindBy(css="#form_submit > div:nth-child(6) > div > table > tbody > tr:nth-child(4) > td > input[type=checkbox]")//D8130112-SANTI WIDYAWATIK
	private WebElement ceklis4;
	
	@FindBy(name="Validation_Remark")//D8130112-SANTI WIDYAWATIK
	private WebElement keterangan;
	
	@FindBy(id="btnConfirm")//D8130112-SANTI WIDYAWATIK
	private WebElement btnConfirm;
	
	@FindBy(id="btnPending")//D8130112-SANTI WIDYAWATIK
	private WebElement btnPending;
	
	@FindBy(id="btnReject")//D8130112-SANTI WIDYAWATIK
	private WebElement btnReject;
	
	public void accessFormCoding() {
		try {
			menuCoding.click();
		} catch (Exception e) {
			menuCoding2.click();
		}
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
	
	
	public void clickFilterData() {
		clikFilterBranch.click();
		
		inputFilterBranch.sendKeys("MEDAN");
		
		inputFilterBranch.sendKeys(Keys.ENTER);
		
		btnFilterBranch.click();
		
		tunggu(2);
		clikFilterBranch.click();
		
		inputFilterBranch.sendKeys("All");
		
		inputFilterBranch.sendKeys(Keys.ENTER);
	
		btnFilterBranch.click();
	}
	
	public void inputSearchTable() {
		inputSearch.sendKeys("abcdefg");
		inputSearch.sendKeys(Keys.ENTER);
		inputSearch.clear();
		inputSearch.sendKeys("");
		inputSearch.sendKeys(Keys.ENTER);
	}
	
	public void detailFormCoding() {
		btn_plus.click();
		tunggu(2);
		btn_detail.click();
	}
	 
	
	public void inputDataDetail(HashMap<Integer, String> params) {
		btn_card_data.click();
		btn_edit.click();
		tunggu(2);
		btn_cancel.click();
		tunggu(1);
		btn_edit.click();	
		
		select(Division).selectByValue(params.get(1));
		select(Departement).selectByValue(params.get(2));
		select(Branch).selectByValue(params.get(3));
		select(Position).selectByValue(params.get(4));
		select(Employee_Type).selectByValue(params.get(5));
		select(Product).selectByValue(params.get(6));
		select(Channel).selectByValue(params.get(7));
		select(Group_Type).selectByValue(params.get(8));
		select(Level).selectByValue(params.get(9));
		select(Sales_Mode).selectByValue(params.get(10));
		select(SM_Code).selectByValue(params.get(11));
		select(BSH_Code).selectByVisibleText(params.get(12));
		
		ceklis1.click();
		ceklis2.click();
		ceklis3.click();
		ceklis4.click();
		
		keterangan.sendKeys("Kelompok 4");
		
//		tunggu(2);
		btn_simpan.click();
		tunggu(2);
		driver.switchTo().alert().accept();
	}
	
	public Boolean buttonEdit() {
		return btn_edit.isDisplayed();
	}

	

	private Select select(WebElement params) {
		Select val = new Select(params);
		return val;
	}
	
	private static void scroll(WebDriver driver,String num) {
		JavascriptExecutor js = (JavascriptExecutor)driver;  
		js.executeScript("scrollBy(0,"+num+")");
	}
	
	public static void tunggu(int detik) {
		try {
			Thread.sleep(1000*detik);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
