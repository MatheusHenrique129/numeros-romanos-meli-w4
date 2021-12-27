package br.com.meli.w4.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import static java.lang.String.join;
import static java.util.Collections.nCopies;


@RestController
public class NumeroRomanosController {

    private static final int[] decimais = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] romanos = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    @GetMapping(path = "/numero/{numero}")
    public String numeroRomano(@PathVariable("numero") int numero) {

            StringBuilder resultado = new StringBuilder();

            for (int i = 0; i < decimais.length; i++) {

                int parteInteira = numero / decimais[i];
                numero -= decimais[i] * parteInteira;
                resultado.append(join("", nCopies(parteInteira, romanos[i])));
            }
            return "Em números romanos é " + resultado.toString();
    }
}