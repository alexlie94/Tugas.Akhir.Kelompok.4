package project;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.HashMap;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import project.config.AutomationFrameworkConfig;
import project.driver.DriverSingleton;
import project.pages.Coding;
import project.pages.Dashboard;
import project.pages.JadwalTrainingPages;
import project.pages.LoginPage;
import project.pages.Session;
import project.pages.Tarik_Data;
import project.pages.Training;
import project.pages.Wawancara;
import project.utils.ConfigurationProperties;
import project.utils.Constants;
import project.utils.TestCases;
import project.utils.Utils;

@CucumberContextConfiguration
@ContextConfiguration(classes = AutomationFrameworkConfig.class)
public class StepDefinition {

	private static WebDriver driver;
	private LoginPage login;
	private Dashboard dashboard;
	private Wawancara wawancara;
	private JadwalTrainingPages jadwal;
	private Coding coding;
	private Training training;
	private Tarik_Data tarik;
	private Session session;
	static ExtentTest extentTest;
	static ExtentReports reports = new ExtentReports("src/test/resources/Report.html");
	
	@Autowired
	ConfigurationProperties config;
	
	@Before
	public void setUp() {
		DriverSingleton.getInstance(config.getBrowser());
		login = new LoginPage();
		dashboard = new Dashboard();
		wawancara = new Wawancara();
		jadwal = new JadwalTrainingPages();
		coding = new Coding();
		training = new Training();
		tarik = new Tarik_Data();
		session = new Session();
		TestCases[] tests = TestCases.values();
		extentTest = reports.startTest(tests[Utils.testCount].getTestName());
		Utils.testCount++;
	}
	
	@AfterStep
	public void getResultScreenshot(Scenario scenario) throws Exception {
		if(scenario.isFailed()) {
			String screenshotPath = Utils.getScreenshot(driver, scenario.getName().replace(" ","_"));
			extentTest.log(LogStatus.FAIL, "Screenshot:\n"+
					extentTest.addScreenCapture(screenshotPath));
		}
	}
	
	@After
	public static void endTestStep() {
		reports.endTest(extentTest);
		reports.flush();
	}
	
	// User Admin Login Di Website Salesindo Recruitment
	@Given("User Admin Mengakses URL Salesindo Recruitment")
	public void customer_mengakses_url() {
		driver = DriverSingleton.getDriver();
		driver.get(Constants.URL);
		extentTest.log(LogStatus.PASS, "User Admin Mengakses Url "+Constants.URL);
	}
	
	@When("Username dan Password Field Kosong")
	public void Username_dan_Password_Field_Kosong() {
		tunggu(2);
		login.formLogin("", "");
		extentTest.log(LogStatus.PASS, "Username dan Password Field Kosong");
	}	
	
	@Then("Tampil Alert Username is Required & Password is Required")
	public void alertIsRequiredFormLogin() {
		assertEquals(login.usernameEmpty(),"");
		assertEquals(login.passwordEmpty(), "");
		extentTest.log(LogStatus.PASS, "Tampil Alert Username is Required & Password is Required");
	}
	
	//Testing Login User Admin Tidak Terdaftar Atau Username & Passwaord Salah
	@When("User Login Dengan Username dan Password Data Tidak Terdaftar Atau Username & Password Salah")
	public void User_Login_Dengan_Username_dan_Password_Data_Salah() {
		tunggu(3);
		login.formLogin(config.getUsernameError(), config.getPassword());
		extentTest.log(LogStatus.PASS, "User Login Dengan Username dan Password Data Tidak Terdaftar Atau Username & Password Salah");
	}	
	
	@Then("Menampilkan Notifikasi Username & Password Salah")
	public void User_Gagal_Login_Ke_Dashboard_Admin() {
		tunggu(2);
		assertEquals("                 Wrong username or password..!                            ",login.text_alert_error());
		extentTest.log(LogStatus.PASS, "Menampilkan Notifikasi Username & Password Salah");
	}
	
	//Testing Login User Admin Sudah Login Ditempat Lain
	@When("User Login Dengan Username dan Password Data Sudah Login")
	public void User_Login_Dengan_Username_dan_Password_Data_Sudah_Login() {
		tunggu(3);
		login.formLogin(config.getUsernameIsLogin(), config.getPassword());
		extentTest.log(LogStatus.PASS, "User Login Dengan Username dan Password Data Sudah Login");
	}	
	
	@Then("Menampilkan Notifikasi User Sudah Pernah Login Ditempat Lain")
	public void  User_Sudah_Pernah_Login_Ditempat_Lain() {
		assertEquals(" User sudah login di tempat lain..!                ",login.text_alert_error());
		extentTest.log(LogStatus.PASS, "Menampilkan Notifikasi User Sudah Pernah Login Ditempat Lain");
	}	
	
//	Testing Login User Admin Sudah Terdaftar
	@When("User Login Dengan Username dan Password Data Sudah Terdaftar")
	public void User_Login_Dengan_Username_dan_Password_Data_Sudah_Terdaftar() {
		tunggu(5);
		login.formLogin("adminsd2", "d1k4@passw0rd");
		extentTest.log(LogStatus.PASS, "User Login Dengan Username dan Password Data Sudah Terdaftar");
	}	
	
	@Then("User Berhasil Login Ke Dashboard Admin")
	public void User_Berhasil_Login_Ke_Dashboard_Admin() {
		
		extentTest.log(LogStatus.PASS, "User Berhasil Login Ke Dashboard Admin");
	}
	
//	Dashboard
	@Given("User Admin Mengakses Halaman Dashboard")
	public void User_Admin_Mengakses_Halaman_Dashboard() {
		driver.navigate().refresh();
		extentTest.log(LogStatus.PASS, "User Admin Mengakses Halaman Dashboard");
	}

