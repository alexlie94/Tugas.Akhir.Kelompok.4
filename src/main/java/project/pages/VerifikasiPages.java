package project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import project.driver.DriverSingleton;

public class VerifikasiPages {

	private WebDriver driver;
	
	public VerifikasiPages() {
		this.driver = DriverSingleton.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="#sidebar > div > div:nth-child(1) > ul:nth-child(2) > li:nth-child(3) > a")
	private WebElement menuBucket;
	
	@FindBy(css="#sidebar > div > div:nth-child(1) > ul:nth-child(2) > li.has-sub.expand > ul > li:nth-child(2) > a")
	private WebElement menuVerifikasi;
	
	@FindBy(css="#content > div > div > div > div.panel-heading.ui-sortable-handle > div > a.btn.btn-xs.btn-icon.btn-circle.btn-default")
	private WebElement btn_expand;
	
	@FindBy(css="#content > div > div > div > div.panel-heading.ui-sortable-handle > div > a.btn.btn-xs.btn-icon.btn-circle.btn-success")
	private WebElement btn_refresh;
	
	@FindBy(css="#content > div > div > div > div.panel-heading.ui-sortable-handle > div > a.btn.btn-xs.btn-icon.btn-circle.btn-warning")
	private WebElement btn_collapse;
	
	@FindBy(id="btn-filter")
	private WebElement btnFilterVerifikasi;
	
	@FindBy(css="#data-table-rto_filter > label > input")
	private WebElement inputSearch;
	
	@FindBy(id="btnSearch")
	private WebElement btnSearch;
	
	@FindBy(css="#data-table-rto > tbody > tr > td:nth-child(1)")
	private WebElement btn_plus;
	
	@FindBy(css="#data-table-rto > tbody > tr.child > td > ul > li > span.dtr-data")
	private WebElement btn_detail;
	
	@FindBy(css="#data-table-rto > tbody > tr.odd > td:nth-child(9) > a")
	private WebElement btn_detailSingle;
	
	@FindBy(id="btnEdit")
	private WebElement btn_edit;
	
	//Data Personal
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
	
	@FindBy(id="Home_Phone_Number_Code")
	private WebElement Home_Phone_Number_Code;
	
	@FindBy(id="Home_Phone_Number")
	private WebElement Home_Phone_Number;
	
	@FindBy(id="Mobile_Phone_Number")
	private WebElement Mobile_Phone_Number;
	
	@FindBy(id="Email")
	private WebElement Email;
	
	@FindBy(id="FaceBook")
	private WebElement FaceBook;
	
	@FindBy(id="Twitter")
	private WebElement Twitter;
	
	@FindBy(id="Instagram")
	private WebElement Instagram;
	
	@FindBy(id="Gender")//Perempuan
	private WebElement Gender;
	
	@FindBy(id="Body_Height")
	private WebElement Body_Height;
	
	@FindBy(id="Body_Weight")
	private WebElement Body_Weight;
	
	@FindBy(id="Mother_Maid")
	private WebElement Mother_Maid;
	
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
	
	@FindBy(id="Education")//DIPLOMA
	private WebElement Education;
	
	@FindBy(id="School_Name")//Politeknik Negeri Malang
	private WebElement School_Name;
	
	@FindBy(id="Majoring") //Teknik Informatika
	private WebElement Majoring;
	
	@FindBy(id="IPK_Value")
	private WebElement IPK_Value;
	
	
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
	@FindBy(id="Division")
	private WebElement Division;
	
	@FindBy(id="Product")
	private WebElement Product;
	
	@FindBy(id="Company_Name_RTO")
	private WebElement Company_Name_RTO;
	
	@FindBy(id="Project_Name_RTO")
	private WebElement Project_Name_RTO;
	
	@FindBy(id="Position_RTO")
	private WebElement Position_RTO;
	
	@FindBy(id="Channel_RTO")
	private WebElement Channel_RTO;
	
	@FindBy(id="Group_Type_RTO")
	private WebElement Group_Type_RTO;
	
	@FindBy(id="Level_RTO")
	private WebElement Level_RTO;
	
	@FindBy(id="Sales_Mode_RTO")
	private WebElement Sales_Mode_RTO;
	
