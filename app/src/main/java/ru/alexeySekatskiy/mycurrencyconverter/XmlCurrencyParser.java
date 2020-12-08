package ru.alexeySekatskiy.mycurrencyconverter;

import android.util.Log;

import java.util.Arrays;
import java.util.List;

public class XmlCurrencyParser {
    private static final String PARSER_TAG = "XmlCP";
    private String textXml;
    private List<String> valutes;

    private final String opCharCode = "<CharCode>";
    private final String clCharCode = "</CharCode>";
    private final String opNominal = "<Nominal>";
    private final String clNominal = "</Nominal>";
    private final String opName = "<Name>";
    private final String clName = "</Name>";
    private final String opValue = "<Value>";
    private final String clValue = "</Value>";



    public XmlCurrencyParser() { /////конструтор в роли метода - исправить!
        this.textXml = XmlLoadThread.getData()
                .replaceFirst("<[\\.[^>]]*>(<[\\.[^>]]*>){3}\\d+<[\\.[^>]]*>", "")
                .replace("</Valute></ValCurs>", "");
        if (!XmlLoadThread.haveInetEx) {
            ///// add exception handler


            System.err.println(textXml);
//        Log.i(TAG, textXml);
            valutes = Arrays.asList(textXml.split("</Valute>" +
                    "<Valute ID=\"\\w*\">" +
                    "<NumCode>\\d{3}</NumCode>"));

            Log.e(this.getClass().getSimpleName(), "CurrencyList.clear();"); /////
            if (CurrencyList.valute[0] != null) CurrencyList.clear();
            CurrencyList.add(new CurrencyBucket("RUB", 1, "Рубль"));
        }
    }

    public void parseText() {
        if (!XmlLoadThread.haveInetEx) {
            for (String lines : valutes) {
//            TODO:
                Log.i(PARSER_TAG, lines);
                Log.e(PARSER_TAG, "???");
                String[] param = lines.split("</\\w+><\\w+>");

                CurrencyList.add(new CurrencyBucket(charCode(param), value(param), name(param)));
            }

//            CurrencyList.add(new CurrencyBucket("||||||||", 0, "    |||||||||||"));   ///////
        }
    }


    private String charCode(String[] param) {
        String tagValue =
                param[0].replace(opCharCode, "");
//                param[0].substring(
//                        opCharCode.length(), param[0].indexOf(clCharCode));
        return tagValue;
    }


    private double value(String[] param) {
        int nominal =
                Integer.parseInt(
                        param[1]);
//                        param[1].substring(
//                                opNominal.length(), param[1].indexOf(clNominal)));

        double curValue =
                Double.parseDouble(
                        param[3].replace(clValue, "")
                                .replace(',', '.'));
//                        param[3].substring(
//                                opValue.length(), param[3].indexOf(clValue)));
        return curValue/nominal;
    }


    private String name(String[] param) {
        String tagValue =
                param[2];
//                param[2].substring(
//                        opName.length(), param[2].indexOf(clName));
        return tagValue;
    }
}
