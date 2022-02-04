package com.test.translator.demo.repository;

import com.test.translator.demo.entity.LanguageTranslate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageTranslateRepository extends JpaRepository<LanguageTranslate, Long> {

    LanguageTranslate getByLangueAndNbr(String langue, Integer number);
    //List<LanguageTranslate> getLanguageTranslatesByNumberAndByLangue(Integer number, String langue);

}