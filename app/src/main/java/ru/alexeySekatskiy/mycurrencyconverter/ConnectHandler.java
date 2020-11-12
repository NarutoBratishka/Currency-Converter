package ru.alexeySekatskiy.mycurrencyconverter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class ConnectHandler {
    static volatile StringBuilder stringBuilder = new StringBuilder();
    static Thread thread;

    public static String getString() {


        thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL("http://www.cbr.ru/scripts/XML_daily.asp");
                    BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

                    String inputLine;

                    while ((inputLine = in.readLine()) != null) {
                        stringBuilder.append(inputLine);
                    }

                    in.close();
                    thread.interrupt();
                } catch (IOException e) {
                    ConnectHandler.stringBuilder = stringBuilder.replace(0, stringBuilder.length(), "EXCEPTION");
                }
            }
        });
        thread.start();

        while (!thread.isInterrupted()) {

        }

        return stringBuilder.toString();
    }
}
