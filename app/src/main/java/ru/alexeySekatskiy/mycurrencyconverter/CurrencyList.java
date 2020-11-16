package ru.alexeySekatskiy.mycurrencyconverter;

import android.support.annotation.NonNull;

import java.util.Arrays;
import java.util.Iterator;

public class CurrencyList implements Iterable<CurrencyBucket> {
    static int size = 0;
    int iteratorIteration = 0;
    static CurrencyBucket[] valute = new CurrencyBucket[16];



    static void add(CurrencyBucket bucket) {
        if (size >= valute.length - 1) {
            CurrencyBucket[] temp = new CurrencyBucket[size * 2 + 1];
            temp = Arrays.copyOf(valute, size);
            valute = temp;
        }
        valute[size++] = bucket;
    }

    static CurrencyBucket get(int index) {
        return valute[index];
    }

    @NonNull
    @Override
    public Iterator<CurrencyBucket> iterator() {
        return new Iterator<CurrencyBucket>() {

            @Override
            public boolean hasNext() {
                return iteratorIteration <= size;
            }

            @Override
            public CurrencyBucket next() {
                return CurrencyList.get(iteratorIteration++);
            }
        };
    }
}
