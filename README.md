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

## Tutorial 4
### What I have learned today
Pada tutorial ini, saya belajar bagaimana menggunakan Fragment yang merupakan sebuah fitur dalam Thymeleaf yang dapat menggunakan source code secara berulang pada halaman html. Saya juga belajar cara menghandle error yang lebih baik dengan membuat folder error berisi html sesuai dengan error yang akan ditangkap.

1. Jelaskan perbedaan th:include dan th:replace!
th:include dan th:replace adalah bentuk dari host tag yang akan mengimplementasikan bentuk fragment yang disediakan oleh Thymeleaf.
th:replace akan menggantikan host tag dengan fragment sehingga posisi host tag akan sepenuhnya diubah dengan fragment, termasuk fragment tagnya.
th: include akan memasukkan atau menambahkan fragment yang ditentukan pada body dari host tag, tetapi tidak termasuk fragment tagnya.

2. Jelaskan apa fungsi dari th:object!
th: digunakan untuk menyediakan URL dari form. th:object digunakan untuk menentukan objek yang akan diikat pada suatu form. th:object menampung object yang berasal dari controller. th:object mereferensikan model yang merepresentasikan state dari form yang dibuat.

3. Jelaskan perbedaan dari * dan $ pada saat penggunaan th:object! Kapan harus dipakai?
* dan $ sama-sama digunakan untuk melakukan variable expression. Perbedaannya yaitu * tidak digunakan untuk melakukan expression pada keseluruhan dari variable maps, melainkan hanya pada selected object. Jika tidak terdapat selected object, maka fungsi dari * dan $ sama.

4. Bagaimana kamu menyelesaikan latihan nomor 3?
Untuk menyelesaikan latihan nomor 3, saya melakukan passing data dari html ke fragment Thymeleaf. Saya mengimplementasikan penggunaan fragment dengan atribut th::text pada elemen HTML dengan expression ${NamaPage}. Setelah itu saya mendefinisikan NamaPage dengan penggunaan th:replace pada halaman HTML yang diisi dengan judul halaman HTML tersebut.

## Tutorial 5
### What I have learned today
Pada tutorial kali ini, saya belajar bagaimana cara kerja dari Web Service. Saya juga mempelajari bagaimana cara menggunakan postman, dan membuat mock server beserta fungsi dan kegunaannya.

1. Apa itu Postman? Apa kegunaannya?
Postman adalah sebuah develompent tool API yang dapat digunakan untuk melakukan proses develompent API. Postman juga dapat digunakan untuk melakukan build, test, desain, mock, debug, testing, memonitor, menyimpan HTTP request, dan menampilkan API pada suatu tempat.

2. Jelaskan fungsi dari anotasi @JsonIgnoreProperties dan @JsonProperty.
@JsonIgnoreProperties digunakan pada tingkat kelas untuk menandai properti atau daftar properti yang akan diabaikan @JsonIgnoreProperties memiliki elemen yaitu allowGetters, allowSetters, ignoreUnknown, dan value. Nilai elemen di @JsonIgnoreProperties menentukan nama properti yang akan diabaikan.
@JsonProperty adalah anotasi marker untuk mendefinisikan logical propety. @JsonProperty dapat dianotasi dengan metode setter atau getter non-static atau non-static ob. Logical property digunakan dalam serialisasi dan de-serialisasi JSON.

3. Apa kegunaan atribut WebClient?
RestServiceImpl memanfatkan atribut WebClient untuk menerima dan mengirimkan dari resource URI menggunakan akses yang diberikan dalam WebRequest Class.

4. Apa itu ResponseEntity dan BindingResult? Apa kegunaannya?
ResponseEntity adalah perwakilan dari seluruh respons HTTP. ResponseEntity digunakan untuk mengontrol apapun yang masuk ke dalam bagian HTTP seperti kode status, header, dan body.
BindingResult adalah objek Spring yang digunakan untuk menyimpan hasil validasi dan pengikatan yang berisi kesalahan yang terjadi. BindingResult menentukan bagaimana objek yang menyimpan hasil validasi harus menyimpan dan mengambil hasil validasi.

## Tutorial 6
### What I have learned today
Pada tutorial kali ini, saya belajar bagaimana menambahkan security pada suatu website. Saya belajar bagaimana fitur login dan logout bekerja, dan bagaimana untuk menyimpan data-data yang boleh atau tidak boleh dilihat oleh user tertentu.

1. Jelaskan secara singkat perbedaan Otentikasi dan Otorisasi! Di bagian mana (dalam kode yang telah anda
buat) konsep tersebut diimplementasi?
Otentifikasi merupakan proses untuk melakukan verifikasi yang menentukan apakah user yang ingin login dengan username tersebut telah terdaftar di dalam database.
Berikut adalah cotoh kode implementasi dari otentifikasi:
    pada class WebSecurityConfig:
    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userDetailsService).passwordEncoder(encoder());}
