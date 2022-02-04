package com.test.translator.demo.controller;

import com.test.translator.demo.entity.LanguageTranslate;
import com.test.translator.demo.enumeration.Language;
import com.test.translator.demo.exception.LangueTranslateBadRequestException;
import com.test.translator.demo.exception.LangueTranslateNotFoundException;
import com.test.translator.demo.repository.LanguageTranslateRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException.BadRequest;

import java.util.Arrays;

import static org.springframework.data.crossstore.ChangeSetPersister.*;

@RestController
@RequestMapping("/api/translate")
public class TranslateController {

    private final Logger logger = LoggerFactory.getLogger(TranslateController.class);

    @Autowired
    private LanguageTranslateRepository languageTranslateRepo;

    @GetMapping("/{langue}/{number}")
    public String toTranslate(@PathVariable("langue") String langue, @PathVariable("number") Integer number) {
            checkVariables(langue, number);
            LanguageTranslate languageTranslate = languageTranslateRepo.getByLangueAndNbr(langue, number);

            logger.info("################# languageTranslate {}", languageTranslate);
            String msg = "La Traduction de : " + languageTranslate.getMessage() +" en "+ languageTranslate.getLangue();
            return msg;
    }

    private void checkVariables(String langue, Integer nb) {
        if(Arrays.stream(Language.values()).noneMatch(item -> item.name().equals(langue)) && (nb < 0 || nb>30)) {
            throw new LangueTranslateNotFoundException("Veuillez saisir une langue reconnue et un numero valide (0 et 30) !");
        } else if(Arrays.stream(Language.values()).noneMatch(item -> item.name().equals(langue)) && (nb >= 0 && nb<= 30)) {
            throw new LangueTranslateNotFoundException("Votre langue n'est pas reconnue !");
        } else {
            throw new LangueTranslateNotFoundException("Veuillez saisir un nb entre 0 et 30");
        }

    }

}