	@When("User Admin Klik Tombol Card Wawancara")
	public void User_Admin_Klik_Tombol_Card_Wawancara() {
		tunggu(2);
		dashboard.linkDirectWawancara();
		extentTest.log(LogStatus.PASS, "User Admin Klik Tombol Card Wawancara");
	}
	
	@Then("Tampil Form Wawancara")
	public void Tampil_Form_Wawancara() {
		tunggu(1);
		back();
		extentTest.log(LogStatus.PASS, "Tampil Form Wawancara");
	}
	
	@When("User Admin Klik Tombol Card Verifikasi")
	public void User_Admin_Klik_Tombol_Card_Verifikasi() {
		tunggu(2);
		dashboard.linkDirectVerifikasi();
		extentTest.log(LogStatus.PASS, "User Admin Klik Tombol Card Verifikasi");
	}
	
	@Then("Tampil Form Verifikasi")
	public void Tampil_Form_Verifikasi() {
		tunggu(1);
		back();
		extentTest.log(LogStatus.PASS, "Tampil Form Verifikasi");
	}

	@When("User Admin Klik Tombol Card Jadwal Training")
	public void User_Admin_Klik_Tombol_Card_Jadwal_Training() {
		tunggu(2);
		dashboard.linkDirectJadwalTraining();
		extentTest.log(LogStatus.PASS, "User Admin Klik Tombol Card Jadwal Training");
	}

	@Then("Tampil Form Jadwal Training")
	public void Tampil_Form_Jadwal_Training() {
		tunggu(1);
		back();
		extentTest.log(LogStatus.PASS, "Tampil Form Jadwal Training");
	}

	@When("User Admin Klik Tombol Card Coding")
	public void User_Admin_Klik_Tombol_Card_Coding() {
		tunggu(2);
		dashboard.linkDirectCoding();
		extentTest.log(LogStatus.PASS, "User Admin Klik Tombol Card Coding");
	}
	
	@Then("Tampil Form Coding")
	public void Tampil_Form_Coding() {
		tunggu(1);
		back();
		extentTest.log(LogStatus.PASS, "Tampil Form Coding");
	}
	
	//User Admin Mengakses Menu Form Wawancara
		//User Admin Mengklik Button Support Form Wawancara
		@When("User Admin klik Button Expand Layar Form Wawancara Akan Full Size atau Melebar Satu Halaman")
		public void buttonExpand() {
			wawancara.accessFormWawancara();
			tunggu(2);
			wawancara.buttonSupportFormExpand();
			extentTest.log(LogStatus.PASS, "User Admin klik Button Expand Layar Form Wawancara Akan Full Size atau Melebar Satu Halaman");
		}
		
		@When("User Admin klik Button Refresh Form Wawancara Akan Merefresh Data table Form Wawancara")
		public void buttonRefresh() {
			wawancara.buttonSupportFormRefresh();
			extentTest.log(LogStatus.PASS, "User Admin klik Button Refresh Form Wawancara Akan Merefresh Data table Form Wawancara");
		}
		
		@When("User Admin klik Button Collapse Menutup Layar Form Wawancara")
		public void buttonCollapse() {
			wawancara.buttonSupportFormCollapse();
			extentTest.log(LogStatus.PASS, "User Admin klik Button Collapse Menutup Layar Form Wawancara");
		}
		
		//User Admin Mencari Data di List Filter
		@When("User Admin Memilih Data Recruiter di Field List DropDown Filter Recruiter Dan Klik Tombol Filter")
		public void User_Admin_Memilih_Data_Recruiter_di_Field_List_DropDown_Filter_Recruiter() {
			wawancara.pickFilterData();
			extentTest.log(LogStatus.PASS, "User Admin Memilih Data Recruiter di Field List DropDown Filter Recruiter Dan Klik Tombol Filter");
		}
		
		//User Admin Memasukkan Key Yang Datanya Ada Didalam Table
		@When("User Admin Memasukkan Key di Field Search Table")
		public void User_Admin_Memasukkan_Key_di_Field_Search_Table() {
			wawancara.searchInput(wawancara.getDataListTable());
			wawancara.setText(wawancara.getDataListTable());
			extentTest.log(LogStatus.PASS, "User Admin Memasukkan Key di Field Search Table");
		}
		
		@Then("Menampilkan Data Table Sesuai Key Yang Dimasukkan di Table Form Wawancara")
		public void Menampilkan_Data_Table_Sesuai_Key_Yang_Dimasukkan_di_Table_Form_Wawancara() {
			if(1>=wawancara.getCountData().size()) {
				Assert.fail("Menampilkan Data Table Sesuai Key Yang Dimasukkan");
			}
			
			extentTest.log(LogStatus.PASS, "Menampilkan Data Table Sesuai Key Yang Dimasukkan di Table Form Wawancara");
		}
		
		
		//User Admin Memasukkan Key Yang Datanya Tidak Ada Didalam Table
		@When("User Admin Memasukkan Key Yang Datanya Tidak Ada di Field Search Table Form Wawancara")
		public void User_Admin_Memasukkan_Key_Yang_Datanya_Tidak_Ada_di_Field_Search_Table_Form_Wawancara() {
			wawancara.searchInput("abcdefg");
			extentTest.log(LogStatus.PASS, "User Admin Memasukkan Key Yang Datanya Tidak Ada di Field Search Table Form Wawancara");
		}
		
