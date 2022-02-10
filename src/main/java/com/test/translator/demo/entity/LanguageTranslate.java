package com.test.translator.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "LANGUAGE_TRANSLATE")
public class LanguageTranslate {

    @GeneratedValue()
    @Id
    private Long id;

    @Column(name = "nbr")
    private Integer nbr;

    @Column(name = "message")
    private String message;

    @Column(name = "langue")
    private String langue;

    public LanguageTranslate(Integer nbr, String message, String langue) {
        this.nbr = nbr;
        this.message = message;
        this.langue = langue;
    }

    public Long getId() {
        return id;
    }

    public Integer getNbr() {
        return nbr;
    }

    public String getMessage() {
        return message;
    }

    public String getLangue() {
        return langue;
    }

    @Override
    public String toString() {
        return "LanguageTranslate{" +
                ", number=" + nbr +
                ", message='" + message +
                ", message='" + langue + '\'' +
                '}';
    }
}
