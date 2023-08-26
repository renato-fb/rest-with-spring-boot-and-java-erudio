package br.com.renato.math;

import br.com.renato.converters.NumberConverter;
import br.com.renato.exceptions.UnsupportedMathOperationException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class SimpleMath {


    public double sum(Double numberOne, Double numberTwo) {
        return numberOne + numberTwo;
    }
    public double subtraction(Double numberOne, Double numberTwo) {
        return numberOne - numberTwo;
    }
    public double multiply(Double numberOne, Double numberTwo) {
        return numberOne *numberTwo;
    }
    public double divide(Double numberOne, Double numberTwo) {
        return numberOne / numberTwo;
    }
    public double average(Double numberOne, Double numberTwo, Double numberThree) {
        return (numberOne + numberTwo + numberThree) / 2;
    }
    public double squareRoot(Double number) {
        return Math.sqrt(number);
    }
}
