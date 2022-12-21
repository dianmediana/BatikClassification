# GOTIQUE - Batik Classification


# Anggota Kelompok 4
1. I Nengah Arya Tri Putrawan   (1905551016)
2. Putu Reza Faby Yolanda       (1905551025)
3. Luh Kade Devi Dwiyani        (1905551097)
4. Ketut Mediana Ayu Candrayani (1905551098)
5. Ni Made Tara Okta Adriana    (1905551101) 



- [Batik Classification](#batik-classification)
  - [Deskripsi Aplikasi](#deskripsi-aplikasi)
  - [Cara Menjalankan Aplikasi](#cara-menjalankan-aplikasi)
  - [Arsitektur Aplikasi](#arsitektur-aplikasi)
  - [Dataset](#dataset)
  - [Model Deep Learning](#model-deep-learning)
  - [Proses Training dan Testing](#proses-training-dan-testing)
  - [Analisis Model](#analisis-model)
  - [Link Project Google Colab](#link-project-google-colab)
  - [Daftar Pustaka](#daftar-pustaka)
  

## Deskripsi Aplikasi
GOTIQUE merupakan sebuah aplikasi berbasis android yang dapat membantu user untuk mengetahui jenis batik secara langsung melalui kamera handphone. Jenis batik yang dapat diklasifikasikan adalah Batik Bali, Batik Betawi, Batik Celup, Batik Cendrawasih, Batik Dayak, Batik Geblek Renteng, Batik Insang, Batik Kawung, Batik Lasem, Batik Mega Mendung, Batik Pala, Batik Parang, Batik Poleng, Batik Sekar Jagad, dan Batik Tambal. Aplikasi ini memungkinkan user untuk dapat mengetahui jenis batik dengan berbagai cara, seperti memfoto batik melalui kamera, mengupload foto batik dari galeri, maupun mengarahkan kamera handphone ke batik untuk mengetahui jenis batik secara real-time.

## Cara Menjalankan Aplikasi
![tutor gotique](https://user-images.githubusercontent.com/82147780/208751397-b2604aa0-6b76-48df-b1ea-194a2c29d9c5.png)


## Arsitektur Aplikasi

![image](https://user-images.githubusercontent.com/80681345/208809017-d7cc660c-cd2a-46c0-87b5-5415d9452cd8.png)

Gambar di atas merupakan arsitektur dari aplikasi Gotique. Model yang digunakan adalah EfficientNet yang dibuat menggunakan bahasa pemrograman Python. Selanjutnya, model tersebut akan di-convert dalam bentuk TFLITE dengan menggunakan TensorFlow Lite agar dapat digunakan pada aplikasi mobile. Kemudian, model dalam bentuk TFLITE tersebut akan diimplementasikan pada project android yang telah dimiliki, sehingga menghasilkan sebuah aplikasi android yang mampu melakukan klasifikasi jenis-jenis batik.

## Dataset
Dataset yang digunakan adalah dataset gambar batik yang dikumpulkan secara manual dari google image yang terdiri dari 15 jenis batik, yaitu Batik Bali, Batik Betawi, Batik Celup, Batik Cendrawasih, Batik Dayak, Batik Geblek Renteng, Batik Insang, Batik Kawung, Batik Lasem, Batik Mega Mendung, Batik Pala, Batik Parang, Batik Poleng, Batik Sekar Jagad, dan Batik Tambal. Adapun total keseluruhan dataset batik yang dimiliki adalah 894 images. Berikut merupakan rincian jumlah masing-masing jenis batik yang digunakan.

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


**Contoh data gambar yang ada pada dataset**

![Screenshot 2022-12-20 220222](https://user-images.githubusercontent.com/79390341/208685034-086cdb66-e826-446d-9661-d5a4f676d589.png)


## Model Deep Learning
### Algoritma EffiecientNet
EfficientNet merupakan salah satu arsitektur pada Convolutional Neural Network (CNN) yang dikembangkan oleh tim Google Brain. EfficientNet menggunakan model scaling, yaitu melakukan penskalaan pada model [1] dengan menggabungkan skala width (penambahan jumlah feature map pada layer), depth (penambahan jumlah layer CNN), dan resolusi (meningkatkan resolusi input image) yang disebut sebagai compound scaling yang bertujuan untuk memperbaiki performa model [2]. Penskalaan ini menyebabkan EfficientNet tidak memerlukan kebutuhan komputasi sebanyak yang dibutuhkan CNN konvensional, sehingga dapat menghasilkan nilai akurasi yang lebih baik [3]. Pada project ini, kami menggunakan EfficientNet-B0 yang merupakan baseline model dari arsitektur EfficientNet. Selain itu, menurut [4] arsitektur EfficientNet-B0 dipilih karena memiliki jumlah parameter yang paling sedikit, sehingga memiliki waktu training yang lebih cepat dibandingkan dengan arsitektur EfficientNet yang lain. Berikut merupakan arsitektur dari EfficientNet.

![image](https://user-images.githubusercontent.com/80681345/208716364-30d8bde6-c4e0-4c2d-b4a2-e8ad13709e3c.png)

Gambar di atas menunjukkan bahwa arsitektur EfficientNet-B0 terdiri dari beberapa layer. Layer pertama adalah Convolutional Layer dengan input size sebesar 224 x 224. Lalu, dilanjutkan dengan Mobile Bottlenect Convolutional Layer yang terdiri dari 7 blok. 

### Algoritma VGG16
VGG16 Merupakan hasil pengembangan dari Alexnet, di mana arsitektur ini berfokus pada memperbanyak proses fitur ekstraksi pada layer convolution, sehingga mampu mendapatkan representasi citra yang banyak untuk dapat diklasifikasikan. VGG16 memiliki total layer 16, yaitu 13 layer convolution dan 3 layer fully connected. VGG16 menggunakan konsep blok untuk membentuk convolution layer yang masing-masing convolution layernya memiliki ukuran 3 x 3 dan stride 1. Pada akhir blok, digunakan max pooling layer dengan ukuran 2 x 2 dan stride 2. Berikut merupakan arsitektur dari VGG16.

![image](https://user-images.githubusercontent.com/83971650/208709474-ac6d88d0-d590-4ec5-8f5c-5e8651c921b7.png)


## Proses Training dan Testing
### Model EffiecientNet
#### Proses Training
**1. Data Training dan Data Testing**

Langkah pertama yang dilakukan adalah membagi dataset menjadi data training dan data testing untuk menguji performa model. Adapun jumlah data training adalah 785 images dan jumlah data testing adalah 139 images.

**2. Data Augmentation**

Data augmentation merupakan suatu teknik untuk melakukan modifikasi pada gambar asli dengan melakukan perubahan bentuk, sehingga mendapatkan data gambar yang baru. Adapun data augmentation bertujuan untuk meningkatkan jumlah data pada dataset.

![image](https://user-images.githubusercontent.com/80681345/208754042-04f0b885-3b50-4ead-a65b-0397c1b3c9fc.png)

Output Data Augmentasi:
- Training sebanyak 770 images
- Test sebanyak 124 images

Penjelasan Data Augmentasi:
- shear_range=0.2, artinya menggeser citra searah jarum jam dengan pergeseran sebanyak 0.2 derajat.
- rotation_range=30, artinya memutar gambar dengan sudut 30 derajat secara acak.
- zoom_range=0.2, artinya memperbesar citra dengan perbesaran sebanyak 1+0.2 dari luas gambar.
- width_shift_range=0.2, artinya menggeser gambar secara horizontal (kiri atau kanan).
- height_shift_range=0.2, artinya menggeser gambar secara vertical (atas atau bawah).
- horizontal_flip=True, artinya membalik gambar secara horizontal.
- vertical_flip=True artinya membalik gambar secara vertical.

Contoh data augmentation

![image](https://user-images.githubusercontent.com/80681345/208732642-e538ed73-dfaa-44ae-88cd-60710296bb92.png)

**3. Implementasi Model**

Pengimplementasian algoritma EfficientNet diawali dengan pembuatan base model yang selanjutnya digabungkan dengan beberapa layer seperti pada gambar di bawah ini.

![image](https://user-images.githubusercontent.com/80681345/208745112-f111fccc-cf33-4e87-bf1b-1360a2850f4d.png)

Penjelasan:
- input_shape=(224, 224, 3), artinya mengatur size input gambar sebesar 224x224.
- pooling='avg', artinya menggunakan global averange pooling sebagai output blok convolutional terakhir.
- Dense(64, activation='relu'), artinya menggunakan dense layer sebanyak 64 units dengan akstivasi relu.
- Dropout(0.2), artinya menerapkan dropout ke input yang akan menonaktifkan 20% hidden units secara acak.
- Dense(15, activation='softmax'), artinya menggunakan dense layer dengan softmax activation function untuk prediksi akhir sebanyak 15 kelas.

**4. Evaluasi Model**

Setelah model dibuat, langkah selanjutnya adalah melakukan evaluasi pada kinerja model seperti gambar berikut.

![image](https://user-images.githubusercontent.com/80681345/208734548-5d95563d-00a4-48e2-b2f9-1be8076c64b2.png)

Penjelasan:
- optimizer=Adam(learning_rate=1e-4), artinya menggunakan optimizer adam dengan learning rate 0.0001.
- loss='categorical_crossentropy', artinya menggunakan categorical crossentropy loss function karena memiliki unit lebih dari 2
- metrics=['accuracy'], artinya menggunakan metrik accuracy untuk melihat ketepatan model dalam melakukan klasifikasi.
- shuffle=True, artinya masing masing batch pada generator diacak sehingga data tidak akan urut.
- epochs=50, artinya mengatur banyaknya iterasi yang digunakan oleh model sebanyak 50.

#### Proses Testing

![image](https://user-images.githubusercontent.com/80681345/208745606-6df5c75d-bb4a-4f8e-8ecc-4c7f432c4463.png)

![image](https://user-images.githubusercontent.com/80681345/208745702-9f9f59a8-d9c3-4d11-9c2d-aee81403286c.png)

Dari proses training model yang telah dibuat, adapun hasil yang didapatkan adalah sebagai berikut.
- loss        : 0.6583
- accuracy    : 0.8026
- val_loss    : 0.7288
- val_accuray : 0.7903

### Model VGG 16
#### Proses Training
1. Data Training dan Data Testing

Langkah pertama yang dilakukan adalah membagi dataset menjadi data training dan data testing untuk menguji performa model. Adapun jumlah data training adalah 785 image dan jumlah data testing adalah 139 image.

2. Data Augmentation

Data augmentation merupakan suatu teknik untuk melakukan modifikasi pada gambar asli dengan melakukan perubahan bentuk, sehingga mendapatkan data gambar yang baru. Adapun data augmentation bertujuan untuk meningkatkan jumlah data pada dataset.

![image](https://user-images.githubusercontent.com/83971650/208741863-e82d7eec-9b27-4369-a667-0aa4b0d3c52c.png)

Output Data Augmentasi:
- Training sebanyak 770 images
- Test sebanyak 124 images

Penjelasan Data Augmentasi:
- vgg16.preprocess_input, digunakan pada preprocess gambar untuk penggunaan model VGG16.
- shear_range=0.2, artinya menggeser citra searah jarum jam dengan pergeseran sebanyak 0.2 derajat.
- rotation_range=30, artinya memutar gambar dengan sudut 30 derajat secara acak.
- zoom_range=0.2, artinya memperbesar citra dengan perbesaran sebanyak 1+0.2 dari luas gambar.
- width_shift_range=0.2, artinya menggeser gambar secara horizontal (kiri atau kanan).
- height_shift_range=0.2, artinya menggeser gambar secara vertical (atas atau bawah).
- horizontal_flip=True, artinya membalik gambar secara horizontal.
- vertical_flip=True artinya membalik gambar secara vertical.

**Contoh data augmentation**

![image](https://user-images.githubusercontent.com/83971650/208742991-d68a03e7-f165-4518-a7ab-0c1cb8a8a7c0.png)

3. Implementasi Model

Pengimplementasian algoritma VGG16 diawali dengan pembuatan base model yang selanjutnya digabungkan dengan beberapa layer seperti pada gambar di bawah ini.

![image](https://user-images.githubusercontent.com/83971650/208743732-4e04308c-1646-4f3d-bab1-e3d286b32282.png)

Penjelasan :

- input shape = (224, 224, 3) artinya mengatur ukuran input sebesar 224x224.
- model sequential = digunakan untuk memproses input berurutan.
- model.add(base_model) = menambahkan arsitektur model VGG16.
- base_model.trainable = melakukan freeze layer untuk menghindari pre-trained weight terupdate.
- GlobalAveragePooling2D = menambahkan global average pooling layer.
- Dense(units=64, activation='relu') = menggunakna dense layer sebanyak 64 units dengan aktivasi relu.
- Dropout(0.2), menerapkan dropout ke input yang akan menonaktifkan 20% hidden units secara acak.
- Dense(units=15, activation='softmax'), artinya menggunaknan dense layer denagn softmax activation function untuk prediksi akhir sebanyak 15 kelas.

4. Evaluasi Model

Setelah model dibuat, langkah selanjutnya adalah melakukan evaluasi pada kinerja model seperti gambar berikut.

![image](https://user-images.githubusercontent.com/83971650/208749698-9e660355-2576-484b-8b07-f2ec9b261f03.png)

Penjelasan :
- optimizer=Adam(learning_rate=0.0001), artinya menggunakan optimizer adam dengan learning rate 0.0001.
- loss='categorical_crossentropy', artinya menggunakan categorical crossentropy loss function karena memiliki unit lebih dari 2.
- metrics=['accuracy'], artinya menggunakan metrik accuracy untuk melihat ketepatan model dalam melakukan klasifikasi.
- epochs=50, artinya mengatur banyaknya iterasi yang digunakan oleh model sebanyak 50.

## Analisis Model

Adapun perbandingan antara model EfficientNet dan model VGG16 adalah sebagai berikut.

Metrics | EfficientNet | VGG16 | 
| - | ---------- | -- |
| loss | 0.6583 |  |
| accuracy | 0.8026 |  |
| val_loss | 0.7288 |  |
| val_accuracy | 0.7903 |  |


## Link Project Google Colab
#### Model EfficientNet: https://colab.research.google.com/drive/1kkSOZAMV9-g_MxRymMSrJpJq8MqvNPzf?usp=sharing

#### Model VGG-16: https://colab.research.google.com/drive/1tkgMsX13exbPDHwE9NQFviZSuUoKtL4r?usp=sharing

## Daftar Pustaka
[1]	N. Azahro Choirunisa, T. Karlita, and R. Asmara, “Deteksi Ras Kucing Menggunakan Compound Model Scaling Convolutional Neural Network,” Technomedia J., vol. 6, no. 2, pp. 236–251, 2021, doi: 10.33050/tmj.v6i2.1704.

[2]	G. Kim and C. Lee, “Convolutional Neural Network Using Convolutional Neural Network,” Springer, vol. 2644, no. 2, pp. 747–749, 2016, [Online]. Available: https://link.springer.com/chapter/10.1007/978-1-4842-2845-6_6

[3]	I. N. Alam, “METODE TRANSFER LEARNING PADA DEEP CONVOLUTIONAL NEURAL NETWORK ( DCNN ) UNTUK PENGENALAN EKSPRESI WAJAH METODE TRANSFER LEARNING PADA DEEP CONVOLUTIONAL NEURAL NETWORK ( DCNN ),” no. October, 2022.

[4]	S. A. Sabrina and W. F. Al Maki, “Klasifikasi Penyakit Pada Tanaman Kopi Robusta Berdasarkan Citra Daun Menggunakan Convolutional Neural Network,” eProceedings …, vol. 9, no. 3, pp. 1919–1927, 2022, [Online]. Available: https://openlibrarypublications.telkomuniversity.ac.id/index.php/engineering/article/view/17997%0Ahttps://openlibrarypublications.telkomuniversity.ac.id/index.php/engineering/article/download/17997/17626

