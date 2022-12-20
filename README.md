# batik_classification
Model deep learning ini dirancang untuk melakukan klasifikasi terhadap gambar batik. Batik diklasifikasikan berdasarkan jenisnya. 

Jenis Batik : Batik Bali, Batik Betawi, Batik Celup, Batik Cendrawasih, dll 

Percobaan model EfficientNet: https://colab.research.google.com/drive/1kkSOZAMV9-g_MxRymMSrJpJq8MqvNPzf?usp=sharing

Percobaan model VGG-16: https://colab.research.google.com/drive/1tkgMsX13exbPDHwE9NQFviZSuUoKtL4r?usp=sharing


# Batik Classification

- [Batik Classification](#batik-classification)
  - [Deskripsi Aplikasi](#deskripsi-aplikasi)
  - [Arsitektur Aplikasi](#arsitektur-aplikasi)
  - [Dataset](#dataset)
  - [Algoritma CNN](#algoritma-cnn)
  - [Proses Training dan Testing](#proses-training-dan-testing)
  - [Analisis Model dan Hasil Evaluasi](#analisis-model-dan-hasil-evaluasi)
  - [Cara Menjalankan Aplikasi](#cara-menjalankan-aplikasi)


## Deskripsi Aplikasi
Aplikasi Gotique merupakan aplikasi android yang dapat menentukan jenis batik secara langsung melalui kamera handphone. Jenis batik yang dapat diklasifikasi adalah Batik Bali, Batik Betawi, Batik Celup, Batik Cendrawasih, Batik Dayak, Batik Geblek Renteng, Batik Insang, Batik Kawung, Batik Lasem, Batik Mega Mendung, Batik Pala, Batik Parang, Batik Poleng, Batik Sekar Jagad, Batik Tambal. 

## Arsitektur Aplikasi

## Dataset
Dataset yang digunakan adalah dataset gambar batik yang dikumpulkan manual dari google image yang terdiri 15 jenis batik. Berikut dapat dilihat 15 jenis batik tersebut pada tabel di bawah:

No | Nama Batik | Jumlah Gambar | 
| - | ---------- | -- |
| 1 | Batik Bali | 50 |
| 2 | Batik Betawi | 50 |
| 3 | Batik Celup | 95 |
| 4 | Batik Cendrawasih | 49 |
| 5 | Batik Dayak | 77 |
| 6 | Batik Geblek Renteng | 59 |
| 7 | Batik Insang | 50 |
| 8 | Batik Kawung | 50 |
| 9 | Batik Lasem | 50 |
| 10 | Batik Megamedung | 50 |
| 11 | Batik Pala | 50 |
| 12 | Batik Parang | 50 |
| 13 | Batik Poleng | 69 |
| 14 | Batik Sekar Jagad | 69 |
| 15 | Batik Tambal | 76 |
| | **TOTAL**  | 894 |

## Penjelasan Algoritma

### Algoritma EffiecienNetB0

### Algoritma VGG16

#### Definisi Algoritma VGG16

##### VGG16 memiliki total layer 16 yaitu 13 layer convolution dan 3 layer fully connected. VGG16 menggunakan konsep blok untuk membentuk convolution layer yang masing-masing convolution layer nya memiliki ukuran 3 x 3 dan stride 1. Pada akhir blok, digunakan max pooling layer dengan ukuran 2 x 2 dan stride 2.


## Proses Training dan Testing

## Analisis Model dan Hasil Evaluasi

## Cara Menjalankan Aplikasi
#### Klasifikasi gambar dengan kamera
1) Klik tombol kamera pada halaman utama aplikasi, maka akan muncul tampilan kamera.

![image](https://user-images.githubusercontent.com/82147780/208564417-00e9cf52-c87a-4b51-8679-f97e0b43367a.png)

2) Ambil gambar batik, kemudian klik OK.

![image](https://user-images.githubusercontent.com/82147780/208564392-d59cd093-0abb-4109-b2e9-c267e1114854.png)
![image](https://user-images.githubusercontent.com/82147780/208564380-93fe4635-d6f7-4fe2-b061-60ebcac25d41.png)

3) Gambar batik, hasil klasifikasi, dan nilai confidence kemudian akan ditampilkan pada halaman utama aplikasi.

![image](https://user-images.githubusercontent.com/82147780/208564337-4033383a-367e-40eb-afe8-2d7dabd46946.png)


#### Klasifikasi gambar melalui galeri
1) Klik tombol galeri pada halaman utama aplikasi, maka akan muncul galeri.

![image](https://user-images.githubusercontent.com/82147780/208564313-7cd98672-b61c-4518-990d-ee9e5735f715.png)

2) Pada galeri, pilih salah satu gambar batik yang ingin diklasifikasi

![image](https://user-images.githubusercontent.com/82147780/208564299-89fbe2e7-2487-4819-86e9-8bef715c8657.png)

3) Gambar batik, hasil klasifikasi, dan nilai confidence kemudian akan ditampilkan pada halaman utama aplikasi.

![image](https://user-images.githubusercontent.com/82147780/208564280-922ff79d-579f-4243-a9ca-da8fe29175b3.png)


#### Klasifikasi gambar secara real-time
1) Klik tombol live pada halaman utama aplikasi, maka akan muncul tampilan kamera.

![image](https://user-images.githubusercontent.com/82147780/208564270-6f4df162-c2a1-4051-aa7f-c2f26bfb0ce7.png)

2) Arahkan kamera ke objek batik, maka akan muncul teks hasil klasifikasi batik dan nilai confidence pada bagian bawah kamera.

![image](https://user-images.githubusercontent.com/82147780/208564228-04466f27-f546-48f8-bb94-d22a52c0cc05.png)
