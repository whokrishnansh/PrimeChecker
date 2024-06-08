package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PrimeCheckerController {

    @Autowired
    private PrimeService primeService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/check")
    public String checkPrime(@RequestParam("number") int number, Model model) {
        boolean isPrime = primeService.isPrime(number);
        model.addAttribute("number", number);
        model.addAttribute("isPrime", isPrime);
        return "index";
    }
}
