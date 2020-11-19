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
            CurrencyBucket[] newContainer;

            newContainer = copyFromPreviousBucketArray(valute);
            valute = newContainer;
        }
        valute[size++] = bucket;
    }

    private static CurrencyBucket[] copyFromPreviousBucketArray(CurrencyBucket[] valute) {
        CurrencyBucket[] newContainer = new CurrencyBucket[size * 2 + 1];
        int inc = 0;
        for (CurrencyBucket bucket: valute) {
            newContainer[inc++] = bucket;
        }

        return newContainer;
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
