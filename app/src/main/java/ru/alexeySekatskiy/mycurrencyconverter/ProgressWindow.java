package ru.alexeySekatskiy.mycurrencyconverter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class ProgressWindow extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_window);

//        if (CurrencyList.size == 0) { ////
            new XmlCurrencyParser().parseText();
//        }

        Intent intent = new Intent(ProgressWindow.this, CurrencySelectionDialog.class);
        startActivity(intent);

        //TODO:
//        onDestroy();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }

    public void tempShowHere(View view) {
        finish();
        setContentView(R.layout.activity_progress_window);
//        Intent intent = new Intent(ProgressWindow.this, CurrencySelectionDialog.class);
//        startActivity(intent);
    }
}
