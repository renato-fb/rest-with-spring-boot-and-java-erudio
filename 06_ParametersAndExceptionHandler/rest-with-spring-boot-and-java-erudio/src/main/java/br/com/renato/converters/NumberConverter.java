package br.com.renato.converters;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class NumberConverter implements Serializable {

    public static boolean isNumeric(String strNumber) {
        if (strNumber == null) return false;
        String number = strNumber.replaceAll(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
    public static Double convertToDouble(String strNumber) {
        if (strNumber == null) return 0D;
        String number = strNumber.replaceAll(",", ".");
        return isNumeric(number) ? Double.parseDouble(number) : 0D;
    }
}
