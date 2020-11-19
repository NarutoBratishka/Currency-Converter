package ru.alexeySekatskiy.mycurrencyconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class CurrencySelectionDialog extends AppCompatActivity {

    private RecyclerView currencyList;
    private CurrencyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency_selection_dialog);

        currencyList = findViewById(R.id.currency_list);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        currencyList.setLayoutManager(layoutManager);

        currencyList.setHasFixedSize(true);

        adapter = new CurrencyAdapter();
        currencyList.setAdapter(adapter);
    }

    public void rubActivity(View view) {

    }
}