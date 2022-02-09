package com.test.translator.demo.controller;

import com.test.translator.demo.entity.LanguageTranslate;
import com.test.translator.demo.enumeration.Language;
import com.test.translator.demo.exception.LangueTranslateBadRequestException;
import com.test.translator.demo.exception.LangueTranslateNotFoundException;
import com.test.translator.demo.repository.LanguageTranslateRepository;
import com.test.translator.demo.service.LanguageTranslateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/translate")
public class TranslateController {

    private final Logger logger = LoggerFactory.getLogger(TranslateController.class);
    private final LanguageTranslateService languageTranslateService;

    public TranslateController(LanguageTranslateService languageTranslateService) {
        this.languageTranslateService = languageTranslateService;
    }

    //@GetMapping(value = "/{langue}/{number}", produces = "application/json;charset=UTF-8")
    @GetMapping(value = "/{langue}/{number}")
    public ResponseEntity<Object> toTranslate(@PathVariable("langue") String langue, @PathVariable("number") Integer number)
            throws LangueTranslateNotFoundException, LangueTranslateBadRequestException {
        try {
            //LocalDate date = LocalDate.now();
            LanguageTranslate languageTranslate = languageTranslateService.getByLangueAndNbr(langue, number);
            logger.info("################# languageTranslate {}", languageTranslate);

            return ResponseEntity.ok("La Traduction de : " + languageTranslate.getMessage() + " en " + languageTranslate.getLangue());
        } catch (Exception exception) {
            return checkVariables(langue, number);
        }
    }

    private ResponseEntity<Object> checkVariables(String langue, Integer nb) {
        Map<String, Object> result = new HashMap<>();

        if (Arrays.stream(Language.values()).noneMatch(item -> item.name().equals(langue)) && (nb < 0 || nb > 30)) {
            result.put("msg", "Veuillez saisir une langue reconnue et un numero valide (0 et 30) !");
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        } else if (Arrays.stream(Language.values()).noneMatch(item -> item.name().equals(langue)) && (nb >= 0 && nb <= 30)) {
            result.put("msg", "Votre langue n'est pas reconnue !");
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        } else if (nb < 0 || nb > 30) {
            result.put("msg", "Veuillez saisir un nb entre 0 et 30");
            return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
        } else {
            result.put("msg", "veuillez saisir une URL valide !");
            return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
        }
    }
}