	@FindBy(id="Departement")
	private WebElement Departement;
	
	@FindBy(id="Branch")
	private WebElement Branch;
	
	@FindBy(id="Employee_Type")
	private WebElement Employee_Type;
	
	@FindBy(id="SM_Code")
	private WebElement SM_Code;
	
	@FindBy(id="btnCancelUpdate")
	private WebElement btnCancelUpdate;
	
	@FindBy(id="btnUpdate")
	private WebElement btnUpdate;
	
	@FindBy(css="#applicant_form > div > div:nth-child(1) > div > div.panel-heading.ui-sortable-handle > div > a")
	private WebElement btnCollapseData;
	
	@FindBy(css="#applicant_form > div > div:nth-child(2) > div > div.panel-heading.ui-sortable-handle > div > a")
	private WebElement btnCollapseFotoDanDoukumen;
	
	@FindBy(css="#fileupload > div > div.panel-heading > div > a")
	private WebElement btnCollapseUploadDoukumen;
	
	@FindBy(css="#fileupload > div > table > tbody > tr:nth-child(1) > td:nth-child(4) > a")
	private WebElement btnUploadKTP;
	
	@FindBy(css="#fileupload > div > table > tbody > tr:nth-child(2) > td:nth-child(4) > a")
	private WebElement btnUploadIjazah;
	
	@FindBy(css="#fileupload > div > table > tbody > tr:nth-child(3) > td:nth-child(4) > a")
	private WebElement btnUploadCV;
	
	@FindBy(css="#fileupload > div > table > tbody > tr:nth-child(4) > td:nth-child(4) > a")
	private WebElement btnUploadKK;
	
	@FindBy(css="#fileupload > div > table > tbody > tr:nth-child(5) > td:nth-child(4) > a")
	private WebElement btnUploadKTPPasangan;
	
	@FindBy(id="file")
	private WebElement file;
	
	@FindBy(id="error_message")
	private WebElement messageError;
	
	@FindBy(css="#form_verification > div:nth-child(4) > div > table > tbody > tr:nth-child(1) > td > input[type=checkbox]")
	private WebElement ceklisDSR;
	
	@FindBy(css="#form_verification > div:nth-child(4) > div > table > tbody > tr:nth-child(2) > td > input[type=checkbox]")
	private WebElement ceklisEcon;
	
	@FindBy(css="#form_verification > div:nth-child(4) > div > table > tbody > tr:nth-child(3) > td > input[type=checkbox]")
	private WebElement ceklisData;
	
	@FindBy(css="#form_verification > div:nth-child(4) > div > table > tbody > tr:nth-child(4) > td > input[type=checkbox]")
	private WebElement ceklisDocumen;
	
	@FindBy(css="#form_verification > div:nth-child(5) > div > table:nth-child(2) > tbody > tr:nth-child(1) > td > input[type=radio]:nth-child(1)")
	private WebElement radioAnswer;
	
	@FindBy(name="Answer_2")
	private WebElement inputDateFacebook;
	
	@FindBy(name="Answer_3")
	private WebElement inputDateTwitter;
	
	@FindBy(name="Answer_4")
	private WebElement inputDateInstagram;
	
	@FindBy(id="radio_submit2")
	private WebElement radioTidak;
	
	@FindBy(id="radio_submit1")
	private WebElement radioYa;
	
	@FindBy(css="#form_verification > div:nth-child(5) > div > table:nth-child(2) > tbody > tr:nth-child(4) > td > div > input[type=radio]:nth-child(2)")
	private WebElement radio2;
	
	@FindBy(css="#form_verification > div:nth-child(5) > div > table:nth-child(2) > tbody > tr:nth-child(5) > td > div > input[type=radio]:nth-child(2)")
	private WebElement radio3;
	
	@FindBy(css="#form_verification > div:nth-child(5) > div > table:nth-child(2) > tbody > tr:nth-child(6) > td > div > input[type=radio]:nth-child(2)")
	private WebElement radio4;
	
	@FindBy(css="#form_verification > div:nth-child(6) > div > select")
	private WebElement selectStatus;
	
	@FindBy(css="#form_verification > div:nth-child(7) > div > textarea")
	private WebElement inputKeterangan;
	
	
	public String getTextError() {
		return messageError.getText();
	}
	
