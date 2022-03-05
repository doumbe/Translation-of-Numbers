package com.test.translator.demo.controller;

import com.test.translator.demo.entity.HistoryLanguage;
import com.test.translator.demo.service.LanguageTranslateService;
import com.test.translator.demo.service.dto.LanguageTranslateDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.time.LocalDate;

@RestController
@RequestMapping("/api/translate")
public class TranslateController {

    static final String HISTORY_URI = "http://localhost:9090/api/history";
    private final Logger logger = LoggerFactory.getLogger(TranslateController.class);
    private final LanguageTranslateService languageTranslateService;
    private final RestTemplate restTemplate;

    public TranslateController(LanguageTranslateService languageTranslateService, RestTemplate restTemplate) {
        this.languageTranslateService = languageTranslateService;
        this.restTemplate = restTemplate;
    }

    //@GetMapping(value = "/{langue}/{number}", produces = "application/json;charset=UTF-8")
    @GetMapping(value = "/{langue}/{number}")
    //public ResponseEntity<LanguageTranslate> toTranslate(@PathVariable("langue") String langue, @PathVariable("number") Integer number) throws LangueTranslateNotFoundException {
    public ResponseEntity<LanguageTranslateDTO> toTranslate(@PathVariable("langue") String langue, @PathVariable("number") Integer number) throws IOException {

        postHistory(langue, number);

        LanguageTranslateDTO dto = languageTranslateService.getByLangueAndNbr(langue, number);

        logger.info("################# languageTranslate {}", dto);

        //return ResponseEntity.ok(languageTranslate);
        return ResponseEntity.ok().body(dto);
    }


    private void postHistory(String langue, Integer number) {
        logger.info("################ debut post");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        LocalDate date = LocalDate.now();
        HistoryLanguage history = new HistoryLanguage(number, langue, date.toString());
        HttpEntity<HistoryLanguage> request = new HttpEntity(history, headers);
        HistoryLanguage response = restTemplate.postForObject(HISTORY_URI, request, HistoryLanguage.class);
        logger.info("################ post history: {}", response);
    }
}