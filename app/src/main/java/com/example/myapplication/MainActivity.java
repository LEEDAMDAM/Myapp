package com.example.myapplication;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

public class MainActivity extends AppCompatActivity {

    Handler mHandler = new Handler();
    Runnable r = new Runnable() {
        @Override
        public void run() {
            Intent i = new Intent(MainActivity.this, MainActivity2.class);

            startActivity(i);
            finish();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    protected void onResume() {
        super.onResume();

        mHandler.postDelayed(r,3000);

    }
    protected void onPause(){
        super.onPause();

        mHandler.removeCallbacks(r);
    }
}
