package com.test.translator.demo.service;

import com.test.translator.demo.entity.LanguageTranslate;
import com.test.translator.demo.repository.LanguageTranslateRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LanguageTranslateService {

    private final LanguageTranslateRepository languageTranslateRepository;

    public LanguageTranslateService(LanguageTranslateRepository languageTranslateRepository) {
        this.languageTranslateRepository = languageTranslateRepository;
    }

    @Transactional(readOnly = true)
    public LanguageTranslate getByLangueAndNbr(String langue, Integer number) {
        return languageTranslateRepository.getByLangueAndNbr(langue,number);
    }

}
