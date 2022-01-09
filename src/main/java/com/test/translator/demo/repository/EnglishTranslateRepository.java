package com.test.translator.demo.repository;

import com.test.translator.demo.entity.EnglishTranslate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnglishTranslateRepository extends JpaRepository<EnglishTranslate, Integer> {

    List<EnglishTranslate> getEnglishTranslateByNumber(Integer number);

}
