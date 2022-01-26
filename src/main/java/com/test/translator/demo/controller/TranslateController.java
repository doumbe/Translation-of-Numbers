package com.test.translator.demo.controller;

import com.test.translator.demo.entity.LanguageTranslate;
import com.test.translator.demo.repository.LanguageTranslateRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/translate")
public class TranslateController {

    private final Logger logger = LoggerFactory.getLogger(TranslateController.class);

    @Autowired
    private LanguageTranslateRepository languageTranslateRepo;

    @GetMapping("/languageTranslate")
    public String listAll(Model model) {
        List<LanguageTranslate> languageTranslateList = languageTranslateRepo.findAll();
        model.addAttribute("languageTranslateList", languageTranslateList);

        return "languageTranslate";
    }

    @GetMapping("/all")
    public List<LanguageTranslate> findAll() {
        List<LanguageTranslate> languageTranslateList = languageTranslateRepo.findAll();
        return languageTranslateList;
    }

    @GetMapping("/{langue}/{id}")
        public String toTranslate(@PathVariable("id") Integer langue, @PathVariable("langue") String id) {
        LanguageTranslate languageTranslate = languageTranslateRepo.getByNumberAndLangue(id, langue);
        if(languageTranslate != null) {
            var msg = "Bonjour votre numéro est :" + languageTranslate.getLangue() + languageTranslate.getMessage();
            return msg;
        } else {
            return "Impossible de Traduire, Veuillez vérifier votre saisie !";
        }
    }

    /*
    @GetMapping("/translate")
    public String toTranslate(@RequestParam("number") Integer number, @RequestParam("langue") String langue) {

        if (langue.equals("fr")) {
            List<LanguageTranslate> languageTranslates = languageTranslateRepo.getEnglishTranslateByNumber(number);
            if (!languageTranslates.isEmpty()) {
                return languageTranslates.get(0).getMessage();
            }
            return "Impossible de Traduire, Veuillez saisir un nombre entre 1 à 30";
        } else if (langue.equals("eng")) {
            List<LanguageTranslate> languageTranslates = languageTranslateRepo.getEnglishTranslateByNumber(number);
            if (!languageTranslates.isEmpty()) {
                return languageTranslates.get(0).getMessage();
            }
            return "Impossible de Traduire, Veuillez saisir un nombre entre 1 à 30";
        }
        // langue différent de français et anglais
        return "Impossible de Traduire, Veuillez choisir une langue gérée (Français / Anglais) !";
    }
*/
}