	public void method() {
		menuBucket.click();
		menuVerifikasi.click();
		tunggu(2);
		btn_expand.click();
		tunggu(3);
		btn_expand.click();
		tunggu(3);
		btn_refresh.click();
		tunggu(3);
		btn_collapse.click();
		tunggu(3);
		btn_collapse.click();
		driver.navigate().refresh();
		tunggu(5);
		btnFilterVerifikasi.click();
		tunggu(3);
		inputSearch.sendKeys("klmpok4");
		btnSearch.click();
		tunggu(3);
		inputSearch.clear();
		btnSearch.click();
		tunggu(2);
		
		try {
			btn_plus.click();
			tunggu(2);
			btn_detail.click();
		} catch (Exception e) {
			btn_detailSingle.click();
		}
		
		tunggu(1);
		btnCollapseData.click();
		tunggu(1);
		btnCollapseFotoDanDoukumen.click();
		tunggu(1);
		btnCollapseUploadDoukumen.click();
		tunggu(1);
		btnCollapseData.click();
		tunggu(2);
		btn_edit.click();
		tunggu(2);
		Name.clear();
		Name.sendKeys("antonedi6");
		tunggu(1);
		select(Place_Of_Birth).selectByValue("Bandung");
		tunggu(1);
		select(Date_Of_Birth).selectByValue("05");
		tunggu(1);
		select(Month_Of_Birth).selectByValue("05");
		tunggu(1);
		select(Year_Of_Birth).selectByValue("1990");
		tunggu(1);
		select(ID_Type).selectByValue("KTP");
		tunggu(1);
		ID_Number.clear();
		ID_Number.sendKeys("7627467264712786781");
		tunggu(1);
		Home_Phone_Number_Code.clear();
		Home_Phone_Number_Code.sendKeys("112");
		tunggu(1);
		Home_Phone_Number.clear();
		Home_Phone_Number.sendKeys("8678889");
		
		tunggu(1);
		Mobile_Phone_Number.clear();
		Mobile_Phone_Number.sendKeys("082113293321");
		tunggu(1);
		Email.clear();
		Email.sendKeys("antonedi6@gmail.com");
		tunggu(1);
		FaceBook.clear();
		FaceBook.sendKeys("sadasdsd");
		tunggu(1);
		Twitter.clear();
		Twitter.sendKeys("sadasdsd");
		tunggu(1);
		Instagram.clear();
		Instagram.sendKeys("sadasdsd");
		tunggu(1);
		select(Gender).selectByValue("Laki-Laki");
		tunggu(1);
		Body_Height.clear();
		Body_Height.sendKeys("190");
		tunggu(1);
		Body_Weight.clear();
		Body_Weight.sendKeys("80");	
		tunggu(1);
		Mother_Maid.clear();
		Mother_Maid.sendKeys("test ibu");
		tunggu(1);
		select(Religion).selectByValue("Islam");
		tunggu(1);
		select(Marital_Status).selectByValue("Single");
		tunggu(1);
		Total_Of_Child.clear();
		Total_Of_Child.sendKeys("0");
		tunggu(1);
		Address_By_ID.clear();
		Address_By_ID.sendKeys("jalan jakarta selatan");
		tunggu(1);
		Address_ID_RT.clear();
		Address_ID_RT.sendKeys("7");
		tunggu(1);
		Address_ID_RW.clear();
		Address_ID_RW.sendKeys("9");
		tunggu(1);
		select(Address_ID_Province).selectByValue("DKI Jakarta");
		tunggu(1);
		select(Address_ID_City).selectByValue("Jakarta Selatan");
		tunggu(1);
		select(Address_ID_District).selectByValue("Pasar Minggu");
		tunggu(1);
		select(Address_ID_Village).selectByValue("Pejaten Barat");
		tunggu(1);
		Address_By_Residence.clear();
		Address_By_Residence.sendKeys("jalan jakarta selatan");
		tunggu(1);
		Address_Residence_RT.clear();
		Address_Residence_RT.sendKeys("7");
		tunggu(1);
		Address_Residence_RW.clear();
		Address_Residence_RW.sendKeys("9");
		
		tunggu(1);
		select(Address_Residence_Province).selectByValue("DKI Jakarta");
		tunggu(1);
		select(Address_Residence_City).selectByValue("Jakarta Selatan");
		tunggu(1);
		select(Address_Residence_District).selectByValue("Pasar Minggu");
		tunggu(1);
		select(Address_Residence_Village).selectByValue("Pejaten Barat");
		
		//Data Pendidikan
		tunggu(1);
		select(Education).selectByValue("SARJANA");
		tunggu(1);
		School_Name.clear();
		School_Name.sendKeys("Universitas Veteran");
		tunggu(1);
		Majoring.clear();
		Majoring.sendKeys("IT");
		tunggu(1);
		IPK_Value.clear();
		IPK_Value.sendKeys("3.35");
		
		//Saudara Tidak Serumah
		tunggu(1);
		Econ_Name.clear();
		Econ_Name.sendKeys("test si kakak");
		tunggu(1);
		Econ_Relationship.clear();
		Econ_Relationship.sendKeys("kakak");
		tunggu(1);
		Econ_Phone_Number.clear();
		Econ_Phone_Number.sendKeys("082179202289");
		tunggu(1);
		Econ_Address.clear();
		Econ_Address.sendKeys("jalan jakarta barat");
		tunggu(1);
		Econ_Address_RT.clear();
		Econ_Address_RT.sendKeys("5");
		tunggu(1);
		Econ_Address_RW.clear();
		Econ_Address_RW.sendKeys("3");
		tunggu(1);
		select(Econ_Address_Province).selectByValue("DKI Jakarta");
		tunggu(1);
		select(Econ_Address_City).selectByValue("Jakarta Barat");
		tunggu(1);
		select(Econ_Address_District).selectByValue("Taman Sari");
		tunggu(1);
		select(Econ_Address_Village).selectByValue("Pinangsia");
		
		//Struktur
		tunggu(1);
		select(Division).selectByValue("Sales and Marketing");
		tunggu(1);
		select(Product).selectByValue("Sales Merchant");
		tunggu(1);
		select(Company_Name_RTO).selectByValue("Undefined");
		tunggu(1);
		select(Project_Name_RTO).selectByValue("Undefined");
		tunggu(1);
		select(Position_RTO).selectByValue("ASM");
		tunggu(1);
		select(Channel_RTO).selectByValue("Sales Merchant");
		tunggu(1);
		select(Group_Type_RTO).selectByValue("Sales Merchant");
		tunggu(1);
		select(Level_RTO).selectByValue("Sales Merchant");
		tunggu(1);
		select(Sales_Mode_RTO).selectByValue("Tele Sales");
		tunggu(1);
		select(Departement).selectByValue("Telemarketing");
		tunggu(1);
		select(Branch).selectByValue("MEDAN");
		tunggu(1);
		select(Employee_Type).selectByValue("MAGANG");
		tunggu(1);
		select(SM_Code).selectByValue("S3220421007-ARIE8");
		
		tunggu(1);
		btnCancelUpdate.click();
		tunggu(1);
		btn_edit.click();
		tunggu(1);
		btnUpdate.click();
		tunggu(1);
		scroll(driver,"500");
		tunggu(1);
		btnCollapseUploadDoukumen.click();
		tunggu(1);
//		btnUploadKTP.click();
//		
//		file.sendKeys("D:\\\\imgTesting\\\\Wawancara.java");
		
		ceklisDSR.click();
		ceklisEcon.click();
		ceklisData.click();
		ceklisDocumen.click();
		
		radioAnswer.click();
		inputDateFacebook.sendKeys("2022-7-18");
		inputDateFacebook.sendKeys(Keys.RETURN);
		inputDateTwitter.sendKeys("2022-7-18");
		inputDateTwitter.sendKeys(Keys.RETURN);
		inputDateInstagram.sendKeys("2022-7-18");
		inputDateInstagram.sendKeys(Keys.ENTER);
		
		radioTidak.click();
		tunggu(2);
		radioYa.click();
		radio2.click();
		radio3.click();
		radio4.click();

		
		select(selectStatus).selectByValue("VERIFIED");
		inputKeterangan.sendKeys("Coba Masukin Teks");
		
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
