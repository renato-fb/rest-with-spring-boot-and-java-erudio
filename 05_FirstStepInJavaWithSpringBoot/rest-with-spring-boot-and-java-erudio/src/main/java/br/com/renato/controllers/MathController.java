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

    @RequestMapping(value = "/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        return mathService.sum(numberTwo, numberTwo);
    }

    @RequestMapping(value = "/subtraction/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double subtraction(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        return mathService.substraction(numberTwo, numberTwo);
    }

    @RequestMapping(value = "/multiply/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double multiply(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        return mathService.multiply(numberTwo, numberTwo);
    }

    @RequestMapping(value = "/divide/{numberOne}/{numberTwo}", method = RequestMethod.GET)
    public Double divide(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
        return mathService.divide(numberTwo, numberTwo);
    }

    @RequestMapping(value = "/average/{numberOne}/{numberTwo}/{numberThree}", method = RequestMethod.GET)
    public Double average(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo, @PathVariable("numberThree") String numberThree) throws Exception {
        return mathService.average(numberTwo, numberTwo, numberThree);
    }

    @RequestMapping(value = "/sqrt/{number}", method = RequestMethod.GET)
    public Double squareRoot(@PathVariable("number") String number) throws Exception {
        return mathService.squareRoot(number);
    }
}
