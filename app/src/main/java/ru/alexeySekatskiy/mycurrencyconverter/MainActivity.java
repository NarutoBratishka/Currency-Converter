package ru.alexeySekatskiy.mycurrencyconverter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements TextView.OnEditorActionListener {
    private static boolean rightSide = false;
    static CurrencyBucket firstValute;
    static CurrencyBucket secondValute;
    EditText firstEdit;
    EditText secondEdit;
    TextView firstTextView;
    TextView secondTextView;
    InputMethodManager manager/* = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE)*/;
    View viewValForKB;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new XmlCurrencyParser().parseText();

        firstValute = CurrencyList.get("RUB");
        secondValute = CurrencyList.get("EUR");
        firstTextView = findViewById(R.id.first_short_name);
        secondTextView = findViewById(R.id.second_short_name);
        firstEdit = (EditText) findViewById(R.id.first_money_text);
        firstEdit.setOnEditorActionListener(this); /////
        secondEdit = (EditText) findViewById(R.id.second_money_text);
        secondEdit.setOnEditorActionListener(this); /////

        firstEdit.setText("120.5");
        calculate(rightSide);
//        startEditPreferences();
    }

    @SuppressLint("DefaultLocale")
    public void calculate(boolean side) {
        if (!side) {
            double firstEditDigit = Double.parseDouble(String.valueOf(firstEdit.getText()));
            double firstSum = firstValute.getValue() *
                    firstEditDigit;

            double result = 0d;

            try {
                result = firstSum / secondValute.getValue();
            } catch (ArithmeticException e) {
                result = 0.0;
            }

            secondEdit.setText(String.format("%.2f", result).replace(',', '.'));
            firstEdit.setText(String.format("%.2f", firstEditDigit).replace(',', '.'));
        } else {
            double secondEditDigit = Double.parseDouble(String.valueOf(secondEdit.getText()));
            double secondSum = secondValute.getValue() *
                    secondEditDigit;

            double result = 0d;

            try {
                result = secondSum / firstValute.getValue();
            } catch (ArithmeticException e) {
                result = 0.0;
            }

            firstEdit.setText(String.format("%.2f", result).replace(',', '.'));
            secondEdit.setText(String.format("%.2f", secondEditDigit).replace(',', '.'));
        }
    }

    /*public void startEditPreferences() {
//        EditText firstMoneyText = (EditText)findViewById(R.id.first_money_text);
        firstMoneyText.setText("" + 120.5);
//        EditText secondMoneyText = (EditText)findViewById(R.id.second_money_text);
        secondMoneyText.setText("" + 2.2);
    }*/

    public void hideKeyboard(View view) {
        viewValForKB = view;  /////
        /*InputMethodManager */manager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        manager.hideSoftInputFromWindow(view.getWindowToken(), 0);
//        manager.isAcceptingText();
//        manager.restartInput();
        Toast.makeText(getBaseContext(), view.toString(), Toast.LENGTH_SHORT).show(); /////
        calculate(rightSide);
    }

    /*@Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_ENTER:
                hideKeyboard(viewValForKB);
                calculate(rightSide);
                break;

            default:
                calculate(rightSide);
                break;
        }

        return super.onKeyDown(keyCode, event);
    }*/

    public void changeCurrencyActivityLeft(View view) {
        MainActivity.rightSide = false;
        Intent intent = new Intent(MainActivity.this, ProgressWindow.class);
        startActivity(intent);
    }

    public void changeCurrencyActivityRight(View view) {
        MainActivity.rightSide = true;
        Intent intent = new Intent(MainActivity.this, ProgressWindow.class);
        startActivity(intent);
    }

    public static boolean isRightActivity() {
        return rightSide;
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if (v == firstEdit) {
            rightSide = false;
        } else if (v == secondEdit) {
            rightSide = true;
        }


        if (actionId == EditorInfo.IME_ACTION_DONE) {
//            hideKeyboard(viewValForKB);
            manager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            manager.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0);
            calculate(rightSide);
        } else {
            calculate(rightSide);
        }

        return true;
    }

    @Override
    protected void onResume() {
        super.onResume();
        firstTextView.setText(firstValute.getCharCode());
        secondTextView.setText(secondValute.getCharCode());
        calculate(rightSide);
    }

    //    public void TEMP_ACTION(View view) {
//        setContentView(R.layout.activity_progress_window);
//    }
    
}