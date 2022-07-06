Feature: User Admin Mengakses Menu Form Report Tarik Data

Scenario: User Admin Mengklik Button Support Form Report Tarik Data
When User Admin klik Button Collapse Akan menutup Data table Form Report Tarik Data

Scenario: User Admin Tidak Memilih Filter List Kategori Dan Pilih Tanggal
When User Admin Tidak Memilih Filter List Kategori Dan Pilih Tanggal
Then Tampil Text Error The Kategori field is required Dan The tanggal field is required
And Button Generate Report Tidak Tampil

Scenario: User Admin Memilih Filter List Kategori Dan Pilih Tanggal
When User Admin Memilih Filter List Kategori Dan Pilih Tanggal
Then Tampil Button Generate Report 
And File Terdownload Berupa Format Excel
