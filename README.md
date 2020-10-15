# Tutorial APAP

## Authors

* **Jacob Marulitua Ido Situmorang** - **1806185361** - **APAP - B**

## Tutorial 1
### What I have learned today
Sebelum melakukan tutorial in, saya belum tahu bagaimana cara menggunakan Spring. Saya mempelajari dalam menggunakan Spring kita juga memiliki model dan controller, mirip dengan penggunaan dari Django. Saya juga baru mencoba untuk run aplikasi yang dibuat dengan extension dari Spring, bukan dari terminal.

### Github
1. Apa itu Issue Tracker? Apa saja masalah yang dapat diselesaikan dengan Issue Tracker?
Issue tracker adalah package software komputer yang melacak masalah yang ada. Tujuannya agar masalah dapat dilacak dengan mudah dan dapat diperbaiki. Banyak hal yang dapat diselesaikan oleh Issue tracker, contohnya bug, masalah duplikasi program, dokumentasi, error and request, dan masih banyak lagi. 

2. Apa perbedaan dari git merge dan git merge --squash?
Kegunaan dari git merge adalah untuk menggabungkan branch-branch yang bercabang menjadi 1 branch. Demikian juga dengan git merge --squash, perbedaannya adalah di commit dan jumlah parent. Pada git merge --squash, commit yang ada dari branch yang berbeda digabungkan menjadi satu yang bernama squash, hal tersebut membuat history yang lebih simple. Jumlah parent pada git merge adalah 2, sedangkan pada git merge --squash hanya memiliki 1 parent.

3. Apa keunggulan menggunakan Version Control System seperti Git dalam pengembangan suatu
aplikasi?
Version Control System dapat memungkinkan kita untuk membandingkan file, mengidentifikasi perbedaan, dan menggabungkan perubahan jika diperlukan sebelum memasukkan kode apa pun. Keuntungannya adalah dapat bekerja secara offline, proses pengembangan software menjadi lebih cepat, perubahan tetap disimpan jadi dapat kembali ke perubahan sebelumnya jika terjadi masalah, dan masih banyak lagi.

### Spring
4. Apa itu library & dependency?
Library adalah kumpulan dari suatu fungsi atau kode yang dapat dipanggil dalam suatu program untuk tujuan tertentu. Library dapat diakses dengan mudah sehingga memudahkan untuk pembuatan sebuah aplikasi.
Dependency adalah ketergantungan atau keterikatan antara suatu class dengan class lainnya.

5. Mengapa kita menggunakan Maven? Apakah ada alternatif dari Maven?
Maven adalah sebuah project management tool yang mempunyai aturan-aturan untuk menyeragamkan tim. Maven berguna untuk membangun struktur yang baik agar project berjalan dengan lancar. Beberapa alternatif dari maven yaitu CMake, GNU Make, Gradle, Scons, dan masih banyak lagi.

6. Selain untuk pengembangan ​web,​ apa saja yang bisa dikembangkan dengan Spring ​framework​?
Spring framework memiliki banyak kegunaan. Selain untuk pengembangan web, Spring framework dapat digunakan untuk testing, akses data, big data, mengembangkan aplikasi-aplikasi enterprise, manajemen transaksi, dan big data. Spring framework juga dikembangkan untuk aplikasi web berbasis MVC.

7. Apa perbedaan dari @RequestParam dan @PathVariable? Kapan sebaiknya menggunakan
@RequestParam atau @PathVariable?
Fungsi dari @PathVariable adalah untuk mengekstrak nilai dari URI. @PathVariable berguna untuk website dengan framework RESTful. Sedangkan fungsi dari @RequestParam adalah untuk mendapatkan parameter dari URI atau disebut juga dengan parameter query.

### What I did not understand
-[]Apa yang membedakan pertimbangan penggunaan dari Spring dan Django? Apakah ada keuntungan jika memakai Spring?


