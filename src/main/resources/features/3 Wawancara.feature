Feature: User Admin Mengakses Menu Form Wawancara

Scenario: User Admin Mengklik Button Support Form Wawancara
When User Admin klik Button Expand Layar Form Wawancara Akan Full Size atau Melebar Satu Halaman
When User Admin klik Button Refresh Form Wawancara Akan Merefresh Data table Form Wawancara
When User Admin klik Button Collapse Menutup Layar Form Wawancara

Scenario: User Admin Mencari Data di List Filter
When User Admin Memilih Data Recruiter di Field List DropDown Filter Recruiter Dan Klik Tombol Filter

Scenario: User Admin Memasukkan Key Yang Datanya Ada Didalam Table
When User Admin Memasukkan Key di Field Search Table
Then Menampilkan Data Table Sesuai Key Yang Dimasukkan di Table Form Wawancara

Scenario: User Admin Memasukkan Key Yang Datanya Tidak Ada Didalam Table Form Wawancara
When User Admin Memasukkan Key Yang Datanya Tidak Ada di Field Search Table Form Wawancara
Then Data Tidak Tampil Dan Menampilkan Pesan No data available in table di Form Wawancara

Scenario: User Admin Tidak Memasukkan Key Yang Datanya Ada Didalam Table
When User Admin Tidak Memasukkan Key di Field Search Table
Then Menampilkan Semua Data Table

Scenario: User Admin Membuka Halaman Detail Data Recruiter
When User Admin Mengklik Button Plus Dan Button Detail Form Wawancara
Then Menampilkan Data Detail Nama Recruiter

Scenario: User Admin Mengisi Semua Data Detail Form Wawancara
When User Admin Mengisi Semua Data Detail Form Wawancara
And User Admin Klik Button Submit Form Wawancara
Then Otomatis Ke Direct Ke halaman Form Verifikasi

Scenario: User admin Klik Button Back 
When User Admin klik Button Back 
Then Otomatis Ke Direct Ke halaman Form Wawancara

