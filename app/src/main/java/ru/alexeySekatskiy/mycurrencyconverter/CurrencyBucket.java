package ru.alexeySekatskiy.mycurrencyconverter;

import android.support.constraint.ConstraintLayout;
import android.text.Layout;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CurrencyBucket {
    private String charCode;
    private double value;
    private String name;
//    ConstraintLayout layout = (ConstraintLayout)f(R.layout.activity_currency_selection_dialog);
//    EditText ttt = (EditText)findViewById(R.id.first_money_text);

    public CurrencyBucket(String charCode, double value, String name) {
        this.charCode = charCode;
        this.value = value;
        this.name = name;


    }

    public String getCharCode() {
        return charCode;
    }

    public void setCharCode(String charCode) {
        this.charCode = charCode;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
