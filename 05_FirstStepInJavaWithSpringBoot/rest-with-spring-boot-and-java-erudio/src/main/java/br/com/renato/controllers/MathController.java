package br.com.renato.controllers;

import br.com.renato.exceptions.UnsupportedMathOperationException;
import br.com.renato.services.MathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.DecimalFormat;

@RestController
public class MathController {

//    private static AtomicLong counter = new AtomicLong();

    @Autowired
    public static final MathService mathService = new MathService();

    @RequestMapping(value = "/{operator}/{numberOne}")
    public Double mathOperation(@PathVariable("operator") String operator, @PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        switch (operator) {
            case "sum" -> {
                return mathService.sum(numberOne, numberTwo);
            }
            case "subtraction" -> {
                return mathService.subtraction(numberOne, numberTwo);
            }
            case "divide" -> {
                return mathService.divide(numberOne, numberTwo);
            }
            case "multiply" -> {
                return mathService.multiply(numberOne, numberTwo);
            }
            case "sqrt" -> {
                return mathService.squareRoot(numberOne);
            }
        }
        return 0D;
    }

    @RequestMapping(value = "/average/{numberOne}/{numberTwo}/{numberThree}", method = RequestMethod.GET)
    public Double average(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo, @PathVariable("numberThree") String numberThree) throws Exception {
        return mathService.average(numberOne, numberTwo, numberThree);
    }
}
