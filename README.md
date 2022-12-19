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
  - [How to Run Application](#how-to-run-application)


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

##### VGG16 memiliki total layer 16 yaitu 13 layer convolution dan 3 layer fully connected. VGG16 menggunakan konsep blok untuk membentuk Convolution layer yang masing-masing convolution layer nya memiliki ukuran 3 x 3 dan stride 1. Pada akhir blok, digunakan max pooling layer dengan ukuran 2 x 2 dan stride 2.


## Proses Training dan Testing

## Analisis Model dan Hasil Evaluasi

## How to Run Application
