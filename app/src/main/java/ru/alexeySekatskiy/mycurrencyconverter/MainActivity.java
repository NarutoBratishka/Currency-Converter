package ru.alexeySekatskiy.mycurrencyconverter;

import android.content.Context;
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

}