		@Then("Data Tidak Tampil Dan Menampilkan Pesan No data available in table di Form Wawancara")
		public void Data_Tidak_Tampil_Dan_Menampilkan_Pesan_No_data_available_in_table_di_Form_Wawancara() {
			assertEquals("No matching records found", wawancara.getTextDataNotFound().getText());
			extentTest.log(LogStatus.PASS, "Data Tidak Tampil Dan Menampilkan Pesan No data available in table di Form Wawancara");
		}
		
		// User Admin Tidak Memasukkan Key Yang Datanya Ada Didalam Table
		@When("User Admin Tidak Memasukkan Key di Field Search Table")
		public void User_Admin_Tidak_Memasukkan_Key_di_Field_Search_Table() {
			tunggu(2);
			wawancara.searchInput("");
			extentTest.log(LogStatus.PASS, "User Admin Tidak Memasukkan Key di Field Search Table");
		}
		
		@Then("Menampilkan Semua Data Table")
		public void Menampilkan_Semua_Data_Table() {
			if(1>=wawancara.getCountData().size()) {
				Assert.fail("Menampilkan Semua Data Table");
			}
			extentTest.log(LogStatus.PASS, "Menampilkan Semua Data Table");
		}
		
		//User Admin Membuka Halaman Detail Data Recruiter
		@When("User Admin Mengklik Button Plus Dan Button Detail Form Wawancara")
		public void User_Admin_Mengklik_Button_Plus_Form_Wawancara() {
			wawancara.detail();
			extentTest.log(LogStatus.PASS, "User Admin Mengklik Button Plus Dan Button Detail Form Wawancara");
		}
		
		@Then("Menampilkan Data Detail Nama Recruiter")
		public void Menampilkan_Data_Detail_Nama_Recruiter() {
			assertEquals(wawancara.getText(), wawancara.nameDetail());
			extentTest.log(LogStatus.PASS, "Menampilkan Data Detail Nama Recruiter");
		}

		//User Admin Mengisi Semua Data Detail Form Wawancara
		@When("User Admin Mengisi Semua Data Detail Form Wawancara")
		public void User_Admin_Mengisi_Semua_Data_Detail_Form_Wawancara() {
			HashMap<Integer,String> list = new HashMap<Integer,String>();
			list.put(1, "Sales and Marketing");
			list.put(2, "DSR");
			list.put(3, "Facebook");
			list.put(4, "klmpok4@gmail.com");
			list.put(5, "klmpok4@gmail.com");
			list.put(6, "@klmpok4automation");
			list.put(7, "Lolos");
			
			wawancara.inputFormAllData(list);
			
			extentTest.log(LogStatus.PASS, "User Admin Mengisi Semua Data Detail Form Wawancara");
		}
		
		@And("User Admin Klik Button Submit Form Wawancara")
		public void User_Admin_Klik_Button_Submit_Form_Wawancara() {	

			extentTest.log(LogStatus.PASS, "User Admin Klik Button Submit Form Wawancara");
		}
		
		@Then("Otomatis Ke Direct Ke halaman Form Verifikasi")
		public void otomatis_Ke_Direct_Ke_halaman_Form_Verifikasi() {	
			
			extentTest.log(LogStatus.PASS, "Otomatis Ke Direct Ke halaman Form Verifikasi");
		}
		
		//User admin Klik Button Back 
		@When("User Admin klik Button Back")
		public void User_admin_Klik_Button_Back() {
			wawancara.buttonBack();
			extentTest.log(LogStatus.PASS, "User Admin klik Button Back");
		}
		
		@Then("Otomatis Ke Direct Ke halaman Form Wawancara")
		public void Otomatis_Ke_Direct_Ke_halaman_Form_Wawancara() {
			assertEquals("Form Wawancara", "404 Page Not Found");
			extentTest.log(LogStatus.FAIL, "Otomatis Ke Direct Ke halaman Form Wawancara");
		}
	
	//Menu Form Jadwal Training
	//User Admin Mengklik Button Support Form Jadwal Training
	@When("User Admin klik Button Expand Layar Form Jadwal Training Akan Full Size atau Melebar Satu Halaman")
	public void buttonExpandJadwalTraining() {
		jadwal.accessFormJadwalTraining();;
		tunggu(2);
		jadwal.buttonSupportFormExpand();
		extentTest.log(LogStatus.PASS, "User Admin klik Button Expand Layar Form Jadwal Training Akan Full Size atau Melebar Satu Halaman");
	}
	
	@When("User Admin klik Button Refresh Akan Merefresh Data table Form Jadwal Training")
	public void buttonRefreshJadwalTraining() {
		jadwal.buttonSupportFormRefresh();
		extentTest.log(LogStatus.PASS, "User Admin klik Button Refresh Akan Merefresh Data table Form Jadwal Training");
	}
	
	@When("User Admin klik Button Collapse Menutup Layar Form Jadwal Training")
	public void buttonCollapseJadwalTraining() {
		jadwal.buttonSupportFormCollapse();
		extentTest.log(LogStatus.PASS, "User Admin klik Button Collapse Menutup Layar Form Jadwal Training");
	}
	
	//User Admin Mencari Data di List Filter Jadwal Training
	@When("User Admin Memilih Data Recruiter di Field List DropDown Filter Recruiter Jadwal Training")
	public void User_Admin_Memilih_Data_Recruiter_di_Field_List_DropDown_Filter_Recruiter_Jadwal_Training() {
		jadwal.pickFilterData();
		extentTest.log(LogStatus.PASS, "User Admin Memilih Data Recruiter di Field List DropDown Filter Recruiter Jadwal Training");
	}
	

