Feature: User Admin Mengakses Menu Form Report Training

Scenario: User Admin Mengklik Button Support Form Report Training
When User Admin klik Button Collapse Form Wawancara Akan menutup Data table Form Report Training

Scenario: User Admin Memilih Filter List Tahun Dan Filter List Bulan Yang Datanya Tidak Ada Didalam Table
When User Admin Memilih Filter List Tahun Dan Filter List Bulan Yang Datanya Tidak Ada Didalam Table
Then Data Tidak Tampil Dan Menampilkan Pesan No data available in table

Scenario: User Admin Memilih Filter List Tahun Dan Filter List Bulan Yang Datanya Ada Didalam Table
When User Admin Memilih Filter List Tahun Dan Filter List Bulan Yang Datanya Ada Didalam Table
Then Menampilkan Data Sesuai Filter Tahun Dan Bulan

Scenario: User Admin Memasukkan Sembarang Key Yang Datanya Tidak Ada Didalam Table Form Report Training
When User Admin Memasukkan Sembarang Key Yang Datanya Tidak Ada di Field Search Table Form Report Training
Then Data Tidak Tampil Dan Menampilkan Pesan No data available in Table Form Report Training

Scenario: User Admin Memasukkan Key Yang Datanya Ada Didalam Table Form Report Training
When User Admin Memasukkan Key di Field Search Table Form Report Training
Then Menampilkan Data Sesuai Key Yang Dimasukkan diTable Form Report Training

Scenario: User Admin Tidak Memasukkan Key Yang Datanya Ada Didalam Table Form Report Training
When User Admin Tidak Memasukkan Key di Field Search Table Form Report Training
Then Menampilkan Semua Data Table Form Report Training

Scenario: User Admin Melihat Detail Data Table Report Training
When User Admin Klik Button Plus dan Button Detail 
Then Menampilkan Detail Data Trainer Sesuai ID