## Tutorial 2
### What I have learned today
Pada hari ini saya sudah lumayan terbiasa untuk memakai Spring dalam lab ini. Saya sudah mencoba untuk mengimplementasikan fitur-fitur yang saya buat pada controller dari aplikasi ini. Saya juga membuat html baru yang fungsinya memberi tahu user jika suatu fungsi sudah berhasil dilakukan seperti update catatan dan delete resep. Semua itu terhubung kepada database yaitu list dari resep itu sendiri sehingga jika dicek pada view all resep, maka resep tersebut sudah terupdate atau terhapus.

### Pertanyaan pada tutorial
1. Cobalah untuk menambahkan sebuah resep dengan mengakses link berikut:
http://localhost:8080/resep/add?noResep=1&namaDokter=Papa%20APAP&namaPasien=Quanta%20F
asilkom&catatan=Semangat
Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi
Saat membuka link tersebut, terjadi error yang meminta referensi dari template "add-resep". Pada controller, fungsi memanggil halaman "add-resep" yang menjadi template, tetapi template tersebut belum dibuat sehingga terjadi error ketika membuka halaman tersebut. Yang harus kita lakukan untuk memperbaiki masalah tersebut adalah membuat template yang bernama "add-resep.html" sehingga fungsi pada controller dapat memanggil template yang sudah dibuat.

2. Menurut kamu anotasi @Autowired pada class Controller tersebut merupakan
implementasi dari konsep apa? Dan jelaskan secara singkat cara kerja @Autowired tersebut dalam
konteks service dan controller yang telah kamu buat
Anotasi @Autowired memberikan kontrol yang lebih baik terhadap autowiring. Anotasi @Autowired bisa digunakan untuk melakukan autowire bean pada class seperti @Repository, @Servire, @Controller, dan @Component. @Autowired akan melakukan inisialisasi terhadap class tersebut, dan lalu mengisi (inject) semua kebutuhannya (dependency). Untuk injection ini, kita juga tidak perlu lagi menyediakan setter method maupun menambahkan argumen di constructor.

3. Cobalah untuk menambahkan sebuah resep dengan mengakses link berikut:
http://localhost:8080/resep/add?noResep=1&namaDokter=Papa%20APAP&namaPasien=Quanta%20F
asilkom Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi
Saat saya mengakses link tersebut, muncul halaman error yang bertuliskan "Whitelabel Error Page". Hal ini disebabkan oleh kurangnya atribut yang dibutuhkan untuk menambahkan resep. Pada controller, fitur menambahkan resep memerlukan atribut "catatan" yang tidak ada pada link tersebut sehingga ketika diakses, terjadi error.

4. Jika Papa APAP ingin melihat resep untuk pasien yang bernama Quanta, link apa yang
harus diakses?
Pada program ini tidak ada fitur yang dapat melihat resep dengan menggunakan nama pasien. Jika Papa APAP sudah tahu nomor resep dari pasien Quanta (misalnya 1), maka Papa APAP dapat mengakses link "http://localhost:8080/resep/view/no-resep/1". Tetapi jika Papa APAP tidak mengetahui nomor resep dari pasien Quanta, maka Papa Apap harus mencarinya melewati http://localhost:8080/resep/viewall yang akan menampilkan semua resep dan mencarinya pada halaman itu.