	//User Admin Memasukkan Key Yang Datanya Tidak Ada Didalam Table Form Jadwal Training
	@When("User Admin Memasukkan Key Sembarang di Field Search Table Form Jadwal Training")
	public void User_Admin_Memasukkan_Key_Sembarang_di_Field_Search_Table_Form_Jadwal_Training() {
		jadwal.searchInput("abcdefghij");
		extentTest.log(LogStatus.PASS, "User Admin Memasukkan Key Sembarang di Field Search Table Form Jadwal Training");
	}
	
	@Then("Data Tidak Tampil Dan Menampilkan Pesan No data available in table Form Jadwal Training")
	public void Data_Tidak_Tampil_Dan_Menampilkan_Pesan_No_data_available_in_table_Form_Jadwal_Training() {
		assertEquals("No matching records found", jadwal.getTextNotFound());
		extentTest.log(LogStatus.PASS, "Data Tidak Tampil Dan Menampilkan Pesan No data available in table Form Jadwal Training");
	}
	
	//  User Admin Memasukkan Key Yang Datanya Ada Didalam Table Form Jadwal Training
	@When("User Admin Memasukkan Key di Field Search Table Form Jadwal Training")
	public void User_Admin_Memasukkan_Key_di_Field_Search_Table_Form_Jadwal_Training() {
		jadwal.searchInput(jadwal.getDataListTable());
		jadwal.setTextIdDetail(jadwal.getDataListTable());
		extentTest.log(LogStatus.PASS, "User Admin Memasukkan Key di Field Search Table Form Jadwal Training");
	}
	
	@Then("Menampilkan Data Table Form Jadwal Training Sesuai Key Yang Dimasukkan")
	public void Menampilkan_Data_Table_Form_Jadwal_Training_Sesuai_Key_Yang_Dimasukkan() {
		if(1>=jadwal.countData()) {
			Assert.fail("Menampilkan Data Table Form Jadwal Training Sesuai Key Yang Dimasukkan");
		}
		extentTest.log(LogStatus.PASS, "Menampilkan Data Table Form Jadwal Training Sesuai Key Yang Dimasukkan");
	}
	
	//User Admin Tidak Memasukkan Key Yang Datanya Ada Didalam Table Form Jadwal Training
	@When("User Admin Tidak Memasukkan Key di Field Search Table Form Jadwal Training")
	public void User_Admin_Tidak_Memasukkan_Key_di_Field_Search_Table_Form_Jadwal_Training() {
		jadwal.searchInput("");
		extentTest.log(LogStatus.PASS, "User Admin Tidak Memasukkan Key di Field Search Table Form Jadwal Training");
	}
	
	@Then("Menampilkan Semua Data Table Form Jadwal Training")
	public void Menampilkan_Semua_Data_Table_Form_Jadwal_Training() {		
		if(1>=jadwal.countData()) {
			Assert.fail("Menampilkan Data Table Form Jadwal Training Sesuai Key Yang Dimasukkan");
		}
		
		extentTest.log(LogStatus.PASS, "Menampilkan Semua Data Table Form Jadwal Training");
	}
	
	//User Admin Membuka Halaman Detail Data Recruiter
	@When("User Admin Mengklik Button Plus Dan Button Detail")
	public void User_Admin_Mengklik_Button_Plus_Dan_Button_Detail() {
		tunggu(2);
		jadwal.buttonPlus();
		extentTest.log(LogStatus.PASS, "User Admin Mengklik Button Plus Dan Button Detail");
	}
	
	@Then("Menampilkan Data Detail per ID Recruiter")
	public void Menampilkan_Data_Detail_per_ID_Recruiter() {
		assertTrue(jadwal.getDetailText().contains(jadwal.getTextIdDetail()));
		extentTest.log(LogStatus.PASS, "Menampilkan Data Detail per ID Recruiter");
	}
	
	//User Admin Tidak Mengisi Semua Data Form Detail Jadwal Training
	@When("User Admin Klik Button Submit")
	public void  User_Admin_Klik_Button_Submit() {
		jadwal.btnCollapseDetail();
		tunggu(3);
		jadwal.buttonSubmitClick();
		extentTest.log(LogStatus.PASS, "User Admin Klik Button Submit");
	}
	
	@Then("Data Tidak Tersimpan Dan Tetap Dihalaman Detail Jadwal Training")
	public void Data_Tidak_Tersimpan_Dan_Tetap_Dihalaman_Detail_Jadwal_Training() {
		assertTrue(jadwal.getDetailText().contains(jadwal.getTextIdDetail()));
		extentTest.log(LogStatus.PASS, "Data Tidak Tersimpan Dan Tetap Dihalaman Detail Jadwal Training");
	}
	
	//User Admin Mengisi Hanya Satu Data List Form Detail Jadwal Training
	@When("User Admin Mengisi Hanya Satu Data List Dan Klik Button Submit")
	public void  User_Admin_Mengisi_Hanya_Satu_Data_List_Dan_Klik_Button_Submit() {
		tunggu(2);
		jadwal.inputNotAllData();
		extentTest.log(LogStatus.PASS, "User Admin Mengisi Hanya Satu Data List Dan Klik Button Submit");
	}
	
