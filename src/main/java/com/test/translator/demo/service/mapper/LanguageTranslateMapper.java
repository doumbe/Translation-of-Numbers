package com.test.translator.demo.service.mapper;

import com.test.translator.demo.entity.LanguageTranslate;
import com.test.translator.demo.service.dto.LanguageTranslateDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LanguageTranslateMapper {

    LanguageTranslateDTO toDto(LanguageTranslate languageTranslate);

}
