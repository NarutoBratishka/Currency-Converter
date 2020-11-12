package ru.alexeySekatskiy.mycurrencyconverter;

import android.Manifest;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;

public class ProgressWindow extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_window);
//        ActivityCompat.requestPermissions(ProgressWindow.this,
//                new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission. INTERNET},
//                1);
    }

    public void tempShowHere(View view) throws Exception {

        TextView tempText = (TextView) findViewById(R.id.tempElementID);
        tempText.setText(ConnectHandler.getString());
    }
}