	@Then("Data Tidak Tersimpan Dan Tetap Dihalaman Detail Jadwal Training Melengkapi Inputan Yang Kosong")
	public void Data_Tidak_Tersimpan_Dan_Tetap_Dihalaman_Detail_Jadwal_Training_Melengkapi_Inputan_Yang_Kosong() {
		assertTrue(jadwal.getDetailText().contains(jadwal.getTextIdDetail()));
		extentTest.log(LogStatus.PASS, "Data Tidak Tersimpan Dan Tetap Dihalaman Detail Jadwal Training Melengkapi Inputan Yang Kosong");
	}
	
	//User Admin Mengisi Semua Data Form Detail Jadwal Training
	@When("Pilih Data Dropdown List Tipe Pegawai")
	public void Pilih_Data_Dropdown_List_Tipe_Pegawai() {
		jadwal.inputFormJadwalTraining(jadwal.getEmployee_Type(),"MAGANG");
		extentTest.log(LogStatus.PASS, "Pilih Data Dropdown List Tipe Pegawai");
	}
	
	@And("Pilih Data Dropdown List Department")
	public void Pilih_Data_Dropdown_List_Department() {
		tunggu(2);
		jadwal.inputFormJadwalTraining(jadwal.getDepartement(),"Finance");
		extentTest.log(LogStatus.PASS, "Pilih Data Dropdown List Department");
	}
	
	@And("Pilih Data Dropdown List Divisi")
	public void Pilih_Data_Dropdown_List_Divisi() {
		tunggu(2);
		jadwal.inputFormJadwalTraining(jadwal.getDivision(),"Operational");
		extentTest.log(LogStatus.PASS, "Pilih Data Dropdown List Divisi");
	}
	
	@And("Pilih Data Dropdown List Cabang")
	public void Pilih_Data_Dropdown_List_Cabang() {
		tunggu(2);
		jadwal.inputFormJadwalTraining(jadwal.getBranch(),"MEDAN");
		extentTest.log(LogStatus.PASS, "Pilih Data Dropdown List Cabang");
	}
	
	@And("Pilih Data Dropdown List Posisi")
	public void Pilih_Data_Dropdown_List_Posisi() {
		tunggu(2);
		jadwal.inputFormJadwalTraining(jadwal.getPosition(),"DSR");
		extentTest.log(LogStatus.PASS, "Pilih Data Dropdown List Posisi");
	}
	
	@And("Pilih Data Dropdown List Channel")
	public void Pilih_Data_Dropdown_List_Channel() {
		tunggu(2);
		jadwal.inputFormJadwalTraining(jadwal.getChannel(),"Community");
		extentTest.log(LogStatus.PASS, "Pilih Data Dropdown List Channel");
	}
	
	@And("Pilih Data Dropdown List Tipe Group")
	public void Pilih_Data_Dropdown_List_Tipe_Group() {
		tunggu(2);
		jadwal.inputFormJadwalTraining(jadwal.getGroup_Type(),"Exhibition");
		extentTest.log(LogStatus.PASS, "Pilih Data Dropdown List Tipe Group");
	}
	
	@And("Pilih Data Dropdown List Level")
	public void Pilih_Data_Dropdown_List_Level() {
		tunggu(2);
		jadwal.inputFormJadwalTraining(jadwal.getLevel(),"Executive");
		extentTest.log(LogStatus.PASS, "Pilih Data Dropdown List Level");
	}
	
	@And("Pilih Data Dropdown List Produk")
	public void Pilih_Data_Dropdown_List_Produk() {
		tunggu(2);
		jadwal.inputFormJadwalTraining(jadwal.getProduct(),"EDC");
		extentTest.log(LogStatus.PASS, "Pilih Data Dropdown List Produk");
	}
	
	@And("Pilih Data Dropdown List Sales Mode")
	public void Pilih_Data_Dropdown_List_Sales_Mode() {
		tunggu(2);
		jadwal.inputFormJadwalTraining(jadwal.getSales_Mode(),"Tele Sales");
		extentTest.log(LogStatus.PASS, "Pilih Data Dropdown List Sales Mode");
	}
	
	@And("Pilih Tanggal Training")
	public void Pilih_Tanggal_Training() {
		jadwal.inputDate("2022-07-20");
		extentTest.log(LogStatus.PASS, "Pilih Tanggal Training");
	}
	
	//User Admin Mengklik Button Support Form Coding
	@When("User Admin klik Button Expand Layar Form Verifikasi Akan Full Size atau Melebar Satu Halaman Form Coding")
	public void buttonExpandFormCoding() {
		coding.accessFormCoding();
		tunggu(2);
		coding.buttonSupportFormExpand();
		extentTest.log(LogStatus.PASS, "User Admin klik Button Expand Layar Form Verifikasi Akan Full Size atau Melebar Satu Halaman Form Coding");
	}
	
	@When("User Admin klik Button Refresh Akan Merefresh Data table Form Coding")
	public void buttonRefreshFormCoding() {
		coding.buttonSupportFormRefresh();
		extentTest.log(LogStatus.PASS, "User Admin klik Button Refresh Akan Merefresh Data table Form Coding");
	}
	
	@When("User Admin klik Button Collapse Menutup Layar Form Coding")
	public void buttonCollapseFormVerifikasi() {
		coding.buttonSupportFormCollapse();
		extentTest.log(LogStatus.PASS, "User Admin klik Button Collapse Menutup Layar Form Verifikasi");
	}
	
	//User Admin Mencari Data di List Filter BSH
	@When("User Admin Memilih Data Branch di Field List DropDown Filter Branch")
	public void User_Admin_Memilih_Data_Branch_di_Field_List_DropDown_Filter_Branch() {
		coding.clickFilterData();
		extentTest.log(LogStatus.PASS, "User Admin Memilih Data Branch di Field List DropDown Filter Branch");
	}
	
