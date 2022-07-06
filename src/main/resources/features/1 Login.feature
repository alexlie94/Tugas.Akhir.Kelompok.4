Feature: User Admin Login Di Website Salesindo Recruitment

Scenario: Testing Login Field Kosong User Admin
Given User Admin Mengakses URL Salesindo Recruitment
When Username dan Password Field Kosong
Then Tampil Alert Username is Required & Password is Required

Scenario: Testing Login User Admin Tidak Terdaftar Atau Username & Password Salah
When User Login Dengan Username dan Password Data Tidak Terdaftar Atau Username & Password Salah
Then Menampilkan Notifikasi Username & Password Salah

Scenario: Testing Login User Admin Sudah Login Ditempat Lain
When User Login Dengan Username dan Password Data Sudah Login
Then Menampilkan Notifikasi User Sudah Pernah Login Ditempat Lain

Scenario: Testing Login User Admin Sudah Terdaftar
When User Login Dengan Username dan Password Data Sudah Terdaftar
Then User Berhasil Login Ke Dashboard Admin