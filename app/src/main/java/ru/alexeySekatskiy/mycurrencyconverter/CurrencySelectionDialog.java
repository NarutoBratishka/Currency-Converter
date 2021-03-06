package ru.alexeySekatskiy.mycurrencyconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

public class CurrencySelectionDialog extends AppCompatActivity {

    private RecyclerView currencyListView;
    private CurrencyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(this.getClass().getSimpleName(), "До адаптера");  //////
        setContentView(R.layout.activity_currency_selection_dialog);

        currencyListView = findViewById(R.id.currency_list_view);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        currencyListView.setLayoutManager(layoutManager);

        currencyListView.setHasFixedSize(true);

        adapter = new CurrencyAdapter(this);
        currencyListView.setAdapter(adapter);
    }

    public void rubActivity(View view) {

    }
}