	//User Admin Mencari Data yang Diinginkan Di Field Search Table Form Coding
	@When("User Admin Memasukkan Key Yang Ingin Ditampilkan")
	public void User_Admin_Memasukkan_Key_Data_Yang_Ingin_Ditampilkan() {
		tunggu(2);
		coding.inputSearchTable();
		extentTest.log(LogStatus.PASS, "User Admin Memasukkan Key Yang Ingin Ditampilkan");
	}
	
	@Then("Menampilkan Data List Table Form Coding Sesuai Key/Data Yang Dimasukkan")
	public void Menampilkan_Data_List_Table_Form_Coding_Sesuai_Key_Data_Yang_Dimasukkan() {
		extentTest.log(LogStatus.PASS, "Menampilkan Data List Table Form Coding Sesuai Key Yang Dimasukkan");
	}
	
	//User Admin Membuka Halaman Detail Data Form Coding
	@When("User Admin Mengklik Button Plus Dan Button Detail Table Form Coding")
	public void User_Admin_Mengklik_Button_Plus_Dan_Button_Detail_Table_Form_Coding() {
		tunggu(2);
		coding.detailFormCoding();
		extentTest.log(LogStatus.PASS, "User Admin Mengklik Button Plus Dan Button Detail Table Form Coding");
	}
	
	//User Admin Mengisi Semua Form Data Detail Form Coding
	@When("User Admin Mengisi Data Detail Form Coding")
	public void User_Admin_Mengisi_Data_Detail_Form_Coding() {
		tunggu(2);
		HashMap<Integer, String> send =  new HashMap<Integer,String>();
		send.put(1, "Operational");
		send.put(2, "Project");
		send.put(3, "MEDAN");
		send.put(4, "DSR");
		send.put(5, "MAGANG");
		send.put(6, "EDC");
		send.put(7, "");
		send.put(8, "Retail");
		send.put(9, "Premier");
		send.put(10, "Direct Sales");
		send.put(11, "");
		send.put(12, "SANTI WIDYAWATIK");
		
		
		
		coding.inputDataDetail(send);
		extentTest.log(LogStatus.PASS, "User Admin Mengisi Data Detail Form Coding");
	}
	
	@Then("Data Berhasil Disimpan")
	public void Data_Berhasil_Disimpan() {
//			assertTrue(coding.buttonEdit());
		extentTest.log(LogStatus.PASS, "Data Berhasil Disimpan");
	}
	
	//Form Report Training
	//User Admin Mengklik Button Support Form Report Training
	@When("User Admin klik Button Collapse Form Wawancara Akan menutup Data table Form Report Training")
	public void User_Admin_klik_Button_Collapse_Form_Wawancara_Akan_menutup_Data_table_Form_Report_Training() {
		training.buttonCollapse();
		extentTest.log(LogStatus.PASS, "User Admin klik Button Collapse Form Wawancara Akan menutup Data table Form Report Training");
	}
	
	//User Admin Memilih Filter List Tahun Dan Filter List Bulan Yang Datanya Tidak Ada Didalam Table
	@When("User Admin Memilih Filter List Tahun Dan Filter List Bulan Yang Datanya Tidak Ada Didalam Table")
	public void User_Admin_Memilih_Filter_List_Tahun_Dan_Filter_List_Bulan_Yang_Datanya_Tidak_Ada_Didalam_Table() {
		training.filterData("2021", "08");
		extentTest.log(LogStatus.PASS, "User Admin Memilih Filter List Tahun Dan Filter List Bulan Yang Datanya Tidak Ada Didalam Table");
	}	
	
	@Then("Data Tidak Tampil Dan Menampilkan Pesan No data available in table")
	public void Data_Tidak_Tampil_Dan_Menampilkan_Pesan_No_data_available_in_table() {
		assertEquals("No data available in table", training.getTextNotFound());
		extentTest.log(LogStatus.PASS, "Data Tidak Tampil Dan Menampilkan Pesan No data available in table");
	}
	
	//User Admin Memilih Filter List Tahun Dan Filter List Bulan Yang Datanya Ada Didalam Table
	@When("User Admin Memilih Filter List Tahun Dan Filter List Bulan Yang Datanya Ada Didalam Table")
	public void User_Admin_Memilih_Filter_List_Tahun_Dan_Filter_List_Bulan_Yang_Datanya_Ada_Didalam_Table() {
		tunggu(2);
		training.filterData("2022", "07");
		extentTest.log(LogStatus.PASS, "User Admin Memilih Filter List Tahun Dan Filter List Bulan Yang Datanya Ada Didalam Table");
	}	
	
	@Then("Menampilkan Data Sesuai Filter Tahun Dan Bulan")
	public void Menampilkan_Data_Sesuai_Filter_Tahun_Dan_Bulan() {
		if(1>=training.countData()) {
			Assert.fail("Menampilkan Data Sesuai Filter Tahun Dan Bulan");
		}
		extentTest.log(LogStatus.PASS, "Menampilkan Data Sesuai Filter Tahun Dan Bulan");
	}
	
	//User Admin Memasukkan Sembarang Key Yang Datanya Tidak Ada Didalam Table Form Report Training
	@When("User Admin Memasukkan Sembarang Key Yang Datanya Tidak Ada di Field Search Table Form Report Training")
	public void User_Admin_Memasukkan_Sembarang_Key_Yang_Datanya_Tidak_Ada_di_Field_Search_Table_Form_Report_Training() {
		training.searchData("abcdefg");
		extentTest.log(LogStatus.PASS, "User Admin Memasukkan Sembarang Key Yang Datanya Tidak Ada di Field Search Table Form Report Training");
	}	
	
