package com.test.translator.demo.service;

import com.test.translator.demo.entity.LanguageTranslate;
import com.test.translator.demo.enumeration.Language;
import com.test.translator.demo.exception.LangueTranslateNotFoundException;
import com.test.translator.demo.repository.LanguageTranslateRepository;
import com.test.translator.demo.service.dto.LanguageTranslateDTO;
import com.test.translator.demo.service.mapper.LanguageTranslateMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

@Service
public class LanguageTranslateService {

    private final LanguageTranslateRepository languageTranslateRepository;
    private final LanguageTranslateMapper languageTranslateMapper;

    public LanguageTranslateService(LanguageTranslateRepository languageTranslateRepository, LanguageTranslateMapper languageTranslateMapper) {
        this.languageTranslateRepository = languageTranslateRepository;
        this.languageTranslateMapper = languageTranslateMapper;
    }

    /*
        private ResponseEntity<Object> checkVariables(String langue, Integer nb) {
            Map<String, LanguageTranslate> result = new HashMap<>();

            if (Arrays.stream(Language.values()).noneMatch(item -> item.name().equals(langue)) && (nb < 0 || nb > 30)) {
                result.put("msg", "Veuillez saisir une langue reconnue et un numero valide (0 et 30) !");
                return new ResponseEntity<LanguageTranslate>(result, HttpStatus.NOT_FOUND);
            } else if (Arrays.stream(Language.values()).noneMatch(item -> item.name().equals(langue)) && (nb >= 0 && nb <= 30)) {
                result.put("msg", "Votre langue n'est pas reconnue !");
                return new ResponseEntity<LanguageTranslate>(result, HttpStatus.NOT_FOUND);
            } else if (nb < 0 || nb > 30) {
                result.put("msg", "Veuillez saisir un nb entre 0 et 30");
                return new ResponseEntity<LanguageTranslate>(result, HttpStatus.NOT_FOUND);
            } else {
                result.put("msg", "veuillez saisir une URL valide !");
                return new ResponseEntity<LanguageTranslate>(result, HttpStatus.BAD_REQUEST);
            }
        }
    */
    @Transactional(readOnly = true)
    public LanguageTranslateDTO getByLangueAndNbr(String langue, Integer nb) throws LangueTranslateNotFoundException {
        //List<LanguageTranslate> LanguageTranslateList = languageTranslateRepository.findAll();
        if (Arrays.stream(Language.values()).noneMatch(item -> item.name().equals(langue)) && (nb < 0 || nb > 30)) {
            throw new LangueTranslateNotFoundException("Veuillez saisir une langue reconnue et un numero valide (0 et 30) !");
        } else if (Arrays.stream(Language.values()).noneMatch(item -> item.name().equals(langue)) && (nb >= 0 && nb <= 30)) {
            throw new LangueTranslateNotFoundException("Votre langue n'est pas reconnue !");
        } else if (nb < 0 || nb > 30) {
            throw new LangueTranslateNotFoundException("Veuillez saisir un nb entre 0 et 30\"");
        }
        LanguageTranslate languageTranslate = languageTranslateRepository.getByLangueAndNbr(langue, nb);
        LanguageTranslateDTO languageTranslateDTO = languageTranslateMapper.toDto(languageTranslate);
        return languageTranslateDTO;
    }

}
