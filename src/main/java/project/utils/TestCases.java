package project.utils;

public enum TestCases {

	T1("Testing Login Field Kosong User Admin"),
	T2("Testing Login User Admin Tidak Terdaftar Atau Username & Password Salah"),
	T3("Testing Login User Admin Sudah Login Ditempat Lain"),
	T4("Testing Login User Admin Sudah Terdaftar"),
	T5("Testing Menu Card Dashboard"),
	T6("User Admin Mengklik Button Support Form Wawancara"),
	T7("User Admin Mencari Data di List Filter"),
	T8("User Admin Memasukkan Key Yang Datanya Ada Didalam Table"),
	T9("User Admin Memasukkan Key Yang Datanya Tidak Ada Didalam Table"),
	T10("User Admin Tidak Memasukkan Key Yang Datanya Ada Didalam Table"),
	T11("User Admin Membuka Halaman Detail Data Recruiter"),
	T12("User Admin Mengisi Semua Data Detail Form Wawancara"),
	T13("User admin Klik Button Back"),
	T14("User Admin Mengklik Button Support Form Jadwal Training"),
	T15("User Admin Mencari Data di List Filter Jadwal Training"),
	T16("User Admin Memasukkan Key Yang Datanya Ada Didalam Table Form Jadwal Training"),
	T17("User Admin Memasukkan Key Yang Datanya Tidak Ada Didalam Table Form Jadwal Training"),
	T18("User Admin Tidak Memasukkan Key Yang Datanya Ada Didalam Table Form Jadwal Training"),
	T19("User Admin Membuka Halaman Detail Data Recruiter"),
	T20("User Admin Tidak Mengisi Semua Data Form Detail Jadwal Training"),
	T21("User Admin Mengisi Hanya Satu Data List Form Detail Jadwal Training"),
	T22("User Admin Mengisi Semua Data Form Detail Jadwal Training"),
	T23("User Admin Mengklik Button Support Form Coding"),
	T24("User Admin Mencari Data di List Filter Branch"),
	T25("User Admin Mencari Data yang Diinginkan Di Field Search Table Form Coding"),
	T26("User Admin Membuka Halaman Detail Data Form Coding"),
	T27("User Admin Mengisi Semua Form Data Detail Form Coding"),
	T28("User Admin Mengklik Button Support Form Report Training"),
	T29("User Admin Memilih Filter List Tahun Dan Filter List Bulan Yang Datanya Tidak Ada Didalam Table"),
	T30("User Admin Memilih Filter List Tahun Dan Filter List Bulan Yang Datanya Ada Didalam Table"),
	T31("User Admin Memasukkan Sembarang Key Yang Datanya Tidak Ada Didalam Table Form Report Training"),
	T32("User Admin Tidak Memasukkan Key Yang Datanya Ada Didalam Table Form Report Training"),
	T33("User Admin Memasukkan Key Yang Datanya Ada Didalam Table Form Report Training"),
	T34("User Admin Melihat Detail Data Table Report Training"),
	T35("User Admin Mengklik Button Support Form Report Tarik Data"),
	T37("User Admin Tidak Memilih Filter List Kategori Dan Pilih Tanggal"),
	T38("User Admin Memilih Filter List Kategori Dan Pilih Tanggal"),
	T39("User Admin Mengklik Button Support Form Session"),
	T40("User Admin Memasukkan Sembarang Key Yang Datanya Tidak Ada Didalam Table"),
	T41("User Admin Tidak Memasukkan Key Yang Datanya Ada Didalam Table"),
	T42("User Admin Memasukkan Key Yang Datanya Ada Didalam Table"),
	T43("User Admin Menghapus Data Session");
	
	private String testName;
	
	TestCases(String testName){
		this.testName = testName;
	}
	
	public String getTestName() {
		return testName;
	}
	
}