	@Then("Data Tidak Tampil Dan Menampilkan Pesan No data available in Table Form Report Training")
	public void Data_Tidak_Tampil_Dan_Menampilkan_Pesan_No_data_available_in_Table_Form_Report_Training() {
		assertEquals("No matching records found", training.getTextNotFound());
		extentTest.log(LogStatus.PASS, "Data Tidak Tampil Dan Menampilkan Pesan No data available in Table Form Report Training");
	}
	
	//User Admin Memasukkan Key Yang Datanya Ada Didalam Table Form Report Training
	@When("User Admin Memasukkan Key di Field Search Table Form Report Training")
	public void User_Admin_Memasukkan_Key_di_Field_Search_Table_Form_Report_Training() {
		training.searchData("D6191615");
		extentTest.log(LogStatus.PASS, "User Admin Memasukkan Key di Field Search Table Form Report Training");
	}	
	
	@Then("Menampilkan Data Sesuai Key Yang Dimasukkan diTable Form Report Training")
	public void Menampilkan_Data_Sesuai_Key_Yang_Dimasukkan_diTable_Form_Report_Training() {
		if(1>=training.countData()) {
			Assert.fail("Menampilkan Data Sesuai Key Yang Dimasukkan diTable Form Report Training");
		}
		extentTest.log(LogStatus.PASS, "Menampilkan Data Sesuai Key Yang Dimasukkan diTable Form Report Training");
	}
	
	//User Admin Tidak Memasukkan Key Yang Datanya Ada Didalam Table Form Report Training
	@When("User Admin Tidak Memasukkan Key di Field Search Table Form Report Training")
	public void User_Admin_Tidak_Memasukkan_Key_di_Field_Search_Table_Form_Report_Training() {
		training.searchData("");
		extentTest.log(LogStatus.PASS, "User Admin Tidak Memasukkan Key di Field Search Table Form Report Training");
	}	
	
	@Then("Menampilkan Semua Data Table Form Report Training")
	public void Menampilkan_Semua_Data_Table_Form_Report_Training() {
		if(1>=training.countData()) {
			Assert.fail("Menampilkan Semua Data Table Form Report Training");
		}
		extentTest.log(LogStatus.PASS, "Menampilkan Semua Data Table Form Report Training");
	}
	
	//User Admin Melihat Detail Data Table Report Training
	@When("User Admin Klik Button Plus dan Button Detail")
	public void User_Admin_Klik_Button_Plus_dan_Button_Detail () {
		training.clickDetail();
		extentTest.log(LogStatus.PASS, "User Admin Klik Button Plus dan Button Detail ");
	}	
	
	@Then("Menampilkan Detail Data Trainer Sesuai ID")
	public void Menampilkan_Detail_Data_Trainer_Sesuai_ID() {
		String text ="D6191615";
		assertTrue(text.contains(training.getTextDetailNameDataTableTrainer()));
		extentTest.log(LogStatus.PASS, "Menampilkan Detail Data Trainer Sesuai ID");
	}
	
//	Form Report Tarik Data
//	User Admin Mengklik Button Support Form Report Tarik Data
	@When("User Admin klik Button Collapse Akan menutup Data table Form Report Tarik Data")
	public void User_Admin_klik_Button_Collapse_Akan_menutup_Data_table_Form_Report_Tarik_Data() {
		tarik.buttonCollapse();
		extentTest.log(LogStatus.PASS, "User Admin klik Button Collapse Akan menutup Data table Form Report Tarik Data");
	}
	
//	User Admin Tidak Memilih Filter List Kategori Dan Pilih Tanggal
	@When("User Admin Tidak Memilih Filter List Kategori Dan Pilih Tanggal")
	public void User_Admin_Tidak_Memilih_Filter_List_Kategori_Dan_Pilih_Tanggal() {
		tarik.inputFilterData("", "");
		extentTest.log(LogStatus.PASS, "User Admin Tidak Memilih Filter List Kategori Dan Pilih Tanggal");
	}
	
	@Then("Tampil Text Error The Kategori field is required Dan The tanggal field is required")
	public void Tampil_Text_Error_The_Kategori_field_is_required_Dan_The_tanggal_field_is_required () {
		assertEquals("The Kategori field is required.", tarik.textKategoriError());
		assertEquals("The tanggal field is required.", tarik.textTanggalError());
		extentTest.log(LogStatus.PASS, "Tampil Text Error The Kategori field is required Dan The tanggal field is required");
	}
	
	@And("Button Generate Report Tidak Tampil")
	public void Button_Generate_Report_Tidak_Tampil () {
		assertEquals("", tarik.buttonGenerate());
		extentTest.log(LogStatus.PASS, "Button Generate Report Tidak Tampil");
	}
	
//	User Admin Memilih Filter List Kategori Dan Pilih Tanggal
	@When("User Admin Memilih Filter List Kategori Dan Pilih Tanggal")
	public void User_Admin_Memilih_Filter_List_Kategori_Dan_Pilih_Tanggal() {
		tunggu(2);
		tarik.inputFilterData("Data Pelamar", "2022-05-19");
		extentTest.log(LogStatus.PASS, "User Admin Memilih Filter List Kategori Dan Pilih Tanggal");
	}
	
	@Then("Tampil Button Generate Report")
	public void Tampil_Button_Generate_Report () {
		tunggu(2);
		tarik.clickButtonGenerate();
		assertNotNull(tarik.buttonGenerate());
		extentTest.log(LogStatus.PASS, "Tampil Button Generate Report");
	}
	
