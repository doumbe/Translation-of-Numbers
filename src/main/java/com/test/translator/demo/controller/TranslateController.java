package com.test.translator.demo.controller;

import com.test.translator.demo.entity.EnglishTranslate;
import com.test.translator.demo.entity.FrenchTranslate;
import com.test.translator.demo.repository.EnglishTranslateRepository;
import com.test.translator.demo.repository.FrenchTranslateRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TranslateController {

    private final Logger logger = LoggerFactory.getLogger(TranslateController.class);

    @Autowired
    private EnglishTranslateRepository englishTranslateRepo;
    @Autowired
    private FrenchTranslateRepository frenchTranslateRepo;

    @GetMapping("/englishTranslate")
    public String listAll(Model model) {
        List<EnglishTranslate> englishTranslateList = englishTranslateRepo.findAll();
        model.addAttribute("englishTranslateList", englishTranslateList);

        return "englishTranslate";
    }

    @GetMapping("/translate")
    public String toTranslate(@RequestParam("number") Integer number, @RequestParam("langue") String langue) {

        if (langue.equals("fr")) {
            List<FrenchTranslate> frenchTranslates = frenchTranslateRepo.getFrenchTranslateByNumber(number);
            if (!frenchTranslates.isEmpty()) {
                return frenchTranslates.get(0).getMessage();
            }
            return "Impossible de Traduire, Veuillez saisir un nombre entre 1 à 30";
        } else if (langue.equals("eng")) {
            List<EnglishTranslate> englishTranslate = englishTranslateRepo.getEnglishTranslateByNumber(number);
            if (!englishTranslate.isEmpty()) {
                return englishTranslate.get(0).getMessage();
            }
            return "Impossible de Traduire, Veuillez saisir un nombre entre 1 à 30";
        }
        // langue différent de français et anglais
        return "Impossible de Traduire, Veuillez choisir une langue gérée (Français / Anglais) !";
    }

}