Otorisasi berfungsi untuk mengetahui hak terhadap suatu user yang menentukan apakah user tersebut memiliki akses atau dapat melakukan perubahan terhadap halaman tertentu yang sudah diotentifikasi.
Berikut adalah cotoh kode implementasi dari otorisasi:
    pada class WebSecurityConfig:
        .antMatchers("/css/**").permitAll()
        .antMatchers("/js/**").permitAll()
        .antMatchers("/resep/**").hasAnyAuthority("APOTEKER")
        .antMatchers("/obat/**").hasAnyAuthority("APOTEKER")
    pada html:
        sec:authorize="hasAuthority('ADMIN')"
        sec:authorize="hasAuthority('APOTEKER')"

2. Apa itu BCryptPasswordEncoder? Jelaskan secara singkat cara kerjanya!
BCryptPasswordEncoder adalah algoritma hash password default untuk OpenBSD dan sistem lain. BCryptPasswordEncoder berfungsi untuk melakukan encrypt password user sebelum disimpan ke database. BCryptPasswordEncoder melakukan enkripsi data password yang diinput oleh user sehingga password yang terlihat pada database merupakan password yang sudah dienkripsi.

3. Jelaskan secara singkat apa itu UUID beserta penggunaannya!
UUID adalah kode identifikasi unik yang digenerate oleh sistem berbentuk 32 karakter string yang dibuat secara acak dengan algoritma tertentu. UUID berguna untuk meningkatkan keamanan dari data user karena id yang digenerate secara unik aman dan sulit untuk diretas.

4. Apa kegunaan class UserDetailsServiceImpl.java? Mengapa harus ada class tersebut padahal kita sudah memiliki class UserServiceImpl.java?
class UserDetailsServiceImpl.java digunakan untuk mengambil informasi otentikasi dan otorisasi user. Hal ini dilakukan agar Spring Boot Security dapat melakukan otorisasi terhadap user yang melakukan login sesuai dengan role yang telah terdaftar pada database.

## Tutorial 7
### What I have learned today
Pada tutorial kali ini saya mempelajari lebih banyak bagaimana menggunakan react.js dan mengaplikasikannya untuk membuat fungsi dan fitur.

1. Jelaskan apa yang Anda lakukan di latihan dalam satu paragraf per-soal. Berikan screenshot sebagai ilustrasi
dari apa yang Anda jelaskan.
Pada latihan nomor 1, saya menambahkan type pada input sehingga bersifat hidden ketika tidak dalam status 'checked'. Ketika input berstatus 'checked', maka checkbox akan ditampilkan.
screenshot: https://ibb.co/nLKThQf

Pada latihan nomor 2, saya menambahkan function yang digunakan untuk menghandle event onClick yang mengubah array favItems menjadi kosong bernama deleteAll. Kemudian saya membuat tombol Delete All Favorites yang memiliki kondisi ketika favItems kosong, maka tombol tersebut tidak ditampilkan.
screenshot: https://ibb.co/gtCTrtS

Pada latihan nomor 3, saya membuat method bernama handleFavoriteClick yang berfungsi untuk menghapus item dari favItems dengan method .splice. Pada function handleItemClick, saya juga membuat agar list film pada bagian kiri tidak dapat digunakan untuk menghilangkan list favorite, melainkan hanya dapat menambahkannya saja.
screenshot: https://ibb.co/6D5CMVC

Pada latihan nomor 4, saya membuat toggle button yang digunakan untuk mengontrol state yang berisi boolean. State ini akan menentukan apakah list dari film favorit ditampilkan atau tidak. Saya memberikan fungsi toggleFavorite() yang mengubah isi dari state.
screenshot: https://ibb.co/374t43w

Pada latihan nomor 5, saya membuat component yang bernama EmptyState dan membuat variable let untuk menyimpan komponen tersebut. Setelah itu saya memberikan kondisi dimana variable itu akan dilemparkan dengan keberadaan {emptyState} jika tidak terdapat item favorit.
screenshot: https://ibb.co/dkz82xd

2. Menurut pemahaman kamu selama pengerjaan tutorial ini, apa perbedaan antara state dan props?
State merupakan data yang berubah secara konstan dengan perilaku program. Contoh dari state yang diterapkan di tutorial ini adalah pada favItems. favItems akan berubah sesuai dengan penambahan ataupun pengurangan item yang di klik pada daftar list favitems.
Props adalah parameter dalam suatu functional component. Jika suatu component berbentuk class, maka prop merupakan property dari classnya. Prop digunakan untuk komunikasi antar parent dan childnya. Contoh props pada tutorial ini adalah item pada function handleItemClick = item