	@And("File Terdownload Berupa Format Excel")
	public void File_Terdownload_Berupa_Format_Excel () {
		File file = new File("C:\\\\Users\\\\LENOVO\\\\Downloads\\\\REPORT-RTO-DATA-PELAMAR.xls");
		assertTrue(file.exists());
		extentTest.log(LogStatus.PASS, "File Terdownload Berupa Format Excel");
	}
	
	//Form Session
	//User Admin Mengklik Button Support Form Session
	@When("User Admin klik Button Refresh Form Session Akan Merefresh Data table Form Session")
	public void User_Admin_klik_Button_Refresh_Form_Session_Akan_Merefresh_Data_table_Form_Session() {
		session.buttonRefresh();
		extentTest.log(LogStatus.PASS, "User Admin klik Button Refresh Form Session Akan Merefresh Data table Form Session");
	}
	
	//User Admin Memasukkan Sembarang Key Yang Datanya Tidak Ada Didalam Table
	@When("User Admin Memasukkan Sembarang Key Yang Datanya Tidak Ada di Field Search Table Form Session")
	public void User_Admin_Memasukkan_Sembarang_Key_Yang_Datanya_Tidak_Ada_di_Field_Search_Table_Form_Session() {
		session.searchInput("abcdefg");
		extentTest.log(LogStatus.PASS, "User Admin Memasukkan Sembarang Key Yang Datanya Tidak Ada di Field Search Table Form Session");
	}
	
	@Then("Data Tidak Tampil Dan Menampilkan Pesan No data available in table Table Form Session")
	public void Data_Tidak_Tampil_Dan_Menampilkan_Pesan_No_data_available_in_table_Table_Form_Session() {
		assertEquals("No data available in table", session.getText());
		extentTest.log(LogStatus.PASS, "Data Tidak Tampil Dan Menampilkan Pesan No data available in table Table Form Session");
	}
	
	// User Admin Memasukkan Key Yang Datanya Ada Didalam Table Form Session
	@When("User Admin Memasukkan Key di Field Search Table Form Session")
	public void Menampilkan_Data_Table_Sesuai_Key_Yang_Dimasukkan_Table_Form_Session() {
		tunggu(3);
		session.searchInput("adminsd3");
		extentTest.log(LogStatus.PASS, "User Admin Memasukkan Key di Field Search Table Form Session");
	}
	
	@Then("Menampilkan Data Table Sesuai Key Yang Dimasukkan Table Form Session")
	public void Menampilkan_Data_Table_Sesuai_Key_Yang_Dimasukkan() {
		if(1>=session.countData()) {
			Assert.fail("Menampilkan Data Table Sesuai Key Yang Dimasukkan Table Form Session");
		}
		
		extentTest.log(LogStatus.PASS, "Menampilkan Data Table Sesuai Key Yang Dimasukkan Table Form Session");
	}
	
	//User Admin Tidak Memasukkan Key Didalam Field Search Table Form Session 
	@When("User Admin Tidak Memasukkan Key di Field Search Table Form Session")
	public void User_Admin_Tidak_Memasukkan_Key_di_Field_Search_Table_Form_Session() {
		session.searchInput("");
		extentTest.log(LogStatus.PASS, "User Admin Memasukkan Key di Field Search Table");
	}
	
	@Then("Menampilkan Semua Data Table Form Session")
	public void Menampilkan_Semua_Data_Table_Form_Session() {
		if(1>=session.countData()) {
			Assert.fail("Menampilkan Semua Data Table Form Session");
		}
		extentTest.log(LogStatus.PASS, "Menampilkan Semua Data Table Form Session");
	}
	
	//User Admin Menghapus Data Session
	@When("User Admin Klik Button Hapus Data Session")
	public void User_Admin_Klik_Button_Hapus_Data_Session () {
		session.clickBtnDelete();
		extentTest.log(LogStatus.PASS, "User Admin Klik Button Hapus Data Session");
	}
	
	@And("Tampil Pop Up Alert Force Logout Klik Batal")
	public void Tampil_Pop_Up_Alert_Force_Logout_Klik_Batal() {
		tunggu(2);
		driver.switchTo().alert().dismiss();
		extentTest.log(LogStatus.PASS, "Tampil Pop Up Alert Force Logout Klik Batal");
	}
	
	@Then("Data Yang Dipilih Tidak Terhapus")
	public void Data_Yang_Dipilih_Tidak_Terhapus() {
		tunggu(2);
		driver.navigate().refresh();
		extentTest.log(LogStatus.PASS, "Data Yang Dipilih Tidak Terhapus");
	}
	
	@When("Tampil Pop Up Alert Force Logout Klik Ok")
	public void Tampil_Pop_Up_Alert_Force_Logout_Klik_Ok () {
		session.clickBtnDelete();
		tunggu(2);
		driver.switchTo().alert().accept();
		extentTest.log(LogStatus.PASS, "Tampil Pop Up Alert Force Logout Klik Ok");
	}
	
	
	@Then("Data Yang Dipilih Terhapus Dan Logout Otomatis")
	public void Data_Yang_Dipilih_Terhapus_Dan_Logout_Otomatis() {
		driver.navigate().refresh();
		driver.quit();
		extentTest.log(LogStatus.PASS, "Data Yang Dipilih Terhapus Dan Logout Otomatis");
	}
	
	public void back() {
		driver.navigate().back();
	}

	public static void tunggu(int detik) {
		try {
			Thread.sleep(1000*detik);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
