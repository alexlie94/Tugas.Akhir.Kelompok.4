Feature: User Admin Mengakses Menu Form Jadwal Training

Scenario: User Admin Mengklik Button Support Form Jadwal Training
When User Admin klik Button Expand Layar Form Jadwal Training Akan Full Size atau Melebar Satu Halaman
When User Admin klik Button Refresh Akan Merefresh Data table Form Jadwal Training
When User Admin klik Button Collapse Menutup Layar Form Jadwal Training

Scenario: User Admin Mencari Data di List Filter Jadwal Training
When User Admin Memilih Data Recruiter di Field List DropDown Filter Recruiter Jadwal Training

Scenario: User Admin Memasukkan Key Yang Datanya Ada Didalam Table Form Jadwal Training
When User Admin Memasukkan Key di Field Search Table Form Jadwal Training
Then Menampilkan Data Table Form Jadwal Training Sesuai Key Yang Dimasukkan

Scenario: User Admin Memasukkan Key Yang Datanya Tidak Ada Didalam Table Form Jadwal Training
When User Admin Memasukkan Key Sembarang di Field Search Table Form Jadwal Training
Then Data Tidak Tampil Dan Menampilkan Pesan No data available in table Form Jadwal Training

Scenario: User Admin Tidak Memasukkan Key Yang Datanya Ada Didalam Table Form Jadwal Training
When User Admin Tidak Memasukkan Key di Field Search Table Form Jadwal Training
Then Menampilkan Semua Data Table Form Jadwal Training

Scenario: User Admin Membuka Halaman Detail Data Recruiter
When User Admin Mengklik Button Plus Dan Button Detail
Then Menampilkan Data Detail per ID Recruiter

Scenario: User Admin Tidak Mengisi Semua Data Form Detail Jadwal Training
When User Admin Klik Button Submit
Then Data Tidak Tersimpan Dan Tetap Dihalaman Detail Jadwal Training

Scenario: User Admin Mengisi Hanya Satu Data List Form Detail Jadwal Training
When User Admin Mengisi Hanya Satu Data List Dan Klik Button Submit
Then Data Tidak Tersimpan Dan Tetap Dihalaman Detail Jadwal Training Melengkapi Inputan Yang Kosong

Scenario: User Admin Mengisi Semua Data Form Detail Jadwal Training
When Pilih Data Dropdown List Tipe Pegawai
And Pilih Data Dropdown List Department
And Pilih Data Dropdown List Divisi
And Pilih Data Dropdown List Cabang
And Pilih Data Dropdown List Posisi
And Pilih Data Dropdown List Channel
And Pilih Data Dropdown List Tipe Group
And Pilih Data Dropdown List Level
And Pilih Data Dropdown List Produk
And Pilih Data Dropdown List Sales Mode
And Pilih Tanggal Training
