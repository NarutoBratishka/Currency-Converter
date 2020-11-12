package ru.alexeySekatskiy.mycurrencyconverter;

import java.util.Arrays;

public class CurrencyList {
    int size = 0;
    CurrencyBucket[] valute;

    public CurrencyList(int size) {
        valute = new CurrencyBucket[size];
    }

    private CurrencyList() {
        valute = new CurrencyBucket[16];
    }

    private void add(CurrencyBucket bucket) {
        if (size >= this.valute.length - 1) {
            CurrencyBucket[] temp = new CurrencyBucket[size * 2 + 1];
            Arrays.copyOf(this.valute, size);
            valute = temp;
        }
        valute[size++] = bucket;
    }

    private CurrencyBucket get(int index) {
        return valute[index];
    }
}