5. Tambahkan 1 contoh resep lainnya sesukamu. Lalu cobalah untuk mengakses
http://localhost:8080/resep/viewall , apa yang akan ditampilkan? Sertakan juga bukti screenshotmu.
Saya menambahkan sebuah resep dengan data sebagai berikut:
Nomor Resep: 2
Nama Dokter: Pasti Pasti
Nama Pasien: Jacob Situmorang
Catatan: Mantap
Resep tersebut saya tambahkan dengan link berikut "http://localhost:8080/resep/add?noResep=2&namaDokter=Pasti%20Pasti&namaPasien=Jacob%20Situmorang&catatan=Mantap". Setelah mengakses halaman view all resep, tampilan halaman tersebut sebagai berikut. Link gambar: (https://ibb.co/LPSNnJM)

### What I did not understand
-[]Apakah untuk membuat fitur dari fungsi program ini hanya dapat dilakukan didalam control? Atau ada cara lain untuk memodifikasi data yang ada?
-[]Apa yang membedakan pertimbangan penggunaan dari Spring dan Django? Apakah ada keuntungan jika memakai Spring?

## Tutorial 3
### What I have learned today
Hari ini saya mempelajari bagaimana membuat suatu database dengan XAMPP. Saya juga belajar pengolahan data dari database sehingga data dapat dimodifikasi.

1. Pada class ObatDb, terdapat method findByNoResep, apakah kegunaan dari method tersebut?
Method findByNoResep pada class ObatDb berguna untuk mencari record atau data resep yang berada pada database sesuai dengan NoResep yang sudah diberikan. Method ini dibuat secara otomatis oleh Springboot karena Spring Data akan menanalisis semua metode yang didefinisikan oleh interface dan akan mencoba untuk menghasilkan query pada method terkait ketika Spring Data membuat sebuah @Repository baru.

2. Pada class ResepController, jelaskan perbedaan method addResepFormPage dan addResepSubmit?
Method addResepFormPage digunakan untuk mengakses halaman untuk pendaftaran resep baru yang akan mengembalikan atau menampilkan html dari method tersebut. Method addResepFormPage dipanggil saat browser melakukan REQUEST untuk mengakses url /resep/add. 
Method addResepSubmit digunakan untuk melakukan submit form yang ada pada halaman html dari url /resep/add. Method addResepSubmit mengambil data yang telah dimasukkan pada html form-add-resep, lalu data tersebut disimpan kedalam database. Method addResepSubmit dipanggil saat browser melakukan POST method.

3. Jelaskan kegunaan dari JPA Repository!
JPA Repository adalah sebuah spesifikasi yang terdiri atas API untuk menyimpan object ke dalam database relasional. JPA Repository akan melakukan pemetaan dari Java class ke dalam bentuk tabel relasional secara otomatis. JPA memiliki sebuah mapping subsystem untuk melakukan mapping antara class dengan relational table. JPA juga memiliki sebuah API EntityManager untuk mengakses objek, mendefinisikan dan mengeksekusikan query, dan lainnya. Developer akan lebih mudah untuk mengelola objek Java yang perlu dimasukkan kedalam database dengan menggunakan JPA Repository.

4. Sebutkan dan jelaskan di bagian kode mana sebuah relasi antara ResepModel dan ObatModel dibuat?
ResepModel menggunakan anotasi @OneToMany yang berguna untuk mendefinisikan relasinya dengan tabel Obat yang diikuti dengan 'List<ObatModel> listObat' sebagai implementasi terhadap Java Objects. ObatModel menggunakan anotasi @ManyToOne yang berguna untuk mendefinisikan relasinya dengan tabel Resep hang diikuti dengan 'ResepModel resepModel' sebagai implementasinya dengan Java Object. Kedua model ini memudahkan dalam hal pengelolaan objek karena relasi sudah didefinisikan.

5. Jelaskan kegunaan FetchType.LAZY, CascadeType.ALL, dan FetchType.EAGER!
FetchType.LAZY memuat seluruh data dari Java Objects yang direferensikan ke relational database (fetch) saat dibutuhkan atau saat data dipanggil (LAZY). FetchType.LAZY digunakan untuk relasi one-to-many atau many-to-one
CascadeType.ALL digunakan untuk memudahkan dalam melakukan operasi pada database dengan memberlakukan semua operasi yang dilakukan pada parent secara otomatis pada seluruh childnya.
FetchType.EAGER memuat seluruh data dari Java Objects yang direferensikan ke relational database (fetch) secara langsung. FetchType.EAGER digunakan untuk relasi many-to-one atau one-to-one