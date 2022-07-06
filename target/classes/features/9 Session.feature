Feature: User Admin Mengakses Menu Form Session

Scenario: User Admin Mengklik Button Support Form Session
When User Admin klik Button Refresh Form Session Akan Merefresh Data table Form Session

Scenario: User Admin Memasukkan Sembarang Key Yang Datanya Tidak Ada Didalam Table
When User Admin Memasukkan Sembarang Key Yang Datanya Tidak Ada di Field Search Table Form Session
Then Data Tidak Tampil Dan Menampilkan Pesan No data available in table Table Form Session

Scenario: User Admin Memasukkan Key Yang Datanya Ada Didalam Table Form Session
When User Admin Memasukkan Key di Field Search Table Form Session
Then Menampilkan Data Table Sesuai Key Yang Dimasukkan Table Form Session

Scenario: User Admin Tidak Memasukkan Key Didalam Field Search Table Form Session 
When User Admin Tidak Memasukkan Key di Field Search Table Form Session
Then Menampilkan Semua Data Table Form Session

Scenario: User Admin Menghapus Data Session
When User Admin Klik Button Hapus Data Session 
And Tampil Pop Up Alert Force Logout Klik Batal
Then Data Yang Dipilih Tidak Terhapus
When Tampil Pop Up Alert Force Logout Klik Ok
Then Data Yang Dipilih Terhapus Dan Logout Otomatis