3. Apa keuntungan menggunakan component (e.g. List, Item) di React? Berikan contohnya!
Keuntungan menggunakan component (e.g. List, Item) adalah komponen bersifat reusable. Setiap komponen memiliki logika sendiri untuk mengontrol proses renderingnya,tidak perlu menggunakan this dan tidak perlu melakukan bind. Contohnya adalah ketika memisahkan komponen list dan item. List digunakan untuk mengelola list film favourite, sedangkan item digunakan untuk mengelola list film. dengan memisahkan keduanya, code dapat menjadi lebih rapih.

4. Menurut kamu, apa saja kelebihan menggunakan React dalam pengembangan web?
Menggunakan react memiliki banyak keuntungan dalam mengembangkan sebuah web. Komponen yang digunakan menjadi reusable, proses rendering akan lebih cepat karena adanya virtual DOM, terdapat developer toolset untuk pengimplementasian yang lebih mudah, SEO friendly, dan masih banyak lagi.

5. Menurut kamu, apa saja kekurangan menggunakan React dalam pengembangan web?
Menurut saya, kekurangan dari menggunakan React adalah beberapa browser dengan versi yang sudah lama tidak compatible sehingga harus menggunakan extension, ReactJS hanya mencakup lapisan dari User Interface, dan bahasa pemrograman yang terasa lebih sulit jika tidak pernah menggunakannya.

## Tutorial 8
### What I have learned today
Pada tutorial kali ini saya belajar bagaimana menghubungkan backend dengan frontend. Saya belajar melakukan refactor aplikasi HaiDokter menggunakan ReactJS dengan fitur yang sudah ada pada backend.

1. Ceritakan langkah - langkah yang kalian lakukan untuk solve LATIHAN no.1, dan mengapa kalian melakukan langkah - langkah tersebut?
Pada latihan pertama, saya melakukan setstate yang membuat value dari namaDokter, namaPasien, dan catatan menjadi kosong. Saya menambahkan beberapa baris pada kode event handleCancel menjadi seperti berikut.

handleCancel(event) {
        event.preventDefault();
        this.setState({  
            namaDokter: "",
            namaPasien: "",
            catatan: "",
            isCreate: false, 
            isEdit: false });
    }

Hal tersebut membuat value dari setiap form field tersebut kembali seperti sebelum diisi.


2. Jelaskan fungsi dari async dan await!
Async membuat suatu fungsi menjadi asynchronus. Hal ini berfungsi untuk secara otomatis mengembalikan sebuah return value berupa objek dengan bentuk atau tipe Promise.
Await memberi tahu program untuk keluar secara sementara dari fungsi async, kemudian menjalankan langkah-langkah selanjutnya.
Untuk dapat menggunakan await, fungsi tersebut harus ditandai dengan keyword async.

3. Masukkan jawaban dari Screenshot yang diperintahkan di halaman 8 pada Component Lifecycle pada pertanyaan ini.
![alt text](https://i.ibb.co/syS4WzN/3.png)
![alt text](https://i.ibb.co/WpwjD2Q/8.png)
![alt text](https://i.ibb.co/pW7GtLM/axios-8.png)
![alt text](https://i.ibb.co/12B6XCH/axios-12.png)
![alt text](https://i.ibb.co/54J9gT2/axios-13.png)

4. Jelaskan fungsi dari componentDidMount, shouldComponentUpdate, componentDidUpdate, componentWillReceiveProps, componentWillUnmount.

componentDidMount: Berfungsi untuk menandakan tahap akhir dari mounting lifecycle yang dipanggil setelah HTML yang dilakukan render telah selesai melakukan loading. Fungsi ini dipanggil saat HTML selesai melakukan rendering dan dapat juga digunakan ketika React ingin mengambil data dari aplikasi eksternal. Use case: Request data dari API

shouldComponentUpdate: Berfungsi untuk menentukan apakah sebuah component akan di render kembali atau tidak. Fungsi ini dipanggil saat terdapat komponen yang diperbarui setelah berjalannya method componentWillReceiveProps tetapi sebelum proses rendering html dilakukan. Use case: Ketika ingin mengubah komponen dan melakukan rendering ulang terhadap setiap state yang berubah

componentDidUpdate: Berfungsi untuk memanipulasi DOM data request data. Dipanggil saat suatu instance pada suatu komponen melakukan update dan ketika HTML yang dilakukan proses render telah selesai melakukan loading. Use case: Melakukan update pada komponen

componentWillReceiveProps: Berfungsi untuk memberi tahu React jika akan ada perubahan pada komponen yang memiliki props. Fungsi ini dipanggil saat suatu instance pada suatu komponen melakukan update dan sebelum proses rendering dimulai. Use case: Melakukan reset state

componentWillUnmount: Berfungsi untuk melakukan pembersihan yang diperlukan pada method. Fungsi ini dipanggil ketika komponen telah dihapus dari DOM. Use case: Menghilangkan timer yang sebelumnya didefinisikan pada componentDidMount