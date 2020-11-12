package ru.alexeySekatskiy.mycurrencyconverter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class ProgressWindow extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_window);

    }

    public void tempShowHere(View view) throws Exception {
        TextView tempText = (TextView) findViewById(R.id.tempElementID);
        tempText.setText(XmlLoadThread.getData());
    }
}


//
////        ActivityCompat.requestPermissions(ProgressWindow.this,
////                new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
////                1);
////
////        boolean ready = ConnectHandler.downloadXml();
////
//////        new Thread(new Runnable() {
//////            @Override
//////            public void run() {
//////                try {
//////                    BufferedReader reader = new BufferedReader(new FileReader("currency_file.xml"));
//////                    line = reader.readLine();
//////                    Thread.currentThread().interrupt();
//////                } catch (IOException e) {
//////                    e.printStackTrace();
//////                }
//////            }
//////        }).start();
//
//    }
//}