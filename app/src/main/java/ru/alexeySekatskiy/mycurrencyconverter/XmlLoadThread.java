package ru.alexeySekatskiy.mycurrencyconverter;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class XmlLoadThread implements Runnable {
    private static volatile StringBuffer stringB = new StringBuffer("");

    @Override
    public void run() {
        stringB.replace(0, stringB.length(), "");

        try {
            URL url = new URL("http://www.cbr.ru/scripts/XML_daily.asp");
            BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                stringB.append(inputLine);
            }
            in.close();
            Thread.currentThread().interrupt();
        } catch (IOException e) {
            e.printStackTrace();
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
