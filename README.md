# GOTIQUE - Batik Classification

- [Batik Classification](#batik-classification)
  - [Deskripsi Aplikasi](#deskripsi-aplikasi)
  - [Cara Menjalankan Aplikasi](#cara-menjalankan-aplikasi)
  - [Arsitektur Aplikasi](#arsitektur-aplikasi)
  - [Dataset](#dataset)
  - [Model Deep Learning](#model-deep-learning)
  - [Proses Training dan Testing](#proses-training-dan-testing)
  - [Analisis Model dan Hasil Evaluasi](#analisis-model-dan-hasil-evaluasi)
  - [Link Project Google Colab](#link-project-google-colab)
  

## Deskripsi Aplikasi
GOTIQUE merupakan sebuah aplikasi android yang dapat membantu user untuk mengetahui jenis batik secara langsung melalui kamera handphone. Jenis batik yang dapat diklasifikasikan adalah Batik Bali, Batik Betawi, Batik Celup, Batik Cendrawasih, Batik Dayak, Batik Geblek Renteng, Batik Insang, Batik Kawung, Batik Lasem, Batik Mega Mendung, Batik Pala, Batik Parang, Batik Poleng, Batik Sekar Jagad, dan Batik Tambal. Aplikasi ini memungkinkan user untuk dapat mengetahui jenis batik dengan berbagai cara, seperti memfoto batik melalui kamera, mengupload foto batik dari handphone, maupun mengarahkan kamera handphone ke batik untuk mengetahui jenis batik secara real-time.

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


**Contoh data gambar yang ada di dataset:**

![Screenshot 2022-12-20 220222](https://user-images.githubusercontent.com/79390341/208685034-086cdb66-e826-446d-9661-d5a4f676d589.png)


## Penjelasan Algoritma

### Algoritma EffiecienNet-B0
####    EfficientNet merupakan salah satu arsitektur pada Convolutional Neural Network (CNN) yang dikembangkan oleh tim Google Brain. EfficientNet menggunakan model scaling, yaitu melakukan penskalaan pada model [1] dengan menggabungkan skala lebar (penambahan jumlah feature map pada layer), kedalaman (penambahan jumlah layer CNN), dan resolusi (meningkatkan resolusi input image) yang disebut sebagai compound scaling yang bertujuan untuk memperbaiki performa model [2]. Penskalaan ini menyebabkan EfficientNet tidak memerlukan kebutuhan komputasi sebanyak yang dibutuhkan CNN konvensional, sehingga dapat menghasilkan nilai akurasi yang lebih baik [3]. Pada penelitian ini, kami menggunakan EfficientNet-B0 yang merupakan baseline model dari arsitektur EfficientNet. Selain itu, menurut [4] arsitektur EfficientNet-B0 dipilih karena memiliki jumlah parameter yang paling sedikit, sehingga memiliki waktu training yang lebih cepat dibandingkan dengan arsitektur EfficientNet yang lain. Berikut merupakan gambaran dari EfficientNet.

![image](https://user-images.githubusercontent.com/80681345/208693996-b46fcd99-b9c0-49cb-92ef-9ed0e744c5dd.png)



### Algoritma VGG16
#####     VGG16 Merupakan hasil pengembangan dari Alexnet, dimana arsitektur ini berfokus pada memperbanyak proses fitur ekstraksi pada layer convolution sehingga mampu mendapatkan representasi citra yang banyak untuk dapat di klasifikasikan. VGG16 memiliki total layer 16 yaitu 13 layer convolution dan 3 layer fully connected. VGG16 menggunakan konsep blok untuk membentuk convolution layer yang masing-masing convolution layer nya memiliki ukuran 3 x 3 dan stride 1. Pada akhir blok, digunakan max pooling layer dengan ukuran 2 x 2 dan stride 2.

![image](https://user-images.githubusercontent.com/83971650/208709474-ac6d88d0-d590-4ec5-8f5c-5e8651c921b7.png)



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

## Link Project Google Colab
#### Model EfficientNet: https://colab.research.google.com/drive/1kkSOZAMV9-g_MxRymMSrJpJq8MqvNPzf?usp=sharing

#### Model VGG-16: https://colab.research.google.com/drive/1tkgMsX13exbPDHwE9NQFviZSuUoKtL4r?usp=sharing
