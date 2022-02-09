package com.test.translator.demo.service;

import com.test.translator.demo.entity.LanguageTranslate;
import com.test.translator.demo.repository.LanguageTranslateRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HistoryLanguageService {

    private final LanguageTranslateRepository languageTranslateRepository;

    public HistoryLanguageService(LanguageTranslateRepository languageTranslateRepository) {
        this.languageTranslateRepository = languageTranslateRepository;
    }
/*
    @Transactional(readOnly = true)
    public void saveHistoryLanguage(String langue, Integer number, String date) {
        languageTranslateRepository.saveHistoryLanguage(langue, number, date);
    }
*/
    @Transactional(readOnly = true)
    public void saveLanguageTranslate(LanguageTranslate languageTranslate) {
        languageTranslateRepository.save(languageTranslate);
    }
}
