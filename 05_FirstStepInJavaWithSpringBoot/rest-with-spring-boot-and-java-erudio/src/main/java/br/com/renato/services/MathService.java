package br.com.renato.services;

import br.com.renato.exceptions.UnsupportedMathOperationException;
import org.springframework.stereotype.Service;

@Service
public class MathService {

    public MathService() {
    }

    public double sum(String numberOne, String numberTwo) {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedMathOperationException("Please set a numeric value!");
        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }

    public double substraction(String numberOne, String numberTwo) {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedMathOperationException("Please set a numeric value!");
        return convertToDouble(numberOne) - convertToDouble(numberTwo);
    }

    public double multiply(String numberOne, String numberTwo) {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedMathOperationException("Please set a numeric value!");
        return convertToDouble(numberOne) * convertToDouble(numberTwo);
    }
    public double divide(String numberOne, String numberTwo) {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) throw new UnsupportedMathOperationException("Please set a numeric value!");
        return convertToDouble(numberOne) / convertToDouble(numberTwo);
    }
    public double average(String numberOne, String numberTwo, String numberThree) {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo) || !isNumeric(numberThree)) throw new UnsupportedMathOperationException("Please set a numeric value!");
        return (convertToDouble(numberOne) + convertToDouble(numberTwo) + convertToDouble(numberThree)) / 2;
    }
    public double squareRoot(String number) {
        if (!isNumeric(number)) throw new UnsupportedMathOperationException("Please set a numeric value!");
        return Math.sqrt(convertToDouble(number));
    }

    private boolean isNumeric(String strNumber) {
        if (strNumber == null) return false;
        String number = strNumber.replaceAll(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
    private Double convertToDouble(String strNumber) {
        if (strNumber == null) return 0D;
        String number = strNumber.replaceAll(",", ".");
        return isNumeric(number) ? Double.parseDouble(number) : 0D;
    }

}
