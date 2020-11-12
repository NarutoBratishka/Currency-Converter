package ru.alexeySekatskiy.mycurrencyconverter;

import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startEditPreferences();
    }

    public void startEditPreferences() {
        EditText firstMoneyText = (EditText)findViewById(R.id.first_money_text);
        firstMoneyText.setText("" + 120.5);
        EditText secondMoneyText = (EditText)findViewById(R.id.second_money_text);
        secondMoneyText.setText("" + 2.2);
    }

    public void hideKeyboard(View view) {
        InputMethodManager manager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        manager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public void changeCurrencyActivity(View view) {
        Intent intent = new Intent(MainActivity.this, ProgressWindow.class);
        startActivity(intent);
    }

//    public void TEMP_ACTION(View view) {
//        setContentView(R.layout.activity_progress_window);
//    }
    
}