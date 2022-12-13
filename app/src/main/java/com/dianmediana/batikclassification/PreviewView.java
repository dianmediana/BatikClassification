package com.dianmediana.batikclassification;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.Preview;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.common.util.concurrent.ListenableFuture;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

public class PreviewView extends AppCompatActivity {

    View previewView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preview_view);
        getSupportActionBar().hide();

        previewView = findViewById(R.id.previewView);

//        ListenableFuture<ProcessCameraProvider> cameraProviderFuture = ProcessCameraProvider.getInstance(this);
//        cameraProviderFuture.addListener(() -> {
//            try {
//                ProcessCameraProvider cameraProvider = cameraProviderFuture.get();
//                startCameraX(cameraProvider);
//            } catch (ExecutionException | InterruptedException e) {
//                e.printStackTrace();
//            }
//        }, getExecutor());
    }

//    Executor getExecutor() {
//        return ContextCompat.getMainExecutor(this);
//    }
//
//    @SuppressLint("RestrictedApi")
//    private void startCameraX(ProcessCameraProvider cameraProvider) {
//        cameraProvider.unbindAll();
//        CameraSelector cameraSelector = new CameraSelector.Builder()
//                .requireLensFacing(CameraSelector.LENS_FACING_BACK)
//                .build();
//        Preview preview = new Preview.Builder()
//                .build();
//        preview.setSurfaceProvider(previewView.getSurfaceProvider());
//
////        // Image capture use case
////        imageCapture = new ImageCapture.Builder()
////                .setCaptureMode(ImageCapture.CAPTURE_MODE_MINIMIZE_LATENCY)
////                .build();
////
////        // Video capture use case
////        videoCapture = new VideoCapture.Builder()
////                .setVideoFrameRate(30)
////                .build();
//
//        // Image analysis use case
//        ImageAnalysis imageAnalysis = new ImageAnalysis.Builder()
//                .setBackpressureStrategy(ImageAnalysis.STRATEGY_KEEP_ONLY_LATEST)
//                .build();
//
//        imageAnalysis.setAnalyzer(getExecutor(), this);
//
//        //bind to lifecycle:
////        cameraProvider.bindToLifecycle((LifecycleOwner) this, cameraSelector, preview, imageCapture, videoCapture);
//    }
//
//    @Override
//    public void analyze(@NonNull ImageProxy image) {
//        // image processing here for the current frame
//        Log.d("TAG", "analyze: got the frame at: " + image.getImageInfo().getTimestamp());
//        image.close();
//    }
}