package com.dianmediana.batikclassification;


import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.Preview;
import androidx.camera.core.ViewPort;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.view.PreviewView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.dianmediana.batikclassification.ml.ModelDatasetbaruBaru;
import com.google.common.util.concurrent.ListenableFuture;

import org.tensorflow.lite.DataType;
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.concurrent.ExecutionException;

public class CameraActivity extends AppCompatActivity {


    private int REQUEST_CODE_PERMISSIONS = 1001;
    private final String [] REQUIRED_PERMISSIONS = new String []{Manifest.permission.CAMERA};

    PreviewView mPreviewView;
    TextView tvResults, tvConfidence;
    int imageSize = 224;
    ModelDatasetbaruBaru model;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);

        mPreviewView = findViewById(R.id.viewFinder);
        tvResults = findViewById(R.id.tvResults);
        try {
            model = ModelDatasetbaruBaru.newInstance(getApplicationContext());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.d("clasify", "hah");

        if (allPermissionsGranted()){
            startCamera();
        }
        else{
            ActivityCompat.requestPermissions(this, REQUIRED_PERMISSIONS,
                    REQUEST_CODE_PERMISSIONS);
        }
    }

    private void startCamera(){

        ListenableFuture<ProcessCameraProvider>
                cameraProviderFuture = ProcessCameraProvider.getInstance(this);
        cameraProviderFuture.addListener(
                new Runnable() {
                    @Override
                    public void run() {
                        try {
                            ProcessCameraProvider cameraProvider = cameraProviderFuture.get();
                            bindPreview(cameraProvider);
                        } catch (ExecutionException | InterruptedException e) { } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                },
                ActivityCompat.getMainExecutor(this)
        );
    }

    void bindPreview(ProcessCameraProvider cameraProvider) throws IOException {

        Preview preview = new Preview.Builder().build();
        preview.setSurfaceProvider(mPreviewView.getSurfaceProvider());

        @SuppressLint("UnsafeOptInUsageError")
        ViewPort viewPort = mPreviewView.getViewPort();

        if(viewPort !=null){
            CameraSelector cameraSelector = new CameraSelector.Builder().requireLensFacing(
                    CameraSelector.LENS_FACING_BACK).build();
            ImageAnalysis imageAnalysis =
                    new ImageAnalysis.Builder()
                            .setBackpressureStrategy(ImageAnalysis.STRATEGY_KEEP_ONLY_LATEST)
                            .build();

            imageAnalysis.setAnalyzer(ActivityCompat.getMainExecutor(this),
                    new ImageAnalysis.Analyzer() {
                        @Override
                        public void analyze(@NonNull ImageProxy image) {
                            String result = null;
                            @SuppressLint("UnsafeOptInUsageError")
                            Image img = image.getImage();

                            try {
                                result = classifyImage(img, model);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            tvResults.setText(result);
                            image.close();
                        }
                    });

            cameraProvider.unbindAll();
            cameraProvider.bindToLifecycle(this, cameraSelector,
                    preview, imageAnalysis);
        }

    }

    private String classifyImage(Image image, ModelDatasetbaruBaru model ) throws IOException {

        Bitmap img = Utils.toBitmap(image);
        img = Bitmap.createScaledBitmap(img, 224, 224, false);

        try {
            // Creates inputs for reference.
            TensorBuffer inputFeature0 = TensorBuffer.createFixedSize(new int[]{1, 224, 224, 3}, DataType.FLOAT32);
            ByteBuffer byteBuffer = ByteBuffer.allocateDirect(4 * imageSize * imageSize * 3);
            byteBuffer.order(ByteOrder.nativeOrder());

            int[] intValues = new int[imageSize * imageSize];
            img.getPixels(intValues, 0, img.getWidth(), 0, 0, img.getWidth(), img.getHeight());
            int pixel = 0;
            //iterate over each pixel and extract R, G, and B values. Add those values individually to the byte buffer.
            for (int i = 0; i < imageSize; i++) {
                for (int j = 0; j < imageSize; j++) {
                    int val = intValues[pixel++]; // RGB
                    byteBuffer.putFloat(((val >> 16) & 0xFF) * (1.f / 1));
                    byteBuffer.putFloat(((val >> 8) & 0xFF) * (1.f / 1));
                    byteBuffer.putFloat((val & 0xFF) * (1.f / 1));
                }
            }

//            inputFeature0.loadBuffer(byteBuffer);
            inputFeature0.loadBuffer(byteBuffer);
            // Runs model inference and gets result.
            ModelDatasetbaruBaru.Outputs outputs = model.process(inputFeature0);
            TensorBuffer outputFeature0 = outputs.getOutputFeature0AsTensorBuffer();
            float[] confidences = outputFeature0.getFloatArray();
            // find the index of the class with the biggest confidence.
            int maxPos = 0;
            float maxConfidence = 0;
            for (int i = 0; i < confidences.length; i++) {
                if (confidences[i] > maxConfidence) {
                    maxConfidence = confidences[i];
                    maxPos = i;
                }
            }
            String[] classes = {"Batik Bali", "Batik Betawi", "Batik Celup", "Batik Cendrawasih", "Batik Dayak", "Batik Geblek Renteng",
                    "Batik Insang", "Batik Kawung", "Batik Lasem", "Batik Megamendung", "Batik Pala", "Batik Parang",
                    "Batik Poleng", "Batik Sekar Jagad", "Batik Tambal"};

            // Releases model resources if no longer used.
            Log.d("clasify", classes[maxPos]);
            return classes[maxPos]  + " " + String.valueOf(String.format("%.2f", maxConfidence));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private boolean allPermissionsGranted(){
        for(String permission: REQUIRED_PERMISSIONS){
            if(ContextCompat.checkSelfPermission(
                    this, permission) != PackageManager.PERMISSION_GRANTED){
                return false;
            }
        }
        return true;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == REQUEST_CODE_PERMISSIONS) {
            if (allPermissionsGranted()) {
                startCamera();
            } else {
                Toast.makeText(this, "Please, give access to camera",
                        Toast.LENGTH_SHORT).show();
                this.finish();
            }
        }
    }
    @Override
    public void onBackPressed() {
        model.close();


    }
}