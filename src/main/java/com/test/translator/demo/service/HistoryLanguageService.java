package com.test.translator.demo.service;

import com.test.translator.demo.entity.LanguageTranslate;
import com.test.translator.demo.repository.HistoryLanguageRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HistoryLanguageService {

    private final HistoryLanguageRepository historyLanguageRepository;

    public HistoryLanguageService(HistoryLanguageRepository historyLanguageRepository) {
        this.historyLanguageRepository = historyLanguageRepository;
    }
/*
    @Transactional(readOnly = true)
    public void saveHistoryLanguage(String langue, Integer number, String date) {
        historyLanguageRepository.saveHistoryLanguage(langue, number, date);
    }
*/

    @Transactional(readOnly = true)
    public void saveHistoryLanguage(LanguageTranslate languageTranslate) {
        historyLanguageRepository.save(languageTranslate);
    }
}
