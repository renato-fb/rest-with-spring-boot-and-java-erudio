package br.com.renato.controllers;

import br.com.renato.converters.NumberConverter;
import br.com.renato.exceptions.UnsupportedMathOperationException;
import br.com.renato.math.SimpleMath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {

//    private static AtomicLong counter = new AtomicLong();

    private final SimpleMath simpleMath = new SimpleMath();

    @RequestMapping(value = "/{operator}/{numberOne}/{numberTwo}")
    public Double mathOperation(@PathVariable("operator") String operator, @PathVariable("numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo) throws Exception {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo))
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        switch (operator) {
            case "sum" -> {
                return simpleMath.sum(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
            }
            case "subtraction" -> {
                return simpleMath.subtraction(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
            }
            case "divide" -> {
                return simpleMath.divide(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
            }
            case "multiply" -> {
                return simpleMath.multiply(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));
            }
        }
        return 0D;
    }

    @RequestMapping(value = "/average/{numberOne}/{numberTwo}/{numberThree}", method = RequestMethod.GET)
    public Double average(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo, @PathVariable("numberThree") String numberThree) throws Exception {
        if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo) || !NumberConverter.isNumeric(numberThree))
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        return simpleMath.average(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo), NumberConverter.convertToDouble(numberThree));
    }

    @RequestMapping(value = "/sqrt/{numberOne}", method = RequestMethod.GET)

    public Double squareRoot(@PathVariable("numberOne") String numberOne) throws Exception {
        if (!NumberConverter.isNumeric(numberOne))
            throw new UnsupportedMathOperationException("Please set a numeric value!");
        return simpleMath.squareRoot(NumberConverter.convertToDouble(numberOne));

    }
}
