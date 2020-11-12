package ru.alexeySekatskiy.mycurrencyconverter;

import java.util.Arrays;
import java.util.List;

public class XmlCurrencyParser {
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



    public XmlCurrencyParser() {
        this.textXml = XmlLoadThread.getData().replaceFirst("<.*>\\n<.*>\\n<.*>\\n", "");
        valutes = Arrays.asList(textXml.split("</Valute>\n" +
                "<Valute ID=\"\\w{6}\">\n" +
                "<NumCode>\\d{3}</NumCode>\n"));
    }

    void parseText() {
        for (String lines: valutes) {
            String[] param = lines.split("\n");
//            TODO:
        }
    }


    private String charCode(String[] param) {
        String tagValue =
            param[0].substring(
                opCharCode.length(), param[0].indexOf(clCharCode));
        return tagValue;
    }


    private double value(String[] param) {
        int nominal =
                Integer.parseInt(
                    param[1].substring(
                            opNominal.length(), param[1].indexOf(clNominal)));

        double curValue =
                Double.parseDouble(
                        param[3].substring(
                            opValue.length(), param[3].indexOf(clValue)));
        return curValue/nominal;
    }


    private String name(String[] param) {
        String tagValue =
                param[2].substring(
                        opName.length(), param[2].indexOf(clName));
        return tagValue;
    }
}
