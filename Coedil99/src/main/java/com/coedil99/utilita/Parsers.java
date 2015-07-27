package com.coedil99.utilita;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Fabiano on 25/11/2014.
 */
public final class Parsers {

    private Parsers () {}

    public static String printItalianDate(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        return sdf.format(date);
    }

    public static int getNumbers(String str) {
        StringBuffer sBuffer = new StringBuffer();
        Pattern p = Pattern.compile("[0-9]+.[0-9]*|[0-9]*.[0-9]+|[0-9]+");
        Matcher m = p.matcher(str);
        while (m.find()) {
            sBuffer.append(m.group());
        }
        return Integer.parseInt(sBuffer.toString());
    }

    public static int getSingleNumber(final String str){
        final String onlyNumbers = str.replaceAll("[^0-9]", "");
        int a = (onlyNumbers.length() > 0 ? onlyNumbers.charAt(0) - '0' : -1);
        System.out.println(a);
        return a;
    }

    public static float getFloat(final String str){
        return Float.parseFloat(str);
    }

}
