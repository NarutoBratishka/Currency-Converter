package ru.alexeySekatskiy.mycurrencyconverter;

import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class XmlLoadThread implements Runnable {
    private static volatile StringBuffer stringB = new StringBuffer("");
    private static final String TAG = "XmlLoadThread";

    @Override
    public void run() {
        stringB.replace(0, stringB.length(), "");

        try {
            URL url = new URL("http://www.cbr.ru/scripts/XML_daily.asp");
            InputStream is = (url.openStream());
            InputStreamReader isr = new InputStreamReader(is, "windows-1251");
            BufferedReader reader = new BufferedReader(isr);

            String input;
            while ((input = reader.readLine()) != null) {
                stringB.append(input);
                Log.i(TAG, input);
            }

            reader.close();
            Thread.currentThread().interrupt();
        } catch (IOException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }

    public static String getData() {
        Thread current = new Thread(new XmlLoadThread());
        current.start();

        while (!current.isInterrupted()) {

        }
        return stringB.toString();
    }
}
