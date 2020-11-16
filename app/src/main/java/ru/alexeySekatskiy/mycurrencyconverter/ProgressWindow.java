package ru.alexeySekatskiy.mycurrencyconverter;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ProgressWindow extends AppCompatActivity {
    Context themedContext = new ContextThemeWrapper(getBaseContext(), R.style.MyTextStyle);
    Context themedContext2 = new ContextThemeWrapper(getBaseContext(), R.style.MySecondTextStyle);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_progress_window);
        new XmlCurrencyParser().parseText();

        ConstraintLayout layout = (ConstraintLayout) findViewById(R.id.constr_layout_select);


        for (CurrencyBucket bucket: new CurrencyList()) {
            addContentView(new TextView(themedContext), layout.getLayoutParams());
            addContentView(new TextView(themedContext2), layout.getLayoutParams());
        }
        finish();
        setContentView(R.layout.activity_progress_window);
    }


//    int intIdName = 10, intIdChar = 15;
//    private TextView duplicateTextViewLeft(CurrencyBucket bucket) {
//        TextView textView = new TextView(findViewById(R.id.rub_name).getContext());
//        textView.setText(bucket.getName());
//        textView.setId(intIdName);
//        intIdName += 10;
//        textView.setLayoutParams(namePattern.getLayoutParams());
//        textView.setPadding(32, 16, 0, 16);
//        textView.setBackgroundColor(0xebebeb);
//        textView.setTextColor(Color.BLACK);
//        textView.setTextSize(24);
////        Formatter.BigDecimalLayoutForm.valueOf("ebebeb");
//        return textView;
//    }
//
//    private TextView duplicateTextViewRight(CurrencyBucket bucket) {
//        TextView textView = new TextView(findViewById(R.id.rub_char).getContext());
//        textView.setText(bucket.getCharCode());
//        textView.setId(intIdChar);
//        intIdChar += 10;
//        textView.setLayoutParams(charPattern.getLayoutParams());
//        textView.setPadding(8, 16, 0, 16);
//        textView.setBackgroundColor(0xebebeb);
//        textView.setTextAlignment(View.TEXT_ALIGNMENT_GRAVITY);
//        textView.setTextColor(Color.DKGRAY);
//        textView.setTextSize(24);
////        Formatter.BigDecimalLayoutForm.valueOf("ebebeb");
//        return textView;
//    }






//    public void tempShowHere(View view) throws Exception {
//        TextView tempText = (TextView) findViewById(R.id.tempElementID);
//        tempText.setText(XmlLoadThread.getData());
//    }

    public void tempShowHere(View view) {
        finish();
        setContentView(R.layout.activity_progress_window);
//        Intent intent = new Intent(ProgressWindow.this, CurrencySelectionDialog.class);
//        startActivity(intent);
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