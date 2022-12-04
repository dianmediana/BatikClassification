package com.dianmediana.batikclassification;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

import org.w3c.dom.Text;

public class SplashActivity extends AppCompatActivity {

    TextView appname;
    ImageView splashimg, logo;
    LottieAnimationView lottieAnimationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        appname = findViewById(R.id.app_name);
        splashimg = findViewById(R.id.background);
        logo = findViewById(R.id.logo);

        splashimg.animate().translationY(-2500).setDuration(1500).setStartDelay(5000);
        appname.animate().translationY(2000).setDuration(1500).setStartDelay(5000);
        logo.animate().translationY(1500).setDuration(1500).setStartDelay(5000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
            }
        },3000);
    }
}