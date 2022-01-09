package com.test.translator.demo.repository;

import com.test.translator.demo.entity.FrenchTranslate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FrenchTranslateRepository extends JpaRepository<FrenchTranslate, Integer> {

    List<FrenchTranslate> getFrenchTranslateByNumber(Integer number);

}
